package com.example.devon.ccsi235lab2;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    int countSave = 0;
    int countRestore = 0;

    // below is the same as String greeting = getResources().getString(R.string.hello);
    Resources res = getResources();
    String text = (res.getString(R.string.message));
    String textpart2 = (res.getString(R.string.message2));
    String textpart3 = (res.getString(R.string.message3));

    /*
    testing from video
    private static final String TAG = "your log message";
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(text, " onCreate()");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(text, " onStart()");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(text, " onResume()");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(text, " onPause()");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(text, " onStop()");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(text, " onDestroy()");
    }


    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        countSave++;
        Log.d(textpart2," "+countSave+" times");
    }

    @Override
    public void onRestoreInstanceState (Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
       countRestore++;
       Log.d(textpart3," "+countRestore+" times");

    }
}
