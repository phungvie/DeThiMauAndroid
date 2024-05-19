package com.example.mau1.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mau1.entity.Contact_PhungTienViet;

import java.util.List;

@Dao
public interface ContactDAO {
    @Query("SELECT * FROM Contact_PhungTienViet")
    List<Contact_PhungTienViet> getAll();

    @Query("SELECT * FROM Contact_PhungTienViet WHERE id IN (:Ids)")
    List<Contact_PhungTienViet> loadAllByIds(int[] Ids);

    @Query("SELECT * FROM Contact_PhungTienViet WHERE name LIKE :name LIMIT 1")
    Contact_PhungTienViet findByName(String name);

    @Insert
    void insertAll(Contact_PhungTienViet... contact);

    @Delete
    void delete(Contact_PhungTienViet contact);
}
