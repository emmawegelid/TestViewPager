package se.testviewpager.fragments;

import android.app.Fragment;

import timber.log.Timber;

/**
 * TestViewPager
 * Created by Sergii Nezdolii on 2017-12-06.
 * <p>
 * Copyright (c) 2017 Frost°. All rights reserved.
 */
public class BaseNestedFragment extends Fragment {

	protected boolean isMenuVisible() {
		Fragment parentFragment = getParentFragment();
		if (parentFragment instanceof BaseRootFragment) {
			return ((BaseRootFragment) parentFragment).isMenuVisible();
		}
		return false;
	}

	@Override
	public void setMenuVisibility(boolean menuVisible) {
		Timber.d("1337: Nested - " + menuVisible);
		super.setMenuVisibility(menuVisible);
	}

}
