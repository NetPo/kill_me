package com.example.kill_me;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class DAO {
    private DatabaseReference databaseReference;
    public DAO(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Name.class.getSimpleName());
    }
    public Task<Void> add(Name name){
        return databaseReference.push().setValue(name);
    }
    public Query get(){
        return databaseReference.orderByKey();
    }
}

