package com.example.parkkro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Slots extends AppCompatActivity {


    ImageView slot1, slot2,slot3,slot4,slot5,slot6,slot7,slot8;

    CardView card_time,slot_Free_card;

    FrameLayout frameL;

    RelativeLayout ChargingLayout;
    BottomNavigationView bottomNavigationView;
    DatabaseReference databaseReference;

    Button next,btn_no,btn_confirm;
    //Button Rpt;
   // Button slot1_btn;

    TextView Tv_CT,Tv_total;

    Spinner Time_Spinner,wheeler_Spinner;
    String time;
    String CurrentTime, UserTime;

    String timeH, timeM,CtimeH,CtimeM,totalTime;

    Animation top,right,left,bottom;


    String  paisa;
    String wheelerstr;

    String rpt,slotNumber;

    String slot_str_1= "";
    String slot_str_2= "";

    String slot_str_3= "";

    String slot_str_4= "";

    String slot_str_5= "";

    String slot_str_6= "";

    String slot_str_7= "";

    String slot_str_8= "";

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slots);


        top = AnimationUtils.loadAnimation(this,R.anim.top);
        left = AnimationUtils.loadAnimation(this,R.anim.left);

        slot1 = findViewById(R.id.slot1);
        slot2 = findViewById(R.id.slot2);
        slot3 = findViewById(R.id.slot3);
        slot4 = findViewById(R.id.slot4);
        slot5 = findViewById(R.id.slot5);
        slot6 = findViewById(R.id.slot6);
        slot7 = findViewById(R.id.slot7);
        slot8 = findViewById(R.id.slot8);


        next = findViewById(R.id.Next_Btn);
        btn_no = findViewById(R.id.btn_no);
        btn_confirm = findViewById(R.id.btn_confirm);
        //Rpt = findViewById(R.id.RPT_Btn);
       //
        //
        //slot1_btn = findViewById(R.id.slot1_btn);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        card_time = findViewById(R.id.card_time);
        slot_Free_card = findViewById(R.id.slot_Free_card);
        frameL = findViewById(R.id.frameL);
        bottomNavigationView = findViewById(R.id.bottom_nav_bar);


        Tv_CT = findViewById(R.id.Tv_CT);
        Tv_total = findViewById(R.id.Tv_total);


        //
        Time_Spinner = findViewById(R.id.Time_spiner);
        wheeler_Spinner = findViewById(R.id.type);

        String[] hour = {"Enter time","30m","1h","2h","3h","5h","8h"};
        String[] wheeler={"2","4"};

        //1st vala
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Slots.this,android.R.layout.simple_spinner_item,hour);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //2nd vala
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Slots.this,android.R.layout.simple_spinner_item,wheeler);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        Time_Spinner.setAdapter(adapter);
        wheeler_Spinner.setAdapter(adapter1);

        String Name = MemoryData.getName(getApplicationContext());
        String vn = MemoryData.getVnum(getApplicationContext());
        String phoneNum = MemoryData.getPhone(getApplicationContext());
        //


        reference = FirebaseDatabase.getInstance().getReference("Slots");
        reference.child("slot1").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){


                    if (task.getResult().exists()){

                        DataSnapshot dataSnapshot = task.getResult();
                        String slot = String.valueOf(dataSnapshot.child("slot").getValue());

                        if (slot.equals("full")){

                            //Toast.makeText(getApplicationContext(),"Slot 1: "+slot,Toast.LENGTH_LONG).show();
                            slot1.setImageResource(R.drawable.fourw);
                            //slot1.setAnimation(left);

                            slot_str_1 = "1";

                        }else{
                            Toast.makeText(Slots.this, "Slot 1 is Free", Toast.LENGTH_SHORT).show();
                            slot1.setImageResource(R.drawable.greenbr);
                        }



                    }else {
                        Toast.makeText(Slots.this, "Slot 1 is Free", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(Slots.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                }
            }
        });


        reference.child("slot2").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){


                    if (task.getResult().exists()){

                        DataSnapshot dataSnapshot = task.getResult();
                        String slot = String.valueOf(dataSnapshot.child("slot").getValue());

                        if (slot.equals("full")){

                            //Toast.makeText(getApplicationContext(),"Slot 2: "+slot,Toast.LENGTH_LONG).show();
                            slot2.setImageResource(R.drawable.fourw);
                            //slot1.setAnimation(left);

                            slot_str_2 = "1";

                        }else{
                            Toast.makeText(Slots.this, "Slot 2 is Free", Toast.LENGTH_SHORT).show();
                            slot2.setImageResource(R.drawable.greenbr);
                        }



                    }else {
                        Toast.makeText(Slots.this, "Slot 2 is Free", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(Slots.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                }
            }
        });


        reference.child("slot3").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){


                    if (task.getResult().exists()){

                        DataSnapshot dataSnapshot = task.getResult();
                        String slot = String.valueOf(dataSnapshot.child("slot").getValue());

                        if (slot.equals("full")){

                            //Toast.makeText(getApplicationContext(),"Slot 3: "+slot,Toast.LENGTH_LONG).show();
                            slot3.setImageResource(R.drawable.fourw);
                            //slot1.setAnimation(left);

                            slot_str_3 = "1";

                        }else{
                            Toast.makeText(Slots.this, "Slot 3 is Free", Toast.LENGTH_SHORT).show();
                            slot3.setImageResource(R.drawable.greenbr);
                        }



                    }else {
                        Toast.makeText(Slots.this, "Slot 3 is Free", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(Slots.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reference.child("slot4").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){


                    if (task.getResult().exists()){

                        DataSnapshot dataSnapshot = task.getResult();
                        String slot = String.valueOf(dataSnapshot.child("slot").getValue());

                        if (slot.equals("full")){

                            //Toast.makeText(getApplicationContext(),"Slot 4: "+slot,Toast.LENGTH_LONG).show();
                            slot4.setImageResource(R.drawable.fourw);
                            //slot1.setAnimation(left);

                            slot_str_4 = "1";

                        }else{
                            Toast.makeText(Slots.this, "Slot 4 is Free", Toast.LENGTH_SHORT).show();
                            slot4.setImageResource(R.drawable.greenbr);
                        }



                    }else {
                        Toast.makeText(Slots.this, "Slot 4 is Free", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(Slots.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reference.child("slot5").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){


                    if (task.getResult().exists()){

                        DataSnapshot dataSnapshot = task.getResult();
                        String slot = String.valueOf(dataSnapshot.child("slot").getValue());

                        if (slot.equals("full")){

                            //Toast.makeText(getApplicationContext(),"Slot 5: "+slot,Toast.LENGTH_LONG).show();
                            slot5.setImageResource(R.drawable.fourw);
                            //slot1.setAnimation(left);

                            slot_str_5 = "1";

                        }else{
                            Toast.makeText(Slots.this, "Slot 5 is Free", Toast.LENGTH_SHORT).show();
                            slot5.setImageResource(R.drawable.greenbr);
                        }



                    }else {
                        Toast.makeText(Slots.this, "Slot 5 is Free", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(Slots.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //


        reference.child("slot6").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){


                    if (task.getResult().exists()){

                        DataSnapshot dataSnapshot = task.getResult();
                        String slot = String.valueOf(dataSnapshot.child("slot").getValue());

                        if (slot.equals("full")){

                            //Toast.makeText(getApplicationContext(),"Slot 6: "+slot,Toast.LENGTH_LONG).show();
                            slot6.setImageResource(R.drawable.fourw);
                            //slot6.setAnimation(left);

                            slot_str_6 = "1";

                        }else{
                            Toast.makeText(Slots.this, "Slot 6 is Free", Toast.LENGTH_SHORT).show();
                            slot5.setImageResource(R.drawable.greenbr);
                        }



                    }else {
                        Toast.makeText(Slots.this, "Slot 6 is Free", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(Slots.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                }
            }
        });


        reference.child("slot7").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){


                    if (task.getResult().exists()){

                        DataSnapshot dataSnapshot = task.getResult();
                        String slot = String.valueOf(dataSnapshot.child("slot").getValue());

                        if (slot.equals("full")){

                            //Toast.makeText(getApplicationContext(),"Slot 7: "+slot,Toast.LENGTH_LONG).show();
                            slot7.setImageResource(R.drawable.fourw);
                            //slot7.setAnimation(left);

                            slot_str_7 = "1";

                        }else{
                            Toast.makeText(Slots.this, "Slot 7 is Free", Toast.LENGTH_SHORT).show();
                            slot7.setImageResource(R.drawable.greenbr);
                        }



                    }else {
                        Toast.makeText(Slots.this, "Slot 7 is Free", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(Slots.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reference.child("slot8").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){


                    if (task.getResult().exists()){

                        DataSnapshot dataSnapshot = task.getResult();
                        String slot = String.valueOf(dataSnapshot.child("slot").getValue());

                        if (slot.equals("full")){

                            //Toast.makeText(getApplicationContext(),"Slot 8: "+slot,Toast.LENGTH_LONG).show();
                            slot8.setImageResource(R.drawable.fourw);
                            //slot8.setAnimation(left);

                            slot_str_8 = "1";

                        }else{
                            Toast.makeText(Slots.this, "Slot 8 is Free", Toast.LENGTH_SHORT).show();
                            slot8.setImageResource(R.drawable.greenbr);
                        }



                    }else {
                        Toast.makeText(Slots.this, "Slot 8 is Free", Toast.LENGTH_SHORT).show();
                    }


                }else {
                    Toast.makeText(Slots.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                }
            }
        });


        slot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (slot_str_1.equals("1")){

                    Toast.makeText(Slots.this,"Slot is full",Toast.LENGTH_SHORT).show();

                    return;

                }else{

                    card_time.setVisibility(View.VISIBLE);
                    card_time.setAnimation(top);
                    String time1 = (String) DateFormat.format("HH:mm", new Date());
                    Tv_CT.setText(time1);

                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (!Name.isEmpty() && !vn.isEmpty()){


                                time = (String) DateFormat.format("HH:mm", new Date());

                                CtimeH = (String) DateFormat.format("HH",new Date());
                                CtimeM = (String) DateFormat.format("mm",new Date());

//                            //Current time
//                            int H = Integer.parseInt((String) DateFormat.format("HH", new Date()));
//                            int Min = Integer.parseInt((String) DateFormat.format("mm", new Date()));
//
//
//                            if (UH > H){
//                                int FH = UH-H;
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//
//                            if (UH == H){
//                                int FH = 12;
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//
//                            if (UH < H){
//                                int FH = UH-H ;
//                                if (FH==-1){
//                                    FH = 11;
//                                }
//
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//

                                //UH and UM user entered time
//                            int FinalHH = UH-H;
//                            int FinalMM = UM-Min;

                                //Tv_total.setText(FinalHH+":"+FinalMM);

                                // Toast.makeText(Slots.this, "Total Time :"+FinalHH, Toast.LENGTH_LONG).show(
                                if (rpt.equals("0")){
                                    Toast.makeText(Slots.this, "Please select time", Toast.LENGTH_SHORT).show();
                                    return;
                                }

                                if (rpt.equals("1")){
                                    if (CtimeH.equals("24")){
                                        totalTime = "13"+":"+CtimeM;
                                        Toast.makeText(getApplicationContext(),""+totalTime,Toast.LENGTH_SHORT).show();
                                    }
                                }

                                if (rpt.equals("1")){

                                    int th = 1;
                                    int ch = Integer.parseInt(CtimeH);

                                    totalTime = String.valueOf(ch+th);
                                    Toast.makeText(Slots.this, ""+totalTime, Toast.LENGTH_SHORT).show();
                                }

                                //----------------------------Memory data-------------------------------------//

                                MemoryData.savedPaisa(paisa,getApplicationContext());
                                MemoryData.savedType(wheelerstr,getApplicationContext());
                                MemoryData.savedRpt(rpt,getApplicationContext());
                                MemoryData.savedSlot("slot1",getApplicationContext());

                                //----------------------------Memory data-------------------------------------//


                                Intent intent = new Intent(Slots.this, MainActivity.class);
                                intent.putExtra("paisa",paisa);
                                intent.putExtra("type",wheelerstr);
                                intent.putExtra("rpt",rpt);
                                intent.putExtra("slot","slot1");
                                startActivity(intent);


//                            databaseReference.child("Slots").child("slot1").setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void unused) {
//
//                                    slot1.setImageResource(R.drawable.fourw);
//                                    Toast.makeText(getApplicationContext(),"slot booked (slot number 1)",Toast.LENGTH_LONG).show();
//                                    card_time.setVisibility(View.GONE);
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                                }
//                            });

                            }else {
                                Toast.makeText(getApplicationContext(),"Something Went Wrong, slot not booked",Toast.LENGTH_LONG).show();
                            }

                        }
                    });

                }


            }
        });



        slot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (slot_str_2.equals("1")){

                    Toast.makeText(Slots.this,"Slot is full",Toast.LENGTH_SHORT).show();

                    return;

                }else{

                    card_time.setVisibility(View.VISIBLE);
                    card_time.setAnimation(top);
                    String time1 = (String) DateFormat.format("HH:mm", new Date());
                    Tv_CT.setText(time1);

                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (!Name.isEmpty() && !vn.isEmpty()){


                                time = (String) DateFormat.format("HH:mm", new Date());

                                CtimeH = (String) DateFormat.format("HH",new Date());
                                CtimeM = (String) DateFormat.format("mm",new Date());

//                            //Current time
//                            int H = Integer.parseInt((String) DateFormat.format("HH", new Date()));
//                            int Min = Integer.parseInt((String) DateFormat.format("mm", new Date()));
//
//
//                            if (UH > H){
//                                int FH = UH-H;
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//
//                            if (UH == H){
//                                int FH = 12;
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//
//                            if (UH < H){
//                                int FH = UH-H ;
//                                if (FH==-1){
//                                    FH = 11;
//                                }
//
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//

                                //UH and UM user entered time
//                            int FinalHH = UH-H;
//                            int FinalMM = UM-Min;

                                //Tv_total.setText(FinalHH+":"+FinalMM);

                                // Toast.makeText(Slots.this, "Total Time :"+FinalHH, Toast.LENGTH_LONG).show(
                                if (rpt.equals("0")){
                                    Toast.makeText(Slots.this, "Please select time", Toast.LENGTH_SHORT).show();
                                    return;
                                }

//                                if (rpt.equals("1")){
//                                    if (CtimeH.equals("24")){
//                                        totalTime = "13"+":"+CtimeM;
//                                        Toast.makeText(getApplicationContext(),""+totalTime,Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//
//                                if (rpt.equals("1")){
//
//                                    int th = 1;
//                                    int ch = Integer.parseInt(CtimeH);
//
//                                    totalTime = String.valueOf(ch+th);
//                                    Toast.makeText(Slots.this, ""+totalTime, Toast.LENGTH_SHORT).show();
//                                }



                                //----------------------------Memory data-------------------------------------//

                                MemoryData.savedPaisa(paisa,getApplicationContext());
                                MemoryData.savedType(wheelerstr,getApplicationContext());
                                MemoryData.savedRpt(rpt,getApplicationContext());
                                MemoryData.savedSlot("slot2",getApplicationContext());

                                //----------------------------Memory data-------------------------------------//


                                Intent intent = new Intent(Slots.this, MainActivity.class);
                                intent.putExtra("paisa",paisa);
                                intent.putExtra("type",wheelerstr);
                                intent.putExtra("rpt",rpt);
                                intent.putExtra("slot","slot2");
                                startActivity(intent);


//                            databaseReference.child("Slots").child("slot1").setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void unused) {
//
//                                    slot1.setImageResource(R.drawable.fourw);
//                                    Toast.makeText(getApplicationContext(),"slot booked (slot number 1)",Toast.LENGTH_LONG).show();
//                                    card_time.setVisibility(View.GONE);
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                                }
//                            });

                            }else {
                                Toast.makeText(getApplicationContext(),"Something Went Wrong, slot not booked",Toast.LENGTH_LONG).show();
                            }

                        }
                    });

                }


            }
        });


        slot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (slot_str_3.equals("1")){

                    Toast.makeText(Slots.this,"Slot is full",Toast.LENGTH_SHORT).show();

                    return;

                }else{

                    card_time.setVisibility(View.VISIBLE);
                    card_time.setAnimation(top);
                    String time1 = (String) DateFormat.format("HH:mm", new Date());
                    Tv_CT.setText(time1);

                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (!Name.isEmpty() && !vn.isEmpty()){


                                time = (String) DateFormat.format("HH:mm", new Date());

                                CtimeH = (String) DateFormat.format("HH",new Date());
                                CtimeM = (String) DateFormat.format("mm",new Date());

//                            //Current time
//                            int H = Integer.parseInt((String) DateFormat.format("HH", new Date()));
//                            int Min = Integer.parseInt((String) DateFormat.format("mm", new Date()));
//
//
//                            if (UH > H){
//                                int FH = UH-H;
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//
//                            if (UH == H){
//                                int FH = 12;
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//
//                            if (UH < H){
//                                int FH = UH-H ;
//                                if (FH==-1){
//                                    FH = 11;
//                                }
//
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//

                                //UH and UM user entered time
//                            int FinalHH = UH-H;
//                            int FinalMM = UM-Min;

                                //Tv_total.setText(FinalHH+":"+FinalMM);

                                // Toast.makeText(Slots.this, "Total Time :"+FinalHH, Toast.LENGTH_LONG).show(
                                if (rpt.equals("0")){
                                    Toast.makeText(Slots.this, "Please select time", Toast.LENGTH_SHORT).show();
                                    return;
                                }

//                                if (rpt.equals("1")){
//                                    if (CtimeH.equals("24")){
//                                        totalTime = "13"+":"+CtimeM;
//                                        Toast.makeText(getApplicationContext(),""+totalTime,Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//
//                                if (rpt.equals("1")){
//
//                                    int th = 1;
//                                    int ch = Integer.parseInt(CtimeH);
//
//                                    totalTime = String.valueOf(ch+th);
//                                    Toast.makeText(Slots.this, ""+totalTime, Toast.LENGTH_SHORT).show();
//                                }



                                //----------------------------Memory data-------------------------------------//

                                MemoryData.savedPaisa(paisa,getApplicationContext());
                                MemoryData.savedType(wheelerstr,getApplicationContext());
                                MemoryData.savedRpt(rpt,getApplicationContext());
                                MemoryData.savedSlot("slot3",getApplicationContext());

                                //----------------------------Memory data-------------------------------------//


                                Intent intent = new Intent(Slots.this, MainActivity.class);
                                intent.putExtra("paisa",paisa);
                                intent.putExtra("type",wheelerstr);
                                intent.putExtra("rpt",rpt);
                                intent.putExtra("slot","slot3");
                                startActivity(intent);


//                            databaseReference.child("Slots").child("slot1").setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void unused) {
//
//                                    slot1.setImageResource(R.drawable.fourw);
//                                    Toast.makeText(getApplicationContext(),"slot booked (slot number 1)",Toast.LENGTH_LONG).show();
//                                    card_time.setVisibility(View.GONE);
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                                }
//                            });

                            }else {
                                Toast.makeText(getApplicationContext(),"Something Went Wrong, slot not booked",Toast.LENGTH_LONG).show();
                            }

                        }
                    });

                }


            }
        });


        slot4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (slot_str_4.equals("1")){

                    Toast.makeText(Slots.this,"Slot is full",Toast.LENGTH_SHORT).show();

                    return;

                }else{

                    card_time.setVisibility(View.VISIBLE);
                    card_time.setAnimation(top);
                    String time1 = (String) DateFormat.format("HH:mm", new Date());
                    Tv_CT.setText(time1);

                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (!Name.isEmpty() && !vn.isEmpty()){


                                time = (String) DateFormat.format("HH:mm", new Date());

                                CtimeH = (String) DateFormat.format("HH",new Date());
                                CtimeM = (String) DateFormat.format("mm",new Date());

//                            //Current time
//                            int H = Integer.parseInt((String) DateFormat.format("HH", new Date()));
//                            int Min = Integer.parseInt((String) DateFormat.format("mm", new Date()));
//
//
//                            if (UH > H){
//                                int FH = UH-H;
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//
//                            if (UH == H){
//                                int FH = 12;
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//
//                            if (UH < H){
//                                int FH = UH-H ;
//                                if (FH==-1){
//                                    FH = 11;
//                                }
//
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//

                                //UH and UM user entered time
//                            int FinalHH = UH-H;
//                            int FinalMM = UM-Min;

                                //Tv_total.setText(FinalHH+":"+FinalMM);

                                // Toast.makeText(Slots.this, "Total Time :"+FinalHH, Toast.LENGTH_LONG).show(
                                if (rpt.equals("0")){
                                    Toast.makeText(Slots.this, "Please select time", Toast.LENGTH_SHORT).show();
                                    return;
                                }

//                                if (rpt.equals("1")){
//                                    if (CtimeH.equals("24")){
//                                        totalTime = "13"+":"+CtimeM;
//                                        Toast.makeText(getApplicationContext(),""+totalTime,Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//
//                                if (rpt.equals("1")){
//
//                                    int th = 1;
//                                    int ch = Integer.parseInt(CtimeH);
//
//                                    totalTime = String.valueOf(ch+th);
//                                    Toast.makeText(Slots.this, ""+totalTime, Toast.LENGTH_SHORT).show();
//                                }



                                //----------------------------Memory data-------------------------------------//

                                MemoryData.savedPaisa(paisa,getApplicationContext());
                                MemoryData.savedType(wheelerstr,getApplicationContext());
                                MemoryData.savedRpt(rpt,getApplicationContext());
                                MemoryData.savedSlot("slot4",getApplicationContext());

                                //----------------------------Memory data-------------------------------------//


                                Intent intent = new Intent(Slots.this, MainActivity.class);
                                intent.putExtra("paisa",paisa);
                                intent.putExtra("type",wheelerstr);
                                intent.putExtra("rpt",rpt);
                                intent.putExtra("slot","slot4");
                                startActivity(intent);


//                            databaseReference.child("Slots").child("slot1").setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void unused) {
//
//                                    slot1.setImageResource(R.drawable.fourw);
//                                    Toast.makeText(getApplicationContext(),"slot booked (slot number 1)",Toast.LENGTH_LONG).show();
//                                    card_time.setVisibility(View.GONE);
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                                }
//                            });

                            }else {
                                Toast.makeText(getApplicationContext(),"Something Went Wrong, slot not booked",Toast.LENGTH_LONG).show();
                            }

                        }
                    });

                }


            }
        });

        slot5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (slot_str_5.equals("1")){

                    Toast.makeText(Slots.this,"Slot is full",Toast.LENGTH_SHORT).show();

                    return;

                }else{

                    card_time.setVisibility(View.VISIBLE);
                    card_time.setAnimation(top);
                    String time1 = (String) DateFormat.format("HH:mm", new Date());
                    Tv_CT.setText(time1);

                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (!Name.isEmpty() && !vn.isEmpty()){


                                time = (String) DateFormat.format("HH:mm", new Date());

                                CtimeH = (String) DateFormat.format("HH",new Date());
                                CtimeM = (String) DateFormat.format("mm",new Date());

//                            //Current time
//                            int H = Integer.parseInt((String) DateFormat.format("HH", new Date()));
//                            int Min = Integer.parseInt((String) DateFormat.format("mm", new Date()));
//
//
//                            if (UH > H){
//                                int FH = UH-H;
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//
//                            if (UH == H){
//                                int FH = 12;
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//
//                            if (UH < H){
//                                int FH = UH-H ;
//                                if (FH==-1){
//                                    FH = 11;
//                                }
//
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//

                                //UH and UM user entered time
//                            int FinalHH = UH-H;
//                            int FinalMM = UM-Min;

                                //Tv_total.setText(FinalHH+":"+FinalMM);

                                // Toast.makeText(Slots.this, "Total Time :"+FinalHH, Toast.LENGTH_LONG).show(
                                if (rpt.equals("0")){
                                    Toast.makeText(Slots.this, "Please select time", Toast.LENGTH_SHORT).show();
                                    return;
                                }

//                                if (rpt.equals("1")){
//                                    if (CtimeH.equals("24")){
//                                        totalTime = "13"+":"+CtimeM;
//                                        Toast.makeText(getApplicationContext(),""+totalTime,Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//
//                                if (rpt.equals("1")){
//
//                                    int th = 1;
//                                    int ch = Integer.parseInt(CtimeH);
//
//                                    totalTime = String.valueOf(ch+th);
//                                    Toast.makeText(Slots.this, ""+totalTime, Toast.LENGTH_SHORT).show();
//                                }



                                //----------------------------Memory data-------------------------------------//

                                MemoryData.savedPaisa(paisa,getApplicationContext());
                                MemoryData.savedType(wheelerstr,getApplicationContext());
                                MemoryData.savedRpt(rpt,getApplicationContext());
                                MemoryData.savedSlot("slot5",getApplicationContext());

                                //----------------------------Memory data-------------------------------------//


                                Intent intent = new Intent(Slots.this, MainActivity.class);
                                intent.putExtra("paisa",paisa);
                                intent.putExtra("type",wheelerstr);
                                intent.putExtra("rpt",rpt);
                                intent.putExtra("slot","slot5");
                                startActivity(intent);


//                            databaseReference.child("Slots").child("slot1").setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void unused) {
//
//                                    slot1.setImageResource(R.drawable.fourw);
//                                    Toast.makeText(getApplicationContext(),"slot booked (slot number 1)",Toast.LENGTH_LONG).show();
//                                    card_time.setVisibility(View.GONE);
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                                }
//                            });

                            }else {
                                Toast.makeText(getApplicationContext(),"Something Went Wrong, slot not booked",Toast.LENGTH_LONG).show();
                            }

                        }
                    });

                }


            }
        });

        slot6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (slot_str_6.equals("1")){

                    Toast.makeText(Slots.this,"Slot is full",Toast.LENGTH_SHORT).show();

                    return;

                }else{

                    card_time.setVisibility(View.VISIBLE);
                    card_time.setAnimation(top);
                    String time1 = (String) DateFormat.format("HH:mm", new Date());
                    Tv_CT.setText(time1);

                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (!Name.isEmpty() && !vn.isEmpty()){


                                time = (String) DateFormat.format("HH:mm", new Date());

                                CtimeH = (String) DateFormat.format("HH",new Date());
                                CtimeM = (String) DateFormat.format("mm",new Date());

//                            //Current time
//                            int H = Integer.parseInt((String) DateFormat.format("HH", new Date()));
//                            int Min = Integer.parseInt((String) DateFormat.format("mm", new Date()));
//
//
//                            if (UH > H){
//                                int FH = UH-H;
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//
//                            if (UH == H){
//                                int FH = 12;
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//
//                            if (UH < H){
//                                int FH = UH-H ;
//                                if (FH==-1){
//                                    FH = 11;
//                                }
//
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//

                                //UH and UM user entered time
//                            int FinalHH = UH-H;
//                            int FinalMM = UM-Min;

                                //Tv_total.setText(FinalHH+":"+FinalMM);

                                // Toast.makeText(Slots.this, "Total Time :"+FinalHH, Toast.LENGTH_LONG).show(
                                if (rpt.equals("0")){
                                    Toast.makeText(Slots.this, "Please select time", Toast.LENGTH_SHORT).show();
                                    return;
                                }

//                                if (rpt.equals("1")){
//                                    if (CtimeH.equals("24")){
//                                        totalTime = "13"+":"+CtimeM;
//                                        Toast.makeText(getApplicationContext(),""+totalTime,Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//
//                                if (rpt.equals("1")){
//
//                                    int th = 1;
//                                    int ch = Integer.parseInt(CtimeH);
//
//                                    totalTime = String.valueOf(ch+th);
//                                    Toast.makeText(Slots.this, ""+totalTime, Toast.LENGTH_SHORT).show();
//                                }



                                //----------------------------Memory data-------------------------------------//

                                MemoryData.savedPaisa(paisa,getApplicationContext());
                                MemoryData.savedType(wheelerstr,getApplicationContext());
                                MemoryData.savedRpt(rpt,getApplicationContext());
                                MemoryData.savedSlot("slot6",getApplicationContext());

                                //----------------------------Memory data-------------------------------------//


                                Intent intent = new Intent(Slots.this, MainActivity.class);
                                intent.putExtra("paisa",paisa);
                                intent.putExtra("type",wheelerstr);
                                intent.putExtra("rpt",rpt);
                                intent.putExtra("slot","slot6");
                                startActivity(intent);


//                            databaseReference.child("Slots").child("slot1").setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void unused) {
//
//                                    slot1.setImageResource(R.drawable.fourw);
//                                    Toast.makeText(getApplicationContext(),"slot booked (slot number 1)",Toast.LENGTH_LONG).show();
//                                    card_time.setVisibility(View.GONE);
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                                }
//                            });

                            }else {
                                Toast.makeText(getApplicationContext(),"Something Went Wrong, slot not booked",Toast.LENGTH_LONG).show();
                            }

                        }
                    });

                }


            }
        });


        slot7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (slot_str_7.equals("1")){

                    Toast.makeText(Slots.this,"Slot is full",Toast.LENGTH_SHORT).show();

                    return;

                }else{

                    card_time.setVisibility(View.VISIBLE);
                    card_time.setAnimation(top);
                    String time1 = (String) DateFormat.format("HH:mm", new Date());
                    Tv_CT.setText(time1);

                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (!Name.isEmpty() && !vn.isEmpty()){


                                time = (String) DateFormat.format("HH:mm", new Date());

                                CtimeH = (String) DateFormat.format("HH",new Date());
                                CtimeM = (String) DateFormat.format("mm",new Date());

//                            //Current time
//                            int H = Integer.parseInt((String) DateFormat.format("HH", new Date()));
//                            int Min = Integer.parseInt((String) DateFormat.format("mm", new Date()));
//
//
//                            if (UH > H){
//                                int FH = UH-H;
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//
//                            if (UH == H){
//                                int FH = 12;
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//
//                            if (UH < H){
//                                int FH = UH-H ;
//                                if (FH==-1){
//                                    FH = 11;
//                                }
//
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//

                                //UH and UM user entered time
//                            int FinalHH = UH-H;
//                            int FinalMM = UM-Min;

                                //Tv_total.setText(FinalHH+":"+FinalMM);

                                // Toast.makeText(Slots.this, "Total Time :"+FinalHH, Toast.LENGTH_LONG).show(
                                if (rpt.equals("0")){
                                    Toast.makeText(Slots.this, "Please select time", Toast.LENGTH_SHORT).show();
                                    return;
                                }

//                                if (rpt.equals("1")){
//                                    if (CtimeH.equals("24")){
//                                        totalTime = "13"+":"+CtimeM;
//                                        Toast.makeText(getApplicationContext(),""+totalTime,Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//
//                                if (rpt.equals("1")){
//
//                                    int th = 1;
//                                    int ch = Integer.parseInt(CtimeH);
//
//                                    totalTime = String.valueOf(ch+th);
//                                    Toast.makeText(Slots.this, ""+totalTime, Toast.LENGTH_SHORT).show();
//                                }



                                //----------------------------Memory data-------------------------------------//

                                MemoryData.savedPaisa(paisa,getApplicationContext());
                                MemoryData.savedType(wheelerstr,getApplicationContext());
                                MemoryData.savedRpt(rpt,getApplicationContext());
                                MemoryData.savedSlot("slot7",getApplicationContext());

                                //----------------------------Memory data-------------------------------------//


                                Intent intent = new Intent(Slots.this, MainActivity.class);
                                intent.putExtra("paisa",paisa);
                                intent.putExtra("type",wheelerstr);
                                intent.putExtra("rpt",rpt);
                                intent.putExtra("slot","slot7");
                                startActivity(intent);


//                            databaseReference.child("Slots").child("slot1").setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void unused) {
//
//                                    slot1.setImageResource(R.drawable.fourw);
//                                    Toast.makeText(getApplicationContext(),"slot booked (slot number 1)",Toast.LENGTH_LONG).show();
//                                    card_time.setVisibility(View.GONE);
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                                }
//                            });

                            }else {
                                Toast.makeText(getApplicationContext(),"Something Went Wrong, slot not booked",Toast.LENGTH_LONG).show();
                            }

                        }
                    });

                }


            }
        });

        slot8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (slot_str_8.equals("1")){

                    Toast.makeText(Slots.this,"Slot is full",Toast.LENGTH_SHORT).show();

                    return;

                }else{

                    card_time.setVisibility(View.VISIBLE);
                    card_time.setAnimation(top);
                    String time1 = (String) DateFormat.format("HH:mm", new Date());
                    Tv_CT.setText(time1);

                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (!Name.isEmpty() && !vn.isEmpty()){


                                time = (String) DateFormat.format("HH:mm", new Date());

                                CtimeH = (String) DateFormat.format("HH",new Date());
                                CtimeM = (String) DateFormat.format("mm",new Date());

//                            //Current time
//                            int H = Integer.parseInt((String) DateFormat.format("HH", new Date()));
//                            int Min = Integer.parseInt((String) DateFormat.format("mm", new Date()));
//
//
//                            if (UH > H){
//                                int FH = UH-H;
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//
//                            if (UH == H){
//                                int FH = 12;
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//
//                            if (UH < H){
//                                int FH = UH-H ;
//                                if (FH==-1){
//                                    FH = 11;
//                                }
//
//                                Toast.makeText(Slots.this, ""+FH, Toast.LENGTH_SHORT).show();
//                            }
//

                                //UH and UM user entered time
//                            int FinalHH = UH-H;
//                            int FinalMM = UM-Min;

                                //Tv_total.setText(FinalHH+":"+FinalMM);

                                // Toast.makeText(Slots.this, "Total Time :"+FinalHH, Toast.LENGTH_LONG).show(
                                if (rpt.equals("0")){
                                    Toast.makeText(Slots.this, "Please select time", Toast.LENGTH_SHORT).show();
                                    return;
                                }

//                                if (rpt.equals("1")){
//                                    if (CtimeH.equals("24")){
//                                        totalTime = "13"+":"+CtimeM;
//                                        Toast.makeText(getApplicationContext(),""+totalTime,Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//
//                                if (rpt.equals("1")){
//
//                                    int th = 1;
//                                    int ch = Integer.parseInt(CtimeH);
//
//                                    totalTime = String.valueOf(ch+th);
//                                    Toast.makeText(Slots.this, ""+totalTime, Toast.LENGTH_SHORT).show();
//                                }



                                //----------------------------Memory data-------------------------------------//

                                MemoryData.savedPaisa(paisa,getApplicationContext());
                                MemoryData.savedType(wheelerstr,getApplicationContext());
                                MemoryData.savedRpt(rpt,getApplicationContext());
                                MemoryData.savedSlot("slot8",getApplicationContext());

                                //----------------------------Memory data-------------------------------------//


                                Intent intent = new Intent(Slots.this, MainActivity.class);
                                intent.putExtra("paisa",paisa);
                                intent.putExtra("type",wheelerstr);
                                intent.putExtra("rpt",rpt);
                                intent.putExtra("slot","slot8");
                                startActivity(intent);


//                            databaseReference.child("Slots").child("slot1").setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void unused) {
//
//                                    slot1.setImageResource(R.drawable.fourw);
//                                    Toast.makeText(getApplicationContext(),"slot booked (slot number 1)",Toast.LENGTH_LONG).show();
//                                    card_time.setVisibility(View.GONE);
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                                }
//                            });

                            }else {
                                Toast.makeText(getApplicationContext(),"Something Went Wrong, slot not booked",Toast.LENGTH_LONG).show();
                            }

                        }
                    });

                }


            }
        });

        //onLongClick

        slot1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

