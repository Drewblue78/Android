package com.example.project;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

    public void bindModel (QuizSet set){
        n.setText("N" + set.getN());
        q.setText("Q" + set.getQ());
        a.setText("A" + set.getA());
        b.setText("B" + set.getB());
        c.setText("C" + set.getC());
        d.setText("D" + set.getD());
    }
}
