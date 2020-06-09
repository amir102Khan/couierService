package com.courier.courierservice.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.courier.courierservice.R;
import com.courier.courierservice.core.BaseActivity;
import com.courier.courierservice.databinding.ActivityServiceBillBinding;
import com.courier.courierservice.utils.Common;

public class ServiceBill extends BaseActivity {
    private ActivityServiceBillBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_service_bill);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
