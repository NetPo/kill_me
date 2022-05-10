package com.example.kill_me;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DAO dao;
    RVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editT = findViewById(R.id.editText1);
        EditText edAge = findViewById(R.id.editTextAge);
        Button btn = findViewById(R.id.button);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RVAdapter(this);
        recyclerView.setAdapter(adapter);
        dao = new DAO();
        btn.setOnClickListener(v->{
            Name name = new Name(editT.getText().toString(), edAge.getText().toString());
            dao.add(name).addOnSuccessListener(suc ->{
                Toast.makeText(this, "OK", Toast.LENGTH_LONG).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show();
            });
        });
        loadData();
    }

    private void loadData() {
        dao.get().addValueEventListener(new ValueEventListener() {
            ArrayList<Name> names = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data: snapshot.getChildren()){
                    Name name = data.getValue(Name.class);
                    names.add(name);
                }
                adapter.setItems(names);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}