package com.example.androidmenusample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PopUpMenuActivity extends AppCompatActivity {

    Button popupButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_menu);
        popupButton = findViewById(R.id.popup_button);
        popupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu p = new PopupMenu(PopUpMenuActivity.this, popupButton);
                p.getMenuInflater().inflate(R.menu.menu, p .getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(PopUpMenuActivity.this,item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                p.show();
            }
        });
    }
}