package com.udg.t4.antonio.hf___test;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

/**
 * Created by ulimartinez on 6/27/17.
 */

public class CalorieFragment extends android.app.Fragment {
    private static int[] COLORS = new int[] {Color.MAGENTA, Color.CYAN };

    private static double[] VALUES = new double[] { 1300, 900 };

    private static String[] NAME_LIST = new String[] { "Consumed", "Remaining" };

    private CategorySeries mSeries = new CategorySeries("");

    private DefaultRenderer mRenderer = new DefaultRenderer();

    private GraphicalView mChartView;
    private LinearLayout layout;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getActivity().setContentView(R.layout.calorie_fragment);

        mRenderer.setApplyBackgroundColor(false);
        mRenderer.setChartTitle("Calorie Consumption");
        mRenderer.setBackgroundColor(Color.WHITE);
        mRenderer.setChartTitleTextSize(50);
        //mRenderer.setLabelsTextSize(35);
        mRenderer.setLegendTextSize(55);
        mRenderer.setLegendHeight(200);
        mRenderer.setShowLabels(false);
        mRenderer.setMargins(new int[] { 20, 30, 15, 0 });
        mRenderer.setZoomButtonsVisible(false);
        mRenderer.setStartAngle(270);
        mRenderer.setPanEnabled(false);
        mRenderer.setZoomEnabled(false);
        mRenderer.setFitLegend(true);

        for (int i = 0; i < VALUES.length; i++) {
            mSeries.add(NAME_LIST[i] + " " + VALUES[i], VALUES[i]);
            SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
            renderer.setColor(COLORS[(mSeries.getItemCount() - 1) % COLORS.length]);
            mRenderer.addSeriesRenderer(renderer);
        }

        if (mChartView != null) {
            mChartView.repaint();
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return view = inflater.inflate(R.layout.calorie_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mChartView = ChartFactory.getPieChartView(view.findViewById(R.id.chart).getContext(), mSeries, mRenderer);
    }

    @Override
    public void onResume() {
        super.onResume();
        layout = (LinearLayout) getActivity().findViewById(R.id.chart);
        layout.addView(mChartView);
        if (mChartView != null) {
            mChartView.repaint();
        }
    }
}
