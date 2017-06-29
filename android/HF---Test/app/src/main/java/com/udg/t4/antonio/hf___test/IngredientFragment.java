package com.udg.t4.antonio.hf___test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class IngredientFragment extends android.app.Fragment {
    GridView grid_view;
    static int count = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        count++;
        //getActivity().setContentView(R.layout.ingredients_fragment);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ingredients_fragment, container, false);
        grid_view = (GridView) view.findViewById(R.id.gridview);
        grid_view.setAdapter(new ImageAdapter(view.getContext()));
        grid_view.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {

                Toast.makeText(getActivity().getBaseContext(), "Image "+position, Toast.LENGTH_LONG).show();

            }


        });
        return view;
    }

    public class ImageAdapter extends BaseAdapter {
        private Context CTX;
        private Integer image_id[] = {R.drawable.sample_ing1,
                R.drawable.sample_ing2, R.drawable.sample_ing3,
                R.drawable.sample_ing4, R.drawable.sample_ing5,
                R.drawable.sample_ing6
        };

        public ImageAdapter(Context CTX) {
            this.CTX = CTX;
        }

        @Override
        public int getCount() {

            return image_id.length;
        }

        @Override
        public Object getItem(int arg0) {
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            return 0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {
            ImageView img;
            if(arg1 == null)
            {
                img = new ImageView(CTX);
                img.setLayoutParams(new GridView.LayoutParams(160,160));
                img.setScaleType(ImageView.ScaleType.CENTER_CROP);
                img.setPadding(8, 8, 8, 8);

            }
            else
            {
                img = (ImageView) arg1;
            }

            img.setImageResource(image_id[arg0]);
            return img;



        }
    }
}
