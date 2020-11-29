package gr.uom.socialmediaaggregetor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button intentToMainActivityButton = (Button) findViewById(R.id.intentToMainActivityButton);
        intentToMainActivityButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this,MainActivity.class);
            startActivity(intent);
        });
    }
}