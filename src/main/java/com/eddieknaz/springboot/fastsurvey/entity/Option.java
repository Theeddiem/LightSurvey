package com.eddieknaz.springboot.fastsurvey.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  int id;

    @Column(name="counter")
    private int counter;

    @Column(name="option_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "option_id")
    private List<Voter> voters = new ArrayList<>();

    public Option(String name) {
        this.name = name;
        this.counter = 0;
    }

    public Option() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public List<Voter> getVoters() {
        return voters;
    }

    public void setVoters(List<Voter> voters) {
        this.voters = voters;
    }

    public void addVoter(Voter voter)
    {
        counter++;
        voters.add(voter);
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", voters=" + voters +
                '}';
    }
}

