package com.example.mau1.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mau1.entity.Contact;

import java.util.List;

@Dao
public interface ContactDAO {
    @Query("SELECT * FROM Contact")
    List<Contact> getAll();

    @Query("SELECT * FROM Contact WHERE id IN (:Ids)")
    List<Contact> loadAllByIds(int[] Ids);

    @Query("SELECT * FROM Contact WHERE name LIKE :name LIMIT 1")
    Contact findByName(String name);

    @Insert
    void insertAll(Contact... contact);

    @Delete
    void delete(Contact contact);
}
