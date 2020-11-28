package gr.uom.socialmediaaggregetor;

import android.os.AsyncTask;

public class GetSelectedTweetTask extends AsyncTask<Void,Void,String> {

    public static String TWITTER_ENDPOINT = "https://api.twitter.com/2/tweets/search/recent?query=";
    public static final String BEARER_TOKEN = "Bearer AAAAAAAAAAAAAAAAAAAAACy5JgEAAAAA18e%2FheRtBV9sNNifThQf5vBv11M%3De3Zib0YbJWkUkZjMqSiRR5Us1GpJEXht6PNpnxATaFQrI9oFfL";


    public GetSelectedTweetTask(String queryParameter){
        TWITTER_ENDPOINT = TWITTER_ENDPOINT + queryParameter;
    }
    @Override
    protected String doInBackground(Void... voids) {

        return null;
    }
}
