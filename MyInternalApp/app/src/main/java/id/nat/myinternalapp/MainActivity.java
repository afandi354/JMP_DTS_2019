package id.nat.myinternalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String FILENAME = "dts.txt";
    Button buatFile, ubahFile, bacaFile, deteleFile;
    TextView textBaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buatFile = findViewById(R.id.btnCreate);
        ubahFile = findViewById(R.id.btnUpdate);
        bacaFile = findViewById(R.id.btnRead);
        deteleFile = findViewById(R.id.btnDelete);
        textBaca = findViewById(R.id.textBaca);

        buatFile.setOnClickListener(this);
        ubahFile.setOnClickListener(this);
        bacaFile.setOnClickListener(this);
        deteleFile.setOnClickListener(this);
    }

    void buatFile(){
        String isiFile = "Afandi Nur Aziz Thohari";
        File file = new File(getFilesDir(), FILENAME);

        FileOutputStream outputStream = null;
        try{
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();

            Toast.makeText(this, getFilesDir().toString(), Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    void ubahFile(){
        String ubah = "Semangat Pagi! Pagi, Pagi, Pagi!";
        File file = new File(getFilesDir(), FILENAME);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(ubah.getBytes());
            outputStream.flush();
            outputStream.close();

            Toast.makeText(this, "File telah diubah", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    void bacaFile(){
        File sdcard = getFilesDir();
        File file = new File(sdcard, FILENAME);

        if(file.exists()){
            StringBuilder text = new StringBuilder();

            try{
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();

                while (line != null){
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
                Toast.makeText(this, "Membaca File", Toast.LENGTH_SHORT).show();
            } catch (IOException e){
                System.out.println("Error "+e.getMessage());
            }
            textBaca.setText(text.toString());
        }
    }

    void hapusFile(){
        File file = new File(getFilesDir(), FILENAME);
        if(file.exists()){
            file.delete();
            Toast.makeText(this, "File telah terhapus", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        jalankanPerintah(v.getId());
    }

    public void jalankanPerintah(int id) {
        switch (id) {
            case R.id.btnCreate:
                buatFile();
                break;
            case R.id.btnRead:
                bacaFile();
                break;
            case R.id.btnUpdate:
                ubahFile();
                break;
            case R.id.btnDelete:
                hapusFile();
                break;
        }
    }
}