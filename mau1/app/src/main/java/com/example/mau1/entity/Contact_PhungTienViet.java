package com.example.mau1.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contact_PhungTienViet {
    @PrimaryKey(autoGenerate = true)

    private int id;
    private String name;
    private String number;


    public Contact_PhungTienViet(int id, String name, String number) {
        this.id=id;
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
        return "Contact_PhungTienViet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
