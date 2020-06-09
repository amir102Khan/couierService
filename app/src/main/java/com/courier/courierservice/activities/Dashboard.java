package com.courier.courierservice.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.courier.courierservice.R;
import com.courier.courierservice.core.BaseActivity;
import com.courier.courierservice.databinding.ActivityDashboardBinding;
import com.courier.courierservice.fragments.BookOrder;
import com.courier.courierservice.fragments.FillCompanyDetails;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends BaseActivity {
    private ActivityDashboardBinding binding;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        implementListener();
        switchToFragment(new FillCompanyDetails());
        setUpToggle();
    }

    private void setUpToggle(){
        toggle = new ActionBarDrawerToggle(this,
                binding.drawerLayout,binding.toolbar.mToolbar,R.string.drawer_open,R.string.drawer_close);

        binding.drawerLayout.addDrawerListener(toggle);

        binding.toolbar.mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorWhite));
        binding.toolbar.titleTv.setText("Company Details");
        setSupportActionBar(binding.toolbar.mToolbar);

        if (getSupportActionBar()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

    }

    private void implementListener(){
        binding.nvView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                setNavigationView(menuItem);
                return false;
            }
        });
    }

    private void setNavigationView(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.nav_create_order:
                switchToFragment(new BookOrder());
                binding.toolbar.titleTv.setText("Book Order");
                break;

            case R.id.nav_cmpny_details:
                switchToFragment(new FillCompanyDetails());
                binding.toolbar.titleTv.setText("Company Details");
                break;
        }

        binding.drawerLayout.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            binding.drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    private void switchToFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }
}