//                    databaseReference.child("Slots").child("slot1").child("slot").setValue("").addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void unused) {
//
//                            slot1.setImageResource(R.drawable.greenbr);
//                            Toast.makeText(getApplicationContext(),"Slot Free (slot number 1)",Toast.LENGTH_LONG).show();
//
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
                reference = FirebaseDatabase.getInstance().getReference("Slots");
                reference.child("slot1").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()){

                            if (task.getResult().exists()){

                                DataSnapshot dataSnapshot = task.getResult();
                                String slot = String.valueOf(dataSnapshot.child("phoneNumber").getValue());

                                if (slot.equals(phoneNum)){

                                    Toast.makeText(getApplicationContext(),"your slot",Toast.LENGTH_LONG).show();
                                    slot_Free_card.setVisibility(View.VISIBLE);

                                    slotNumber = "slot1";
                                   // slot1.setImageResource(R.drawable.fourw);
                                   // slot1.setAnimation(left);
                                }else{
                                    Toast.makeText(Slots.this, "not your Slot ", Toast.LENGTH_SHORT).show();
                                    //slot1.setImageResource(R.drawable.greenbr);
                                }


                            }else {
                                Toast.makeText(Slots.this, "not your Slot", Toast.LENGTH_SHORT).show();
                            }

                        }else {
                            Toast.makeText(Slots.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                return true;
            }
        });

        slot2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

