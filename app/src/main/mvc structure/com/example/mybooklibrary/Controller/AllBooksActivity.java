package com.example.mybooklibrary.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.example.mybooklibrary.R;
import com.example.mybooklibrary.model.Utils;

public class AllBooksActivity extends AppCompatActivity {
    private RecyclerView booksRecView;
    private BookRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        adapter =new BookRecViewAdapter(this,"allBooks");
        booksRecView =findViewById(R.id.booksRecView);


        adapter.setBooks(Utils.getInstance().getAllBooks());

        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new LinearLayoutManager(this));
    }
}