package io.maritimus.sofaexpert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import io.maritimus.sofaexpert.model.Movie;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        GridView gridview = (GridView) view.findViewById(R.id.grid_view);

        if (gridview == null) {
            return view;
        }


        gridview.setAdapter(new ImageAdapter(getActivity()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v,
                                    int position,
                                    long id) {

                ImageAdapter adapter = (ImageAdapter) parent.getAdapter();
                Movie movie = adapter.getItem(position);

                if (movie == null) {
                    return;
                }

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(Movie.EXTRA_MOVIE, movie.toBundle());
                getActivity().startActivity(intent);
            }
        });

        return view;
    }

}

