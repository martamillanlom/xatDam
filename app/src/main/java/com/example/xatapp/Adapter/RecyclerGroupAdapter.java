package com.example.xatapp.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xatapp.Model.XatGroup;
import com.example.xatapp.R;
import com.example.xatapp.Views.Fragments.XatFragment;

import java.util.ArrayList;



public class RecyclerGroupAdapter extends RecyclerView.Adapter<RecyclerGroupAdapter.ViewHolder> {
    private ArrayList<XatGroup> arrayList;
    private Context context;

    public RecyclerGroupAdapter(ArrayList<XatGroup> arrN, Context c){
        this.arrayList = arrN;
        this.context = c;
    }

    @NonNull
    @Override
    public RecyclerGroupAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group, parent, false);
        RecyclerGroupAdapter.ViewHolder holder = new RecyclerGroupAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.recGroupName.setText(arrayList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.itemGroup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putString("group", arrayList.get(position).getName());
                        bundle.putString("type", "xatgroup");
                        XatFragment detailFragment = new XatFragment();
                        detailFragment.setArguments(bundle);

                        AppCompatActivity app = (AppCompatActivity) view.getContext();
                        app.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, detailFragment).commit();
                    }
                });
            }
        });
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView recGroupName;
        ConstraintLayout itemGroup;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recGroupName = itemView.findViewById(R.id.recGroupName);
            itemGroup = itemView.findViewById(R.id.itemGroup);
        }
    }
}

