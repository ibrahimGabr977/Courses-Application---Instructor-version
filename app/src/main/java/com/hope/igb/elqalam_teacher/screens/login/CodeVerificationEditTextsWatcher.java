package com.hope.igb.elqalam_teacher.screens.login;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

//this class is for managing the verification code 6 edit texts
public class CodeVerificationEditTextsWatcher implements TextWatcher, View.OnKeyListener {
    private final ArrayList<EditText> editTexts;
    private int position;

    public CodeVerificationEditTextsWatcher(ArrayList<EditText> editTexts){

        this.editTexts = editTexts;


    }


    public void registerWatcher(){
        editTexts.get(0).requestFocus();
        for (EditText editText : editTexts) {
            editText.addTextChangedListener(this);
            editText.setOnKeyListener(this);
        }
    }

    public void unregisterWatcher(){
        editTexts.get(0).requestFocus();
        for (EditText editText : editTexts) {
            editText.removeTextChangedListener(this);
            editText.setOnKeyListener(null);
        }
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (position < 6){
            if (s.toString().length() == 1){
                position ++;
                editTexts.get(position).requestFocus();

            }



        }

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        if (position != 0 && event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL){

            if (editTexts.get(position).getText().toString().length() == 0){
                position--;
                editTexts.get(position).requestFocus();

            }
        }

        return false;
    }
}
