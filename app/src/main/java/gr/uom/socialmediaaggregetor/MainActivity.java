package gr.uom.socialmediaaggregetor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import gr.uom.socialmediaaggregetor.ArrayAdapters.TrendingHashTagsArrayAdapter;
import gr.uom.socialmediaaggregetor.AsyncTasks.GetTrendingHashTagsTask;
import gr.uom.socialmediaaggregetor.Models.Hashtag;

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