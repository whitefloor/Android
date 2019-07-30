package com.ehappy.activitylifetime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MyActivity","MyActivity_OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MyActivity","MyActivity_onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MyActivity","MyActivity_onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MyActivity","MyActivity_ononPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MyActivity","MyActivity_onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MyActivity","MyActivity_onDestroy");
    }
}
