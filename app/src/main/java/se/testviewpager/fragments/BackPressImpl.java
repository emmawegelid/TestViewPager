package se.testviewpager.fragments;

import android.app.Fragment;
import android.app.FragmentManager;

import se.testviewpager.OnBackPressedListener;

public class BackPressImpl implements OnBackPressedListener {

    private Fragment parentRootFragment;
    private int rootFrameRes;
    private String firstFragmentTag;

    public BackPressImpl(Fragment parentRootFragment, String firstFragmentTag, int rootFrameRes) {
        this.parentRootFragment = parentRootFragment;
        this.rootFrameRes = rootFrameRes;
        this.firstFragmentTag = firstFragmentTag;
    }

    @Override
    public boolean onBackPressed() {

        if (parentRootFragment == null) return false;

        /*Fragment firstFragment = parentRootFragment.getFragmentManager().findFragmentByTag(firstFragmentTag);

        Fragment visibleFragment = parentRootFragment.getFragmentManager().findFragmentById(rootFrameRes);

        if (visibleFragment == null || visibleFragment.equals(firstFragment)) {
            return false;
        } else {
            if (visibleFragment instanceof OnBackPressedListener) {

                OnBackPressedListener childFragment = (OnBackPressedListener) visibleFragment;

                if (!childFragment.onBackPressed()) {
                    parentRootFragment.getFragmentManager().popBackStackImmediate();
                }

                return true;
            } else {
                parentRootFragment.getFragmentManager().popBackStackImmediate();
                return true;
            }
        }*/

        int childCount = parentRootFragment.getChildFragmentManager().getBackStackEntryCount();

        if (childCount == 0) {
            // it has no child Fragment
            // can not handle the onBackPressed task by itself
            return false;

        } else {
            // get the child Fragment
            parentRootFragment.getChildFragmentManager().popBackStackImmediate();

            /*childFragmentManager.getFragments().get(0);

            Fragment fragmentById = childFragmentManager.findFragmentById(rootFrameRes);

            if (fragmentById instanceof OnBackPressedListener) {
                OnBackPressedListener childFragment = (OnBackPressedListener) fragmentById;
                // propagate onBackPressed method call to the child Fragment
                if (!childFragment.onBackPressed()) {
                    // child Fragment was unable to handle the task
                    // It could happen when the child Fragment is last last leaf of a chain
                    // removing the child Fragment from stack
                    childFragmentManager.popBackStackImmediate();

                }
            } else {
                childFragmentManager.popBackStackImmediate();
            }*/

            // either this Fragment or its child handled the task
            // either way we are successful and done here
            return true;
        }

        /*Fragment fragmentById = parentRootFragment.getFragmentManager().findFragmentById(rootFrameRes);

        if (fragmentById == null || fragmentById.equals(parentRootFragment)) {
            return false;
        } else {
            if (fragmentById instanceof OnBackPressedListener) {

                OnBackPressedListener childFragment = (OnBackPressedListener) fragmentById;

                if (!childFragment.onBackPressed()) {
                    parentRootFragment.getFragmentManager().popBackStackImmediate();
                }

                return true;
            } else {
                parentRootFragment.getFragmentManager().popBackStackImmediate();
                return true;
            }
        }*/
    }
}
