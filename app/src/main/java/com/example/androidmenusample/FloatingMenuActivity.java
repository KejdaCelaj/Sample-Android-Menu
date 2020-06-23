package com.example.androidmenusample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FloatingMenuActivity extends AppCompatActivity {

    private FloatingActionButton main, mail, share;
    private Animation open, close, clock, anticlock;
    TextView textview_mail, textview_share;

    Boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_menu);

        main = findViewById(R.id.fab);
        mail = findViewById(R.id.fab1);
        share = findViewById(R.id.fab2);
        close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.close);
        open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.open);
        clock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clock_rotation);
        anticlock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anticlock_rotation);

        textview_mail = (TextView) findViewById(R.id.textview_mail);
        textview_share = (TextView) findViewById(R.id.textview_share);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isOpen) {

                    textview_mail.setVisibility(View.INVISIBLE);
                    textview_share.setVisibility(View.INVISIBLE);
                    share.startAnimation(close);
                    mail.startAnimation(close);
                    main.startAnimation(anticlock);
                    share.setClickable(false);
                    mail.setClickable(false);
                    isOpen = false;
                } else {
                    textview_mail.setVisibility(View.VISIBLE);
                    textview_share.setVisibility(View.VISIBLE);
                    share.startAnimation(open);
                    mail.startAnimation(open);
                    main.startAnimation(clock);
                    share.setClickable(true);
                    mail.setClickable(true);
                    isOpen = true;
                }

            }
        });


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(FloatingMenuActivity.this, "Share", Toast.LENGTH_SHORT).show();

            }
        });

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FloatingMenuActivity.this, "Email", Toast.LENGTH_SHORT).show();

            }
        });


    }
}