package com.example.androidmenusample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.navigation_drawer_activity){
            Toast.makeText(MainActivity.this, "Click the top left icon to display menu.", Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this, NavigationDrawerActivity.class));
        }else if(item.getItemId() == R.id.floating_menu){
            startActivity(new Intent(MainActivity.this, FloatingMenuActivity.class));
            Toast.makeText(MainActivity.this, "CLick foating button for floating menu", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}