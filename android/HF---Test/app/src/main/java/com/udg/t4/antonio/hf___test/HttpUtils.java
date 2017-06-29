package com.udg.t4.antonio.hf___test;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.Map;

/**
 * Created by ulimartinez on 6/28/17.
 */

public class HttpUtils {
    private static final String BASE_URL = "https://smart-fridge.mybluemix.net/index.php/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, String[][] params, AsyncHttpResponseHandler responseHandler) {
        client.get(serializeParams(getAbsoluteUrl(url), params), responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
    private static String serializeParams(String url, String[][] map){
        String params = "";
        for(int i = 0; i < map.length; i++){
            params += "/" + map[i][0] + "/" + map[i][1];
        }
        return url + params;
    }
}
