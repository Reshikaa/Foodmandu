package com.reshika.foodmandu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.reshika.foodmandu.MainActivity;
import com.reshika.foodmandu.R;

public class SpplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spplash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SpplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1000);
    }
}
