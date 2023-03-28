package com.hope.igb.elqalam_teacher.screens.login;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import com.hope.igb.elqalam_teacher.screens.BaseActivity;


public class LoginActivity extends AppCompatActivity implements LoginViewMvc.LoginListener {


    private LoginViewMvc viewMvc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewMvc = new LoginViewMvc(getLayoutInflater(), null);

        setContentView(viewMvc.getRootView());
    }


    @Override
    protected void onStart() {
        super.onStart();
        viewMvc.registerListener(this);
    }


    @Override
    protected void onStop() {
        super.onStop();
        viewMvc.unregisterListener(this);
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }




    @Override
    public void onLoginClicked(String email, String password) {
//        if (isEmailValid(email))
//            startActivity(new Intent(LoginActivity.this, BaseActivity.class));
//        else
//            Toast.makeText(this, "invalid email", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(LoginActivity.this, BaseActivity.class));
    }

    @Override
    public void onLoginWithFacebookClicked() {

    }

    @Override
    public void onLoginWithGoogle() {

    }

    @Override
    public void onForgotPassword() {

    }

    @Override
    public void onRegisterClicked() {

    }
}