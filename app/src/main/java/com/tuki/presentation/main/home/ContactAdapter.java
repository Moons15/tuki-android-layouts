package com.tuki.presentation.main.home;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tuki.R;
import com.tuki.data.entity.Contact;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    private List<Contact> contacts;
    private Context context;
    private OnContactItemListener onContactItemListener;

    public ContactAdapter(List<Contact> contacts, OnContactItemListener onContactItemListener) {
        this.contacts = contacts;
        this.onContactItemListener = onContactItemListener;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.bind(contact);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }


    public void refresh(List<Contact> notifications) {
        this.contacts.clear();
        this.contacts.addAll(notifications);
        notifyDataSetChanged();
    }


    class ContactHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_contact_profile)
        ImageView ivContactProfile;
        @BindView(R.id.lbl_contact_firstname)
        TextView lblContactFirstname;

        public ContactHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Contact contact) {

            Glide.with(itemView)
                    .load(contact.getPhotoUrl())
                    .centerCrop()
                    .into(ivContactProfile);

            lblContactFirstname.setText(contact.getName());

            ivContactProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onContactItemListener.onClick(contact, ivContactProfile , getAdapterPosition());
                }
            });
        }
    }
}
