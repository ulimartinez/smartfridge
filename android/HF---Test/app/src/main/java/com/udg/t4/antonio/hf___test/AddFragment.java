package com.udg.t4.antonio.hf___test;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

//vidimport com.ibm.watson.developer_cloud.speech_to_text.v1.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

import java.io.File;

/**
 * Created by ulimartinez on 6/27/17.
 */

public class AddFragment extends android.app.Fragment {
    private static final String LOG_TAG = "StT";
    private MediaPlayer mPlayer;
    private RecordWavMaster rwm;
    private String outputFilePath;
    private boolean isRecording = false;
    private View view;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //do stuff here
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.add_fragment, container, false);
        return view;
    }
    private void setUpButtons() {
        ImageButton recordButton = (ImageButton) view.findViewById(R.id.add_speech);
        recordButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        recordButtonPressed();
                    }
                });
    }
    private void recordButtonPressed() {
        ImageButton recordButton = (ImageButton) view.findViewById(R.id.add_speech);
        if (isRecording) {
            outputFilePath = rwm.recordWavStop();//stopRecording();
            recordButton.setImageResource(R.drawable.mic);
            speechToTextButtonPressed();
        }
        else {
            rwm.recordWavStart();//startRecording();
            recordButton.setImageResource(R.drawable.micalt);
        }
        isRecording = !isRecording;
    }
    private void speechToTextButtonPressed() {
        new SpeechToTextTask().execute("https://stream.watsonplatform.net/speech-to-text/api");
    }
    private class SpeechToTextTask extends AsyncTask<String, Void, String> {protected String doInBackground(String... params) {
        long totalSize = 0;
        SpeechToText service = new SpeechToText();
        service.setUsernameAndPassword("db5ecb4c-d132-4e23-974e-64e0739fb968", "Be7d6r6nO5YQ"
        );
        //RecognizeOptions options = new RecognizeOptions().contentType("audio/wav");
//        try {
//            File sdcard = Environment.getExternalStorageDirectory();
//            File file = new File(outputFilePath);
//            SpeechResults speechResults = service.recognize(file, options);
//            Log.e(LOG_TAG, speechResults.toString());
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
        return "";
    }
        protected void onProgressUpdate(Integer... progress) {
        }
        protected void onPostExecute(String result) {
        }
    }
}
