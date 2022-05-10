package com.example.kill_me;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameVH extends RecyclerView.ViewHolder {
    public Button btn, btn2;
    public NameVH(@NonNull View itemView) {
        super(itemView);
        btn = itemView.findViewById(R.id.button_name);
        btn2 = itemView.findViewById(R.id.button_age);
    }
}
