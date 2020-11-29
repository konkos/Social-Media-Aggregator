package gr.uom.socialmediaaggregetor.Models;

import com.google.gson.annotations.SerializedName;

public class SelectedTrendingTweet {
    @SerializedName("id") private String id;
    @SerializedName("text")private String text;

    public SelectedTrendingTweet(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "SelectedTrendingTweet{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
