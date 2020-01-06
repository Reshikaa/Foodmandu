package com.reshika.foodmandu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.reshika.foodmandu.R;
import com.reshika.foodmandu.api.UserApi;
import com.reshika.foodmandu.model.User;
import com.reshika.foodmandu.serverresponse.SignUpResponse;
import com.reshika.foodmandu.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    EditText etFname,etLname,etPhnum,etUser,etPass,etCpass;
    Button btnSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etFname=findViewById(R.id.etFname);
        etLname=findViewById(R.id.etLname);
        etPhnum=findViewById(R.id.etPhnum);
        etUser=findViewById(R.id.etUser);
        etPass=findViewById(R.id.etPass);
        etCpass=findViewById(R.id.etCpass);
        btnSignup=findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPass.getText().toString().equals((etCpass.getText().toString())))
                {
//                    saveImageOnly();
                    signup();
                }

                else {
                    Toast.makeText(SignupActivity.this, "Password doesnot match", Toast.LENGTH_SHORT).show();
                    etPass.requestFocus();
                    return;
                }
            }
        });

    }


    private void signup(){
        ///declaration
        String fname= etFname.getText().toString();
        String lname= etLname.getText().toString();
        String pnum=etPhnum.getText().toString();
        String username= etUser.getText().toString();
        String password = etPass.getText().toString();

        User user= new User(fname,lname,pnum,username,password);

        UserApi userapi = Url.getInstance().create(UserApi.class);

        Call<SignUpResponse> signUpResponseCall= userapi.registerUser(user);

        signUpResponseCall.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(SignupActivity.this, "Code" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(SignupActivity.this, "Registered", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {

                Toast.makeText(SignupActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
