package com.eddieknaz.springboot.fastsurvey.entity;

import java.util.HashSet;

public class Option {

    private int count;

    private String name;

    private HashSet<Voter> voters;

    public Option(String name) {
        this.name = name;
        this.count = 0;
    }

    public Option() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void vote()
    {
        this.count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Voter> getVoters() {
        return voters;
    }

    public void setVoters(HashSet<Voter> voters) {
        this.voters = voters;
    }

    public void addVoter(Voter voter)
    {
        if(voters==null)
        {
            voters = new HashSet<>();
        }
        voters.add(voter);
        count++;
    }

    @Override
    public String toString() {
        return "Option{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", voters=" + voters +
                '}';
    }
}

