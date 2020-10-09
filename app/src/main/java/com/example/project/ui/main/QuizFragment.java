package com.example.project.ui.main;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.example.project.R;
import com.example.project.sql_db.Question;
import com.example.project.sql_db.SQLiteManager;
import com.example.project.sql_db.Samples;
import com.example.project.sql_db.Table;


public class QuizFragment extends Fragment {


    private static final String ARG_CONSOLE = "console1";

    private ImageView banner;
    private Button btnconsole;
    private RecyclerView questionList;
    private RecyclerAdapter adapter;
    private SQLiteManager sql;
    private String nConsole;

    public static QuizFragment newInstance(String console1) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CONSOLE, console1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nConsole = getArguments().getString(ARG_CONSOLE);
            sql = new SQLiteManager(getContext());
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.n_quiz, container, false);
        banner = v.findViewById(R.id.imgBanner);
        btnconsole = v.findViewById(R.id.console);
        questionList = v.findViewById(R.id.nQuiz);

        btnconsole.setText(nConsole);

        adapter = new RecyclerAdapter(getContext());
        questionList.setAdapter(adapter);
        questionList.setLayoutManager(new LinearLayoutManager(getContext()));

        SQLiteDatabase db = sql.getReadableDatabase();
        adapter.setList(Table.getQuestions(db));

        switch (nConsole) {
            case "nintendo":
                banner.setImageResource(R.drawable.nintendo);
//                btnconsole.setBackgroundResource(R.color.#E4000F);
                break;
            case "playstation":
                banner.setImageResource(R.drawable.playstation);
                break;
            case "xbox":
                banner.setImageResource(R.drawable.xbox);
                break;
        }
        return v;
    }

    //    Quiz date
    private int score = 0;

    public class OptionSelectCallback implements View.OnClickListener {
        private Question question;
        private int option;
        private QuizFragment quiz;

        public OptionSelectCallback(Question question, int option, QuizFragment quiz) {
            this.question = question;
            this.option = option;
            this.quiz = quiz;
        }

        //TODO what if they click the button more than once
        @Override
        public void onClick(View v) {
            question.getCorrect();
            if (option == question.getCorrect()) {
                score = score + 1;
            }


            Samples.questions.getClass();
        }
    }
}