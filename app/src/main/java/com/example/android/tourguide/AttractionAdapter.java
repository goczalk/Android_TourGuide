package com.example.android.tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by klaudia on 29/07/18.
 */

class AttractionAdapter extends ArrayAdapter<Attraction> {
    private int mColorResourceId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param attractions A List of Word objects to display in a list
     */
    public AttractionAdapter(Activity context, ArrayList<Attraction> attractions, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, attractions);
        this.mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.attraction_list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final Attraction currentAttraction = getItem(position);

        TextView nameTextView = (TextView) convertView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentAttraction.getName());

        TextView hoursDateTextView = (TextView) convertView.findViewById(R.id.opening_hours_or_date_text_view);
        hoursDateTextView.setText(currentAttraction.getOpeningHoursOrDate());


        TextView locationTextView = (TextView) convertView.findViewById(R.id.location_text_view);
        locationTextView.setText(currentAttraction.getLocation());

        ImageView imageView = (ImageView) convertView.findViewById(R.id.attraction_image);
        if(currentAttraction.hasImage()){
            imageView.setImageResource(currentAttraction.getImageResourceId());
        }
        else{
            imageView.setVisibility(View.GONE);
        }

        View textContainer = convertView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return convertView;
    }
}
