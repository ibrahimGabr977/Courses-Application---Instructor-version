package com.hope.igb.elqalam_teacher.screens.addlesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hope.igb.elqalam_teacher.screens.addlesson.attachments.AttachmentsFragment;
import com.hope.igb.elqalam_teacher.screens.addlesson.description.DescriptionFragment;
import com.hope.igb.elqalam_teacher.screens.addlesson.lecture.LectureFragment;
import com.hope.igb.elqalam_teacher.util.FragmentSwitcher;

public class AddLessonBaseFragment extends Fragment implements AddLessonBaseViewMvc.AddLessonBaseListener {

    private AddLessonBaseViewMvc viewMvc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewMvc = new AddLessonBaseViewMvc(inflater);

        if (savedInstanceState == null)
            FragmentSwitcher.switchToFragment(requireActivity(), viewMvc.getFragmentsContainerLayout(), new DescriptionFragment());

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
    }

    @Override
    public void onNextPageClicked(int position) {
        if (position == 1)
            FragmentSwitcher.switchToFragment(requireActivity(), viewMvc.getFragmentsContainerLayout(), new LectureFragment());
        else if (position == 2)
            FragmentSwitcher.switchToFragment(requireActivity(), viewMvc.getFragmentsContainerLayout(), new AttachmentsFragment());
    }

    @Override
    public void onPreviousClicked(int position) {

    }

    @Override
    public void onBackClicked() {

    }
}
