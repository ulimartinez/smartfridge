package com.udg.t4.antonio.hf___test;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;

/**
 * Created by ulimartinez on 6/27/17.
 */

public class ProfileFragment extends Fragment implements HttpCompleted{
    private String name;
    private int age;
    private int weight;
    private int height;
    private int calories;
    private boolean sex;
    private int level;

    private EditText nameView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //save the textviews
        //create the request
        String [][] rp = {{"id", "1"}};

        HttpUtils.get("users/user", rp, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                try {
                    setFeilds(response);
                } catch (JSONException e) {
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
                    setFeilds(values);
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

            @Override
            public void onPostProcessResponse(ResponseHandlerInterface instance, HttpResponse response) {
                super.onPostProcessResponse(instance, response);
                EditText nameText = (EditText)getView().findViewById(R.id.editText);
                nameText.setText(name);
            }
        });
    }
    private void setFeilds(JSONObject data) throws JSONException {
        this.name = data.getString("nombre");
        this.weight = data.getInt("peso");
        this.height = data.getInt("altura");
        this.level = data.getInt("ejercicio");
        this.sex = data.getInt("sexo") > 0;
        this.calories = data.getInt("calorias");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_fragment, container, false);
        nameView = (EditText) view.findViewById(R.id.editText);
        nameView.setText(this.name);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        TextView nameView = (TextView)view.findViewById(R.id.textView);
//        nameView.setText(this.name);
    }

    @Override
    public void taskCompleted(String results) {
        this.nameView.setText("Alex");
    }
}
