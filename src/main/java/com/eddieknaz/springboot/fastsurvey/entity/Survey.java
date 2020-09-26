package com.eddieknaz.springboot.fastsurvey.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="surveys")
public class Survey {

    @Id
    @Column(name="uuid")
    private String uuid;

    @Column(name="question")
    private String question;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "survey_id")
    private Set<Option> options  = new HashSet<>();;

    public Survey(String question, Set<Option> options) {
        this.question = question;
        this.options = options;
    }

    public Survey(){ }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        System.out.println("this is set Options");
        this.question = question;
    }

    public Set<Option> getOptions() {
        System.out.println("manytomany");
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }



    @Override
    public String toString() {
        return "Survey{" +
                "id= '" + uuid + '\'' +
                ", question=' " + question + '\'' +
                ", options= " + options +
                '}';
    }
}


