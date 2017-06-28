package com.udg.t4.antonio.hf___test;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by ulimartinez on 6/27/17.
 */

public class IngredientFragment extends android.app.Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.ingredients);

        GridView gridView = (GridView) getActivity().findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(ingredients)
            }
        });
    }

    @Override
    public boolean onCreateOptionMenu(Menu menu){
        getActivity().getMenuInflater().inflate(R.menu.ingredients, menu);
        return true;
    }

    @Override
    public boolean onOptionItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id==R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(Item);
    }

    public class ImageAdapter extends BaseAdapter{
        private Context mContext;

        public ImageAdapter(Context c){
            mContext = c;
        }

        public int getCount(){
            return mThumbsIds.length;
        }

        public Object getItem(int position){
            return null;
        }

        public long getItemId(int position){
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent){
            ImageView imageView = new ImageView(mContext);
            imageView.setImageResource(mThumbsIds[position]);
            return imageView;
        }

        private Integer[] mThumbsIds = {
                R.drawable.Sample_Ing1,R.drawable.Sample_Ing2,R.drawable.Sample_Ing3,
                R.drawable.Sample_Ing4,R.drawable.Sample_Ing5,R.drawable.Sample_Ing6

        }
    }

}