//                    databaseReference.child("Slots").child("slot1").child("slot").setValue("").addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void unused) {
//
//                            slot1.setImageResource(R.drawable.greenbr);
//                            Toast.makeText(getApplicationContext(),"Slot Free (slot number 1)",Toast.LENGTH_LONG).show();
//
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
                reference = FirebaseDatabase.getInstance().getReference("Slots");
                reference.child("slot2").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()){

                            if (task.getResult().exists()){

                                DataSnapshot dataSnapshot = task.getResult();
                                String slot = String.valueOf(dataSnapshot.child("phoneNumber").getValue());

                                if (slot.equals(phoneNum)){

                                    Toast.makeText(getApplicationContext(),"your slot",Toast.LENGTH_LONG).show();
                                    slot_Free_card.setVisibility(View.VISIBLE);

                                    slotNumber = "slot2";
                                    // slot1.setImageResource(R.drawable.fourw);
                                    // slot1.setAnimation(left);
                                }else{
                                    Toast.makeText(Slots.this, "not your Slot ", Toast.LENGTH_SHORT).show();
                                    //slot1.setImageResource(R.drawable.greenbr);
                                }


                            }else {
                                Toast.makeText(Slots.this, "not your Slot", Toast.LENGTH_SHORT).show();
                            }

                        }else {
                            Toast.makeText(Slots.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                return true;
            }
        });

        slot3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

