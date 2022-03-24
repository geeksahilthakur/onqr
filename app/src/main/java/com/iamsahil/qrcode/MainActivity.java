package com.iamsahil.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText name  = findViewById(R.id.pa);
        EditText mail  = findViewById(R.id.paemail);
        Button btn = findViewById(R.id.btn);
        //TextView sahil = findViewById(R.id.sahil);


        String str1 = "upi://pay?pa=";
        String str2 = "&pn=";
        String str3 = "&tn=Pay to ";
        String str4 = "&tr=WHATSAPP_QR";
        String upi = str1+mail.getText().toString().replaceAll(" ","")+str2+name.getText().toString().replaceAll(" ","%20")+str3+str4;

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), qrcode.class);
                String upi = str1+mail.getText().toString().replaceAll(" ","")+str2+name.getText().toString()+"&cu=INR"+ str3 + name.getText().toString()+str4;
                String id = mail.getText().toString();
                String usr = name.getText().toString();
                i.putExtra("upi", upi);
                i.putExtra("id", id);
                i.putExtra("usr", usr);
                startActivity(i);
            }
        });

//        sahil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent Getintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/geeksahil/"));
//                startActivity(Getintent);
//            }
//        });


    }
}