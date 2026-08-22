package com.example.parkkro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class Payment extends AppCompatActivity implements PaymentResultListener {

    DatabaseReference databaseReference;

    FirebaseDatabase firebaseDatabase;
    TextView P_name,P_phone,P_vn,P_cost,P_Type,P_Time,P_Id,error;
    Button pay,Continue_btn;

    CardView card_done;
    int paisa;
    final int p = 100;

    String Name,vn, phone, cost,type,rpt,PaymentId,slotNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        firebaseDatabase.getInstance().getReference();

        P_name = findViewById(R.id.P_name);
        P_phone = findViewById(R.id.P_phone);
        P_vn = findViewById(R.id.P_vn);
        P_cost = findViewById(R.id.P_cost);
        P_Type = findViewById(R.id.P_Type);
        P_Time = findViewById(R.id.P_Time);
        P_Id = findViewById(R.id.P_Id);
        error = findViewById(R.id.error);

        Continue_btn = findViewById(R.id.Continue_btn);

        card_done = findViewById(R.id.card_done);


         Name = MemoryData.getName(getApplicationContext());
         vn = MemoryData.getVnum(getApplicationContext());
         phone= MemoryData.getPhone(getApplicationContext());

         cost = getIntent().getStringExtra("paisa");
         type = getIntent().getStringExtra("type");
         rpt = getIntent().getStringExtra("rpt");
         slotNumber = getIntent().getStringExtra("slot");

         MemoryData.savedSlot(slotNumber,this);

        Toast.makeText(this, ""+slotNumber, Toast.LENGTH_SHORT).show();

//         P_name.setText("Name: "+Name);
//         P_phone.setText("Phone: "+phone);
//         P_vn.setText(vn);
//         P_cost.setText("Cost: "+cost+"₹");
//         P_Type.setText("Type: "+type);
//         P_Time.setText("Time: "+rpt+"h");
//         P_Id.setText("After payment");


         P_name.setText("Name: "+MemoryData.getName(this));
         P_phone.setText("Phone: "+MemoryData.getPhone(this));
         P_vn.setText(MemoryData.getVnum(this));
         P_cost.setText("Cost: "+MemoryData.getPaisa(this)+"₹");
         P_Type.setText("Type: "+MemoryData.getType(this));
         P_Time.setText("Time: "+MemoryData.getRpt(this)+"h");


         PaymentId = MemoryData.getPaymentId(this);

         if (PaymentId.isEmpty()){
             P_Id.setText("After payment");

         }else {
             P_Id.setText(PaymentId);
         }


        paisa = Integer.parseInt(MemoryData.getPaisa(this))*p;


        pay = findViewById(R.id.button);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Checkout checkout = new Checkout();
                checkout.setKeyID("rzp_test_TpaFRSIneagnvk");
                checkout.setImage(R.drawable.panda);

                JSONObject object = new JSONObject();

                try {
                    object.put("name","Parkkro");
                    object.put("description", "parking payment");

                    object.put("amount",paisa); //yaha
                    object.put("prefill.contact",phone); // yaha

                    checkout.open(Payment.this,object);

                }catch (JSONException e){
                    e.printStackTrace();

                    //Toast.makeText(Payment.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }


            }
        });

        Continue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Slots.class);
                startActivity(intent);
            }
        });


    }//onCreate



    @Override
    public void onPaymentSuccess(String s){


        Toast.makeText(this, "PaymentSuccessful"+" "+s, Toast.LENGTH_SHORT).show();
        PaymentId = s;

        try {
            dataBase();

        }catch (Exception e){
            Toast.makeText(this, "Exception: "+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            error.setText(e.getLocalizedMessage());
        }


    }



    @Override
    public void onPaymentError(int i,String s){

        Toast.makeText(this, "Id:"+i+" : " +s+ " PaymentError", Toast.LENGTH_SHORT).show();

    }


    private void dataBase() {

        P_Id.setText(PaymentId);
                String time = (String) DateFormat.format("HH:mm", new Date());

        User user = new User(type,time,"",Name,vn,rpt,phone );

        databaseReference.child("Slots").child(slotNumber).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {

                                    Toast.makeText(getApplicationContext(),"slot free "+" "+slotNumber,Toast.LENGTH_LONG).show();
                                    card_done.setVisibility(View.VISIBLE);

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplicationContext(), "Database: "+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });



    }

}