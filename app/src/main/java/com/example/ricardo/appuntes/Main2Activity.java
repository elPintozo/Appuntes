package com.example.ricardo.appuntes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toast.makeText(getApplicationContext(), "Oncreate", Toast.LENGTH_LONG);
        Log.e("test","onCreate-Activity_2");

        //recibo los parametros del intent anterior
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String var_string = bundle.getString("var_string","");
            int var_int = bundle.getInt("var_int",0);
            boolean var_bool = bundle.getBoolean("var_bool",false);

            Log.v("bundle","var_string: "+var_string);
            Log.v("bundle","var_int: "+var_int);
            Log.v("bundle","var_bool: "+var_bool);
        }


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_LONG);
        Log.e("test","onDestroy-Activity_2");
    }
}
