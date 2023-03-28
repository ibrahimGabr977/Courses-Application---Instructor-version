package com.hope.igb.elqalam_teacher.screens;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.hope.igb.elqalam_teacher.R;
import com.hope.igb.elqalam_teacher.screens.addlesson.AddLessonBaseFragment;
import com.hope.igb.elqalam_teacher.screens.mainscreen.MainFragment;
import com.hope.igb.elqalam_teacher.screens.profile.ProfileFragment;
import com.hope.igb.elqalam_teacher.util.FragmentSwitcher;


public class BaseActivity extends AppCompatActivity implements MainFragment.MainListener {


    private MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        mainFragment = new MainFragment();

        if (savedInstanceState == null)
            FragmentSwitcher.switchToFragment(this, R.id.baseFrameLayout, mainFragment);



    }


    @Override
    protected void onStart() {
        super.onStart();
        mainFragment.registerMainListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainFragment.unregisterMainListener(this);
    }



    @Override
    public void onProfileSelected() {
        FragmentSwitcher.switchToFragment(this, R.id.baseFrameLayout, new ProfileFragment());
        mainFragment.unregisterMainListener(this);

    }

    @Override
    public void onAddLessonFabClicked() {
        FragmentSwitcher.switchToFragment(this, R.id.baseFrameLayout, new AddLessonBaseFragment());
        mainFragment.unregisterMainListener(this);
    }

    @Override
    public void onScheduleSelected() {

    }

    @Override
    public void onPaymentSelected() {

    }

    @Override
    public void onComplaintsSelected() {

    }

    @Override
    public void onReviewUsSelected() {

    }

    @Override
    public void onHelpSelected() {

    }

    @Override
    public void onSuggestionsSelected() {

    }

    @Override
    public void onSettingsSelected() {

    }
}