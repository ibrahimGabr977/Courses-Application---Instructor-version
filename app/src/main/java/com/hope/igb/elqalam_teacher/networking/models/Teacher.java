package com.hope.igb.elqalam_teacher.networking.models;

public class Teacher {

    private String profilePicturePath, name, sentence, email, phone_number, password, bio, bioVideoPath;
    private int age;
    private float rate;


    Teacher(){}


    public Teacher(String profilePicture, String name, String sentence, String email, String phone_number, String password, String bio, int age, float rate, String bioVideoUrl){

        this.profilePicturePath = profilePicture;
        this.name = name;
        this.sentence = sentence;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
        this.bio = bio;
        this.bioVideoPath = bioVideoUrl;
        this.age = age;
        this.rate = rate;

    }


    public String getName() {
        return name;
    }

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public String getSentence() {
        return sentence;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getPassword() {
        return password;
    }

    public String getBio() {
        return bio;
    }

    public String getBioVideoPath() {
        return bioVideoPath;
    }

    public int getAge() {
        return age;
    }

    public float getRate() {
        return rate;
    }
}
