package com.example.mau1;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mau1.database.AppDatabase;
import com.example.mau1.entity.Contact;
import com.example.mau1.fragment.AddContactFragment;
import com.example.mau1.fragment.ContactsFragment;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager ;
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
//        AppDatabase.getInstance(this).contactDAO().deleteAll();

        fragmentManager = getSupportFragmentManager();
        setSupportActionBar(findViewById(R.id.toolbar));
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    AddContactFragment contactsFragment=new AddContactFragment(null);
                    fragmentTransaction.replace(R.id.fragment_container, contactsFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }

            }
        });

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ContactsFragment contactsFragment=new ContactsFragment();
        fragmentTransaction.replace(R.id.fragment_container, contactsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {

        }else{
            super.onBackPressed();
        }

    }

    public static void hideKeyboard(Context context, View view) {
        if (context == null || view == null) {
            return;
        }
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}