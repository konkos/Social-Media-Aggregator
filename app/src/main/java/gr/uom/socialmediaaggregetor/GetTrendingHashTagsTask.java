package gr.uom.socialmediaaggregetor;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class GetTrendingHashTagsTask extends AsyncTask<Void,Void,String> {

    public static final String TAG = "THisIsAtag";
    public static final String GREECE_WOEID = "23424833";
    private static final String TWITTER_ENDPOINT = "https://api.twitter.com/1.1/trends/place.json?id="+GREECE_WOEID;
    public static final String BEARER_TOKEN = "Bearer AAAAAAAAAAAAAAAAAAAAACy5JgEAAAAA18e%2FheRtBV9sNNifThQf5vBv11M%3De3Zib0YbJWkUkZjMqSiRR5Us1GpJEXht6PNpnxATaFQrI9oFfL";

//    private ListView trendingTweetsListView;
    private TrendingHashTagsArrayAdapter adapter;

    public GetTrendingHashTagsTask(TrendingHashTagsArrayAdapter adapter){
        this.adapter=adapter;
    }

    @Override
    protected String doInBackground(Void... voids) {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(TWITTER_ENDPOINT)
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

        return bodyJSON;//https://github.com/dferreira-cvl/howto-okhttp-android/blob/master/app/src/main/java/com/codavel/howto_okhttp/MainActivity.java
    }

    @Override
    protected void onPostExecute(String jsonString) {
        super.onPostExecute(jsonString);
        Log.i(TAG,"POSTEXECUTE\n"+jsonString);
        String substring=null;
        if (jsonString.startsWith("[")) {
            substring = jsonString.substring(1, jsonString.length() - 1);
            Log.i("Substring",substring);
        }

        List<Hashtag> hashtags = parseJsonToHashTagArray(substring);
        adapter.setHashtagList(hashtags);
    }

    private List<Hashtag> parseJsonToHashTagArray(String substring) {
        Gson gson = new Gson();
        Trends trends = gson.fromJson(substring, Trends.class);
        Hashtag[] hashtags = trends.getHashtags();
        for (Hashtag hashtag : hashtags) {
            Log.i("HASHTAGHOPEFULLY",hashtag.toString());
        }
        return Arrays.asList(hashtags);
    }
}
