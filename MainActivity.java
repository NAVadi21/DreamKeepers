package com.example.aadat;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DreamAdapter adapter;
    private List<Dream> dreamList = new ArrayList<>();
    private ImageView floatingButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        anim.setDuration(1000);

        setContentView(R.layout.activity_main);

        dreamList.add(new Dream("1/1/2021", "Flying Dream", "I had a dream about flying through the clouds and feeling free"));
        dreamList.add(new Dream("2/2/2021", "Ocean Dream", "I had a dream about swimming in the ocean and feeling peaceful"));
        dreamList.add(new Dream("3/3/2021", "Race Dream", "I had a dream about racing cars and feeling adrenaline rush"));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DreamAdapter(dreamList);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddDreamDialog();
            }
        });
    }

    private void showAddDreamDialog() {
        final EditText dateEditText = new EditText(this);
        dateEditText.setInputType(InputType.TYPE_CLASS_DATETIME);
        dateEditText.setHintTextColor(Color.WHITE);
        dateEditText.setHint("Enter Date Here");
        final EditText titleEditText = new EditText(this);
        titleEditText.setHintTextColor(Color.WHITE);
        titleEditText.setHint("Enter Title Here");
        final EditText descriptionEditText = new EditText(this);
        descriptionEditText.setHintTextColor(Color.WHITE);
        descriptionEditText.setHint("Enter Description");

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(dateEditText);
        linearLayout.setBackgroundColor(Color.BLACK);
        linearLayout.addView(titleEditText);
        linearLayout.addView(descriptionEditText);

        dateEditText.setTextColor(Color.WHITE);
        titleEditText.setTextColor(Color.WHITE);
        descriptionEditText.setTextColor(Color.WHITE);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Add Dreams To Your List")
                .setView(linearLayout)
                .setPositiveButton("Add", (dialog1, which) -> {
                    String date = dateEditText.getText().toString();
                    String title = titleEditText.getText().toString();
                    String description = descriptionEditText.getText().toString();
                    Dream dream = new Dream(date, title, description);
                    dreamList.add(dream);
                    adapter.notifyDataSetChanged();
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
    }
}
