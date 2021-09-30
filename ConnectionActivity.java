package com.example.customcalcv3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class ConnectionActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout_connection);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.nav_main, R.string.nav_exit); //добавляем кнопку меню
        drawerLayout.addDrawerListener(actionBarDrawerToggle); //подключаем к ней слушателя
        actionBarDrawerToggle.syncState(); //запускаем меню в тулбаре

        NavigationView navigationView = findViewById(R.id.nav_view_connection); //регаю слушателя для выпадающего меню
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.getMenu().getItem(1).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
            case R.id.nav_exit: finishAffinity();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout_connection);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void sendMessage(View view) {
        EditText name = findViewById(R.id.edit_name);
        EditText email = findViewById(R.id.edit_email);
        EditText message = findViewById(R.id.edit_message);

        String nameString = name.getText().toString();
        String emailString = email.getText().toString();
        String messageString = message.getText().toString();
        if (!(nameString.equals(""))&& !(emailString.equals("")) && !(messageString.equals(""))) {
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"yauhenij@gmail.com"});
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Письмо из мобильного приложения");
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Письмо от " + nameString + " почта " + emailString + " сообщение: " + messageString);
            this.startActivity(Intent.createChooser(emailIntent, "Отправка письма..."));
        } else {
            Toast toast = Toast.makeText(this, "Нужно заполнить ВСЕ поля", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void backToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_connection);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}