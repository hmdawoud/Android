package com.example.sqliteexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAllStudentsAdapter extends RecyclerView.Adapter<ListAllStudentsAdapter.ViewHolder> {

   ArrayList<Student> data=new ArrayList<>();
   Context context;

    public ListAllStudentsAdapter(ArrayList<Student> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ListAllStudentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.students_item,null,false);

        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAllStudentsAdapter.ViewHolder holder, int position) {
        Student std=data.get(position);
        holder.tv_name.setText(std.getName());
        holder.tv_id.setText(std.getId()+"");
        holder.tv_dept.setText(std.getDept());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id,tv_name,tv_dept;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id=itemView.findViewById(R.id.tv_id);
            tv_name=itemView.findViewById(R.id.tv_Name);
            tv_dept=itemView.findViewById(R.id.tv_dept);


        }
    }
}
