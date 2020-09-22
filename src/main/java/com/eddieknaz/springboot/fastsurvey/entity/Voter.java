package com.eddieknaz.springboot.fastsurvey.entity;

import javax.persistence.*;

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

    @Column(name="option_id")
    private int optionId;


    public Voter(String name, String ipAddress, int optionId) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.optionId = optionId;
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

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", optionId='" + optionId + '\'' +
                '}';
    }
}