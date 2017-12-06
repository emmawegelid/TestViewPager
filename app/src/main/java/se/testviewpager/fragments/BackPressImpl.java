package se.testviewpager.fragments;

import android.app.Fragment;

import se.testviewpager.OnBackPressedListener;

public class BackPressImpl implements OnBackPressedListener {

    private Fragment parentRootFragment;

    public BackPressImpl(Fragment parentRootFragment) {
        this.parentRootFragment = parentRootFragment;
    }

    @Override
    public boolean onBackPressed() {

        if (parentRootFragment == null) return false;

        int childCount = parentRootFragment.getChildFragmentManager().getBackStackEntryCount();

        if (childCount == 0) {
            return false;

        } else {
            parentRootFragment.getChildFragmentManager().popBackStackImmediate();

            return true;
        }
    }
}