//                    databaseReference.child("Slots").child("slot1").child("slot").setValue("").addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void unused) {
//
//                            slot1.setImageResource(R.drawable.greenbr);
//                            Toast.makeText(getApplicationContext(),"Slot Free (slot number 1)",Toast.LENGTH_LONG).show();
//
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
                reference = FirebaseDatabase.getInstance().getReference("Slots");
                reference.child("slot3").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()){

                            if (task.getResult().exists()){

                                DataSnapshot dataSnapshot = task.getResult();
                                String slot = String.valueOf(dataSnapshot.child("phoneNumber").getValue());

                                if (slot.equals(phoneNum)){

                                    Toast.makeText(getApplicationContext(),"your slot",Toast.LENGTH_LONG).show();
                                    slot_Free_card.setVisibility(View.VISIBLE);

                                    slotNumber = "slot3";
                                    // slot1.setImageResource(R.drawable.fourw);
                                    // slot1.setAnimation(left);
                                }else{
                                    Toast.makeText(Slots.this, "not your Slot ", Toast.LENGTH_SHORT).show();
                                    //slot1.setImageResource(R.drawable.greenbr);
                                }


                            }else {
                                Toast.makeText(Slots.this, "not your Slot", Toast.LENGTH_SHORT).show();
                            }

                        }else {
                            Toast.makeText(Slots.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                return true;
            }
        });

        slot4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

