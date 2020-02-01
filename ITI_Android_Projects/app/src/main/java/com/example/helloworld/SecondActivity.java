package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {
    public static final String TAG = "ActivityTwo";
    public static final String SHARED_NAME = "SHARED_NAME";
    public static final String PHONE = "PHONE";
    public static final String MESSAGE = "MESSAGE";
    public static final String FILE_NAME ="myFile";

    SharedPreferences sharedPreferences;

    TextView phone_info;
    TextView message_info;
    Button closeBtn;
    Button writeShared;
    Button readShared;
    Button writeFile ;
    Button readFile;
    Button writeSql ;
    Button readSql;

    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        adapter = new Adapter(getApplicationContext());
        sharedPreferences = getSharedPreferences(SHARED_NAME,MODE_PRIVATE);
        initialize();
        getIntentData();
        addListener();


    }

    private void initialize() {
        phone_info = findViewById(R.id.phone_info_id);
        message_info = findViewById(R.id.message_info_id);
        closeBtn = findViewById(R.id.close_id_btn);
        writeShared = findViewById(R.id.write_shared_id);
        readShared = findViewById(R.id.read_shared_id);
        writeFile = findViewById(R.id.write_file_id);
        readFile = findViewById(R.id.read_file_id);
        writeSql = findViewById(R.id.write_sql_id);
        readSql = findViewById(R.id.read_sql_id);
    }

    private void getIntentData() {
        Intent recivedData = getIntent();
        String phone_info = recivedData.getStringExtra(MainActivity.MOBILE);
        String message_info=recivedData.getStringExtra(MainActivity.MESSAGE);
        updateUI(phone_info,message_info);
    }

    private void updateUI(String phone,String message) {
        phone_info.setText(phone);
        message_info.setText(message);
    }

    public void closeSecondActivity(View view){
        finish();
    }

    private void addListener(){
        writeShared.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String p = phone_info.getText().toString();
                String m = message_info.getText().toString();
                writeData(p,m);
                phone_info.setText("");
                message_info.setText("");
            }
        });

        readShared.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String p = sharedPreferences.getString(PHONE,"default");
                String m = sharedPreferences.getString(MESSAGE,"default");
                updateUI(p,m);
            }
        });


        //write to file
        writeFile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String p = phone_info.getText().toString();
                String m = message_info.getText().toString();
                try(FileOutputStream outPutStream = openFileOutput(FILE_NAME,   MODE_PRIVATE)){
                    String writtenData = convertData(p,m);
                    byte[]writterDataAsByte = writtenData.getBytes();
                    outPutStream.write(writterDataAsByte);
                    phone_info.setText("");
                    message_info.setText("");
                }catch(IOException ioException){
                    ioException.printStackTrace();
                }
            }
        });

        //read from file
        readFile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try(FileInputStream inputStream = openFileInput(FILE_NAME)){
                    byte[] byteData = new byte[inputStream.available()];
                    int readingState = inputStream.read(byteData);
                    String stringData = new String(byteData);
                    String []phoneAndMessage = stringData.split(":");
                    String phone=phoneAndMessage[0];
                    String message = phoneAndMessage[1];
                    Log.i("file",stringData);
                    updateUI(phone,message);

                }catch(IOException ioException){

                }
            }
        });

        //write to sql
        writeSql.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String p = phone_info.getText().toString();
                String m = message_info.getText().toString();
                adapter.insert(p,m);
                phone_info.setText("");
                message_info.setText("");
            }
        });

        //read from sql
        readSql.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String phone = adapter.getPhone();
                String message = adapter.getMessage(phone);
                updateUI(phone,message);
            }
        });


    }

    private void writeData(String p , String m){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PHONE,p);
        editor.putString(MESSAGE,m);
        editor.apply();
    }

    private String convertData (String p , String m){
        return p+":"+m;
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
