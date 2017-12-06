package se.testviewpager.fragments;

import android.app.Fragment;

import timber.log.Timber;

/**
 * TestViewPager
 * Created by Sergii Nezdolii on 2017-12-06.
 * <p>
 * Copyright (c) 2017 Frost°. All rights reserved.
 */
public class BaseRootFragment extends Fragment {

	private boolean isMenuVisible;

	@Override
	public void setMenuVisibility(boolean menuVisible) {
		Timber.d("1337: Root - " + menuVisible);
		super.setMenuVisibility(menuVisible);
		isMenuVisible = menuVisible;
	}

	public boolean isMenuVisible() {
		return isMenuVisible;
	}
}
