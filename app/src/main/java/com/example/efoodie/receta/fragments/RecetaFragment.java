package com.example.efoodie.receta.fragments;

import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.efoodie.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RecetaFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_receta, container, false);

        // register the floating action Button
        final ExtendedFloatingActionButton FloatingActionButton = view.findViewById(R.id.floating_btn);

        // register the nestedScrollView from the main layout
        NestedScrollView nestedScrollView = view.findViewById(R.id.nested_scrollview_receta);

        // handle the nestedScrollView behaviour with OnScrollChangeListener
        // to hide or show the Floating Action Button
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                // the delay of the extension of the FAB is set for 12 items
                if (scrollY > oldScrollY + 12 && FloatingActionButton.isShown()) {
                    FloatingActionButton.hide();
                }

                // the delay of the extension of the FAB is set for 12 items
                if (scrollY < oldScrollY - 12 && !FloatingActionButton.isShown()) {
                    FloatingActionButton.show();
                }

                // if the nestedScrollView is at the first item of the list then the
                // floating action should be in show state
                if (scrollY == 0) {
                    FloatingActionButton.show();
                }
            }
        });



        return view;
    }

}