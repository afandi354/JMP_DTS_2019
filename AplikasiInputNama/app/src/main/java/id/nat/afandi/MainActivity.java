package id.nat.afandi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nama;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.edtNama);
        hasil = findViewById(R.id.tvOutput);
    }

    @SuppressLint("SetTextI18n")
    public void show(View view) {
        hasil.setText("Nama Anda " +nama.getText());
        nama.getText().clear();
    }
}