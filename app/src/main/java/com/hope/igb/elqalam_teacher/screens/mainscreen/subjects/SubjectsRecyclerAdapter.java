package com.hope.igb.elqalam_teacher.screens.mainscreen.subjects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hope.igb.elqalam_teacher.R;
import com.hope.igb.elqalam_teacher.networking.models.Subject;

import java.util.ArrayList;

public class SubjectsRecyclerAdapter extends RecyclerView.Adapter<SubjectsRecyclerAdapter.SubjectsViewHolder> {

    private final Context context;
    private final ArrayList<Subject> subjects;

    public SubjectsRecyclerAdapter(Context context, ArrayList<Subject> subjects) {
        this.context = context;
        this.subjects = subjects;
    }


    @NonNull
    @Override
    public SubjectsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root_view = LayoutInflater.from(context).inflate(R.layout.main_subject_holder, parent, false);
        return new SubjectsViewHolder(root_view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        //return subjects.size();
        return 5;
    }

    protected static class SubjectsViewHolder extends RecyclerView.ViewHolder {

        private final TextView name, academic_year, price, lessons_count,  buyers, views, rate;
        private SubjectsViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.subject_holder_subject_name);
            academic_year = itemView.findViewById(R.id.subject_holder_academic_year);
            price = itemView.findViewById(R.id.subject_holder_price);
            lessons_count = itemView.findViewById(R.id.subject_holder_lessons_count);
            buyers = itemView.findViewById(R.id.subject_holder_buyers_count);
            views = itemView.findViewById(R.id.subject_holder_views_count);
            rate = itemView.findViewById(R.id.subject_holder_rate_text);

        }
    }
}
