package com.hope.igb.elqalam_teacher.screens.profile;

import android.annotation.SuppressLint;
import android.text.InputType;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.hope.igb.elqalam_teacher.screens.comman.Constants;
import com.hope.igb.elqalam_teacher.databinding.DrawerFragmentProfileBinding;
import com.hope.igb.elqalam_teacher.networking.models.Teacher;
import com.hope.igb.elqalam_teacher.screens.comman.views.BaseObservableMvc;

import java.util.HashMap;


@SuppressLint("ClickableViewAccessibility")
class ProfileViewMvc extends BaseObservableMvc<ProfileViewMvc.ProfileListener> implements
        View.OnTouchListener, View.OnFocusChangeListener {


   protected interface ProfileListener {
        void onBackClicked();
        void onSaveChangedClicked(HashMap<String, String> changedDataList);
    }


    private final DrawerFragmentProfileBinding binding;
    private final HashMap<String, String> changedDataList;
    private final Teacher currentTeacherObject;





    protected ProfileViewMvc(LayoutInflater inflater, Teacher currentTeacherObject) {
        this.currentTeacherObject = currentTeacherObject;
        changedDataList = new HashMap<>();

        binding = DrawerFragmentProfileBinding.inflate(inflater);
        setRootView(binding.getRoot());

//        initViews();






    }





    private void initViews(){
//        initViewsData();
        initClickableViews();
//        initTouchableEditors();

    }





    private void initViewsData(){
        binding.editName.setText(currentTeacherObject.getName());
        binding.editSentence.setText(currentTeacherObject.getSentence());
        binding.email.setText(currentTeacherObject.getEmail());
        binding.editPhoneNumber.setText(currentTeacherObject.getPhone_number());
        binding.editBio.setText(currentTeacherObject.getBio());


        //imageLoader.loadImageInto(currentTeacherObject.getProfilePicturePath(), binding.profileImage);
        //videoLoader.loadVideoInto(currentTeacherObject.getBioVideoPath(), binding.bioVideo);

    }




    private void initClickableViews() {
        binding.profileBack.setOnClickListener( v -> onBackClicked());
        binding.saveChanges.setOnClickListener( v -> onSaveChangesClicked());
    }




    private void initTouchableEditors(){
        binding.editName.setOnTouchListener(this);
        binding.editSentence.setOnTouchListener(this);
        binding.editPassword.setOnTouchListener(this);
        binding.editPhoneNumber.setOnTouchListener(this);
        binding.editBio.setOnTouchListener(this);

    }



    private void onBackClicked() {
        for (ProfileListener listener : getListeners())
            listener.onBackClicked();
    }




    private void onSaveChangesClicked(){

        if (changedDataList.size() != 0)
            for (ProfileListener listener : getListeners())
                listener.onSaveChangedClicked(changedDataList);



            unregisterFocusedEditors();
            backEditorsToDisabled();
            updateViewsData();

        binding.saveChanges.setVisibility(View.GONE);
    }



    private void updateViewsData() {
        binding.editName.setText((changedDataList.containsKey("name") ? changedDataList.get("name") : currentTeacherObject.getName()));


        binding.editSentence.setText(changedDataList.containsKey("sentence") ? changedDataList.get("sentence") : currentTeacherObject.getSentence());


        binding.editPhoneNumber.setText((changedDataList.containsKey("phone_number") ? changedDataList.get("phone_number") : currentTeacherObject.getPhone_number()));


        binding.editBio.setText((changedDataList.containsKey("bio") ? changedDataList.get("bio") : currentTeacherObject.getBio()));
    }




    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        if(motionEvent.getAction() == MotionEvent.ACTION_UP) {

                if(motionEvent.getRawX() >= view.getRight() - ((EditText)view).getTotalPaddingRight()) {

                    binding.saveChanges.setVisibility(View.VISIBLE);

                    view.setEnabled(true);

                    currentEditingViewAction(view.getId());


                return true;
            }
        }

        return true;
    }






    private void currentEditingViewAction(int view_id) {

        if (view_id == binding.editName.getId())
            onEditNameClicked();

        else if (view_id == binding.editSentence.getId())
            onEditSentenceClicked();

        else if (view_id == binding.editPassword.getId())
            onEditPasswordClicked();

        else if (view_id == binding.editPhoneNumber.getId())
            onEditPhoneNumberClicked();

        else if (view_id == binding.editBio.getId())
            onEditBioClicked();

    }



    private void onEditNameClicked() {

        binding.editName.setOnFocusChangeListener(this);

    }


    private void onEditSentenceClicked() {
        binding.editSentence.setOnFocusChangeListener(this);

    }


    private void onEditPasswordClicked() {
        binding.editPassword.setInputType(InputType.TYPE_CLASS_TEXT);
        binding.editPassword.setOnFocusChangeListener(this);

    }


    private void onEditPhoneNumberClicked() {
        binding.editPhoneNumber.setOnFocusChangeListener(this);

    }


    private void onEditBioClicked() {
        binding.editBio.setOnFocusChangeListener(this);

    }




    @Override
    public void onFocusChange(View view, boolean hasFocused) {
        if (!hasFocused){

            if (view.getId() == binding.editName.getId())
                onNameEdited(binding.editName.getText().toString());

            else if (view.getId() == binding.editSentence.getId())
                onSentenceEdited(binding.editSentence.getText().toString());

            else if (view.getId() == binding.editPassword.getId())
                onPasswordEdited(binding.editPassword.getText().toString());

            else if (view.getId() == binding.editPhoneNumber.getId())
                onPhoneNumberEdited(binding.editPhoneNumber.getText().toString());

            else if (view.getId() == binding.editBio.getId())
                onBioEdited(binding.editBio.getText().toString());
        }


    }






    private void onNameEdited(String new_name) {

        changedDataList.remove("name");

        if (!currentTeacherObject.getName().equals(new_name) &&
                new_name.trim().length() >= Constants.MIN_NAME_LENGTH)

            changedDataList.put("name", new_name);


    }




    private void onSentenceEdited(String new_sentence) {
        changedDataList.remove("sentence");

        if (!currentTeacherObject.getSentence().equals(new_sentence) &&
                new_sentence.trim().length() <= Constants.MAX_SENTENCE_LENGTH)

            changedDataList.put("sentence", new_sentence);
    }




    private void onPasswordEdited(String new_password) {
        changedDataList.remove("password");

        if (!currentTeacherObject.getPassword().equals(new_password) &&
                new_password.trim().length() >= Constants.MIN_PASSWORD_LENGTH)

            changedDataList.put("password", new_password);
    }




    private void onPhoneNumberEdited(String new_phone_number) {
        changedDataList.remove("phone_number");

        if (!currentTeacherObject.getPhone_number().equals(new_phone_number) &&
                isPhoneNumberValid(new_phone_number))

            changedDataList.put("phone_number", new_phone_number);

    }



    private boolean isPhoneNumberValid(String phone_number){
        return Patterns.PHONE.matcher(phone_number).matches();
    }




    private void onBioEdited(String new_bio) {
        changedDataList.remove("bio");

        if (!currentTeacherObject.getBio().equals(new_bio) &&
                new_bio.trim().length() <= Constants.MAX_BIO_LENGTH)

            changedDataList.put("bio", new_bio);
    }



    private void unregisterFocusedEditors() {
        binding.editName.setOnFocusChangeListener(null);
        binding.editSentence.setOnFocusChangeListener(null);
        binding.editPassword.setOnFocusChangeListener(null);
        binding.editPhoneNumber.setOnFocusChangeListener(null);
        binding.editBio.setOnFocusChangeListener(null);
    }


    private void backEditorsToDisabled() {
        binding.editName.setEnabled(false);
        binding.editSentence.setEnabled(false);

        binding.editPassword.setEnabled(false);
        binding.editPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        binding.editPhoneNumber.setEnabled(false);
        binding.editBio.setEnabled(false);
    }



}
