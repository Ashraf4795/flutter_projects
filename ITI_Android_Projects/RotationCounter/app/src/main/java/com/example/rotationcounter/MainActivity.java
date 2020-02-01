package com.example.rotationcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String COUNTER = "COUNTER";
    TextView counter ;
    public  int n = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            n = savedInstanceState.getInt(COUNTER);
        }
        counter = findViewById(R.id.counter_id);
        counter.setText(n+"");
        n++;
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER,n);
    }
}
