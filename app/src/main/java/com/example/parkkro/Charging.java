package com.example.parkkro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Charging extends AppCompatActivity {

    ImageButton backArrow;

    CardView olaCard, AtherCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charging);

        backArrow = findViewById(R.id.backArrow);
        olaCard = findViewById(R.id.olaCard);
        AtherCard = findViewById(R.id.AtherCard);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Charging.this, Slots.class);
                startActivity(intent);
            }
        });
    }
}