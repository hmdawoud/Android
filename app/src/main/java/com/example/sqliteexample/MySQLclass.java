package com.example.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MySQLclass extends SQLiteOpenHelper {

public  static  final String DB_NAME="STUDENTS";
public  static  final int DB_VERSION=2;

    public MySQLclass(Context context ) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE student (id INTEGER PRIMARY KEY, name TEXT NOT NULL, dept TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }

    public void insertStudent(Student student)
    {
        boolean result=true;
        SQLiteDatabase db =getWritableDatabase();

     // String query = "INSERT INTO student(id,name,dept) VALUES("+student.getId()+",'"+student.getName()+"','"+student.getDept()+"')";
       // db.execSQL(query);

        ContentValues cv = new ContentValues();
        cv.put("id",student.getId());
        cv.put("name",student.getName());
        cv.put("dept",student.getDept());
        db.insert("student",null,cv);


    }
    public void updateStudent(Student student)
    {
         SQLiteDatabase db =getWritableDatabase();
         ContentValues cv = new ContentValues();
        cv.put("id",student.getId());
        cv.put("name",student.getName());
        cv.put("dept",student.getDept());
        String args[] ={student.getId()+""};
        db.update("student",cv,"id=?",args);


    }

    public ArrayList<Student> getAllStudents() {
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<Student> students = new ArrayList<>();

        String query = "SELECT * FROM student";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String dept = cursor.getString(2);
            //Create object of user and insert it in students arrayList
            Student s = new Student(name,id,dept);
            students.add(s);

            cursor.moveToNext();
        }

        return students;
    }

    public void deleteStudent(String id)
    {
        SQLiteDatabase db = getWritableDatabase();
//        db.execSQL("DELETE FROM student WHERE id="+id+";");

        String args[] ={id};
        db.delete("student","id=?",args);


    }
        public void deleteAllStudents()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM student;");
    }


}
