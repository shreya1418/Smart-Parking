package com.example.parkkro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Loding_page extends AppCompatActivity {

    Animation left;

    ImageView img,twoW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding_page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        left = AnimationUtils.loadAnimation(this,R.anim.left);

        img = findViewById(R.id.img);
        twoW = findViewById(R.id.twoW);

        twoW.setAnimation(left);




        String str = MemoryData.getData(Loding_page.this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (str.isEmpty()){
                    Intent intent = new Intent(getApplicationContext(),Account.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(getApplicationContext(),Slots.class);
                    startActivity(intent);
                    finish();
                }

            }
        },2500);


    }
}