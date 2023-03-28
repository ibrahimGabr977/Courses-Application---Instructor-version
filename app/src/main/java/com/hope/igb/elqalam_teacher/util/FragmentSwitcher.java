package com.hope.igb.elqalam_teacher.util;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public final class FragmentSwitcher {


    //fragment switcher method
    public static void switchToFragment(FragmentActivity activity, int frameLayoutRes, Fragment fragment) {
        FragmentManager manager = activity.getSupportFragmentManager();
//        manager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        manager.beginTransaction().replace(frameLayoutRes, fragment).commit();

    }



}
