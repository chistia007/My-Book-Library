package com.example.mybooklibrary.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mybooklibrary.R;
import com.example.mybooklibrary.databinding.ActivityAboutBinding;
import com.example.mybooklibrary.databinding.ActivityMainBinding;

public class AboutActivity extends AppCompatActivity {
    ActivityAboutBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}