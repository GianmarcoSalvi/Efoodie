package com.example.efoodie.receta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.efoodie.databinding.FragmentRecetaBinding;
import com.example.efoodie.receta.fragments.IngredientesFragment;
import com.example.efoodie.receta.fragments.RecetaFragment;
import com.example.efoodie.receta.fragments.ValoracionesFragment;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private FragmentRecetaBinding binding;

    public static Fragment newInstance(int index) {
        Fragment fragment = null;
        switch (index){
            case 1: fragment = new RecetaFragment(); break;
            case 2: fragment = new IngredientesFragment(); break;
            case 3: fragment = new ValoracionesFragment(); break;
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentRecetaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}