//                    databaseReference.child("Slots").child("slot1").child("slot").setValue("").addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void unused) {
//
//                            slot1.setImageResource(R.drawable.greenbr);
//                            Toast.makeText(getApplicationContext(),"Slot Free (slot number 1)",Toast.LENGTH_LONG).show();
//
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
                reference = FirebaseDatabase.getInstance().getReference("Slots");
                reference.child("slot4").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()){

                            if (task.getResult().exists()){

                                DataSnapshot dataSnapshot = task.getResult();
                                String slot = String.valueOf(dataSnapshot.child("phoneNumber").getValue());

                                if (slot.equals(phoneNum)){

                                    Toast.makeText(getApplicationContext(),"your slot",Toast.LENGTH_LONG).show();
                                    slot_Free_card.setVisibility(View.VISIBLE);

                                    slotNumber = "slot4";
                                    // slot1.setImageResource(R.drawable.fourw);
                                    // slot1.setAnimation(left);
                                }else{
                                    Toast.makeText(Slots.this, "not your Slot ", Toast.LENGTH_SHORT).show();
                                    //slot1.setImageResource(R.drawable.greenbr);
                                }


                            }else {
                                Toast.makeText(Slots.this, "not your Slot", Toast.LENGTH_SHORT).show();
                            }

                        }else {
                            Toast.makeText(Slots.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                return true;
            }
        });

        slot5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

