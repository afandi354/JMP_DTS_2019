package id.nat.aplikasilistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String [] namanegara = new String[] {
            "Saudi Arabia", "Polandia", "Senegal",
            "Vietnam", "Indonesia", "Timor-Timor",
            "Italia", "Kanada", "Meksiko", "Etiopia",
            "Jerman", "Australia", "Selandia Baru"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Daftar Negara Maju");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, namanegara);

        ListView listView = findViewById(R.id.lvNegara);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Anda Memilih : " +namanegara[position],
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}