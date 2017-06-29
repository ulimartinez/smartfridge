package com.udg.t4.antonio.hf___test;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by ulimartinez on 6/27/17.
 */

public class HomeFragment extends android.app.Fragment{
    ViewPager viewPager;
    CustomSwipeAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.home);
        viewPager = (ViewPager)getView().findViewById(R.id.view_pager);
        adapter = new CustomSwipeAdapter(getActivity());
        viewPager.setAdapter(adapter);
    }


}
