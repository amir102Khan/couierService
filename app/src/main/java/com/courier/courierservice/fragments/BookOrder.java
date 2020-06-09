package com.courier.courierservice.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.courier.courierservice.R;
import com.courier.courierservice.activities.ServiceBill;
import com.courier.courierservice.core.BaseFragment;
import com.courier.courierservice.databinding.FragmentBookOrderBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookOrder extends BaseFragment implements AdapterView.OnItemSelectedListener {
    private FragmentBookOrderBinding binding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_book_order, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        implementListener();
        setSpinnerAdapter();
    }

    private void implementListener(){
        binding.btnNextToBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, ServiceBill.class));
            }
        });
    }

    private void setSpinnerAdapter(){
        ArrayAdapter<CharSequence> arrayAdapterCmpny = ArrayAdapter.createFromResource(mContext,
                R.array.company, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> arrayAdapterType = ArrayAdapter.createFromResource(mContext,
                R.array.package_type, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> arrayAdapterZone = ArrayAdapter.createFromResource(mContext,
                R.array.zone, android.R.layout.simple_spinner_item);
        arrayAdapterCmpny.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapterZone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinrCompanyPro.setAdapter(arrayAdapterCmpny);
        binding.spinrPackageType.setAdapter(arrayAdapterType);
        binding.spinrZonePro.setAdapter(arrayAdapterZone);
        binding.spinrCompanyPro.setOnItemSelectedListener(this);
        binding.spinrZonePro.setOnItemSelectedListener(this);
        binding.spinrPackageType.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
