package com.reshika.foodmandu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.reshika.foodmandu.R;
import com.reshika.foodmandu.bll.LoginBll;
import com.reshika.foodmandu.strictmode.StrictModeClass;
import com.reshika.foodmandu.ui.home.HomeFragment;

public class LoginActivity extends AppCompatActivity {
TextView txtView;
EditText etUsername,etPassword;
Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
        btnlogin=findViewById(R.id.btnlogin);
        txtView=findViewById(R.id.txtView);

        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    private void login(){
        String username=etUsername.getText().toString();
        String password=etPassword.getText().toString();

        LoginBll loginBll=new LoginBll();

        StrictModeClass.StrictMode();
        if (loginBll.checkUser(username,password)){
            Intent intent= new Intent(LoginActivity.this, HomeFragment.class);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            etUsername.requestFocus();
        }
    }
}