//                    databaseReference.child("Slots").child("slot1").child("slot").setValue("").addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void unused) {
//
//                            slot1.setImageResource(R.drawable.greenbr);
//                            Toast.makeText(getApplicationContext(),"Slot Free (slot number 1)",Toast.LENGTH_LONG).show();
//
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
                reference = FirebaseDatabase.getInstance().getReference("Slots");
                reference.child("slot5").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()){

                            if (task.getResult().exists()){

                                DataSnapshot dataSnapshot = task.getResult();
                                String slot = String.valueOf(dataSnapshot.child("phoneNumber").getValue());

                                if (slot.equals(phoneNum)){

                                    Toast.makeText(getApplicationContext(),"your slot",Toast.LENGTH_LONG).show();
                                    slot_Free_card.setVisibility(View.VISIBLE);

                                    slotNumber = "slot5";
                                    // slot1.setImageResource(R.drawable.fourw);
                                    // slot1.setAnimation(left);
                                }else{
                                    Toast.makeText(Slots.this, "not your Slot ", Toast.LENGTH_SHORT).show();
                                    //slot1.setImageResource(R.drawable.greenbr);
                                }


                            }else {
                                Toast.makeText(Slots.this, "not your Slot", Toast.LENGTH_SHORT).show();
                            }

                        }else {
                            Toast.makeText(Slots.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                return true;
            }
        });

        slot6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

