package com.example.project.ui.main;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.sql_db.Question;

public class RowHolder extends RecyclerView.ViewHolder {

    private TextView n;
    private TextView q;
    private Button a;
    private Button b;
    private Button c;
    private Button d;


    public RowHolder(@NonNull View itemView) {
        super(itemView);
        n = itemView.findViewById(R.id.questions);
        q = itemView.findViewById(R.id.uniqueQ1);
        a = itemView.findViewById(R.id.button1);
        b = itemView.findViewById(R.id.button2);
        c = itemView.findViewById(R.id.button3);
        d = itemView.findViewById(R.id.button4);

    }

    public void bindModel (Question set){
        n.setText("N" + set.getId());
        q.setText("Q" + set.getQuestion());
        a.setText("A" + set.getAnswer_a());
        b.setText("B" + set.getAnswer_b());
        c.setText("C" + set.getAnswer_c());
        d.setText("D" + set.getAnswer_d());
    }
}
