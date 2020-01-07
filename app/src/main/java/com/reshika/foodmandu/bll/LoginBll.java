package com.reshika.foodmandu.bll;

import com.reshika.foodmandu.api.UserApi;
import com.reshika.foodmandu.serverresponse.SignUpResponse;
import com.reshika.foodmandu.url.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBll {

    boolean isSuccess=false;

    public boolean checkUser(String username, String password){
        UserApi usersApi= Url.getInstance().create(UserApi.class);
        Call<SignUpResponse> usersCall= usersApi.checkUser(username,password);

        try {
            Response<SignUpResponse> loginResponse=usersCall.execute();
            if (loginResponse.isSuccessful()&&
                    loginResponse.body().getStatus().equals("Login Success")){
                Url.token += loginResponse.body().getToken();
                isSuccess=true;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return isSuccess;
    }
}
