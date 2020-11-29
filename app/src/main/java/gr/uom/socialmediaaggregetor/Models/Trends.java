package gr.uom.socialmediaaggregetor.Models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class Trends {
   @SerializedName("trends") private Hashtag[] hashtags;

    public Trends(Hashtag[] hashtags) {
        this.hashtags = hashtags;
    }

    public Hashtag[] getHashtags() {
        return hashtags;
    }

    public void setHashtags(Hashtag[] hashtags) {
        this.hashtags = hashtags;
    }

    @Override
    public String toString() {
        return "Trends{" +
                "hashtags=" + Arrays.toString(hashtags) +
                '}';
    }
}
