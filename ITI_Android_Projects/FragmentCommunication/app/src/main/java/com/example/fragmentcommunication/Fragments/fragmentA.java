package com.example.fragmentcommunication.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.fragmentcommunication.DAO.Communicator;
import com.example.fragmentcommunication.MainActivity;
import com.example.fragmentcommunication.R;

public class fragmentA extends Fragment{
    public static final String TAG ="fragmentA";
    public static final String SAVED_DATA = "saved";
    public int counter ;
    Communicator comm;
    Bundle savedInstance;
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm = (MainActivity)getActivity();
    }



    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.i("SAVED","A:"+counter);
        outState.putInt(SAVED_DATA,counter);
    }

    @Override
    public void onStart() {
        super.onStart();
        comm.response(counter+"");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(savedInstanceState !=null){
            counter = savedInstanceState.getInt(fragmentA.SAVED_DATA);
        }
        View view = inflater.inflate(R.layout.fragment_a_layout,container,false);
        Button btn = (Button)view.findViewById(R.id.btn_id);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                counter++;
                comm.response(counter+"");
                Log.i("fragment A",counter+"");
            }
        });


        return view;
    }


}
