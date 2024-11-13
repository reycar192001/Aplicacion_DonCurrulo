package com.example.examenfinal_doncurrulo.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.example.examenfinal_doncurrulo.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.DatabaseMetaData;
import java.util.Calendar;

public class SignupTabFragment extends Fragment {

    EditText email,fullname,pass1,pass;
    ConstraintLayout register;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://loginregisterdoncurrulo-default-rtdb.firebaseio.com");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment,container,false);

        email = root.findViewById(R.id.email);
        fullname = root.findViewById(R.id.fullname);
        pass = root.findViewById(R.id.pass);
        pass1 = root.findViewById(R.id.pass1);
        register = root.findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String fullnametxt= fullname.getText().toString();
                final String emailtxt= email.getText().toString();
                final String passtxt= pass.getText().toString();
                final String pass1txt= pass1.getText().toString();

                if (fullnametxt.isEmpty() || emailtxt.isEmpty() || passtxt.isEmpty()){
                    Toast.makeText(getActivity(),"por favor complete todos los campos",Toast.LENGTH_SHORT).show();
                } else if (!passtxt.equals(pass1txt)) {
                    Toast.makeText(getActivity(),"la contraseña no coincide",Toast.LENGTH_SHORT).show();
                }
                else {

                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(emailtxt)){
                                Toast.makeText(getActivity(), "La cuenta ya esta registrada", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                databaseReference.child("users").child(emailtxt).child("fullname").setValue(fullnametxt);
                                databaseReference.child("users").child(emailtxt).child("email").setValue(emailtxt);
                                databaseReference.child("users").child(emailtxt).child("pass").setValue(passtxt);

                                Toast.makeText(getActivity(), "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });



                }
            }
        });



        return root;
    }


}
