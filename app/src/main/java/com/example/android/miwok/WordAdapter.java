package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by neo on 31/12/2017.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    /* Resourtce ID for the background color */
    private int mColorResouceId;

    /* constructor */
    public WordAdapter(Context context, ArrayList<Word> pWords, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, pWords);
        mColorResouceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwoki());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefault());

        ImageView defaultImageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            defaultImageView.setImageResource(currentWord.getWordImage());
        } else {
            defaultImageView.setVisibility(View.GONE);
        }

        /* set color for text container */
        Log.v("color: ", String.valueOf(mColorResouceId));

        View textContainer = (View) listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResouceId);
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
