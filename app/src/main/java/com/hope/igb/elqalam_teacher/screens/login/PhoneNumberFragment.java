package com.hope.igb.elqalam_teacher.screens.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hope.igb.elqalam_teacher.R;

public class PhoneNumberFragment extends Fragment {


    interface VerifyClickListener{
        void  onVerifyClicked();
    }
    private final  VerifyClickListener listener;



    public PhoneNumberFragment(VerifyClickListener listener) {
        this.listener = listener;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.activity_login_signin_fragment, container, false);
//
//
//        rootView.findViewById(R.id.login_phone_verify_text_btn).setOnClickListener(v -> listener.onVerifyClicked());
//

        return null;

    }
}
