package com.example.mybooklibrary.Controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import com.example.mybooklibrary.R;
import com.example.mybooklibrary.databinding.ActivityMainBinding;
import com.example.mybooklibrary.model.Utils;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAllBooks.setOnClickListener(new View.OnClickListener() {
            //taking to all books page
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
            }
        });
        binding.btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, AlreadyReadBooksActivity.class);
                startActivity(intent);
            }
        });
        binding.btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, WantToReadActivity.class);
                startActivity(intent);
            }
        });
        binding.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, FavoriteActivity.class);
                startActivity(intent);
            }
        });
        binding.btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, CurrentlyReadingBookActivity.class);
                startActivity(intent);
            }
        });

        binding.btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("Designed and Developed with Love by Chisthia Khan From BRAC University\n"+
                        "Check my page for more awesome applications");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      Intent intent= new Intent(MainActivity.this, website.class);
                      startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });
        Utils.getInstance();

    }

}