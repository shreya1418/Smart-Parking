package com.example.parkkro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Account extends AppCompatActivity {


    CardView login_card;
    EditText acName,accPhone,acVn,accEmail,accPass;
    TextView Tvnumber;
    CardView cardView;
    Button next,sendOtpBtn;
    ImageView eyeOpen,eyeClose,pandaimg;

    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;

    Animation left,top,bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        //EditTexts
        acName = findViewById(R.id.acc_Name);
        accPhone = findViewById(R.id.acc_Phone);
        accEmail = findViewById(R.id.acc_Email);
        accPass = findViewById(R.id.acc_pass);
        acVn = findViewById(R.id.acc_VehicleNumber);
        //TextViews
        Tvnumber = findViewById(R.id.Tv_number);

        //CardViews
        login_card = findViewById(R.id.login_card);
        cardView = findViewById(R.id.otp_card);
        cardView.setVisibility(View.INVISIBLE);

        //Button
        next = findViewById(R.id.nextBtn);
        sendOtpBtn = findViewById(R.id.send_otp);

        //imageView
        eyeOpen = findViewById(R.id.eyeOpen);
        eyeClose = findViewById(R.id.eyeClose);
        pandaimg = findViewById(R.id.panda);



        //Animations
        left = AnimationUtils.loadAnimation(this,R.anim.left);
        top = AnimationUtils.loadAnimation(this,R.anim.top);
        bottom = AnimationUtils.loadAnimation(this,R.anim.bottom);

        //setting Animations
        acName.setAnimation(top);
        accPhone.setAnimation(top);
        next.setAnimation(top);
        login_card.setAnimation(top);
        pandaimg.setAnimation(top);

        //FireBaseAuth
        mAuth = FirebaseAuth.getInstance();



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int o = accPhone.getText().length();
                if (o!=10){
                    Toast.makeText(Account.this, "10 nhi hai beta", Toast.LENGTH_SHORT).show();
                    accPhone.setError("plz enter 10 digit phone number");
                    return;
                }

                if (!accPhone.getText().toString().isEmpty()) {
                    Tvnumber.setText("+91-" + accPhone.getText().toString().trim());
                    cardView.setVisibility(View.VISIBLE);
                    cardView.animate().y(1000);

                    login_card.animate().x(0).y(-1500).setDuration(2000);

                }else {
                    Toast.makeText(getApplicationContext(),"Plz enter your phone number",Toast.LENGTH_SHORT).show();
                }
            }
        });



        sendOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!accPhone.getText().toString().isEmpty()){

                    otpSend();

                }else {
                    Toast.makeText(Account.this, "plz fill your phone number", Toast.LENGTH_SHORT).show();
                    cardView.setVisibility(View.INVISIBLE);
                }

            }
        });

        eyeOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eyeClose.setVisibility(View.VISIBLE);
                eyeOpen.setVisibility(View.GONE);
                accPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                pandaimg.animate().x(0).y(300).setDuration(300);
            }
        });

        eyeClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eyeOpen.setVisibility(View.VISIBLE);
                eyeClose.setVisibility(View.GONE);
                accPass.setInputType(InputType.TYPE_CLASS_TEXT);
                pandaimg.setVisibility(View.VISIBLE);
                pandaimg.animate().x(0).y(100).setDuration(300);

            }
        });

    }//

    private void otpSend() {

       // progressBar.setVisibility(View.VISIBLE);
      //  buttonGetOTP.setVisibility(View.VISIBLE);

        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                //progressBar.setVisibility(View.GONE);
                //buttonGetOTP.setVisibility(View.VISIBLE);

            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {

                login_card.animate().x(0).y(1000).setDuration(2000);
                cardView.setVisibility(View.GONE);
                Toast.makeText(Account.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                //verifyWithRecaptcha();
            }

            @Override
            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
               // progressBar.setVisibility(View.GONE);
               // buttonGetOTP.setVisibility(View.VISIBLE);
                Intent intent = new Intent(Account.this, verify_OTP.class);
                intent.putExtra("verificationId", verificationId);
                intent.putExtra("name",acName.getText().toString());
                intent.putExtra("mobile", accPhone.getText().toString());
                intent.putExtra("VehicleNumber",acVn.getText().toString());
                startActivity(intent);
                finish();
            }
        };
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91" + accPhone.getText().toString().trim())
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(mCallback)
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

}