package com.courier.courierservice.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.courier.courierservice.R;
import com.courier.courierservice.core.BaseActivity;
import com.courier.courierservice.databinding.ActivityMainBinding;

public class Splash extends BaseActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, Dashboard.class);
                startActivity(i);
                finish();
            }
        }, 2000);

    }

}
