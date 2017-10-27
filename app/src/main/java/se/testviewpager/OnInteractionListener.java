package se.testviewpager;

import android.app.FragmentManager;

/**
 * Horseflow
 * Created by Emma Wegelid on 2017-10-25.
 *
 * Copyright (c) 2017 Frost°. All rights reserved.
 */
public interface OnInteractionListener {

    void openSearch(FragmentManager fragmentManager);
    void openSettings(FragmentManager fragmentManager);
}
