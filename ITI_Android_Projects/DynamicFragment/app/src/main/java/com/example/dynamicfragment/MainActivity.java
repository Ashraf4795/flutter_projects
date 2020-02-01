package com.example.dynamicfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.dynamicfragment.Fragments.myFragment;

public class MainActivity extends AppCompatActivity {
    public static final String FRAGMENT_TAG ="dynamicFragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myFragment fragment = new myFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction trns = manager.beginTransaction();
        trns.add(R.id.fragment_container_id,fragment,FRAGMENT_TAG);
        trns.commit();
    }
}
