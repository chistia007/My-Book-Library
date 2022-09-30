package com.example.mybooklibrary.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mybooklibrary.R;

import com.example.mybooklibrary.databinding.ActivityBookBinding;
import com.example.mybooklibrary.model.Utils;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    ActivityBookBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
// Receiving the intent with id
        Intent intent=getIntent();
        if (null!=intent){
            int bookID= intent.getIntExtra("bookId", -1);
            if (bookID!=-1){
                Book incomingBook= Utils.getInstance().getBookById(bookID);
                if(null!=incomingBook){
                    setData(incomingBook);

                    handleAlreadyRead(incomingBook);
                    handleWantToReadBooks(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                    handleFavoriteBooks(incomingBook);
                }
            }
        }


    }

    private void handleCurrentlyReadingBooks(final Book book){
        ArrayList<Book> currentlyReadingBooks= Utils.getInstance().getCurrentlyReadingBooks();
        boolean existInCurrentlyReadingBooks=false;
        for (Book b: currentlyReadingBooks){
            if (b.getId() == book.getId()) {
                existInCurrentlyReadingBooks = true;
                break;
            }
        }
        if (existInCurrentlyReadingBooks){
            binding.btnAddToCurrentlyReading.setEnabled(false);
        }
        else{
            binding.btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance().addToCurrentlyReadingBooks(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(BookActivity.this, CurrentlyReadingBookActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleFavoriteBooks(final Book book){
        ArrayList<Book> favoriteBooks= Utils.getInstance().getFavoriteBooks();
        boolean existInFavoriteBooks=false;
        for (Book b: favoriteBooks){
            if (b.getId() == book.getId()) {
                existInFavoriteBooks = true;
                break;
            }
        }
        if (existInFavoriteBooks){
            binding.btnAddingToFavBooks.setEnabled(false);
        }
        else{
            binding.btnAddingToFavBooks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance().addToFavorite(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(BookActivity.this, FavoriteActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantToReadBooks(final Book book){
        ArrayList<Book> wantToReadBooks= Utils.getInstance().getWantToReadBooks();
        boolean existInWantToReadBooks=false;
        for (Book b: wantToReadBooks){
            if (b.getId() == book.getId()) {
                existInWantToReadBooks = true;
                break;
            }
        }
        if (existInWantToReadBooks){
            binding.btnAddToWantToRead.setEnabled(false);
        }
        else{
            binding.btnAddToWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance().addTWantToRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(BookActivity.this, WantToReadActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void handleAlreadyRead(Book book){
        ArrayList<Book> alreadyReadBooks= Utils.getAlreadyReadBook();
        boolean existInAlreadyReadBooks=false;
        for (Book b: alreadyReadBooks){
            if (b.getId() == book.getId()) {
                existInAlreadyReadBooks = true;
                break;
            }
        }
        if (existInAlreadyReadBooks){
            binding.btnAddToAlreadyRead.setEnabled(false);
        }
        else{
            binding.btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance().addToAlreadyRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(BookActivity.this, AlreadyReadBooksActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setData(Book book) {
        binding.txtBookName.setText(book.getName());
        binding.txtAuthor.setText(book.getAuthor());
        binding.txtPages.setText(String.valueOf(book.getPages()));
        binding.txtDescription.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap()
                .load(book.getImageUrl()).into(binding.bookImage);
    }
}