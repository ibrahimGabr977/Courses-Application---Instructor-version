package com.hope.igb.elqalam_teacher.networking.models;

public class Subject {
    private  String subject_id, subject_name, subject_academic_year, subject_last_update;
    private int  lessons_count, views_count, buyers_count, price;
    private float subject_rate;


    Subject(){}


    public Subject(String subject_id, String subject_name, String subject_academic_year, String subject_last_update,
                   int lessons_count, int views_count, int buyers_count, int price, float subject_rate) {

        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.subject_academic_year = subject_academic_year;
        this.subject_last_update = subject_last_update;
        this.lessons_count = lessons_count;
        this.views_count = views_count;
        this.buyers_count = buyers_count;
        this.price = price;
        this.subject_rate = subject_rate;
    }


    public String getSubject_id() {
        return subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public String getSubject_academic_year() {
        return subject_academic_year;
    }

    public String getSubject_last_update() {
        return subject_last_update;
    }

    public int getLessons_count() {
        return lessons_count;
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

    public float getSubject_rate() {
        return subject_rate;
    }
}
