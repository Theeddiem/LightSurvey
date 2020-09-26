package com.eddieknaz.springboot.fastsurvey.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name="voters")
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="voter_name")
    private String name;

    @Column(name="ip_address")
    private String ipAddress;

    @ManyToMany(mappedBy = "voters", cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties("voters")
    private Set<Option> options = new HashSet<>();

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    public Voter(String name, String ipAddress) {
        this.name = name;
        this.ipAddress = ipAddress;
    }

    public Voter() {
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

//    public int getOptionId() {
//        return optionId;
//    }
//
//    public void setOptionId(int optionId) {
//        this.optionId = optionId;
//    }

    public void addOption(Option option)
    {
        options.add(option);
        option.getVoters().add(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Voter))
            return false;
        Voter voter = (Voter) obj;
        return voter.getIpAddress().equals(this.getIpAddress());

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((ipAddress == null) ? 0 : ipAddress.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
//                ", optionId='" + optionId + '\'' +
                '}';
    }
}