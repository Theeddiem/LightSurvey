package com.eddieknaz.springboot.fastsurvey.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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



//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
////    @JoinColumn(name = "option_id")
    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinTable(
            name = "option_voter",
            joinColumns = @JoinColumn(name = "option_id"),
            inverseJoinColumns = @JoinColumn(name = "voter_id"))
    @JsonIgnoreProperties("options")
    private Set<Voter> voters = new HashSet<>();

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
        this.voters = voters;
    }

    public void addVoter(Voter voter)
    {
        voters.add(voter);
        voter.getOptions().add(this);
    }


    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", name='" + name + '\'' +
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

