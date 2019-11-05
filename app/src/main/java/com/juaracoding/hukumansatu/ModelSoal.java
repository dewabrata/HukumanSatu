package com.juaracoding.hukumansatu;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelSoal implements Parcelable {

    private String pertanyaan;
    private String  jawabA;
    private String  jawabB;
    private String  jawabC;
    private String  jawabD;
    private String jawaban;
    private int nilai;
    private String urlGambar;
    private String pilihan;

    public ModelSoal(String pertanyaan, String jawabA, String jawabB, String jawabC, String jawabD, String jawaban, int nilai, String urlGambar, String pilihan) {
        this.pertanyaan = pertanyaan;
        this.jawabA = jawabA;
        this.jawabB = jawabB;
        this.jawabC = jawabC;
        this.jawabD = jawabD;
        this.jawaban = jawaban;
        this.nilai = nilai;
        this.urlGambar = urlGambar;
        this.pilihan = pilihan;
    }
    public ModelSoal(){

    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getJawabA() {
        return jawabA;
    }

    public void setJawabA(String jawabA) {
        this.jawabA = jawabA;
    }

    public String getJawabB() {
        return jawabB;
    }

    public void setJawabB(String jawabB) {
        this.jawabB = jawabB;
    }

    public String getJawabC() {
        return jawabC;
    }

    public void setJawabC(String jawabC) {
        this.jawabC = jawabC;
    }

    public String getJawabD() {
        return jawabD;
    }

    public void setJawabD(String jawabD) {
        this.jawabD = jawabD;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public String getUrlGambar() {
        return urlGambar;
    }

    public void setUrlGambar(String urlGambar) {
        this.urlGambar = urlGambar;
    }

    public String getPilihan() {
        return pilihan;
    }

    public void setPilihan(String pilihan) {
        this.pilihan = pilihan;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.pertanyaan);
        dest.writeString(this.jawabA);
        dest.writeString(this.jawabB);
        dest.writeString(this.jawabC);
        dest.writeString(this.jawabD);
        dest.writeString(this.jawaban);
        dest.writeInt(this.nilai);
        dest.writeString(this.urlGambar);
        dest.writeString(this.pilihan);
    }

    protected ModelSoal(Parcel in) {
        this.pertanyaan = in.readString();
        this.jawabA = in.readString();
        this.jawabB = in.readString();
        this.jawabC = in.readString();
        this.jawabD = in.readString();
        this.jawaban = in.readString();
        this.nilai = in.readInt();
        this.urlGambar = in.readString();
        this.pilihan = in.readString();
    }

    public static final Parcelable.Creator<ModelSoal> CREATOR = new Parcelable.Creator<ModelSoal>() {
        @Override
        public ModelSoal createFromParcel(Parcel source) {
            return new ModelSoal(source);
        }

        @Override
        public ModelSoal[] newArray(int size) {
            return new ModelSoal[size];
        }
    };
}
