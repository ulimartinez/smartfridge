package com.udg.t4.antonio.hf___test;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Antonio on 27/06/2017.
 */

public class Profile extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view;

        view = inflater.inflate(R.layout.userprofile,container);
        return view;

        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
