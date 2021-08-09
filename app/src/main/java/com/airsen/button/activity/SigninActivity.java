package com.airsen.button.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.airsen.button.MainActivity;
import com.airsen.button.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    private EditText edit_email, edit_password;
    private Button button;
    private  LinearLayout layoutforword;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin);
        inisign();
        iniliseter();
    }

    private void inisign() {
        progressDialog = new ProgressDialog(this);
        linearLayout = findViewById(R.id.siginup1);
        layoutforword = findViewById(R.id.forgot);
        edit_email = findViewById(R.id.edit_text_email);
        edit_password = findViewById(R.id.edit_text_password);
        button = findViewById(R.id.click_button);

    }

    private void iniliseter() {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SigninActivity.this, Singup.class);
                startActivity(intent);

            }
        });
        layoutforword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickforgot();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edit_email.equals("") || edit_password.equals("")) {

                    edit_email.setError("fail");
                } else {
                    onclicksign();
                }


            }
        });




    }

    private void onClickforgot() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAddress = "user@example.com";
        progressDialog.show();

        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(SigninActivity.this,"email send", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(SigninActivity.this,"send email fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void onclicksign() {
        String memail = edit_email.getText().toString().trim();
        String mpasword = edit_password.getText().toString().trim();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(memail,mpasword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()){
                            Toast.makeText(SigninActivity.this,"Signup sucsses", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SigninActivity.this, MainActivity.class);
                            startActivity(intent);
                            finishAffinity();

                        }else {
                            Toast.makeText(SigninActivity.this,"Signup fail", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

}