//                    databaseReference.child("Slots").child("slot1").child("slot").setValue("").addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void unused) {
//
//                            slot1.setImageResource(R.drawable.greenbr);
//                            Toast.makeText(getApplicationContext(),"Slot Free (slot number 1)",Toast.LENGTH_LONG).show();
//
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
                reference = FirebaseDatabase.getInstance().getReference("Slots");
                reference.child("slot6").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()){

                            if (task.getResult().exists()){

                                DataSnapshot dataSnapshot = task.getResult();
                                String slot = String.valueOf(dataSnapshot.child("phoneNumber").getValue());

                                if (slot.equals(phoneNum)){

                                    Toast.makeText(getApplicationContext(),"your slot",Toast.LENGTH_LONG).show();
                                    slot_Free_card.setVisibility(View.VISIBLE);

                                    slotNumber = "slot6";
                                    // slot1.setImageResource(R.drawable.fourw);
                                    // slot1.setAnimation(left);
                                }else{
                                    Toast.makeText(Slots.this, "not your Slot ", Toast.LENGTH_SHORT).show();
                                    //slot1.setImageResource(R.drawable.greenbr);
                                }


                            }else {
                                Toast.makeText(Slots.this, "not your Slot", Toast.LENGTH_SHORT).show();
                            }

                        }else {
                            Toast.makeText(Slots.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                return true;
            }
        });

        slot7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

