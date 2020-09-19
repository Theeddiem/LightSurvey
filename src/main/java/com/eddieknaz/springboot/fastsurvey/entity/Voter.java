package com.eddieknaz.springboot.fastsurvey.entity;

public class Voter {

    private String name;

    private String ipAddress;

    public Voter(String name, String ipAddress) {
        this.name = name;
        this.ipAddress = ipAddress;
    }

    public Voter() {
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

    @Override
    public String toString() {
        return "Voter{" +
                "name='" + name + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}