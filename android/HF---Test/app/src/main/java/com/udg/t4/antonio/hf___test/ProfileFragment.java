package com.udg.t4.antonio.hf___test;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by ulimartinez on 6/27/17.
 */

public class ProfileFragment extends Fragment{
    private String name;
    private int age;
    private int weight;
    private int height;
    private int calories;
    private boolean sex;
    private int level;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //create the request
        String [][] rp = {{"id", "1"}};

        HttpUtils.get("users/user", rp, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                Log.d("asd", "---------------- this is response : " + response);
                try {
                    JSONObject serverResp = new JSONObject(response.toString());
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                // Pull out the first event on the public timeline
                Log.d("asd", "---------------- this is response : " + timeline);
                try {
                    JSONArray serverResp = new JSONArray(timeline.toString());
                    JSONObject values = (JSONObject)serverResp.get(0);
                    String name = values.getString("nombre");
                    Log.d("val", "----------: " + name);
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });
    }
    private void setFeilds(JSONObject data) throws JSONException {
        this.name = data.getString("nombre");
        this.weight = data.getInt("peso");
        this.height = data.getInt("altura");
        this.level = data.getInt("ejercicio");
        this.sex = data.getInt("sexo") > 0;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_fragment, container, false);
    }
}
