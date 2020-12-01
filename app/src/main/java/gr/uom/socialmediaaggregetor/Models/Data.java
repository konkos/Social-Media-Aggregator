package gr.uom.socialmediaaggregetor.Models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

//Helper Class For GetListSelectedTweetTask
//Wrapper for GSON
public class Data {
    @SerializedName("data")
    private SelectedTrendingTweet[] selectedTrendingTweets;

    public Data(SelectedTrendingTweet[] selectedTrendingTweets) {
        this.selectedTrendingTweets = selectedTrendingTweets;
    }

    public SelectedTrendingTweet[] getSelectedTrendingTweets() {
        return selectedTrendingTweets;
    }

    public void setSelectedTrendingTweets(SelectedTrendingTweet[] selectedTrendingTweets) {
        this.selectedTrendingTweets = selectedTrendingTweets;
    }

    @Override
    public String toString() {
        return "Data{" +
                "selectedTrendingTweets=" + Arrays.toString(selectedTrendingTweets) +
                '}';
    }
}
