package com.example.parkkro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseReference;

    FirebaseDatabase firebaseDatabase;
    TextView M_name,M_phone,M_vn,M_cost,M_Type,M_Time,M_Id,error;
    Button MContinue_btn;


    String MName,Mvn, Mphone, Mcost,Mtype,Mrpt,MPaymentId,MslotNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        firebaseDatabase.getInstance().getReference();

        M_name = findViewById(R.id.M_name);
        M_phone = findViewById(R.id.M_phone);
        M_vn = findViewById(R.id.M_vn);
        M_cost = findViewById(R.id.M_cost);
        M_Type = findViewById(R.id.M_Type);
        M_Time = findViewById(R.id.M_Time);
        M_Id = findViewById(R.id.M_Id);
        //error = findViewById(R.id.error);

        MContinue_btn = findViewById(R.id.MContinue_bt);




        MName = MemoryData.getName(getApplicationContext());
        Mvn = MemoryData.getVnum(getApplicationContext());
        Mphone= MemoryData.getPhone(getApplicationContext());

        Mcost = getIntent().getStringExtra("paisa");
        Mtype = getIntent().getStringExtra("type");
        Mrpt = getIntent().getStringExtra("rpt");
        MslotNumber = getIntent().getStringExtra("slot");

        MemoryData.savedSlot(MslotNumber,this);

        Toast.makeText(this, ""+MslotNumber, Toast.LENGTH_SHORT).show();

        M_name.setText("Name: "+MemoryData.getName(this));
        M_phone.setText("Phone: "+MemoryData.getPhone(this));
        M_vn.setText(MemoryData.getVnum(this));
        M_cost.setText("Cost: "+MemoryData.getPaisa(this)+"₹");
        M_Type.setText("Type: "+MemoryData.getType(this));
        M_Time.setText("Time: "+MemoryData.getRpt(this)+"h");

        MContinue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    dataBase();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(MainActivity.this, Slots.class);
                            startActivity(intent);

                        }
                    },2000);

                }catch (Exception e){
                    Toast.makeText(MainActivity.this,""+e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });


    }//onCreate


    private void dataBase() {

        M_Id.setText(MPaymentId);
        String time = (String) DateFormat.format("HH:mm", new Date());

        User user = new User(Mtype,time,"full",MName,Mvn,Mrpt,Mphone );

        databaseReference.child("Slots").child(MslotNumber).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

                Toast.makeText(getApplicationContext(),"slot booked "+" "+MslotNumber,Toast.LENGTH_LONG).show();


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Database: "+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }


}