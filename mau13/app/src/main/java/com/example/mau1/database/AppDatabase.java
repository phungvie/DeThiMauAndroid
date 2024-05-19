package com.example.mau1.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mau1.DAO.ContactDAO;
import com.example.mau1.entity.Contact;

@Database(entities = {Contact.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
//    static Migration migration_from_1_to_2=new Migration(1,2) {
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
//            supportSQLiteDatabase.execSQL("ALTER TABLE Contact ADD COLUMN year TEXT");
//        }
//    };
  private static final String DATABASE_NAME="user.db";
  private static AppDatabase instance;

  public static synchronized AppDatabase getInstance(Context context){
      if(instance==null){
          instance= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,DATABASE_NAME)
                  .allowMainThreadQueries()
//                  .addMigrations()
                  .build();
      }
      return instance;
  }
    public abstract ContactDAO contactDAO();
}
