package com.hope.igb.elqalam_teacher.screens.comman.navdrawer;


import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.hope.igb.elqalam_teacher.R;
import com.hope.igb.elqalam_teacher.screens.comman.views.BaseObservableMvc;

public class NavDrawerViewMvc extends BaseObservableMvc<NavDrawerViewMvc.NavDrawerListener>
        implements
        NavigationView.OnNavigationItemSelectedListener{


    private final DrawerLayout drawerLayout;



    public NavDrawerViewMvc(DrawerLayout base_layout) {
        this.drawerLayout = base_layout;

        setRootView(base_layout);


        NavigationView mNavigationView = findViewById(R.id.nav_view);


        mNavigationView.setNavigationItemSelectedListener(this);


    }






    public interface NavDrawerListener {
        void onProfileSelected();
        void onScheduleSelected();

        void onPaymentSelected();
        void onComplaintsSelected();

        void onReviewUsSelected();
        void onHelpSelected();
        void onSuggestionsSelected();
        void onSettingsSelected();
    }







    public void openDrawer() {
        drawerLayout.openDrawer(GravityCompat.START);
    }



    public boolean isDrawerOpen() {
        return drawerLayout.isDrawerOpen(GravityCompat.START);
    }


    public void closeDrawer() {
        drawerLayout.closeDrawers();

    }







    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawers();



        for (NavDrawerListener listener: getListeners())


            if (item.getItemId() == R.id.nav_item_profile) {

                listener.onProfileSelected();

            }else if (item.getItemId() == R.id.nav_item_schedule){
                listener.onScheduleSelected();

            }else if (item.getItemId() == R.id.nav_item_payment){
                listener.onPaymentSelected();

            }else if (item.getItemId() == R.id.nav_item_complaints){
                listener.onComplaintsSelected();


            }else if (item.getItemId() == R.id.nav_item_review){
                listener.onReviewUsSelected();

            }else if (item.getItemId() == R.id.nav_item_help){
                listener.onHelpSelected();

            }else if (item.getItemId() == R.id.nav_item_suggestions){
                listener.onSuggestionsSelected();

            }else
                listener.onSettingsSelected();

        return false;
    }

}
