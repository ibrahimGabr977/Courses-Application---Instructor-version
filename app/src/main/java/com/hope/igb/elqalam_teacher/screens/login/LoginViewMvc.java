package com.hope.igb.elqalam_teacher.screens.login;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.hope.igb.elqalam_teacher.R;
import com.hope.igb.elqalam_teacher.screens.comman.views.BaseObservableMvc;



public class LoginViewMvc extends BaseObservableMvc<LoginViewMvc.LoginListener> implements View.OnClickListener {



    protected interface LoginListener {
        void onLoginClicked(String email, String password);
        void onLoginWithFacebookClicked();
        void onLoginWithGoogle();
        void onForgotPassword();
        void onRegisterClicked();
    }




    private final EditText edit_email;
    private final EditText edit_password;




    protected LoginViewMvc(LayoutInflater inflater, ViewGroup parent){
        setRootView(inflater.inflate(R.layout.activity_login, parent, false));


        initButtons();

        edit_email = findViewById(R.id.login_email_edit);
        edit_password = findViewById(R.id.login_password_edit);




    }






    private void initButtons(){

        TextView login = findViewById(R.id.login_text_btn);
        login.setOnClickListener(this);
        TextView login_facebook = findViewById(R.id.login_facebook_text_btn);
        login_facebook.setOnClickListener(this);
        TextView login_google = findViewById(R.id.login_google_text_btn);
        login_google.setOnClickListener(this);
        TextView forgot_password = findViewById(R.id.login_forgot_password_text_btn);
        forgot_password.setOnClickListener(this);
        TextView register = findViewById(R.id.login_register);
        register.setOnClickListener(this);

    }







    @Override
    public void onClick(View view) {

        for (LoginListener listener: getListeners())

            if (view.getId() == R.id.login_text_btn)
                listener.onLoginClicked(edit_email.getText().toString(), edit_password.getText().toString());


            else if (view.getId() == R.id.login_forgot_password_text_btn)
                listener.onForgotPassword();

            else if (view.getId() == R.id.login_facebook_text_btn)
                listener.onLoginWithFacebookClicked();

            else if (view.getId() == R.id.login_google_text_btn)
                listener.onLoginWithGoogle();


            else
                listener.onRegisterClicked();

    }



}
