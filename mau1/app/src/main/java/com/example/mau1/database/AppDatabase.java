package com.example.mau1.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mau1.DAO.ContactDAO;
import com.example.mau1.entity.Contact_PhungTienViet;

@Database(entities = {Contact_PhungTienViet.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContactDAO contactDAO();
}
