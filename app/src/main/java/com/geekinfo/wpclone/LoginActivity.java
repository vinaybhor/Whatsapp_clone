package com.geekinfo.wpclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    EditText et_email,et_pwd;
    private Button bt_login;
    private TextView tv_signp;
    FirebaseAuth mAuth;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_email = findViewById(R.id.et_email);
        et_pwd = findViewById(R.id.et_pwd);
        tv_signp= findViewById(R.id.tv_signp);
        bt_login = findViewById(R.id.bt_login);
        mAuth = FirebaseAuth.getInstance();
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        tv_signp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void login(){
        String email = et_email.getText().toString();
        String pwd = et_pwd.getText().toString();
        if(validate(email)){
            //FireBase login goes here
            mAuth.signInWithEmailAndPassword(email,pwd)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()){
                            Log.d("detectit", "SigninWithEmail:success");
                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }else {
                            Log.d("detectit", "SigninWithEmail:failure");
                        }
                    });
        }

    }
    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    public static boolean validateP(String pwd) {
        if (pwd!=null){
            return true;
        }else {
            return false;
        }
    }
}