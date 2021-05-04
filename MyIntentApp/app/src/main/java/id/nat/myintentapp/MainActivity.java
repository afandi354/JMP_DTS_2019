package id.nat.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnWeb = findViewById(R.id.btnWeb);
        btnWeb.setOnClickListener(this);

        Button btnCall = findViewById(R.id.btnCall);
        btnCall.setOnClickListener(this);

        Button btnProfile = findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnWeb :
                Uri web = Uri.parse("https://www.kominfo.go.id/");
                Intent website = new Intent(Intent.ACTION_VIEW, web);
                startActivity(website);
                break;
            case R.id.btnCall:
                String phoneNumber = "082325312882";
                Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +phoneNumber));
                startActivity(call);
                break;
            case R.id.btnProfile:
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                break;
        }
    }
}