package com.eddieknaz.springboot.fastsurvey.entity;

import java.util.ArrayList;
import java.util.HashSet;

public class Survey {

    private String id;
    private String question;
    private ArrayList<Option> options;
    private long createdlong;

    public Survey(String question, ArrayList<Option> options, long createdlong) {
        this.question = question;
        this.options = options;
        this.createdlong = createdlong;
    }

    public Survey(){ }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    public long getCreatedlong() {
        return createdlong;
    }

    public void setCreatedlong(long createdlong) {
        this.createdlong = createdlong;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", options=" + options +
                ", createdlong=" + createdlong +
                '}';
    }
}


