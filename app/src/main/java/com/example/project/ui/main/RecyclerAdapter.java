package com.example.project.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.sql_db.Question;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RowHolder> {
    private List<Question> list = new ArrayList<>();
    private Context context;


    public RecyclerAdapter(Context context){ this.context = context; }

    public void addQuestion(Question set) {
        list.add(set);
        notifyDataSetChanged();
    }

    public void setList(List<Question> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView  = LayoutInflater.from(context).inflate(R.layout.recycler_row_nquiz_set, parent, false);

                RowHolder row = new RowHolder(rowView);
        return row;
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        Question set = list.get(position);
        holder.bindModel(set);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
