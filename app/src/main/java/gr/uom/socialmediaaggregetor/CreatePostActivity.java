package gr.uom.socialmediaaggregetor;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.AccountManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import gr.uom.socialmediaaggregetor.AsyncTasks.PostToTwitterTask;

public class CreatePostActivity extends AppCompatActivity {
    private static final String TAG = "CreatePostActivityTAG";
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);
        EditText editText = findViewById(R.id.editTextTextPersonName);
        RadioButton FBradioButton = findViewById(R.id.FBRadioButton);
        RadioButton InstagramRadioButton = findViewById(R.id.InstagramRadioButton);
        RadioButton TwitterRadioButton = findViewById(R.id.TwitterRadioButton);
        btn = findViewById(R.id.postButton);

        btn.setOnClickListener(v->{
            String textToBePosted = editText.getText().toString();
            if(TwitterRadioButton.isChecked()){
                Log.i(TAG, "TwitterRadioButton.isChecked ");
                //post to Twitter
                PostToTwitterTask postToTwitterTask = new PostToTwitterTask(textToBePosted,CreatePostActivity.this);
                postToTwitterTask.execute();
            }
            if (InstagramRadioButton.isChecked()){
                //post to Instagram
            }
            if (FBradioButton.isChecked()
            ){
                //post to FaceBook
            }
        });


    }
}