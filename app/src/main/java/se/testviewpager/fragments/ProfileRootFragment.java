package se.testviewpager.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import se.testviewpager.OnBackPressedListener;
import se.testviewpager.R;

public class ProfileRootFragment extends Fragment implements OnBackPressedListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile_root, container, false);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.profile_root_frame, new ProfileFragment(), ProfileFragment.TAG)
                .commit();

        return view;
    }

    @Override
    public boolean onBackPressed() {
        return new BackPressImpl(this, ProfileFragment.TAG, R.id.profile_root_frame).onBackPressed();
    }
}
