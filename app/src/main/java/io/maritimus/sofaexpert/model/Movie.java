package io.maritimus.sofaexpert.model;

import android.net.Uri;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

public class Movie {
    public static final String EXTRA_MOVIE = "io.maritimus.sofaexpert.EXTRA_MOVIE";
    public static final String KEY_ID = "id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_OVERVIEW = "overview";
    public static final String KEY_POSTER_PATH = "poster_path";
    public static final String KEY_VOTE_AVERAGE = "vote_average";
    public static final String KEY_VOTE_COUNT = "vote_count";

    public final long id;
    public final String title;
    public final String overview;
    public final String poster_path;
    public final double vote_average;
    public final long vote_count;

    public Movie(long id,
                 String title, String overview, String poster_path,
                 double vote_average, long vote_count) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public Movie(Bundle bundle) {
        this(
                bundle.getLong(KEY_ID),
                bundle.getString(KEY_TITLE),
                bundle.getString(KEY_OVERVIEW),
                bundle.getString(KEY_POSTER_PATH),
                bundle.getDouble(KEY_VOTE_AVERAGE),
                bundle.getLong(KEY_VOTE_COUNT)
        );
    }

    public String getRating() {
        return "" + vote_average + " / 10 (" + vote_count + ")";
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();

        bundle.putLong(KEY_ID, id);
        bundle.putString(KEY_TITLE, title);
        bundle.putString(KEY_OVERVIEW, overview);
        bundle.putString(KEY_POSTER_PATH, poster_path);
        bundle.putDouble(KEY_VOTE_AVERAGE, vote_average);
        bundle.putLong(KEY_VOTE_COUNT, vote_count);

        return bundle;
    }


    public static Movie fromJson(JSONObject jsonObject) throws JSONException {
        return new Movie(
                jsonObject.getLong(KEY_ID),
                jsonObject.getString(KEY_TITLE),
                jsonObject.getString(KEY_OVERVIEW),
                jsonObject.getString(KEY_POSTER_PATH),
                jsonObject.getDouble(KEY_VOTE_AVERAGE),
                jsonObject.getLong(KEY_VOTE_COUNT)
        );
    }

    public Uri buildCoverUri(String size) {
        final String BASE_URL = "http://image.tmdb.org/t/p/";

        Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                .appendPath(size)
                .appendEncodedPath(poster_path)
                .build();

        return builtUri;
    }
}