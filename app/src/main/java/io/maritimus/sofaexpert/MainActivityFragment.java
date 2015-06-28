package io.maritimus.sofaexpert;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


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
            Log.d("MYLOG", "gridview is null");
        } else {
            Log.d("MYLOG", "gridview is NOT null");
        }

        gridview.setAdapter(new ImageAdapter(getActivity()));

        return view;
    }

}

