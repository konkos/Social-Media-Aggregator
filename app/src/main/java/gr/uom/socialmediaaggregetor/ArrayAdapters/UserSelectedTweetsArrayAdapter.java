package gr.uom.socialmediaaggregetor.ArrayAdapters;


import android.content.Context;
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

import gr.uom.socialmediaaggregetor.Models.SelectedTrendingTweet;
import gr.uom.socialmediaaggregetor.R;

public class UserSelectedTweetsArrayAdapter extends ArrayAdapter<SelectedTrendingTweet> {
    private static int counter = 0;

    private List<SelectedTrendingTweet> userSelectedTweetList;
    private final LayoutInflater inflater;
    private final int layoutResource;
    private ListView userSelectedTweetsListView;

    public UserSelectedTweetsArrayAdapter(@NonNull Context context, int resource, @NonNull List<SelectedTrendingTweet> objects, ListView listView) {
        super(context, resource, objects);
        userSelectedTweetList = objects;
        layoutResource = resource;
        inflater = LayoutInflater.from(context);
        userSelectedTweetsListView = listView;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        counter++;
        Log.d("UserSelectedTweetsArrayAdapter", "get view in adapter just called. counter = "+counter);
        UserSelectedTweetsArrayAdapter.ViewHolder viewHolder;
        Log.i("UserSelectedTweetsArrayAdapter","getView()");

        if(convertView == null){
            convertView = inflater.inflate(layoutResource, parent, false);
            viewHolder = new UserSelectedTweetsArrayAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);
            Log.w("VIEW_HOLDER", "View Holder Created");
        }
        else {
            viewHolder = (UserSelectedTweetsArrayAdapter.ViewHolder) convertView.getTag();
        }
        SelectedTrendingTweet currentUserSelectedTweet = userSelectedTweetList.get(position);

        viewHolder.userSelectedTextView.setText(currentUserSelectedTweet.getText()+"");

        return convertView;
    }

    private class ViewHolder{
        final TextView userSelectedTextView;

        ViewHolder(View view){
            userSelectedTextView = view.findViewById(R.id.userSelectedTextView);
        }
    }
    @Override
    public int getCount() {
        return userSelectedTweetList.size();
    }
    public void setUserSelectedTweetsList(List<SelectedTrendingTweet> userSelectedTweetList) {
        this.userSelectedTweetList = userSelectedTweetList;
        userSelectedTweetsListView.setAdapter(this);
    }

}
