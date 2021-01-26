package gr.uom.socialmediaaggregetor.AsyncTasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;


import java.io.IOException;

import java.util.Date;
import java.util.Random;

import okhttp3.MediaType;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class PostToTwitterTask extends AsyncTask<Void,Void,String> {

    private final String TAG = "TWITTERPOST";

    private String postText;
    private String postURL = "https://api.twitter.com/1.1/statuses/update.json?status=";
    private Context context;
    private Twitter twitter=null;

    public PostToTwitterTask(String postText, Context context){
        this.postText = postText;
        postURL += postText;
        this.context = context;
    }


    @Override
    protected String doInBackground(Void... voids) {

        String nonce = postText + new Random().nextInt();

/*
        OkHttpClient httpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create("",MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(postURL)
                .post(requestBody)
                .addHeader("Authorization", "OAuth oauth_consumer_key="
                        +KeysStorage.TWITTER_API_KEY+
                        ",oauth_token="+
                        KeysStorage.TWITTER_ACCESS_TOKEN_SECRET).
                        addHeader("Authorization","'authorization: OAuth" +
                                "         oauth_consumer_key=\""+KeysStorage.TWITTER_ACCESS_TOKEN+"\"," +
                                "         oauth_nonce=\""+nonce+"\"," +
                                "         oauth_signature=\"generated_oauth_signature\"," +
                                "         oauth_signature_method=\"HMAC-SHA1\"," +
                                "         oauth_timestamp=\"generated_timestamp\"," +
                                "         oauth_token=\"oauth_token\"," +
                                "         oauth_version=\"1.0\"'")
                .build();

        Call call = httpClient.newCall(request);
        ResponseBody body = null;
        try {
            Response response = call.execute();
            body = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.twitter.com/1.1/statuses/update.json?status="+postText)
                .method("POST", body)
                .addHeader("Authorization", "OAuth oauth_consumer_key=\"KEawCKh3UBiVFs6GMfGbAG2AN\",oauth_token=\"1326957896077283329-CIvHX5WzOc5OarXzHpkBw7FeBDwfCn\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\""+ System.currentTimeMillis() +"\",oauth_nonce=\""+nonce+"\",oauth_version=\"1.0\",oauth_signature=\"A7lA44ovOpS6jOpUtna%2BwmoCRUc%3D\"")
                .addHeader("Cookie", "personalization_id=\"v1_zxq/17TZl4exrgMW6lEzcQ==\"; guest_id=v1%3A160659267909685266")
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("KEawCKh3UBiVFs6GMfGbAG2AN")
                .setOAuthConsumerSecret("WM7Qny88cdfDWaRhre4JY0PQ9a62AWh12059NCUVtaejFv3cYb")
                .setOAuthAccessToken("1326957896077283329-CIvHX5WzOc5OarXzHpkBw7FeBDwfCn")
                .setOAuthAccessTokenSecret("sc3hMXAilyoNLg8cPsShqv9neDtd8FLNqckbOy8HOUKEx");
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();

        String tweet="";
        try {
             tweet = createTweet(postText);
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        return tweet;
    }

    @Override
    protected void onPostExecute(String tweet) {
        super.onPostExecute(tweet);
        Log.i(TAG,tweet);
        Toast toast = Toast.makeText(context,"Posted to Twitter",Toast.LENGTH_SHORT);
        toast.show();
    }
    public String createTweet(String tweet) throws TwitterException {
        twitter4j.Status status = twitter.updateStatus(tweet);
        return status.getText();
    }
}


