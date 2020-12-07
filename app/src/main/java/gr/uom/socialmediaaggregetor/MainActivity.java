package gr.uom.socialmediaaggregetor;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import gr.uom.socialmediaaggregetor.ArrayAdapters.TrendingTwitterHashTagsArrayAdapter;
import gr.uom.socialmediaaggregetor.AsyncTasks.GetTrendingTwitterHashTagsTask;
import gr.uom.socialmediaaggregetor.Models.Hashtag;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView trendingTweetsListView = findViewById(R.id.trendingTweetsListView);

        TrendingTwitterHashTagsArrayAdapter trendingTwitterHashTagsArrayAdapter =
                new TrendingTwitterHashTagsArrayAdapter(this,
                        R.layout.trending_tweet,
                        new ArrayList<Hashtag>(),
                        trendingTweetsListView
                );

        GetTrendingTwitterHashTagsTask task = new GetTrendingTwitterHashTagsTask(trendingTwitterHashTagsArrayAdapter);
        task.execute();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast toast = Toast.makeText(this, "Select A Tweet For Lookup", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }
}