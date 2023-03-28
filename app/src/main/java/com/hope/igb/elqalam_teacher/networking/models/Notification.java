package com.hope.igb.elqalam_teacher.networking.models;

public class Notification {

    //until now there are 5 notification types listed in Constants class

    private String notification_id, notification_title, notification_content, notification_date;
    private char notification_type;

    Notification() {}



    public Notification(String notification_id,
                        String notification_title,
                        String notification_content,
                        String notification_date,
                        char notification_type) {

        this.notification_id = notification_id;
        this.notification_title = notification_title;
        this.notification_content = notification_content;
        this.notification_date = notification_date;
        this.notification_type = notification_type;
    }


    public String getNotification_id() {
        return notification_id;
    }

    public String getNotification_title() {
        return notification_title;
    }

    public String getNotification_content() {
        return notification_content;
    }

    public String getNotification_date() {
        return notification_date;
    }

    public char getNotification_type() {
        return notification_type;
    }
}
