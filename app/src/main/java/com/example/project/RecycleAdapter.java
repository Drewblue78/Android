package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RowHolder> {
    private List<QuizSet> list = new ArrayList<>();
    private Context context;


    public RecycleAdapter(Context context){
        this.context = context;
   }
    public void addQuizSet(QuizSet set) {
        list.add(set);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView  = LayoutInflater.from(context).inflate(R.layout.recycler_row_nquiz_set, parent);
        RowHolder row = new RowHolder(rowView);
        return row;
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        QuizSet set = list.get(position);
        holder.bindModel(set);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
