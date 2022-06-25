package com.example.efoodie.ui.explore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.efoodie.receta.AdapterReceta;
import com.example.efoodie.ItemOffsetDecoration;
import com.example.efoodie.R;
import com.example.efoodie.receta.RecetaActivity;
import com.example.efoodie.receta.RecetaCard;
import com.example.efoodie.databinding.FragmentExploreBinding;

import java.util.ArrayList;

public class ExploreFragment extends Fragment {

    private FragmentExploreBinding binding;
    ArrayAdapter arrayAdapter;
    AutoCompleteTextView autoCompleteTextView;
    ArrayList<RecetaCard> lista_recetas;
    RecyclerView recyclerView;

    @SuppressLint("ClickableViewAccessibility")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentExploreBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Setup listener over filters button in the search bar
        RelativeLayout filters_btn = (RelativeLayout) root.findViewById(R.id.filter_button);
        filters_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FiltersActivity.class);
                getActivity().startActivity(intent);
            }
        });

        // Setup sorting (ordenar por)
        String[] dropdown_menu_items = getResources().getStringArray(R.array.sort_array);
        autoCompleteTextView = root.findViewById(R.id.autoCompleteTextView);
        arrayAdapter = new ArrayAdapter(requireContext(), R.layout.dropdown_item, dropdown_menu_items);
        autoCompleteTextView.setAdapter(arrayAdapter);



        autoCompleteTextView.setDropDownBackgroundDrawable(
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

        // **********************
        // RECYCLER VIEW PART - Scrolling part
        // **********************

        lista_recetas = new ArrayList<>();
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getContext(), R.dimen.item_offset);
        recyclerView.addItemDecoration(itemDecoration);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        llenarRecetas();

        AdapterReceta adapterReceta = new AdapterReceta(lista_recetas);

        adapterReceta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // IMPLEMENT HERE OPENING NEW ACTIVITY BY CLICKING A RECETA
                Intent intent = new Intent(getActivity(), RecetaActivity.class);
                intent.putExtra("Receta title", R.id.nombre_receta);
                getActivity().startActivity(intent);
            }
        });


        recyclerView.setAdapter(adapterReceta);
        recyclerView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                return false;
            }
        });


        return root;

    }


    private void llenarRecetas() {
        // user_icon, chef_name, favorite_btn, foto_receta, nombre_receta, clock_icon,
        // time, flatware_icon, para_cuantos, chef_icon, dificultad, ratingbar
        lista_recetas.add(new RecetaCard(R.drawable.ic_user, "Julian_sanchez", false, R.drawable.image_receta,
                "Pizza vegana", R.drawable.ic_clock, "1.40h", R.drawable.ic_flatware, "Para 4", R.drawable.ic_chef,
                "Intermedio", 4.5f));
        lista_recetas.add(new RecetaCard(R.drawable.ic_user, "Julian_sanchez", true, R.drawable.image_receta,
                "Pizza vegana", R.drawable.ic_clock, "1.40h", R.drawable.ic_flatware, "Para 4", R.drawable.ic_chef,
                "Intermedio", 4.5f));
        lista_recetas.add(new RecetaCard(R.drawable.ic_user, "Julian_sanchez", false, R.drawable.image_receta,
                "Pizza vegana", R.drawable.ic_clock, "1.40h", R.drawable.ic_flatware, "Para 4", R.drawable.ic_chef,
                "Intermedio", 4.5f));
        lista_recetas.add(new RecetaCard(R.drawable.ic_user, "Julian_sanchez", false, R.drawable.image_receta,
                "Pizza vegana", R.drawable.ic_clock, "1.40h", R.drawable.ic_flatware, "Para 4", R.drawable.ic_chef,
                "Intermedio", 4.5f));
        lista_recetas.add(new RecetaCard(R.drawable.ic_user, "Julian_sanchez", false, R.drawable.image_receta,
                "Pizza vegana", R.drawable.ic_clock, "1.40h", R.drawable.ic_flatware, "Para 4", R.drawable.ic_chef,
                "Intermedio", 4.5f));
        lista_recetas.add(new RecetaCard(R.drawable.ic_user, "Julian_sanchez", false, R.drawable.image_receta,
                "Pizza vegana", R.drawable.ic_clock, "1.40h", R.drawable.ic_flatware, "Para 4", R.drawable.ic_chef,
                "Intermedio", 4.5f));
        lista_recetas.add(new RecetaCard(R.drawable.ic_user, "Julian_sanchez", false, R.drawable.image_receta,
                "Pizza vegana", R.drawable.ic_clock, "1.40h", R.drawable.ic_flatware, "Para 4", R.drawable.ic_chef,
                "Intermedio", 4.5f));
        lista_recetas.add(new RecetaCard(R.drawable.ic_user, "Julian_sanchez", true, R.drawable.image_receta,
                "Pizza vegana", R.drawable.ic_clock, "1.40h", R.drawable.ic_flatware, "Para 4", R.drawable.ic_chef,
                "Intermedio", 4.5f));
        lista_recetas.add(new RecetaCard(R.drawable.ic_user, "Julian_sanchez", false, R.drawable.image_receta,
                "Pizza vegana", R.drawable.ic_clock, "1.40h", R.drawable.ic_flatware, "Para 4", R.drawable.ic_chef,
                "Intermedio", 4.5f));
        lista_recetas.add(new RecetaCard(R.drawable.ic_user, "Julian_sanchez", false, R.drawable.image_receta,
                "Pizza vegana", R.drawable.ic_clock, "1.40h", R.drawable.ic_flatware, "Para 4", R.drawable.ic_chef,
                "Intermedio", 4.5f));
        lista_recetas.add(new RecetaCard(R.drawable.ic_user, "Julian_sanchez", false, R.drawable.image_receta,
                "Pizza vegana", R.drawable.ic_clock, "1.40h", R.drawable.ic_flatware, "Para 4", R.drawable.ic_chef,
                "Intermedio", 4.5f));
        lista_recetas.add(new RecetaCard(R.drawable.ic_user, "Julian_sanchez", false, R.drawable.image_receta,
                "Pizza vegana", R.drawable.ic_clock, "1.40h", R.drawable.ic_flatware, "Para 4", R.drawable.ic_chef,
                "Intermedio", 4.5f));
        lista_recetas.add(new RecetaCard(R.drawable.ic_user, "Julian_sanchez", false, R.drawable.image_receta,
                "Pizza vegana", R.drawable.ic_clock, "1.40h", R.drawable.ic_flatware, "Para 4", R.drawable.ic_chef,
                "Intermedio", 4.5f));
        lista_recetas.add(new RecetaCard(R.drawable.ic_user, "Julian_sanchez", false, R.drawable.image_receta,
                "Pizza vegana", R.drawable.ic_clock, "1.40h", R.drawable.ic_flatware, "Para 4", R.drawable.ic_chef,
                "Intermedio", 4.5f));

    }


}


