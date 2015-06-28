package io.maritimus.sofaexpert;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

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

        mMovies.add(new Movie(
                        100500L,
                        "Best movie ever",
                        "lorm ipsum one yuntz foo bar lorm ipsum one yuntz foo bar lorm ipsum one yuntz foo bar lorm ipsum one yuntz foo bar lorm ipsum one yuntz foo bar lorm ipsum one yuntz foo bar lorm ipsum one yuntz foo bar 1000 2000 3000 4000 5000 6000 7000 8000 9000",
                        "/some.part.or.url.jpg",
                        8.5,
                        1234
                )
        );

        mMovies.add(new Movie(
                        100501L,
                        "Test me movie",
                        "lorm ipsum one yuntz foo bar lorm ipsum one yuntz foo bar lorm ipsum one yuntz foo bar lorm ipsum one yuntz foo bar lorm ipsum one yuntz foo bar lorm ipsum one yuntz foo bar lorm ipsum one yuntz foo bar 1000 2000 3000 4000 5000 6000 7000 8000 9000",
                        "/some.part.or.url.jpg",
                        4,
                        123
                )
        );
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

        imageView.setImageResource(R.drawable.sample_1);

        return imageView;
    }
}