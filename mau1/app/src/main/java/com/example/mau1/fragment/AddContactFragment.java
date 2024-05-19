package com.example.mau1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mau1.MainActivity;
import com.example.mau1.R;
import com.example.mau1.database.AppDatabase;
import com.example.mau1.entity.Contact;

public class AddContactFragment extends Fragment {
    Contact contact;

    public AddContactFragment(Contact contact) {
        this.contact = contact;
    }

    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=  inflater.inflate(R.layout.fragment_add_contact, container, false);
        mView.findViewById(R.id.bt_back).setOnClickListener(v -> getActivity().onBackPressed() );

        mView.findViewById(R.id.bt_add).setOnClickListener(v -> {

            EditText editTextId =mView.findViewById(R.id.ed_id);
            String id=editTextId.getText().toString();

            EditText editTextName =mView.findViewById(R.id.ed_name);
            String name=editTextName.getText().toString();

            EditText editTextNumber =mView.findViewById(R.id.ed_number);
            String number=editTextNumber.getText().toString();
            AppDatabase.getInstance(getContext()).contactDAO().insertAll(new Contact(0,name,number));
            MainActivity.hideKeyboard(getContext(),v);
            Toast.makeText(getContext(), "Đã thêm thành công", Toast.LENGTH_SHORT).show();
        } );

        return mView;
    }
}
