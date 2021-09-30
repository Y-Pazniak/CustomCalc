package com.example.customcalcv3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class AboutAppActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout_about);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.nav_main, R.string.nav_exit); //добавляем кнопку меню
        drawerLayout.addDrawerListener(actionBarDrawerToggle); //подключаем к ней слушателя
        actionBarDrawerToggle.syncState(); //запускаем меню в тулбаре

        NavigationView navigationView = findViewById(R.id.nav_view_about); //регаю слушателя для выпадающего меню
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.getMenu().getItem(2).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) { //метод отвечает за обработку меню
        Intent intent;
        int id = item.getItemId();
        switch (id){
            case R.id.nav_main: intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_connect: intent = new Intent(this, ConnectionActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_about: intent = new Intent(this, AboutAppActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_exit: MainActivity.isFinish = true;
                finishAffinity();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout_about);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_about);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void getBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}