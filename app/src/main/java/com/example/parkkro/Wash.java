package com.example.parkkro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Wash extends AppCompatActivity {


    ImageButton backArrow;

    Button washBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wash);


        backArrow = findViewById(R.id.backArrow);
        washBtn = findViewById(R.id.washBtn);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wash.this, Slots.class);
                startActivity(intent);
            }
        });

        washBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+91 9967897981"));
                startActivity(intent);
            }
        });

    }
}