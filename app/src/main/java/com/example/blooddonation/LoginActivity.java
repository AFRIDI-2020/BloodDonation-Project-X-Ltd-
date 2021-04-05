package com.example.blooddonation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private TextView forgetPassTV,signUPTV;
    private TextInputLayout emailTIL, passwordTIL;
    private String email, password;
    private FirebaseAuth firebaseAuth;
    private AlertDialog loginDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        signUPTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUp1Activity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        firebaseAuth = FirebaseAuth.getInstance();
        forgetPassTV = findViewById(R.id.tv_forget_password);
        signUPTV = findViewById(R.id.signUpTV);
        forgetPassTV.setPaintFlags(forgetPassTV.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        emailTIL = findViewById(R.id.email_text_input_layout);
        passwordTIL = findViewById(R.id.password_text_input_layout);
    }

    public boolean validateEmail(){
        email = emailTIL.getEditText().getText().toString();
        if(email.isEmpty()){
            Toast.makeText(this, "Email is required!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }
    }

    public boolean validatePassword(){
        password = passwordTIL.getEditText().getText().toString();
        if(password.isEmpty()){
            Toast.makeText(this, "Please set a password.", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(password.length()<6){
            Toast.makeText(this, "Password must be of six digits!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }
    }

    public void logInToHomePage(View view) {

        if(!validateEmail() || !validatePassword()){
            return;
        }
        else{

            startLoginDialog();
            email = emailTIL.getEditText().getText().toString();
            password = passwordTIL.getEditText().getText().toString();

            signIn(email, password);
        }
    }

    private void signIn(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            loginDialog.dismiss();
                            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Error: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    private void startLoginDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        View view = getLayoutInflater().inflate(R.layout.waiting_for_login_dialog_layout, null);
        builder.setView(view);
        builder.setCancelable(false);
        loginDialog = builder.create();
        loginDialog.show();
    }
}