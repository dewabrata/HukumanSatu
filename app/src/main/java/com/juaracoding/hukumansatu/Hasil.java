package com.juaracoding.hukumansatu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Hasil extends AppCompatActivity {

    ArrayList<ModelSoal>soal;
    TextView txtJumlahSoal, txtBenar,txtSalah,  txtScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        txtJumlahSoal = findViewById(R.id.txtJumlahSoal);
        txtBenar = findViewById(R.id.txtJumlahBenar);
        txtSalah = findViewById(R.id.txtJumlahSalah);
        txtScore = findViewById(R.id.txtScore);


        soal = getIntent().getParcelableArrayListExtra("data");

        int jumlahsoal = soal.size();
        int jumlahbenar =0 ;
        int jumlahsalah =0 ;
        int score=0;

        for (int x = 0 ; x < soal.size();x++) {

            if (soal.get(x).getPilihan() != null) {
                if (soal.get(x).getJawaban().equalsIgnoreCase(soal.get(x).getPilihan())) {
                    jumlahbenar++;
                    score = score + soal.get(0).getNilai();
                } else {
                    jumlahsalah++;
                }
            }else{
                jumlahsalah++;
            }
        }

        txtJumlahSoal.setText("Jumlah soal adalah :"+jumlahsoal );
        txtBenar.setText("Jumlah benar adalah :"+jumlahbenar );
        txtSalah.setText("Jumlah salah adalah :"+jumlahsalah );
        txtScore.setText("Jumlah score adalah :"+score );

    }
}
