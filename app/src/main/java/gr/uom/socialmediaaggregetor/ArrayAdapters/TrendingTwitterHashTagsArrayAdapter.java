package gr.uom.socialmediaaggregetor.ArrayAdapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import gr.uom.socialmediaaggregetor.Models.Hashtag;
import gr.uom.socialmediaaggregetor.R;
import gr.uom.socialmediaaggregetor.postsFromAll3SocialMedia;


public class TrendingTwitterHashTagsArrayAdapter extends ArrayAdapter<Hashtag> {

    private static int counter = 0;

    private List<Hashtag> hashtagList;
    private final LayoutInflater inflater;
    private final int layoutResource;

    private ListView trendingTweetsListView;


    public TrendingTwitterHashTagsArrayAdapter(@NonNull Context context, int resource, @NonNull List<Hashtag> objects, ListView listView) {
        super(context, resource, objects);
        hashtagList = objects;
        layoutResource = resource;
        inflater = LayoutInflater.from(context);
        trendingTweetsListView = listView;

        trendingTweetsListView.setOnItemClickListener((parent, view, position, id) -> {
            Hashtag hashtag = hashtagList.get(position);
            Intent intent = new Intent(context, postsFromAll3SocialMedia.class);
            intent.putExtra("position",position);
            intent.putExtra("selectedHashtag",hashtag);
            context.startActivity(intent);
        });
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        counter++;
        Log.d("ADAPTER", "get view in adapter just called. counter = "+counter);
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = inflater.inflate(layoutResource, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
            Log.w("VIEW_HOLDER", "View Holder Created");
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Hashtag currentHashTag = hashtagList.get(position);

        viewHolder.trendingTweetTextView.setText(currentHashTag.getName()+"");

        return convertView;
    }

    private class ViewHolder{
        final TextView trendingTweetTextView;

        ViewHolder(View view){
            trendingTweetTextView = view.findViewById(R.id.trendingTweetTextView);
        }
    }

    @Override
    public int getCount() {
        return hashtagList.size();
    }


    public void setHashtagList(List<Hashtag> hashtagList) {
        this.hashtagList = hashtagList;
        trendingTweetsListView.setAdapter(this);
    }


}