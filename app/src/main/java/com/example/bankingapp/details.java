package com.example.bankingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.sql.BatchUpdateException;
import java.util.jar.Attributes;

public class details extends AppCompatActivity {
    String userdata;
    String data,data1,data2,data3,data4,data5;
    String Name;
    TextView username,balance,userphonenumber,email,account_no,ifsc_code;
    FirebaseDatabase database;
    DatabaseReference ref;
    Button pay_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_details);
        TextView username = findViewById(R.id.username);
        TextView userphonenumber = findViewById(R.id.userphonenumber);
        TextView account_no = findViewById(R.id.account_no);
        TextView email = findViewById(R.id.email);
        TextView balance = findViewById(R.id.balance);
        TextView ifsc_code = findViewById(R.id.ifsc_code);
        Button pay_button = findViewById(R.id.transfer_button);

        Name = getIntent().getStringExtra("Name");

        userdata = getIntent().getStringExtra("Name");


        database = FirebaseDatabase.getInstance();
        ref = database.getReference("User");

        ref.child(Name).child("Name").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                data = snapshot.getValue(String.class);
                username.setText(String.valueOf(data));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ref.child(Name).child("Current Balance").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                data1 = snapshot.getValue(String.class);
                balance.setText(String.valueOf(data1));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ref.child(Name).child("Mobile Number").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                data2 = snapshot.getValue(String.class);
                userphonenumber.setText(String.valueOf(data2));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ref.child(Name).child("Email id").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                data3 = snapshot.getValue(String.class);
                email.setText(String.valueOf(data3));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ref.child(Name).child("Account No").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                data4 = snapshot.getValue(String.class);
                account_no.setText(String.valueOf(data4));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ref.child(Name).child("IFSC Code").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                data5 = snapshot.getValue(String.class);
                ifsc_code.setText(String.valueOf(data5));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        pay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExampleDialog exampleDialog = new ExampleDialog(userdata);
                exampleDialog.show(getSupportFragmentManager(),"example dialog");

            }
        });



    }


}