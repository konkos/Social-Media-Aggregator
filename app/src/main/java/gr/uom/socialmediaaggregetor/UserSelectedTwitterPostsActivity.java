package gr.uom.socialmediaaggregetor;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import gr.uom.socialmediaaggregetor.ArrayAdapters.UserSelectedTweetsArrayAdapter;
import gr.uom.socialmediaaggregetor.AsyncTasks.GetUserSelectedTweetsTask;
import gr.uom.socialmediaaggregetor.Models.SelectedTrendingTweet;

public class UserSelectedTwitterPostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selected_twitter_posts);

        EditText userSearchEditText = findViewById(R.id.editTextUserSearch);
        ListView userSearchTweetListView = findViewById(R.id.userSearchTweetList);
        Button searchButton = findViewById(R.id.searchButton);

        UserSelectedTweetsArrayAdapter adapter =
                new UserSelectedTweetsArrayAdapter(this,
                        R.layout.user_selected_twitter_post,
                        new ArrayList<SelectedTrendingTweet>(),
                        userSearchTweetListView
                        );
        userSearchTweetListView.setAdapter(adapter);

        searchButton.setOnClickListener(v -> {
            String query = userSearchEditText.getText().toString();
            Log.i("UserSelectedTwitterPostsActivityLogger",query);
            if(query.length()<=0) {
                Toast.makeText(UserSelectedTwitterPostsActivity.this, "Empty Search", Toast.LENGTH_LONG).show();
            }else{
                GetUserSelectedTweetsTask getUserSelectedTweetsTask = new GetUserSelectedTweetsTask(adapter,query);
                getUserSelectedTweetsTask.execute();
            }
        });
    }
}