package com.geekinfo.skeleton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SplashActivity extends AppCompatActivity {
    Button bt_start;
    //FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        bt_start = findViewById(R.id.bt_start);
        //Check user is already logged in session
       /* mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser()!=null){
            redirect("MAIN");
        }*/

        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirect("LOGIN");
            }
        });
    }
    private void redirect(String name){

        if (name.equalsIgnoreCase("LOGIN")){
            Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }else if (name.equalsIgnoreCase("MAIN")){
            Intent intent = new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this,"No valid path",Toast.LENGTH_LONG).show();
        }

    }
}