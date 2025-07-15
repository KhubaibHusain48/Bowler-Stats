package com.example.bowlerstats;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    DrawerLayout DL;
    NavigationView NV;
    Toolbar TB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        DL = findViewById(R.id.drawerLayout);
        NV = findViewById(R.id.navigationView);
        TB = findViewById(R.id.toolbar);


        setSupportActionBar(TB);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, DL, TB, R.string.open, R.string.close);

        DL.addDrawerListener(toggle);
        toggle.syncState();
        DL.openDrawer(GravityCompat.START);

        NV.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int ID = menuItem.getItemId();

                if (ID == R.id.bowlerStrikeRate) {
                    fragmentShow(new StrikeRateFragment(), true);
                } else if (ID == R.id.bowlerAverage) {
                    fragmentShow(new AverageFragment(), false);
                } else {
                    fragmentShow(new EconomyFragment(), false);
                }

                DL.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @SuppressLint("GestureBackNavigation")
    @Override
    public void onBackPressed() {
        if (DL.isDrawerOpen(GravityCompat.START)) {
            DL.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void fragmentShow(Fragment F, boolean flag) {
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        if (flag)
            FT.add(R.id.container, F);
        else
            FT.replace(R.id.container, F);
        FT.commit();
    }

}