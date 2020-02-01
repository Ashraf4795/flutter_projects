package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.fragmentcommunication.DAO.Communicator;
import com.example.fragmentcommunication.Fragments.fragmentB;

public class MainActivity extends AppCompatActivity implements Communicator {

    fragmentB frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction trsn = manager.beginTransaction();
        frag = (fragmentB)manager.findFragmentByTag("myFragment");

        if(frag==null){
            frag = new fragmentB();
            trsn.add(R.id.dynamic_fragment_id, frag, "myFragment");
            trsn.commit();
        }
    }



    @Override
    public void response(String data) {
        Log.i("mainActivity",data);
        frag.changeData(data);
    }
}
