package com.udg.t4.antonio.hf___test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by Antonio on 27/06/2017.
 */

public class UserProfile extends MainActivity {
    TextView texto;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView)findViewById(R.id.text);
    }

    public void Cambia_texto(View v){
        texto.setText("Ingresa tu nombre");
    }
}
