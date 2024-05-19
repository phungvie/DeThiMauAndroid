package com.example.mau1;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.mau1.DAO.ContactDAO;
import com.example.mau1.database.AppDatabase;
import com.example.mau1.entity.Contact_PhungTienViet;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-viet")
                .allowMainThreadQueries()
                .build();
        ContactDAO contactDAO = db.contactDAO();


//        Contact_PhungTienViet viet= new    Contact_PhungTienViet(1,"","");
//        viet.setName("phung");
//        viet.setNumber("0372776759");
//        contactDAO.insertAll(viet);
        List<Contact_PhungTienViet> contacts = contactDAO.getAll();
        Log.e("vietdz",contacts.toString());

    }
}