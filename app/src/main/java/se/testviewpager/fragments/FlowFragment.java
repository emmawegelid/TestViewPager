package se.testviewpager.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import se.testviewpager.OnInteractionListener;
import se.testviewpager.R;

public class FlowFragment extends Fragment {

    private OnInteractionListener listener;

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

}