//                    databaseReference.child("Slots").child("slot1").child("slot").setValue("").addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void unused) {
//
//                            slot1.setImageResource(R.drawable.greenbr);
//                            Toast.makeText(getApplicationContext(),"Slot Free (slot number 1)",Toast.LENGTH_LONG).show();
//
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
                reference = FirebaseDatabase.getInstance().getReference("Slots");
                reference.child("slot7").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()){

                            if (task.getResult().exists()){

                                DataSnapshot dataSnapshot = task.getResult();
                                String slot = String.valueOf(dataSnapshot.child("phoneNumber").getValue());

                                if (slot.equals(phoneNum)){

                                    Toast.makeText(getApplicationContext(),"your slot",Toast.LENGTH_LONG).show();
                                    slot_Free_card.setVisibility(View.VISIBLE);

                                    slotNumber = "slot7";
                                    // slot1.setImageResource(R.drawable.fourw);
                                    // slot1.setAnimation(left);
                                }else{
                                    Toast.makeText(Slots.this, "not your Slot ", Toast.LENGTH_SHORT).show();
                                    //slot1.setImageResource(R.drawable.greenbr);
                                }


                            }else {
                                Toast.makeText(Slots.this, "not your Slot", Toast.LENGTH_SHORT).show();
                            }

                        }else {
                            Toast.makeText(Slots.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                return true;
            }
        });


        slot8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

//                    databaseReference.child("Slots").child("slot1").child("slot").setValue("").addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void unused) {
//
//                            slot1.setImageResource(R.drawable.greenbr);
//                            Toast.makeText(getApplicationContext(),"Slot Free (slot number 1)",Toast.LENGTH_LONG).show();
//
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
                reference = FirebaseDatabase.getInstance().getReference("Slots");
                reference.child("slot8").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()){

                            if (task.getResult().exists()){

                                DataSnapshot dataSnapshot = task.getResult();
                                String slot = String.valueOf(dataSnapshot.child("phoneNumber").getValue());

                                if (slot.equals(phoneNum)){

                                    Toast.makeText(getApplicationContext(),"your slot",Toast.LENGTH_LONG).show();
                                    slot_Free_card.setVisibility(View.VISIBLE);

                                    slotNumber = "slot8";
                                    // slot1.setImageResource(R.drawable.fourw);
                                    // slot1.setAnimation(left);
                                }else{
                                    Toast.makeText(Slots.this, "not your Slot ", Toast.LENGTH_SHORT).show();
                                    //slot1.setImageResource(R.drawable.greenbr);
                                }


                            }else {
                                Toast.makeText(Slots.this, "not your Slot", Toast.LENGTH_SHORT).show();
                            }

                        }else {
                            Toast.makeText(Slots.this, "Failed to get data", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                return true;
            }
        });


//        slot1_btn.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//
//
//
//                databaseReference.child("Slots").child("slot1").child("slot").setValue("").addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//
//                        slot1.setImageResource(R.drawable.greenbr);
//                        Toast.makeText(getApplicationContext(),"Slot Free (slot number 1)",Toast.LENGTH_LONG).show();
//
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                return false;
//            }
//        });



//        Rpt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                TimePicker();
//            }
//        });



        Time_Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String val = adapterView.getItemAtPosition(i).toString();

                String pos = String.valueOf(i);

                if (pos.equals("0")){
                    Tv_total.setText("0");
                    paisa = Tv_total.getText().toString();
                    rpt = "0";
                }

                if (pos.equals("1")){
                    Tv_total.setText("20");
                    paisa = Tv_total.getText().toString();
                    rpt = "30";
                }

                if (pos.equals("2")){
                    Tv_total.setText("40");
                    paisa = Tv_total.getText().toString();
                    rpt = "1";
                }

                if (pos.equals("3")){
                    Tv_total.setText("70");
                    paisa = Tv_total.getText().toString();
                    rpt = "2";
                }

                if (pos.equals("4")){
                    Tv_total.setText("90");
                    paisa = Tv_total.getText().toString();
                    rpt = "3";
                }

                if (pos.equals("5")){
                    Tv_total.setText("120");
                    paisa = Tv_total.getText().toString();
                    rpt = "5";
                }

                if (pos.equals("6")){
                    Tv_total.setText("150");
                    paisa = Tv_total.getText().toString();
                    rpt = "8";
                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        wheeler_Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String pos = String.valueOf(i);

                if (pos.equals("0")){

                    wheelerstr = "Two wheeler";
                }

                if (pos.equals("1")){
                    wheelerstr = "Four wheeler";
                    Toast.makeText(Slots.this, "Four wheeler", Toast.LENGTH_SHORT).show();
                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                slot_Free_card.setVisibility(View.GONE);

            }
        });

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //
//                databaseReference.child("Slots").child("slot1").child("slot").setValue("").addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//
//                        slot1.setImageResource(R.drawable.greenbr);
//                        slot_Free_card.setVisibility(View.GONE);
//                        Toast.makeText(getApplicationContext(),"Slot Free (slot number 1)",Toast.LENGTH_LONG).show();
//
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(Slots.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });

                Intent intent = new Intent(Slots.this,Payment.class);
                intent.putExtra("slotFree",slotNumber);

                intent.putExtra("paisa",paisa);
                intent.putExtra("type",wheelerstr);
                intent.putExtra("rpt",rpt);
                intent.putExtra("slot","slot1");

                startActivity(intent);

            }
        });


        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.menu_Slots:
                    //ChargingLayout.setVisibility(View.INVISIBLE);

                    break;

                case R.id.menu_Washing:

                    Intent i = new Intent(Slots.this,Wash.class);
                    startActivity(i);
                    //replaceFragment(new Washing());
                    break;


                case R.id.menu_Charging:
                    //replaceFragment(new Charging());

                    Intent intent = new Intent(Slots.this,Charging.class);
                    startActivity(intent);
                    break;
            }

            return true;
        });

    }//onCreate

//    public void TimePicker(){
//
//        TimePickerDialog timePickerDialog = new TimePickerDialog(this ,new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker timePicker, int i, int i1) {
//               //Rpt.setText(String.valueOf(i)+":"+String.valueOf(i1));
//                UH = i;
//                UM = i1;
//
//            }
//        }, 15, 00, true);
//
//        timePickerDialog.show();
//    }

//    private void replaceFragment(Fragment fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frameL,fragment);
//        fragmentTransaction.commit();
//    }

}