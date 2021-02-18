package com.example.bankingapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class ExampleDialog extends AppCompatDialogFragment {
    String userdata;
    EditText username;
    EditText name;
    String datadata,datadata1,datadata2,datadata3,datacheck;
    String id;
    Integer data1,data2,sum,data3,dtcheck,valcheck;

    public ExampleDialog(String userdata) {
        this.userdata = userdata;
    }

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater .inflate(R.layout.layout_dialog,null);
        name = view.findViewById(R.id.name);
        username = view.findViewById(R.id.username);
        builder.setView(view).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                FirebaseDatabase database2 = FirebaseDatabase.getInstance();
                DatabaseReference myRef2 = database2.getReference("User");
                myRef2.child("Shubham Gautam").child("Current Balance").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        datacheck = dataSnapshot.getValue(String.class);
                        dtcheck = Integer.parseInt(datacheck);
                        final String name1 = name.getText().toString();
                        String Name = userdata;
                        String Amount = name1;
                        valcheck = Integer.parseInt(Amount);
                        model obj = new model(Name,Amount);

                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        final DatabaseReference myRef = database.getReference("PERSON");

                        id = myRef.push().getKey();
                        if (valcheck<=dtcheck){

                            myRef.child("Shubham Gautam").child(id).setValue(obj);
                            myRef.child("Shubham Gautam").child(id).child("amount").addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    datadata=dataSnapshot.getValue(String.class);
                                    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
                                    final DatabaseReference myRef1 = database1.getReference("Changes");
                                    myRef1.child("change").setValue(String.valueOf(datadata));
                                    myRef1.child("change").addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            datadata1=dataSnapshot.getValue(String.class);
                                            data1=Integer.parseInt(datadata1);

                                            myRef2.child(userdata).child("Current Balance").addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                    datadata2 = dataSnapshot.getValue(String.class);
                                                    data2 = Integer.parseInt(datadata2);
                                                    sum = data1+data2;
                                                    myRef2.child(userdata).child("Current Balance").setValue(String.valueOf(sum));
                                                    myRef2.child("Shubham Gautam").child("Current Balance").addListenerForSingleValueEvent(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            datadata3 = dataSnapshot.getValue(String.class);
                                                            data3 = Integer.parseInt(datadata3);
                                                            data3=data3-data1;
                                                            myRef2.child("Shubham Gautam").child("Current Balance").setValue(String.valueOf(data3));

                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                }
                                            });

                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });


                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            Toast.makeText(view.getContext(), "Amount Successfully Transfered. Refresh The Balance ...", Toast.LENGTH_LONG).show();


                        }
                        else {
                            Toast.makeText(view.getContext(), "You Don't Have Enough Balance To Transfer !!!", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }
        });

        return builder.create();


    }


    }