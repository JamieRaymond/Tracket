package com.example.tracket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //FOR SWITCH - implement Switch.OnCheckedChangeListener

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Switch switchTheme;
    //Switch switchWeekStart;
    //Switch switchTimeFormat;
    //Switch switchDefaultTimeRange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--------------------------------------------------------------------------------------------------------------------------------------------
        //All this bollocks just sets the phones status bar(where your signal and battery life is) to white, with the text being a dark grey.
        //Only works past API version 21 cause its stupid.

        try {
            if (android.os.Build.VERSION.SDK_INT >= 21) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//  set status text dark
                getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.lightThemeColorPrimary));// set status background white
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //--------------------------------------------------------------------------------------------------------------------------------------------

        //--------------------------------------------------------------------------------------------------------------------------------------------

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        //getSupportActionBar().hide();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //This makes the navigation drawer button work and not crash the app because the drawer comes from the right instead of the left(default).
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    drawerLayout.closeDrawer(Gravity.RIGHT);
                } else {
                    drawerLayout.openDrawer(Gravity.RIGHT);
                }
            }
        });

        //--------------------------------------------------------------------------------------------------------------------------------------------

        //--------------------------------------------------------------------------------------------------------------------------------------------
        /* STILL WORKING ON THIS
        //COULD BE HELPFUL - https://abhiandroid.com/ui/switch

        switchTheme = findViewById(R.id.theme_switch);

        switchTheme.setChecked(true);

        switchTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            }
        });*/

    }

    @Override
    public void onBackPressed(){

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawers();
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    //PART OF SWITCH
    /*
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked == true)
        {
            switchTheme.setChecked(true);
            //toolbar.setBackgroundColor(getResources().getColor(R.color.darkThemeColorPrimary));
            drawerLayout.setBackgroundColor(getResources().getColor(R.color.darkThemeColorPrimary));
        }
    }*/
}
