package com.example.linearlayout_with_weight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final String TAG ="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"on Create");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG,"on save instance");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"on stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"on Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"on Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"on Resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"on Restart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"on Start");
    }
}
