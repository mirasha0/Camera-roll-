package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgCamera = findViewById(R.id.imgCamera);

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[] {
                            Manifest.permission.CAMERA
                    },100);  // permission ganna use karnnna

        }

    }
    public void takeImage(View view)
    {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        if(requestCode==100)
        {
            Bitmap image = (Bitmap)data.getExtras().get("data");
            imgCamera.setImageBitmap(image);
        }

    }
}