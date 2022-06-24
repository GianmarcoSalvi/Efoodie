package com.example.efoodie.ui.explore;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.efoodie.MainActivity;
import com.example.efoodie.R;
import com.example.efoodie.databinding.FragmentExploreBinding;

import java.lang.reflect.Array;

public class ExploreFragment extends Fragment {

    private FragmentExploreBinding binding;
    ArrayAdapter arrayAdapter;
    AutoCompleteTextView autoCompleteTextView;
    Spinner spinnerTextSize;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentExploreBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Setup listener over filters button in the search bar
        RelativeLayout filters_btn = (RelativeLayout) root.findViewById(R.id.filter_button);
        filters_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), FiltersActivity.class);
                getActivity().startActivity(intent);
            }
        });

        // Setup sorting (ordenar por)
        String[] dropdown_menu_items = getResources().getStringArray(R.array.sort_array);
        autoCompleteTextView = root.findViewById(R.id.autoCompleteTextView);
        arrayAdapter = new ArrayAdapter(requireContext(),R.layout.dropdown_item, dropdown_menu_items);
        binding.autoCompleteTextView.setAdapter(arrayAdapter);

        binding.autoCompleteTextView.setDropDownBackgroundDrawable(
                ResourcesCompat.getDrawable(
                        getResources(),
                        R.drawable.filter_spinner_bg,
                        null
                )
        );


        // TODO - Setup listener for sorting (backend)
        /* autoCompleteTextView.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick()
        } */


        return root;

    }



}


