package gr.uom.socialmediaaggregetor.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import gr.uom.socialmediaaggregetor.KEYS.KeysStorage;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class GetListSelectedTweetTask extends AsyncTask<Void,Void,String> {

    public static final String TAG = "GetSelectedTweetTaskLogger";
    public static String TWITTER_ENDPOINT = "https://api.twitter.com/2/tweets/search/recent?query=";
    public static final String BEARER_TOKEN = KeysStorage.TWITTER_BEARER_TOKEN;


    public GetListSelectedTweetTask(String queryParameter){
        TWITTER_ENDPOINT = TWITTER_ENDPOINT + queryParameter;
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

        return bodyJSON;
    }

    @Override
    protected void onPostExecute(String jsonString) {
        super.onPostExecute(jsonString);
        Log.i("POSTEXECUTEGETSELECTEDTWEETTASK",jsonString);

        Gson gson = new Gson();
        //Use GetTrendingHashTagsTask::parseJsonToHashTagArray
        String[] split = jsonString.split(",");
        for (String s : split) {
            Log.v("POSTEXECUTEGETSELECTEDTWEETTASKARRAY",s);
        }
    }

}
