package com.hope.igb.elqalam_teacher.screens.mainscreen.notfications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hope.igb.elqalam_teacher.R;
import com.hope.igb.elqalam_teacher.screens.comman.Constants;
import com.hope.igb.elqalam_teacher.networking.models.Notification;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {


    private ArrayList<Notification> notifications_test;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root_view = inflater.inflate(R.layout.main_fragment_adapter, container, false);


        initTestData();


        RecyclerView recyclerView = root_view.findViewById(R.id.mainRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        NotificationsRecyclerAdapter adapter = new NotificationsRecyclerAdapter(getContext(), notifications_test);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        return root_view;


    }





    private void initTestData(){

        notifications_test = new ArrayList<>();

        Notification notification1 = new Notification(null, getString(R.string.notifications_new_lesson_title_test),
                getString(R.string.notifications_new_lesson_content_test), getString(R.string.notifications_new_lesson_date_test),
                Constants.NOTIFICATION_NEW_LESSON);




        Notification notification2 = new Notification(null, getString(R.string.notifications_question_title_test),
                getString(R.string.notifications_question_content_test), getString(R.string.notifications_question_date_test),
                Constants.NOTIFICATION_QUESTION);



        Notification notification3 = new Notification(null, getString(R.string.notifications_warning_title_test),
                getString(R.string.notifications_warning_content_test), getString(R.string.notifications_warning_date_test),
                Constants.NOTIFICATION_WARNING);



        Notification notification4 = new Notification(null, getString(R.string.notifications_buyers_title_test),
                getString(R.string.notifications_buyers_content_test), getString(R.string.notifications_buyers_date_test),
                Constants.NOTIFICATION_NEW_BUYERS);


        Notification notification5 = new Notification(null, getString(R.string.notifications_views_title_test),
                getString(R.string.notifications_views_content_test), getString(R.string.notifications_views_date_test),
                Constants.NOTIFICATION_NEW_VIEWS);





        notifications_test.add(notification1);
        notifications_test.add(notification2);
        notifications_test.add(notification3);
        notifications_test.add(notification4);
        notifications_test.add(notification5);

    }


}
