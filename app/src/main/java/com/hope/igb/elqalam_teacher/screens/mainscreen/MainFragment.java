package com.hope.igb.elqalam_teacher.screens.mainscreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.hope.igb.elqalam_teacher.R;
import com.hope.igb.elqalam_teacher.screens.mainscreen.lessons.LessonsFragment;
import com.hope.igb.elqalam_teacher.screens.mainscreen.notfications.NotificationsFragment;
import com.hope.igb.elqalam_teacher.screens.mainscreen.statistics.StatisticsFragment;
import com.hope.igb.elqalam_teacher.screens.mainscreen.subjects.SubjectsFragment;
import com.hope.igb.elqalam_teacher.util.FragmentSwitcher;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MainFragment extends Fragment implements MainFragmentViewMvc.MainFragmentListener {


    public interface MainListener{
        void onProfileSelected();
        void onScheduleSelected();

        void onPaymentSelected();
        void onComplaintsSelected();

        void onReviewUsSelected();
        void onHelpSelected();
        void onSuggestionsSelected();
        void onSettingsSelected();

        void onAddLessonFabClicked();
    }



    private MainFragmentViewMvc viewMvc;
    private final Set<MainListener> listeners = Collections.newSetFromMap(
            new ConcurrentHashMap<>(1));



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewMvc = new MainFragmentViewMvc(inflater, container);


        if (savedInstanceState == null)
            FragmentSwitcher.switchToFragment(requireActivity(), R.id.mainFrameLayout, new LessonsFragment());


        return viewMvc.getRootView();
    }


    @Override
    public void onStart() {
        super.onStart();

        viewMvc.registerListener(this);
    }


    @Override
    public void onStop() {
        super.onStop();

        viewMvc.unregisterListener(this);
        viewMvc.closeDrawer();
    }


    @Override
    public void onMainMenuClicked() {
        viewMvc.openDrawer();
    }


    @Override
    public void onSearchClicked() {

    }

    @Override
    public void onAddLessonFabClicked() {
        for (MainListener listener : listeners)
            listener.onAddLessonFabClicked();
    }



    @Override
    public void onTabSelected(int tab_id) {

        if (tab_id == R.id.tab_my_lessons)
            FragmentSwitcher.switchToFragment(requireActivity(), R.id.mainFrameLayout, new LessonsFragment());
        else if (tab_id == R.id.tab_my_subjects)
            FragmentSwitcher.switchToFragment(requireActivity(), R.id.mainFrameLayout, new SubjectsFragment());
        else if (tab_id == R.id.tab_notifications)
            FragmentSwitcher.switchToFragment(requireActivity(), R.id.mainFrameLayout, new NotificationsFragment());
        else
            FragmentSwitcher.switchToFragment(requireActivity(), R.id.mainFrameLayout, new StatisticsFragment());
    }





    public void registerMainListener(MainListener listener){
        listeners.add(listener);
    }

    public void unregisterMainListener(MainListener listener){
        listeners.remove(listener);
    }

    @Override
    public void onProfileSelected() {
        for (MainListener listener : listeners)
            listener.onProfileSelected();
    }

    @Override
    public void onScheduleSelected() {
        for (MainListener listener : listeners)
            listener.onScheduleSelected();
    }

    @Override
    public void onPaymentSelected() {
        for (MainListener listener : listeners)
            listener.onPaymentSelected();
    }

    @Override
    public void onComplaintsSelected() {
        for (MainListener listener : listeners)
            listener.onComplaintsSelected();
    }

    @Override
    public void onReviewUsSelected() {
        for (MainListener listener : listeners)
            listener.onReviewUsSelected();
    }

    @Override
    public void onHelpSelected() {
        for (MainListener listener : listeners)
            listener.onHelpSelected();
    }

    @Override
    public void onSuggestionsSelected() {
        for (MainListener listener : listeners)
            listener.onSuggestionsSelected();
    }

    @Override
    public void onSettingsSelected() {
        for (MainListener listener : listeners)
            listener.onSettingsSelected();
    }



}
