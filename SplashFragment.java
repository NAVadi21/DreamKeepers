package com.example.aadat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class SplashFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        ImageView logoImageView = view.findViewById(R.id.dream_keepers_image_view);
        logoImageView.setImageResource(R.drawable.dream_keepers);
        return view;
    }
}
