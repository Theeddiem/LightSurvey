package com.eddieknaz.springboot.fastsurvey.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="options")
public class Option  implements  Comparable<Option>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  int id;

    @Column(name="option_name")
    private String name;



    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "option_id")
    private Set<Voter> voters = new HashSet<>();

//    @Transient // so my sql will ignore it
//    private int votersCount;


    public Option(String name) {
        this.name = name;
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


    public Set<Voter> getVoters() {
        return voters;
    }

    public void setVoters(Set<Voter> voters) {
        System.out.println("insdie set");
        this.voters = voters;
    }

    public void addVoter(Voter voter)
    {
        System.out.println("inside add voter");
        voters.add(voter);
    }


    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", votersCount=" + votersCount +
                ", voters=" + voters +
                 +
                '}';
    }

    @Override
    public int compareTo(Option o) {
        if(this.getVoters().size()==o.getVoters().size())
            return 0;
        else if(this.getVoters().size()>o.getVoters().size())
            return -1;
        else
            return 1;
    }
}

