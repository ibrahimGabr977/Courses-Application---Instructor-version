package com.hope.igb.elqalam_teacher.screens.comman.views;

import android.content.Context;
import android.view.View;

public abstract class BaseViewMvc implements ViewMvc{

    private View rootView;

    @Override
    public View getRootView() {
        return rootView;
    }


    protected void setRootView(View rootView) {
        this.rootView = rootView;
    }

    protected  <T extends View> T findViewById(int view_id) {
        return getRootView().findViewById(view_id);
    }


    public Context getContext() {
        return getRootView().getContext();
    }
}