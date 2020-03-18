package com.example.recyclerviewproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private List<User> users = new ArrayList<>();

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView cardNume;
        public TextView cardNota;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            cardNota = itemView.findViewById(R.id.card_nota);
            cardNume = itemView.findViewById(R.id.card_nume);
        }
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent , false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        User currentUser = users.get(position);
        holder.cardNume.setText(currentUser.getName());
        holder.cardNota.setText(String.valueOf(currentUser.getMark()));

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(List<User> users){
        this.users = users;
        notifyDataSetChanged();
    }

    public User getUserAt(int position){
        return users.get(position);
    }
}
