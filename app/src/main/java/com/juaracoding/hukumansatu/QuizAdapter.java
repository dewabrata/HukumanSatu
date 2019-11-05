package com.juaracoding.hukumansatu;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import worker8.com.github.radiogroupplus.RadioGroupPlus;

public class QuizAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private ArrayList<ModelSoal> dataItemList;

    public ArrayList<ModelSoal> getDataItemList() {
        return dataItemList;
    }

    public QuizAdapter(ArrayList<ModelSoal> dataItemList) {
        this.dataItemList = dataItemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        this.context = parent.getContext();
        if (viewType==0){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_soal, parent, false);
            Penampung penampung = new Penampung(view);
            return penampung;
        }else{
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_soal_gambar, parent, false);
            Penampung2 penampung2 = new Penampung2(view);
            return penampung2;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof  Penampung){
            ((Penampung)holder).txtSoal.setText(dataItemList.get(position).getPertanyaan());
            ((Penampung)holder).jawabA.setText(dataItemList.get(position).getJawabA());
            ((Penampung)holder).jawabB.setText(dataItemList.get(position).getJawabB());
            ((Penampung)holder).jawabC.setText(dataItemList.get(position).getJawabC());
            ((Penampung)holder).jawabD.setText(dataItemList.get(position).getJawabD());

            ((Penampung)holder).rg.setOnCheckedChangeListener(new RadioGroupPlus.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroupPlus radioGroupPlus, int i) {
                    if (R.id.rdA == radioGroupPlus.getCheckedRadioButtonId()) {
                        dataItemList.get(position).setPilihan("A");
                    }
                    if (R.id.rdB == radioGroupPlus.getCheckedRadioButtonId()) {
                        dataItemList.get(position).setPilihan("B");
                    }
                    if (R.id.rdC == radioGroupPlus.getCheckedRadioButtonId()) {
                        dataItemList.get(position).setPilihan("C");
                    }
                    if (R.id.rdD == radioGroupPlus.getCheckedRadioButtonId()) {
                        dataItemList.get(position).setPilihan("D");
                    }

                    Toast.makeText(context,dataItemList.get(position).getPilihan(),Toast.LENGTH_LONG).show();
                }
            });
        }else{

            ImageView image = ((Penampung2)holder).gambar;
            ((Penampung2)holder).txtSoal.setText(dataItemList.get(position).getPertanyaan());
            ((Penampung2)holder).jawabA.setText(dataItemList.get(position).getJawabA());
            ((Penampung2)holder).jawabB.setText(dataItemList.get(position).getJawabB());
            ((Penampung2)holder).jawabC.setText(dataItemList.get(position).getJawabC());
            ((Penampung2)holder).jawabD.setText(dataItemList.get(position).getJawabD());
            ((Penampung2)holder).rg.setOnCheckedChangeListener(new RadioGroupPlus.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroupPlus radioGroupPlus, int i) {
                    if (R.id.rdA == radioGroupPlus.getCheckedRadioButtonId()) {
                        dataItemList.get(position).setPilihan("A");
                    }
                    if (R.id.rdB == radioGroupPlus.getCheckedRadioButtonId()) {
                        dataItemList.get(position).setPilihan("B");
                    }
                    if (R.id.rdC == radioGroupPlus.getCheckedRadioButtonId()) {
                        dataItemList.get(position).setPilihan("C");
                    }
                    if (R.id.rdD == radioGroupPlus.getCheckedRadioButtonId()) {
                        dataItemList.get(position).setPilihan("D");
                    }

                    Toast.makeText(context,dataItemList.get(position).getPilihan(),Toast.LENGTH_LONG).show();
                }
            });
             Picasso.get().load(dataItemList.get(position).getUrlGambar()).into( image );
        }




    }

    @Override
    public int getItemViewType(int position) {
        if (dataItemList.get(position).getUrlGambar().equalsIgnoreCase("-")){

            return 0;
        }else{
            return 1;
        }


    }

    @Override
    public int getItemCount() {
        return dataItemList == null ? 0 : dataItemList.size();
    }


    static class Penampung extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtSoal;
        public RadioButton jawabA;
        public RadioButton jawabB;
        public RadioButton jawabC;
        public RadioButton jawabD;
        public RadioGroupPlus rg;

        public Penampung(View itemView) {
            super(itemView);
          //  itemView.setOnClickListener(this);
            txtSoal = (TextView) itemView.findViewById(R.id.txtSoal);
            jawabA = (RadioButton) itemView.findViewById(R.id.rdA);
            jawabB = (RadioButton) itemView.findViewById(R.id.rdB);
            jawabC = (RadioButton) itemView.findViewById(R.id.rdC);
            jawabD = (RadioButton) itemView.findViewById(R.id.rdD);
            rg = (RadioGroupPlus)itemView.findViewById((R.id.radio_group_plus));

        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + txtSoal.getText());
        }
    }

    static class Penampung2 extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtSoal;
        public RadioButton jawabA;
        public RadioButton jawabB;
        public RadioButton jawabC;
        public RadioButton jawabD;
        public ImageView gambar;
        public RadioGroupPlus rg;

        public Penampung2(View itemView) {
            super(itemView);
            //  itemView.setOnClickListener(this);
            txtSoal = (TextView) itemView.findViewById(R.id.txtSoal);
            jawabA = (RadioButton) itemView.findViewById(R.id.rdA);
            jawabB = (RadioButton) itemView.findViewById(R.id.rdB);
            jawabC = (RadioButton) itemView.findViewById(R.id.rdC);
            jawabD = (RadioButton) itemView.findViewById(R.id.rdD);
            gambar = (ImageView) itemView.findViewById(R.id.gambar);

            rg = (RadioGroupPlus)itemView.findViewById((R.id.radio_group_plus));
        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + txtSoal.getText());
        }
    }
}
