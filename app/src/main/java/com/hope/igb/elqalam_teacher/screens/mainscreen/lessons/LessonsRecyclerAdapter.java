package com.hope.igb.elqalam_teacher.screens.mainscreen.lessons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hope.igb.elqalam_teacher.R;
import com.hope.igb.elqalam_teacher.networking.models.Lesson;

import java.util.ArrayList;

public class LessonsRecyclerAdapter extends RecyclerView.Adapter<LessonsRecyclerAdapter.LessonsViewHolder> {


    private final Context context;
    private final ArrayList<Lesson> lessons;

    public LessonsRecyclerAdapter(Context context, ArrayList<Lesson> lessons) {
        this.context = context;
        this.lessons = lessons;
    }


    @NonNull
    @Override
    public LessonsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.main_lesson_holder, parent, false);

        return new LessonsViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonsViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
//        return lessons.size();
        return 5;
    }

    public static class LessonsViewHolder extends RecyclerView.ViewHolder {
        private final TextView name, number, title, price, media_details, buyers, views, rate;
        private LessonsViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.lesson_holder_subject_title);
            number = itemView.findViewById(R.id.lesson_holder_lesson_number);
            title = itemView.findViewById(R.id.lesson_holder_title);
            price = itemView.findViewById(R.id.lesson_holder_price);
            media_details = itemView.findViewById(R.id.lesson_holder_media_details);
            buyers = itemView.findViewById(R.id.lesson_holder_buyers_count);
            views = itemView.findViewById(R.id.lesson_holder_views_count);
            rate = itemView.findViewById(R.id.lesson_holder_rate_text);

        }
    }
}
