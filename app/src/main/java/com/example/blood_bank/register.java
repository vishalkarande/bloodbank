package com.example.blood_bank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class register extends AppCompatActivity {


    EditText name;
    EditText age;
    EditText blood;
    Button add;
   // FirebaseAuth auth;
    DatabaseReference reff;
    FirebaseDatabase firebaseDatabase;
    TextView display;
    Button displaybutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


            name= (EditText) findViewById(R.id.editTextTextPersonName);
        age= (EditText) findViewById(R.id.age);
        blood= (EditText) findViewById(R.id.blood);
        add= (Button) findViewById(R.id.add);
        display= (TextView) findViewById(R.id.namedisplay);
        displaybutton=(Button)findViewById(R.id.display);
        firebaseDatabase= FirebaseDatabase.getInstance();
    //    reff= FirebaseDatabase.getInstance().getReference().child()

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                reff = firebaseDatabase.getReference("donate").child("user");


                //get values

                String name1= name.getText().toString();
                String age1= age.getText().toString();
                String blood1= blood.getText().toString();

                UserHelper helper= new UserHelper(name1,age1,blood1);

                Toast.makeText(register.this, "value "+name1, Toast.LENGTH_LONG).show();



                reff.child(name1).setValue(helper);
            }
        });


        //featching data

        displaybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                reff = firebaseDatabase.getReference("donate").child("user").child("joker");

               reff.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot snapshot) {

                       String username = snapshot.child("bloodgroup").getValue().toString();

                       display.setText(username);

                       Toast.makeText(register.this, "value "+username, Toast.LENGTH_LONG).show();
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError error) {

                       Toast.makeText(register.this, "Error", Toast.LENGTH_LONG).show();
                   }
               });

            }
        });


    }
}