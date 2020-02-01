package com.example.helloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Adapter {

    private Context adapterOwnerContext;
    private DBhelper helper ;
    public Adapter (Context context){
        adapterOwnerContext = context;
        helper = new DBhelper(context);
    }

    public void insert(String phone, String message){
        helper.insert(phone,message);
    }

    public String getMessage(String phone){
        return helper.getMessage(phone);
    }

    public String getPhone(){
        return helper.getPhone();
    }






    class DBhelper extends SQLiteOpenHelper {

        private static final String DB_NAME="databaseName";
        private static final int DB_VERSION=1;
        private DBhelper instance;

        private static final String TABLE_NAME = "PHONE_MESSAGE";
        private static final String PHONE_COL_NAME = "PHONE";
        private static final String MESSAGE_COL_NAME="MESSAGE";

        private static final String PHONE_KEY ="PHONE";
        private static final String MESSAGE_KEY ="MESSAGE";

        private Context myContext ;
        public  DBhelper(Context context){
            super(context,DB_NAME,null,DB_VERSION);
            myContext = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE "+TABLE_NAME+" ("+PHONE_COL_NAME+" VARCHAR(30) NOT NULL,"+MESSAGE_COL_NAME+" VARCHAR(100))");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        //add phone and message
        public void insert(String phone, String message){
            SQLiteDatabase db = getWritableDatabase();
            db.beginTransaction();
            try{
                ContentValues row = new ContentValues();
                row.put(PHONE_KEY,phone);
                row.put(MESSAGE_KEY,message);

                db.insertOrThrow(TABLE_NAME,null,row);
                db.setTransactionSuccessful();
            }catch(Exception e){
                Toast.makeText(myContext,"Phone is exist",Toast.LENGTH_LONG).show();
            }
            db.endTransaction();

        }

        //retrive phone
        public String getPhone(){
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT "+PHONE_COL_NAME+" FROM "+TABLE_NAME,null);
            if(cursor.moveToNext()){
                String phone = cursor.getString(0);
                return phone;
            }else
                return "no Phone";
        }

        // retrive message
        public String getMessage(String phone) {
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT " + MESSAGE_COL_NAME + " FROM " + TABLE_NAME , null);

            try {
                if (cursor.moveToNext()) {
                    return cursor.getString(0);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                cursor.close();
            }
            return "no message";
        }
    }
}
