package com.geekinfo.skeleton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    EditText et_email,et_pwd,et_pwd2;
    //FirebaseAuth mAuth;
    private Button bt_login;
    private TextView tv_signp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        et_email = findViewById(R.id.et_email);
        et_pwd = findViewById(R.id.et_pwd);
        et_pwd2 = findViewById(R.id.et_pwd2);
        tv_signp= findViewById(R.id.tv_signp);
        bt_login = findViewById(R.id.bt_login);
       // mAuth = FirebaseAuth.getInstance();

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        tv_signp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void signup(){
        String email = et_email.getText().toString();
        String pwd = et_pwd.getText().toString();
        String pwd2 = et_pwd2.getText().toString();

        if(validate(email)&&validateP(pwd,pwd2)){
            //Create User code goes here

            /*mAuth.createUserWithEmailAndPassword(email,pwd)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()){
                            Log.d("detectit", "createUserWithEmail:success");
                            Intent intent = new Intent(SignupActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }else {
                            Log.d("detectit", "createUserWithEmail:failure");
                        }
                    });
*/
        }
    }



    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    public static boolean validateP(String pwd, String pwd2) {
        if (pwd!=null&&pwd.equals(pwd2)){
            return true;
        }else {
            return false;
        }
    }
}