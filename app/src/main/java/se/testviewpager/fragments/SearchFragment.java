package se.testviewpager.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import se.testviewpager.R;

/**
 * Horseflow
 * Created by Emma Wegelid on 2017-10-25.
 *
 * Copyright (c) 2017 Frost°. All rights reserved.
 */
public class SearchFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

}
