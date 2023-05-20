package com.example.aadat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DreamAdapter extends RecyclerView.Adapter<DreamAdapter.DreamViewHolder> {

    private List<Dream> dreams;

    public DreamAdapter(List<Dream> dreams) {
        this.dreams = dreams;
    }

    @NonNull
    @Override
    public DreamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dream_item, parent, false);
        return new DreamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DreamViewHolder holder, int position) {
        Dream dream = dreams.get(position);
        holder.date.setText(dream.getDate());
        holder.date.setTextAppearance(R.style.DreamDateText);
        holder.title.setText(dream.getTitle());
        holder.title.setTextAppearance(R.style.DreamDateText);
        holder.description.setText(dream.getDescription());
        holder.title.setTextAppearance(R.style.DreamDateText);
    }

    @Override
    public int getItemCount() {
        return dreams.size();
    }

    static class DreamViewHolder extends RecyclerView.ViewHolder {
        TextView date, title, description;

        public DreamViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.dream_date);
            title = itemView.findViewById(R.id.dream_title);
            description = itemView.findViewById(R.id.dream_preview);
        }
    }
}

