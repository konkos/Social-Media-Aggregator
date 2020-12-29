package gr.uom.socialmediaaggregetor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class CreatePostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);
        EditText editText = findViewById(R.id.editTextTextPersonName);
        RadioButton FBradioButton = findViewById(R.id.FBRadioButton);
        RadioButton InstagramRadioButton = findViewById(R.id.InstagramRadioButton);
        RadioButton TwitterRadioButton = findViewById(R.id.TwitterRadioButton);

        if(TwitterRadioButton.isChecked()){
            //post to Twitter
        }
        if (InstagramRadioButton.isEnabled()){
            //post to Instagram
        }
        if (FBradioButton.isEnabled()){
            //post to FaceBook
        }
    }
}