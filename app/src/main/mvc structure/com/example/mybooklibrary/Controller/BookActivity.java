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

import com.example.mybooklibrary.model.Utils;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private TextView txtBookName,txtAuthor,txtPages,txtDescription;
    private Button btnAddToCurrentlyReading, btnAddToWantToRead, btnAddToAlreadyRead, btnAddingToFavBooks;
    private ImageView bookImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        initViews();
 //       String longDescription="An essay is nothing but a piece of content which is written from the perception of writer or author. Essays are similar to a story, pamphlet, thesis, etc. The best thing about Essay is you can use any type of language – formal or informal." +
   //             "\n"+" It can biography, the autobiography of anyone.An essay is nothing but a piece of content which is written from the perception of writer or author. Essays are similar to a story, pamphlet, thesis, etc. The best thing about Essay is you can use any type of language – formal or informal. " +
   //             "\n" + "It can biography, the autobiography of anyone.An essay is nothing but a piece of content which is written from the perception of writer or author. Essays are similar to a story, pamphlet, thesis, etc. The best thing about Essay is you can use any type of language – formal or informal. It can biography, the autobiography of anyone.An essay is nothing but a piece of content which is written from the perception of writer or author. Essays are similar to a story, pamphlet, thesis, etc. The best thing about Essay is you can use any type of language – formal or informal. It can biography, the autobiography of anyone.An essay is nothing but a piece of content which is written from the perception of writer or author. Essays are similar to a story, pamphlet, thesis, etc. The best thing about Essay is you can use any type of language – formal or informal. It can biography, the autobiography of anyone.An essay is nothing but a piece of content which is written from the perception of writer or author. Essays are similar to a story, pamphlet, thesis, etc. The best thing about Essay is you can use any type of language – formal or informal. It can biography, the autobiography of anyone.An essay is nothing but a piece of content which is written from the perception of writer or author. Essays are similar to a story, pamphlet, thesis, etc. The best thing about Essay is you can use any type of language – formal or informal. It can biography, the autobiography of anyone.An essay is nothing but a piece of content which is written from the perception of writer or author. Essays are similar to a story, pamphlet, thesis, etc. The best thing about Essay is you can use any type of language – formal or informal. It can biography, the autobiography of anyone.An essay is nothing but a piece of content which is written from the perception of writer or author. Essays are similar to a story, pamphlet, thesis, etc. The best thing about Essay is you can use any type of language – formal or informal. It can biography, the autobiography of anyone.";
   //     //TODO: Get data from Recycler view in here
  //      Book book = new Book(1, "1Q84", "Haruki Murakami", 1350, "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1483103331l/10357575.jpg", "A book of maddening brilliance", longDescription);

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
            btnAddToCurrentlyReading.setEnabled(false);
        }
        else{
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
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
            btnAddingToFavBooks.setEnabled(false);
        }
        else{
            btnAddingToFavBooks.setOnClickListener(new View.OnClickListener() {
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
            btnAddToWantToRead.setEnabled(false);
        }
        else{
            btnAddToWantToRead.setOnClickListener(new View.OnClickListener() {
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
        ArrayList<Book> alreadyReadBooks= Utils.getInstance().getAlreadyReadBook();
        boolean existInAlreadyReadBooks=false;
        for (Book b: alreadyReadBooks){
            if (b.getId() == book.getId()) {
                existInAlreadyReadBooks = true;
                break;
            }
        }
        if (existInAlreadyReadBooks){
            btnAddToAlreadyRead.setEnabled(false);
        }
        else{
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
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
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap()
                .load(book.getImageUrl()).into(bookImage);
    }

    private void initViews(){
        txtBookName=findViewById(R.id.txtBookName);
        txtAuthor=findViewById(R.id.txtAuthor);
        txtPages=findViewById(R.id.txtPages);
        txtDescription=findViewById(R.id.txtDescription);

        btnAddToCurrentlyReading=findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToWantToRead=findViewById(R.id.btnAddToWantToRead);
        btnAddToAlreadyRead=findViewById(R.id.btnAddToAlreadyRead);
        btnAddingToFavBooks=findViewById(R.id.btnAddingToFavBooks);

        bookImage=findViewById(R.id.bookImage);
    }

}