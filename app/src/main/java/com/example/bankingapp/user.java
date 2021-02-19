package com.example.bankingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class user extends AppCompatActivity {

    TextView text1,text2,text3,text4,text5,text6,text7,text8,text9,text10;
    String Name,datatrans;
    ImageView transac;
    ImageView back_pressed;
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user);

        Button button1 = findViewById(R.id.button1);
        TextView text1 = findViewById(R.id.text1);

        Button button2 = findViewById(R.id.button2);
        TextView text2 = findViewById(R.id.text2);

        Button button3 = findViewById(R.id.button3);
        TextView text3 = findViewById(R.id.text3);

        Button button4 = findViewById(R.id.button4);
        TextView text4 = findViewById(R.id.text4);

        Button button5 = findViewById(R.id.button5);
        TextView text5 = findViewById(R.id.text5);

        Button button6 = findViewById(R.id.button6);
        TextView text6 = findViewById(R.id.text6);

        Button button7 = findViewById(R.id.button7);
        TextView text7 = findViewById(R.id.text7);

        Button button8 = findViewById(R.id.button8);
        TextView text8 = findViewById(R.id.text8);

        Button button9 = findViewById(R.id.button9);
        TextView text9 = findViewById(R.id.text9);

        Button button10 = findViewById(R.id.button10);
        TextView text10 = findViewById(R.id.text10);

        ImageView transac = findViewById(R.id.transac);
        ImageView back_pressed = findViewById(R.id.back_pressed);


        transac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(user.this,transaction_history.class);
                intent.putExtra("datatrans",datatrans);
                startActivity(intent);
            }
        });

        back_pressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user.this,Home.class);
                startActivity(intent);

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Name = (String) text1.getText();
                Intent intent = new Intent(user.this,details.class);
                intent.putExtra("Name",Name);
                startActivity(intent);

            }
        });



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Name = (String) text2.getText();
                Intent intent = new Intent(user.this,details.class);
                intent.putExtra("Name",Name);
                startActivity(intent);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Name = (String) text3.getText();
                Intent intent = new Intent(user.this,details.class);
                intent.putExtra("Name",Name);
                startActivity(intent);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Name = (String) text4.getText();
                Intent intent = new Intent(user.this,details.class);
                intent.putExtra("Name",Name);
                startActivity(intent);

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Name = (String) text5.getText();
                Intent intent = new Intent(user.this,details.class);
                intent.putExtra("Name",Name);
                startActivity(intent);

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Name = (String) text6.getText();
                Intent intent = new Intent(user.this,details.class);
                intent.putExtra("Name",Name);
                startActivity(intent);

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Name = (String) text7.getText();
                Intent intent = new Intent(user.this,details.class);
                intent.putExtra("Name",Name);
                startActivity(intent);

            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Name = (String) text8.getText();
                Intent intent = new Intent(user.this,details.class);
                intent.putExtra("Name",Name);
                startActivity(intent);

            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Name = (String) text9.getText();
                Intent intent = new Intent(user.this,details.class);
                intent.putExtra("Name",Name);
                startActivity(intent);

            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Name = (String) text10.getText();
                Intent intent = new Intent(user.this,details.class);
                intent.putExtra("Name",Name);
                startActivity(intent);

            }
        });
    }
}