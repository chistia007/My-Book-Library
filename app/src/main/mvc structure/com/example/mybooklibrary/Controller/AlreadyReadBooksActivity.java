package com.example.mybooklibrary.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.mybooklibrary.Controller.BookRecViewAdapter;
import com.example.mybooklibrary.Controller.MainActivity;
import com.example.mybooklibrary.R;
import com.example.mybooklibrary.model.Utils;

public class AlreadyReadBooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read_books);

        RecyclerView recyclerView=findViewById(R.id.booksRecView);
        BookRecViewAdapter adapter=new BookRecViewAdapter(this,"alreadyRead");
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Sending books for already read
        adapter.setBooks(Utils.getAlreadyReadBook());

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}