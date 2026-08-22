package com.example.parkkro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class verify_OTP extends AppCompatActivity {

    TextView phone_num;
    EditText num1, num2, num3, num4, num5, num6;

    Button verifyBtn;

    //VideoView otp_video;

     private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;


    DatabaseReference databaseReference;
    String verificationId;

    ImageView image,img_lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);


        img_lock = findViewById(R.id.img_lock);
       //////////////////////////////////////////////otp_video = findViewById(R.id.otp_video);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        phone_num = findViewById(R.id.phone_num);







//        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.lock_otp);
//        otp_video.setVideoURI(uri);
//        otp_video.start();
//
//        otp_video.pause();

        //phone_num.setText(phoneNumber);
        verifyBtn = findViewById(R.id.verifyBtn);

        verificationId = getIntent().getStringExtra("verificationId");

        phone_num.setText(String.format("+91-%s", getIntent().getStringExtra("mobile")));
        String phone = getIntent().getStringExtra("mobile");
        String vnum = getIntent().getStringExtra("VehicleNumber");
        String name = getIntent().getStringExtra("name");






        // mAuth = FirebaseAuth.getInstance();

        setupOTPInputs();


        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String code = num1.getText().toString() +
                        num2.getText().toString() +
                        num3.getText().toString() +
                        num4.getText().toString() +
                        num5.getText().toString() +
                        num6.getText().toString();

                if (verificationId != null) {
                    //progressBar.setVisibility(View.VISIBLE);
                    verifyBtn.setVisibility(View.INVISIBLE);
                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(verificationId,code);

                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                   // otp_video.start();
                                    verifyBtn.setVisibility(View.VISIBLE);
                                    if (task.isSuccessful()) {


                                                MemoryData.savedName(name,verify_OTP.this);
                                                MemoryData.savedPhone(phone,verify_OTP.this);
                                                MemoryData.saveddata("login",verify_OTP.this);
                                                MemoryData.savedVnum(vnum,verify_OTP.this);

                                                //Toast.makeText(verify_OTP.this, ""+name+" "+phone, Toast.LENGTH_SHORT).show();

                                                databaseReference = FirebaseDatabase.getInstance().getReference();

                                                databaseReference.child("Accounts").child(phone).setValue(phone);

                                                databaseReference.child(phone).child("Name").setValue(name);
                                                databaseReference.child(phone).child("vnum").setValue(vnum);


                                                Intent intent = new Intent(getApplicationContext(),Slots.class);
                                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                startActivity(intent);

                                                Toast.makeText(getApplicationContext(), "Registration Completed Successfully", Toast.LENGTH_SHORT).show();




                                    } else {
                                        Toast.makeText(getApplicationContext(), "The Verification Code entered was invalid", Toast.LENGTH_SHORT).show();
                                    }

                                }

                            });
                }


            }
        });


    }

    private void setupOTPInputs() {

        num1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                num2.requestFocus();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        num2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                num3.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        num3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                num4.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        num4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                num5.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        num5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                num6.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

}