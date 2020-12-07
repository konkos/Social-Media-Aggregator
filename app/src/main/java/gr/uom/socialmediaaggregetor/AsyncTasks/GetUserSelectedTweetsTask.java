package gr.uom.socialmediaaggregetor.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import gr.uom.socialmediaaggregetor.ArrayAdapters.UserSelectedTweetsArrayAdapter;
import gr.uom.socialmediaaggregetor.KEYS.KeysStorage;
import gr.uom.socialmediaaggregetor.Models.Data;
import gr.uom.socialmediaaggregetor.Models.SelectedTrendingTweet;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class GetUserSelectedTweetsTask extends AsyncTask<Void,Void,String> {

    public static final String TAG = "GetUserSelectedTweetsTaskLogger";
    public static String TWITTER_ENDPOINT = "https://api.twitter.com/2/tweets/search/recent?query=";
    public static final String BEARER_TOKEN = KeysStorage.TWITTER_BEARER_TOKEN;
    private String query;
    private UserSelectedTweetsArrayAdapter adapter;

    public GetUserSelectedTweetsTask(UserSelectedTweetsArrayAdapter adapter, String query){
        this.query = query;
        this.adapter = adapter;
    }
    @Override
    protected String doInBackground(Void... voids) {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(TWITTER_ENDPOINT.concat(query))
                .addHeader("Authorization", BEARER_TOKEN)
                .build(); // defaults to GET

        Call call = httpClient.newCall(request);
        Response response;
        ResponseBody body;
        String bodyJSON = null;
        try {
            response = call.execute();
            body = response.body();
            bodyJSON = body.string();
            Log.i(TAG,bodyJSON);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bodyJSON;
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);
        Log.i("GetUserSelectedTweetsJsonData",jsonData);
        Gson gson = new Gson();
        Data data = gson.fromJson(jsonData, Data.class);
        //Using SelectedTrendingTweet.class Because GSON is an utter penis
        SelectedTrendingTweet[] userSelectedTweets = data.getSelectedTrendingTweets();
        for(SelectedTrendingTweet trendingTweet:userSelectedTweets){
            Log.i("GetUserSelectedTweetsARRAY",trendingTweet.toString());
        }
        List<SelectedTrendingTweet> selectedTrendingTweets = Arrays.asList(userSelectedTweets);
        adapter.setUserSelectedTweetsList(selectedTrendingTweets);

    }
}
