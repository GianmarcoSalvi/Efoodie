package com.example.efoodie.receta;

import static com.example.efoodie.R.layout.fragment_receta;

import android.os.Bundle;

import com.example.efoodie.R;
import com.example.efoodie.receta.fragments.RecetaFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.efoodie.receta.SectionsPagerAdapter;
import com.example.efoodie.databinding.ActivityRecetaBinding;

public class RecetaActivity extends AppCompatActivity {

    private ActivityRecetaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityRecetaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }
}