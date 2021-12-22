package com.example.sqliteexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText txtName;
    EditText txtId;
    Spinner spDept;
    Button btnAdd, btnUpdate, btnListAll, btndeleteStudent, btnDeleteAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MySQLclass mySQLclass = new MySQLclass(getApplicationContext());

        txtName = findViewById(R.id.txt_Name);
        txtId = findViewById(R.id.txt_ID);
        spDept = findViewById(R.id.sp_Dept);
        btnUpdate = findViewById(R.id.btn_Update);
        btnListAll = findViewById(R.id.btn_List);
        btnAdd = findViewById(R.id.btn_ADD);
        btnDeleteAll = findViewById(R.id.btn_deleteALL);
        btndeleteStudent = findViewById(R.id.btn_Delete);

        btndeleteStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtId.getText().toString().isEmpty()) {
                    txtId.setError("Can't be Empty");

                }
                else
                mySQLclass.deleteStudent(txtId.getText().toString());
            }
        });

        btnDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySQLclass.deleteAllStudents();
            }
        });

        btnListAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ListAllStudents.class);
                startActivity(i);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputValidation()) {
                    mySQLclass.insertStudent(ReadStudentData());
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputValidation()) {
                    mySQLclass.updateStudent(ReadStudentData());
                }
            }
        });


    }

    public Student ReadStudentData() {
        String Name, Dept;
        int Id;
        Student std;
        Name = txtName.getText().toString();
        Id = Integer.parseInt(txtId.getText().toString());
        Dept = spDept.getSelectedItem().toString();

        // if(!Name.isEmpty()&&!Id.isEmpty()) {
        std = new Student(Name, Id, Dept);
        return std;
        // }
    }

    public boolean inputValidation() {
        boolean flag = true;
        if (txtName.getText().toString().isEmpty()) {
            txtName.setError("Can't be Empty");
            flag = false;
        }
        if (txtId.getText().toString().isEmpty()) {
            txtId.setError("Can't be Empty");
            flag = false;
        }

        return flag;

    }


}