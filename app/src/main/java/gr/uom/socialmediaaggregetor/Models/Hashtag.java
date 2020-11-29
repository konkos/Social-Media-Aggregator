package gr.uom.socialmediaaggregetor.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Hashtag implements Serializable {
    @SerializedName("name") private String name;
    @SerializedName("url") private String url;
    @SerializedName("tweet_volume") private long tweet_volume;
    @SerializedName("query") private String query;

    public Hashtag(String name, String url, long tweet_volume,String query) {
        this.name = name;
        this.url = url;
        this.tweet_volume = tweet_volume;
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getTweet_volume() {
        return tweet_volume;
    }

    public void setTweet_volume(long tweet_volume) {
        this.tweet_volume = tweet_volume;
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", tweet_volume=" + tweet_volume +
                '}';
    }
}
