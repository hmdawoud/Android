package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ListAllStudents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_students);
        MySQLclass mySQLclass=new MySQLclass(getApplicationContext());
        RecyclerView rv =findViewById(R.id.RV_all_std);
        ListAllStudentsAdapter myadapter=new ListAllStudentsAdapter(mySQLclass.getAllStudents(),getApplicationContext());
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(myadapter);
    }
}