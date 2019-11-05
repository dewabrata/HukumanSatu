package com.juaracoding.hukumansatu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Quiz extends AppCompatActivity {

    ArrayList<ModelSoal> soal ;
    RecyclerView lstData ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        lstData = findViewById(R.id.listData);

        soal = getIntent().getParcelableArrayListExtra("data");

        setList(soal);

    }

    public void setList(ArrayList<ModelSoal>soal ){
        QuizAdapter itemArrayAdapter = new QuizAdapter(soal);

        lstData.setLayoutManager(new LinearLayoutManager(this));
        lstData.setItemAnimator(new DefaultItemAnimator());
        lstData.setAdapter(itemArrayAdapter);



    }

}
