package com.udg.t4.antonio.hf___test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

/**
 * Created by ulimartinez on 6/27/17.
 */

public class HomeFragment extends android.app.Fragment{
    CarouselView carouselView;
    LinearLayout layout;
    CarouselView carouselView2;

    int[] sampleImages = {R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2, R.drawable.sample_3};
    int[] sampleImages2 = {R.drawable.sample_5, R.drawable.sample_6, R.drawable.sample_3, R.drawable.sample_0};
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
    ImageListener imageListener2 = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages2[position]);
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        carouselView = (CarouselView) view.findViewById(R.id.carouselView);
        carouselView.setImageListener(imageListener);
        carouselView.setPageCount(sampleImages.length);

        carouselView2 = (CarouselView) view.findViewById(R.id.carouselView2);
        carouselView2.setImageListener(imageListener2);
        carouselView2.setPageCount(sampleImages2.length);
        super.onViewCreated(view, savedInstanceState);
    }
}
