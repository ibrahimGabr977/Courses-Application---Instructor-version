package com.hope.igb.elqalam_teacher.networking.models;


public class Lesson {


    private  String lesson_id, lesson_name, lesson_title,  lesson_number, lesson_date, lesson_media_details;
    private int  views_count, buyers_count, price;
    private float lesson_rate;


    Lesson(){}


    public Lesson(String lesson_id, String lesson_name, String lesson_title, String lesson_date,
                  String lesson_media_details, String lesson_number, int views_count, int buyers_count,
                  int price, float lesson_rate) {

        this.lesson_id = lesson_id;
        this.lesson_name = lesson_name;
        this.lesson_title = lesson_title;
        this.lesson_date = lesson_date;
        this.lesson_media_details = lesson_media_details;
        this.lesson_number = lesson_number;
        this.views_count = views_count;
        this.buyers_count = buyers_count;
        this.price = price;
        this.lesson_rate = lesson_rate;
    }


    public String getLesson_id() {
        return lesson_id;
    }

    public String getLesson_name() {
        return lesson_name;
    }

    public String getLesson_title() {
        return lesson_title;
    }

    public String getLesson_date() {
        return lesson_date;
    }

    public String getLesson_media_details() {
        return lesson_media_details;
    }

    public String getLesson_number() {
        return lesson_number;
    }

    public int getViews_count() {
        return views_count;
    }

    public int getBuyers_count() {
        return buyers_count;
    }

    public int getPrice() {
        return price;
    }

    public float getLesson_rate() {
        return lesson_rate;
    }
}
