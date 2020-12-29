package gr.uom.socialmediaaggregetor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


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

        Button intentToUserSelectedTwitterPostsActivityButton = (Button) findViewById(R.id.intentToUserSelectedTwitterPostsActivityButton);
        intentToUserSelectedTwitterPostsActivityButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this,UserSelectedTwitterPostsActivity.class);
            startActivity(intent);
        });

        Button intentToCreatePostActivityButton = findViewById(R.id.createPostButton);
        intentToCreatePostActivityButton.setOnClickListener(v->{
            Intent intent = new Intent(MenuActivity.this,CreatePostActivity.class);
            startActivity(intent);
        });
    }


}