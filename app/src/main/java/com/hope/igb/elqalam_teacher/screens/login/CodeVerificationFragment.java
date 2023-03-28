package com.hope.igb.elqalam_teacher.screens.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.hope.igb.elqalam_teacher.R;
import java.util.ArrayList;

public class CodeVerificationFragment extends Fragment {

    private ArrayList<EditText> code_parts;
    private CodeVerificationEditTextsWatcher textsWatcher;
    private final LoginClickListener listener;

    public CodeVerificationFragment(LoginClickListener listener) {
        this.listener = listener;
    }


    interface LoginClickListener{
        void onLoginClicked();
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//         View rootView = inflater.inflate(R.layout.activity_login_register_fragment, container, false);


//         initCodeParts(rootView);


        textsWatcher = new CodeVerificationEditTextsWatcher(code_parts);


//        rootView.findViewById(R.id.login_code_login_text_btn).setOnClickListener(v -> listener.onLoginClicked());


//        return rootView;

        return null;
    }





    private void initCodeParts(View root_view){
        code_parts = new ArrayList<>(6);

//
//        code_parts.add(root_view.findViewById(R.id.login_code_edit_code1));
//        code_parts.add(root_view.findViewById(R.id.login_code_edit_code2));
//        code_parts.add(root_view.findViewById(R.id.login_code_edit_code3));
//        code_parts.add(root_view.findViewById(R.id.login_code_edit_code4));
//        code_parts.add(root_view.findViewById(R.id.login_code_edit_code5));
//        code_parts.add(root_view.findViewById(R.id.login_code_edit_code6));
    }






    @Override
    public void onStart() {
        super.onStart();
        textsWatcher.registerWatcher();
    }


    @Override
    public void onStop() {
        super.onStop();
        textsWatcher.unregisterWatcher();
    }
}
