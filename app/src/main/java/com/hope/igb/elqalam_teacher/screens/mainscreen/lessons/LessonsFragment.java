package com.hope.igb.elqalam_teacher.screens.mainscreen.lessons;

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

public class LessonsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root_view = inflater.inflate(R.layout.main_fragment_adapter, container, false);


        RecyclerView recyclerView = root_view.findViewById(R.id.mainRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        LessonsRecyclerAdapter adapter = new LessonsRecyclerAdapter(getContext(), null);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        return root_view;
    }


    @Override
    public void onStart() {
        super.onStart();
    }


    @Override
    public void onStop() {
        super.onStop();
    }
}
