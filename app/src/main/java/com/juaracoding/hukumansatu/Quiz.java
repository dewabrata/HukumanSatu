package com.juaracoding.hukumansatu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Quiz extends AppCompatActivity {

    ArrayList<ModelSoal> soal ;
    RecyclerView lstData ;
    Button btnSelesai;
    QuizAdapter itemArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        lstData = findViewById(R.id.listData);

        btnSelesai = findViewById(R.id.btnSelesai);
        soal = getIntent().getParcelableArrayListExtra("data");

        setList(soal);

        btnSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Quiz.this,Hasil.class);
                intent.putParcelableArrayListExtra("data",soal);
                startActivity(intent);


            }
        });

    }

    public void setList(ArrayList<ModelSoal>soal ){
         itemArrayAdapter = new QuizAdapter(soal);

        lstData.setLayoutManager(new LinearLayoutManager(this));
        lstData.setItemAnimator(new DefaultItemAnimator());
        lstData.setAdapter(itemArrayAdapter);



    }

}
