package com.juaracoding.hukumansatu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.developer.filepicker.controller.DialogSelectionListener;
import com.developer.filepicker.model.DialogConfigs;
import com.developer.filepicker.model.DialogProperties;
import com.developer.filepicker.view.FilePickerDialog;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    Button btnBaca, btnMulai;
    private ArrayList<ModelSoal> soal ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }


        btnBaca = findViewById(R.id.btnBukaFile);
        btnMulai = findViewById(R.id.btnMulaiUjian);

        DialogProperties properties = new DialogProperties();
        properties.selection_mode = DialogConfigs.SINGLE_MODE;
        properties.selection_type = DialogConfigs.FILE_SELECT;
        properties.root = new File(DialogConfigs.DEFAULT_DIR);
        properties.error_dir = new File(DialogConfigs.DEFAULT_DIR);
        properties.offset = new File(DialogConfigs.DEFAULT_DIR);
        properties.extensions = null;

        final FilePickerDialog dialog = new FilePickerDialog(MainActivity.this,properties);
        dialog.setTitle("Pilih file csv");

        dialog.setDialogSelectionListener(new DialogSelectionListener() {
            @Override
            public void onSelectedFilePaths(String[] files) {
                //files is the array of the paths of files selected by the Application User.
                    soal =  baca(files[0]);
            }
        });

        btnBaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dialog.show();
            }
        });

        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(soal!=null){
                    if (soal.size()>0){
                        Intent intent = new Intent(MainActivity.this,Quiz.class);
                        intent.putParcelableArrayListExtra("data",soal);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this,"Maaf tidak ada soal", Toast.LENGTH_LONG).show();
                    }
                }else{
                        Toast.makeText(MainActivity.this,"Mohon buka soal terlebih dahulu", Toast.LENGTH_LONG).show();
                }

            }
        });
    }



    public ArrayList<ModelSoal> baca(String fileName) {
        ArrayList<ModelSoal> todoList = new ArrayList<>();

        try {


            Scanner scanner = new Scanner(new File(fileName));
            Scanner valueScanner = null;
            int index = 0;


            while (scanner.hasNextLine()) {
                valueScanner = new Scanner(scanner.nextLine());
                valueScanner.useDelimiter(";");
                ModelSoal soal = new ModelSoal();

                while (valueScanner.hasNext()) {
                    String data = valueScanner.next();
                    if (index == 0) {
                        soal.setPertanyaan(data);
                    } else if (index == 1) {
                        soal.setJawabA(data);
                    } else if (index == 2) {
                        soal.setJawabB(data);
                    }else if (index == 3) {
                        soal.setJawabC(data);
                    }else if (index == 4) {
                        soal.setJawabD(data);
                    }else if (index == 5) {
                        soal.setJawaban(data);
                    } else if (index == 6) {
                        soal.setNilai(Integer.parseInt(data));
                    }else if (index == 7) {
                        soal.setUrlGambar(data);
                    }
                    index++;
                }
                index = 0;
                todoList.add(soal);
            }

            scanner.close();
        } catch (IOException e) {

        }

        return todoList;
    }
}
