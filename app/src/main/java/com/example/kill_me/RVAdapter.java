package com.example.kill_me;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    ArrayList<Name> list = new ArrayList<>();
    public RVAdapter(Context context){
        this.context = context;
    }

    public void setItems(ArrayList<Name> nm){
        list.addAll(nm);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new NameVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NameVH vh = (NameVH) holder;
        Name nm = list.get(position);
        vh.btn.setText(nm.getNaming());
        vh.btn2.setText(nm.getAge());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
