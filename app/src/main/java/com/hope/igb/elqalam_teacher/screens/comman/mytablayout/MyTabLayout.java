package com.hope.igb.elqalam_teacher.screens.comman.mytablayout;


import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hope.igb.elqalam_teacher.R;
import com.hope.igb.elqalam_teacher.screens.comman.views.BaseObservableMvc;
import java.util.HashMap;
import java.util.Objects;

public class MyTabLayout extends BaseObservableMvc<MyTabLayout.MyTabSelectedListener> implements View.OnClickListener {

    private final LinearLayout tabLayout;

    private final HashMap<Integer, TextView> tabs;
    private static int last_selected_tab = R.id.tab_my_lessons;



    public interface MyTabSelectedListener {
        void onTabSelected(int tab_id);
    }


    public MyTabLayout(View rootView) {

        setRootView(rootView);


        tabLayout = findViewById(R.id.customTabLayout);
        tabs = new HashMap<>();



        initTabs();

    }



    private void initTabs(){
        tabs.put(R.id.tab_my_lessons,  tabLayout.findViewById(R.id.tab_my_lessons));
        tabs.put(R.id.tab_my_subjects,  tabLayout.findViewById(R.id.tab_my_subjects));
        tabs.put(R.id.tab_notifications,  tabLayout.findViewById(R.id.tab_notifications));
        tabs.put(R.id.tab_statistics,  tabLayout.findViewById(R.id.tab_statistics));



        for (Integer tab_id: tabs.keySet())
            Objects.requireNonNull(tabs.get(tab_id)).setOnClickListener(this);


    }



    private void tabSelectedUiChanges(int selected_tab){
        if (selected_tab != last_selected_tab){

            TextView tab = tabs.get(selected_tab);

            if (tab != null){
                tab.setBackgroundResource(R.drawable.c_main_selected_tabbg);
                tab.setTextColor(getContext().getResources().getColor(R.color.white_color));
            }


            lastSelectedTabUiChanges();

            last_selected_tab = selected_tab;

        }
    }


    private void lastSelectedTabUiChanges(){
        TextView tab = tabs.get(last_selected_tab);

        if (tab != null){
            tab.setBackgroundResource(R.drawable.c_main_tablayoutbg);
            tab.setTextColor(getContext().getResources().getColor(R.color.black_color));
        }
    }


    @Override
    public void onClick(View v) {


        tabSelectedUiChanges(v.getId());



        for (MyTabSelectedListener listener : getListeners())
            listener.onTabSelected(v.getId());


    }


}
