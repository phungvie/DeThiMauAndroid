package com.example.mau1.adapter;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mau1.R;
import com.example.mau1.entity.Contact;
import com.example.mau1.myInterface.iClickItemContact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<Contact> data;
    private iClickItemContact iClickItemContact;


    public ContactAdapter(iClickItemContact iClickItemContact ) {
        this.iClickItemContact=iClickItemContact;
    }
    public void setData(List<Contact> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = data.get(position);
        if (contact == null) {
            return;
        }
        holder.textViewContactId.setText(contact.getId()+"");
        holder.textViewContactNumber.setText(contact.getNumber());
        holder.textViewContactName.setText(contact.getName());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickItemContact.onClickItem(contact);
            }
        });
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mIClickItemViet.onClickIteam(artistAndPlaylist);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewContactNumber;
        private TextView textViewContactName;
        private TextView textViewContactId;

        RelativeLayout relativeLayout;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewContactNumber = itemView.findViewById(R.id.tv_contect_number);
            textViewContactName = itemView.findViewById(R.id.tv_contect_name);
            textViewContactId = itemView.findViewById(R.id.tv_contect_id);
            relativeLayout=itemView.findViewById(R.id.rl_item_contact);
        }
    }
}