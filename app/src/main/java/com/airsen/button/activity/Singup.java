package com.airsen.button.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airsen.button.MainActivity;
import com.airsen.button.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Singup extends AppCompatActivity {
    private EditText edit_email, edit_pasword;
    private Button btnsignup;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        iniup1();
        inilister();

    }



    private void iniup1() {
        progressDialog = new ProgressDialog(this);
        edit_email = findViewById(R.id.edit_email);
        edit_pasword= findViewById(R.id.edit_password);
        btnsignup = findViewById(R.id.btn_signup1);
    }
    private void inilister() {
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicksingup();
                
            }
        });
    }

    private void onclicksingup() {
        String email = edit_email.getText().toString().trim();
        String pasword = edit_pasword.getText().toString().trim();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(email,pasword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()){
                            Toast.makeText(Singup.this,"Signup sucsses", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Singup.this, MainActivity.class);
                            startActivity(intent);
                            finishAffinity();

                        }else {
                            Toast.makeText(Singup.this,"Signup fail", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}
