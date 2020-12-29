package gr.uom.socialmediaaggregetor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.FacebookActivity;

import gr.uom.socialmediaaggregetor.AsyncTasks.GetListSelectedTweetTask;
import gr.uom.socialmediaaggregetor.Models.Hashtag;

public class postsFromAll3SocialMedia extends AppCompatActivity {

    ListView postsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_from_all3_social_media);

        postsListView = findViewById(R.id.postsListView);

        // TODO: 27/11/2020 LOOKUP selected Hashtag on Twitter Fb and Instagram
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Integer position = (Integer) extras.get("position");
        Hashtag selectedHashtag = (Hashtag) extras.get("selectedHashtag");
        Log.i("ALLPOSTS",selectedHashtag.toString());

        /*String url = selectedHashtag.getUrl();
        String querySubstring = url.subSequence(28, url.length()).toString();
        Log.i("CHASRSEQ",querySubstring);*/

        getTweets(selectedHashtag);

    }

    private void getTweets(Hashtag selectedHashtag) {
        GetListSelectedTweetTask getListSelectedTweetTask = new GetListSelectedTweetTask(selectedHashtag.getQuery());
        getListSelectedTweetTask.execute();
    }
}