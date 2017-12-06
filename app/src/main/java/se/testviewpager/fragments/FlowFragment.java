package se.testviewpager.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import se.testviewpager.OnInteractionListener;
import se.testviewpager.R;
import timber.log.Timber;

public class FlowFragment extends Fragment {

    public static final String TAG = FlowFragment.class.getSimpleName();

    private OnInteractionListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flow, container, false);

        Button button = view.findViewById(R.id.openSearchButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.openSearch(getFragmentManager());
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnInteractionListener) {
            listener = (OnInteractionListener) context;
        } else {
            throw new ClassCastException("Should implement " + OnInteractionListener.class.getSimpleName());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (!isMenuVisible()) {
            return;
        }
        inflater.inflate(R.menu.menu_flow, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        Timber.d("1337: " + menuVisible);
    }

    private boolean isMenuVisible() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof FlowRootFragment) {
            return ((FlowRootFragment) parentFragment).isMenuVisible();
        }
        return false;
    }

}
