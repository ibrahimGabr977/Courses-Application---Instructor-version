package com.hope.igb.elqalam_teacher.screens.mainscreen.notfications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hope.igb.elqalam_teacher.R;
import com.hope.igb.elqalam_teacher.screens.comman.Constants;
import com.hope.igb.elqalam_teacher.networking.models.Notification;

import java.util.ArrayList;

public class NotificationsRecyclerAdapter extends RecyclerView.Adapter<NotificationsRecyclerAdapter.NotificationViewHolder> {

    private final Context context;
    private final ArrayList<Notification> notifications;

    public NotificationsRecyclerAdapter(Context context, ArrayList<Notification> notifications) {
        this.context = context;
        this.notifications = notifications;
    }


    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root_view = LayoutInflater.from(context).inflate(R.layout.main_notifications_holder, parent, false);
        return new NotificationViewHolder(root_view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {

        Notification notification = notifications.get(position);

//
//        if (position < 2)
//            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.notification_color));
//        else
//            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.white_color));


        if (position < 2)
            holder.new_notification.setVisibility(View.VISIBLE);
        else
            holder.new_notification.setVisibility(View.INVISIBLE);


        holder.title.setText(notification.getNotification_title());
        holder.content.setText(notification.getNotification_content());
        holder.date.setText(notification.getNotification_date());


        switch (notification.getNotification_type()){
            case Constants
                    .NOTIFICATION_NEW_LESSON:
                holder.image.setImageResource(R.drawable.z_test_notifications_image_lesson);
            break;

            case Constants
                    .NOTIFICATION_QUESTION:
                holder.image.setImageResource(R.drawable.z_test_notifications_image_question);
                break;

            case Constants
                    .NOTIFICATION_WARNING:
                holder.image.setImageResource(R.drawable.z_test_notifications_image_warning);
                break;

            case Constants
                    .NOTIFICATION_NEW_BUYERS:
                holder.image.setImageResource(R.drawable.z_test_notifications_image_buyers);
                break;

            case Constants
                    .NOTIFICATION_NEW_VIEWS:
                holder.image.setImageResource(R.drawable.z_test_notifications_image_views);
                break;

        }


    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public static class NotificationViewHolder extends RecyclerView.ViewHolder {

        private final TextView title, date, content;
        private final ImageView image;
        private final View new_notification;

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.notifications_holder_title);

            date = itemView.findViewById(R.id.notifications_holder_date);

            content = itemView.findViewById(R.id.notifications_holder_content);

            image = itemView.findViewById(R.id.notifications_holder_image);


            new_notification = itemView.findViewById(R.id.notifications_holder_new_notifications_view);
        }
    }
}
