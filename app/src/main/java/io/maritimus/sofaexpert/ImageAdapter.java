package io.maritimus.sofaexpert;


import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;

import io.maritimus.sofaexpert.model.Movie;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private final ArrayList<Movie> mMovies;
    private final int mHeight;
    private final int mWidth;

    public ImageAdapter(Context c) {
        mContext = c;
        mMovies = new ArrayList<>();
        mHeight = Math.round(mContext.getResources().getDimension(R.dimen.poster_height));
        mWidth = Math.round(mContext.getResources().getDimension(R.dimen.poster_width));
    }

    public void addAll(Collection<Movie> xs) {
        mMovies.addAll(xs);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Movie getItem(int position) {
        if (position < 0 || position >= mMovies.size()) {
            return null;
        }
        return mMovies.get(position);
    }

    @Override
    public long getItemId(int position) {
        Movie movie = getItem(position);
        if (movie == null) {
            return -1L;
        }

        return movie.id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);
        if (movie == null) {
            return null;
        }

        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(mWidth, mHeight));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView = (ImageView) convertView;
        }

        Uri coverUri = movie.buildCoverUri(mContext.getString(R.string.cover_default_size));
        Picasso.with(mContext)
                .load(coverUri)
                .placeholder(R.drawable.cover_loading_w185)
                .into(imageView);

        return imageView;
    }
}