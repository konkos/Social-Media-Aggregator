package gr.uom.socialmediaaggregetor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import gr.uom.socialmediaaggregetor.AsyncTasks.GetListSelectedTweetTask;
import gr.uom.socialmediaaggregetor.Models.Hashtag;

public class postsFromAll3SocialMedia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_from_all3_social_media);

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
        GetListSelectedTweetTask getListSelectedTweetTask = new GetListSelectedTweetTask(selectedHashtag.getQuery());
        getListSelectedTweetTask.execute();

    }
}