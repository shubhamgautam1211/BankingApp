package com.example.bankingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends AppCompatActivity {
    String selfdata;
    Button button2,button3;
    String selfname;
    TextView selfbalance,refresh;
    FirebaseDatabase selfdatabase;
    DatabaseReference selfref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
        TextView selfbalance = findViewById(R.id.self_balance);
        TextView refresh = findViewById(R.id.refresh);
        Button button3 = findViewById(R.id.button3);



        selfdatabase = FirebaseDatabase.getInstance();
        selfref = selfdatabase.getReference("User").child("Shubham Gautam");

        selfref.child("Current Balance").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                selfdata = snapshot.getValue(String.class);
                selfbalance.setText(String.valueOf(selfdata));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selfref.child("Current Balance").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        selfdata = snapshot.getValue(String.class);
                        selfbalance.setText(String.valueOf(selfdata));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,transaction_history.class);
                startActivity(intent);
            }
        });

    }


    public void openActivity3(){
        Intent intent = new Intent(this,user.class);
        startActivity(intent);
    }

}