package com.example.mau1.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mau1.R;
import com.example.mau1.adapter.ContactAdapter;
import com.example.mau1.database.AppDatabase;
import com.example.mau1.entity.Contact;
import com.example.mau1.myInterface.iClickItemContact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactsFragment extends Fragment {
    private View mView;
    private List<Contact>data;
    private  RecyclerView mRecyclerView;

    private ContactAdapter contactAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=  inflater.inflate(R.layout.fragment_contacts, container, false);
        mRecyclerView=mView.findViewById(R.id.rcv);

         contactAdapter=new ContactAdapter(new iClickItemContact() {
             @Override
             public void onClickItem(Contact contact) {

             }
         });
         data=new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(contactAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        return mView;
    }
    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }
    private void loadData(){
        data.clear();
        data= AppDatabase.getInstance(getContext()).contactDAO().getAll();
        Collections.sort(data);
        contactAdapter.setData(data);
    }
}
