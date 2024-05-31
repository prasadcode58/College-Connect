package com.example.collageapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.collageapp.R;
import com.example.collageapp.SliderAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class HomeFragment extends Fragment {

     private int[] images;
     private String[] text;
     private SliderAdapter adapter;
     private SliderView sliderView;
     private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderView = view.findViewById(R.id.sliderView);
        images = new int[]{R.drawable.campus, R.drawable.winners, R.drawable.classroom, R.drawable.satkar, R.drawable.labs, R.drawable.event, R.drawable.teachersday, R.drawable.ranking};
        text = new String[]{"B.R.A.C.T's VIIT","Smart India Hackathon","Classrooms","Award Ceremony","Computer Labs","Cultural Event","Teacher's Day","NIRF Ranking #300"};

        adapter = new SliderAdapter(images, text);

        sliderView.setSliderAdapter(adapter);

        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP);
        sliderView.setAutoCycle(true);

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });
        return view;


    }


    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=BRACT's, Vishwakarma Institute of Information Technology");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}