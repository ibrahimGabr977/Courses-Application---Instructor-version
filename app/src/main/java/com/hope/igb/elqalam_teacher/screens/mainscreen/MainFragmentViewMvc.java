package com.hope.igb.elqalam_teacher.screens.mainscreen;


import android.view.LayoutInflater;

import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hope.igb.elqalam_teacher.R;
import com.hope.igb.elqalam_teacher.screens.comman.mytablayout.MyTabLayout;
import com.hope.igb.elqalam_teacher.screens.comman.navdrawer.NavDrawerViewMvc;
import com.hope.igb.elqalam_teacher.screens.comman.views.BaseObservableMvc;

public class MainFragmentViewMvc extends BaseObservableMvc<MainFragmentViewMvc.MainFragmentListener> implements
        NavDrawerViewMvc.NavDrawerListener {


    private NavDrawerViewMvc navDrawerViewMvc;
    private final DrawerLayout main_layout;
    private  ImageView main_menu, search;

    protected interface MainFragmentListener extends MyTabLayout.MyTabSelectedListener{



        @Override
        void onTabSelected(int tab_id);

        void onProfileSelected();
        void onScheduleSelected();

        void onPaymentSelected();
        void onComplaintsSelected();

        void onReviewUsSelected();
        void onHelpSelected();
        void onSuggestionsSelected();
        void onSettingsSelected();

        void onMainMenuClicked();

        void onSearchClicked();

        void onAddLessonFabClicked();
    }



    private final MyTabLayout myTabLayout;

    public MainFragmentViewMvc(LayoutInflater inflater, ViewGroup parent) {

        setRootView(inflater.inflate(R.layout.main_fragment, parent, false));

        this.myTabLayout = new MyTabLayout(getRootView());


        main_layout = findViewById(R.id.main_drawer_layout);

        initClickableViews();

    }


    private void initClickableViews(){
        main_menu = findViewById(R.id.main_menu);
        main_menu.setOnClickListener(v -> onMainMenuClicked());
        search = findViewById(R.id.main_search);
        search.setOnClickListener(v -> onSearchClicked());


        FloatingActionButton add_lesson_fab = findViewById(R.id.main_add_lesson_fab);
        add_lesson_fab.setOnClickListener(v-> onAddLessonFabClicked());
    }



    private void onAddLessonFabClicked() {
        for (MainFragmentListener listener : getListeners())
            listener.onAddLessonFabClicked();
    }


    private void onMainMenuClicked(){
        for (MainFragmentListener listener : getListeners())
            listener.onMainMenuClicked();
    }

    private void onSearchClicked(){
        for (MainFragmentListener listener : getListeners())
            listener.onSearchClicked();
    }



    @Override
    public void registerListener(MainFragmentListener listener) {
        super.registerListener(listener);
        myTabLayout.registerListener(listener);
    }



    @Override
    public void unregisterListener(MainFragmentListener listener) {
        super.unregisterListener(listener);
        myTabLayout.unregisterListener((MyTabLayout.MyTabSelectedListener) listener);
    }






    public void openDrawer(){
        navDrawerViewMvc = new NavDrawerViewMvc(main_layout);
        navDrawerViewMvc.openDrawer();
        navDrawerViewMvc.registerListener(this);
    }

    public void closeDrawer(){

        if (isDrawerOpen()){
            navDrawerViewMvc.unregisterListener(this);
            navDrawerViewMvc.closeDrawer();
            navDrawerViewMvc = null;
        }

    }


    private boolean isDrawerOpen(){
        return navDrawerViewMvc != null && navDrawerViewMvc.isDrawerOpen();
    }




    @Override
    public void onProfileSelected() {
        for (MainFragmentListener listener : getListeners())
            listener.onProfileSelected();
    }

    @Override
    public void onScheduleSelected() {
        for (MainFragmentListener listener : getListeners())
            listener.onScheduleSelected();
    }

    @Override
    public void onPaymentSelected() {
        for (MainFragmentListener listener : getListeners())
            listener.onPaymentSelected();
    }

    @Override
    public void onComplaintsSelected() {
        for (MainFragmentListener listener : getListeners())
            listener.onComplaintsSelected();
    }

    @Override
    public void onReviewUsSelected() {
        for (MainFragmentListener listener : getListeners())
            listener.onReviewUsSelected();
    }

    @Override
    public void onHelpSelected() {
        for (MainFragmentListener listener : getListeners())
            listener.onHelpSelected();
    }

    @Override
    public void onSuggestionsSelected() {
        for (MainFragmentListener listener : getListeners())
            listener.onSuggestionsSelected();
    }

    @Override
    public void onSettingsSelected() {
        for (MainFragmentListener listener : getListeners())
            listener.onSettingsSelected();
    }


}
