package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class transaction_history extends AppCompatActivity {

    RecyclerView recview;
    myadapter adapter;
    String d1,data4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        recview=findViewById(R.id.recview);
        data4 = (getIntent().getStringExtra("data4"));

        d1=getIntent().getStringExtra("val");
        recview.setLayoutManager(new LinearLayoutManager(transaction_history.this));
        FirebaseRecyclerOptions<model> options = new FirebaseRecyclerOptions
                .Builder<model>().setQuery(FirebaseDatabase.getInstance().getReference().child("PERSON")
                .child("Shubham Gautam"),model.class)
                .build();

        adapter = new myadapter(options);
        recview.setAdapter(adapter);




    }


    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}