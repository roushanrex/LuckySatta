package com.example.roushan.satta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.roushan.satta.Chat.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Contact extends AppCompatActivity {

    TextView contxt,contxt1,contxt2;

    FirebaseAuth auth;
    FirebaseDatabase database;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        contxt = (TextView) findViewById(R.id.contacttxt);
        contxt1 = (TextView) findViewById(R.id.contacttxt2);
        contxt2 = (TextView) findViewById(R.id.contacttxt3);


        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        mRef = database.getReference();

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                String s1= String.valueOf(map.get("CONTACTSTATUS"));
                String s2= String.valueOf(map.get("CONTACTSTATUS2"));
                String s3= String.valueOf(map.get("CONTACTSTATUS3"));
                contxt.setText(s1);
                contxt1.setText(s2);
                contxt2.setText(s3);



            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

    }
}