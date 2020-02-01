package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    public static final String TAG ="ActivityOne";
    public static final String MOBILE = "MOBILE";
    public static final String MESSAGE = "MESSAGE";
    public static final String SHARED_NAME ="mySharedData";
    public static final int MODE = Context.MODE_PRIVATE;
    public static final String PHONE = "phone";
    String savedPhoneData ;
    String savedMessageData;
    EditText phone;
    EditText message ;
    Button next ;
    Button close;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize UI component
        initialize();

        //add click listener to next and close btn
        addClickListener();
        Log.i(TAG,"on create");
    }

    private void checkSavedData(Bundle savedInstanceState) {
        if(savedInstanceState !=null){
            String phone= savedInstanceState.getString(MOBILE);
            String message = savedInstanceState.getString(MESSAGE);
            updateUI(phone,message);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(MOBILE,savedPhoneData);
        outState.putString(MESSAGE,savedMessageData);
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

    private void initialize() {
        phone = findViewById(R.id.phone_id);
        message = findViewById(R.id.message_id);
        next = findViewById(R.id.next_id);
        close = findViewById(R.id.close_id);
    }

    private void addClickListener() {

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent goToNextActivity = new Intent(MainActivity.this,SecondActivity.class);
                String phoneBody = phone.getText().toString().trim();
                String messageBody = message.getText().toString().trim();
                if(phoneBody.isEmpty()  || !checkPhoneNumber(phoneBody)){
                    Toast.makeText(MainActivity.this,"Please Enter Phone Number and Message",Toast.LENGTH_LONG).show();
                    return;
                }
                goToNextActivity.putExtra(MOBILE,phoneBody);
                goToNextActivity.putExtra(MESSAGE,messageBody);
                startActivity(goToNextActivity);
            }
        });

        close.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }

    public boolean checkPhoneNumber(String phone){
        String pattern = "(01)[0-9]{9}";
        return Pattern.compile(pattern).matcher(phone).matches();

    }

    private void updateUI(String p,String m) {
        phone.setText(p);
        message.setText(m);
    }


}
