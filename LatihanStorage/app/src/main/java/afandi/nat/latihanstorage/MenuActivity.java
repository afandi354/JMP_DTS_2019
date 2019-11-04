package afandi.nat.latihanstorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnInternal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnInternal = findViewById(R.id.btnInternal);
        btnInternal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnInternal:
                Intent internal = new Intent(MenuActivity.this, InternalActivity.class );
                startActivity(internal);
                break;
            case R.id.btnExternal:
                break;
        }
    }
}
