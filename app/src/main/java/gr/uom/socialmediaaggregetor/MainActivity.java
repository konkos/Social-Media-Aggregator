package gr.uom.socialmediaaggregetor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView trendingTweetsListView = findViewById(R.id.trendingTweetsListView);

        TrendingHashTagsArrayAdapter trendingHashTagsArrayAdapter =
                new TrendingHashTagsArrayAdapter(this,
                        R.layout.trending_tweet,
                        new ArrayList<Hashtag>(),
                        trendingTweetsListView
                );


        GetTrendingHashTagsTask task = new GetTrendingHashTagsTask(trendingHashTagsArrayAdapter);
        task.execute();
    }
}