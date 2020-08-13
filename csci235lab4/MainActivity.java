package com.example.devon.csci235lab4;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.hardware.Camera;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


    public class MainActivity extends AppCompatActivity {
        String TAG = "Camera Prview";
        private static final int REQUEST_CAMERA = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Log.d(TAG, " Event");

            final Button button = (Button) findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Perform action on click

                    showCamera(v);
                }

            });
        }


        public void showCameraPreview(){
        //run camera preview
    }





    public void showCamera(View view){
        if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
            //permision available
            Toast.makeText(this,"Permision already Granted",Toast.LENGTH_SHORT).show();
            showCameraPreview();
        }
        else{
            //notify user
            if(shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                Toast.makeText(this,"Camera permission is needed to show the Camera preview. ", Toast.LENGTH_SHORT).show();
            }
            //request permision
            requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
        }
    }



 public void onRequestPermissionResult(int requestCode, String[] permission, int[] grantResults){

     if(requestCode == REQUEST_CAMERA){
         if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
             showCameraPreview();
         }
         else{
             Toast.makeText(this, "Permision was not granted",Toast.LENGTH_SHORT).show();
         }
     }
     else{
         super.onRequestPermissionsResult(requestCode,permission, grantResults);
     }
 }





    /**
     * Called when the activity is about to become visible.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "The onStart() event");
    }

    /**
     * Called when the activity has become visible.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "The onResume() event");
    }

    /**
     * Called when another activity is taking focus.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "The onPause() event");
    }

    /**
     * Called when the activity is no longer visible.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "The onStop() event");
    }

    /**
     * Called just before the activity is destroyed.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "The onDestroy() event");
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state

        super.onSaveInstanceState(savedInstanceState);
        Log.d(TAG, "The onSaveInstanceState() event");
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "The onRestoreInstanceState() event: " + savedInstanceState.getInt("Count"));
    }
}
