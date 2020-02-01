package com.example.fragmentcommunication.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentcommunication.R;

public class fragmentB extends Fragment {
    public static final String TAG ="fragmentb";

    String data ;
    TextView counterView ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fargment_b_layout,container,false);
        counterView = (TextView)view.findViewById(R.id.counter_view_id);
        if(savedInstanceState != null){
            counterView.setText(savedInstanceState.getString("saved"));
        }
        Log.i(TAG,"fragment B created");
        return view;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("saved",data);
    }

    public void changeData(String d){
        Log.i("fragment b",d);
        data = d;
        counterView.setText(data);
    }


}
