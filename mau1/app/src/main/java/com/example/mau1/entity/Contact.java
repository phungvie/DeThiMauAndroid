package com.example.mau1.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contact implements Comparable<Contact>  {
    @PrimaryKey(autoGenerate = true)

    private int id;
    private String name;
    private String number;


    public Contact(int id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    @Override
    public int compareTo(Contact o) {
        return this.name.compareTo(o.getName());
    }
}
