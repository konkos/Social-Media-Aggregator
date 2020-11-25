package gr.uom.socialmediaaggregetor;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class GetTrendingHashTagsTask extends AsyncTask<Void,Void,String> {

    public static final String TAG = "THisIsAtag";
    private static final String TWITTER_ENDPOINT = "https://api.twitter.com/1.1/trends/place.json?id=1"; //"https://jsonplaceholder.typicode.com/todos/1";
    public static final String BEARER_TOKEN = "Bearer AAAAAAAAAAAAAAAAAAAAACy5JgEAAAAA18e%2FheRtBV9sNNifThQf5vBv11M%3De3Zib0YbJWkUkZjMqSiRR5Us1GpJEXht6PNpnxATaFQrI9oFfL";
    private StringBuilder sb;

    public GetTrendingHashTagsTask(){
        sb = new StringBuilder();
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
        try {
            response = call.execute();
            ResponseBody body = response.body();
            String string = body.string();
            Log.i(TAG,string);
            sb.append(string);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();//https://github.com/dferreira-cvl/howto-okhttp-android/blob/master/app/src/main/java/com/codavel/howto_okhttp/MainActivity.java
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        
    }
}
