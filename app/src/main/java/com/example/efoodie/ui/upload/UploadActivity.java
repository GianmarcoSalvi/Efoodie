package com.example.efoodie.ui.upload;

import static com.example.efoodie.R.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.efoodie.R;



public class UploadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_upload);

        // in order to replace back button with X button
        getSupportActionBar().setHomeAsUpIndicator(drawable.ic_close);

    }


}