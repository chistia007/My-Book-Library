package com.example.mybooklibrary.model;

import com.example.mybooklibrary.Controller.Book;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBook;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> CurrentlyReadingBooks;
    private static ArrayList<Book> favoriteBooks;
    private Utils() {
        if(null==allBooks){
            allBooks=new ArrayList<>();
            initData();
        }
        if(null==alreadyReadBook){
            alreadyReadBook=new ArrayList<>();
        }

        if(null==wantToReadBooks){
            wantToReadBooks=new ArrayList<>();
        }

        if(null==CurrentlyReadingBooks){
            CurrentlyReadingBooks=new ArrayList<>();
        }

        if(null==favoriteBooks){
            favoriteBooks=new ArrayList<>();
        }

    }

    private void initData() {
        allBooks.add(new Book(1,"The Push","Ashley Audrain", 1267,"https://www.julesbuono.com/wp-content/uploads/2021/08/the-push-summary.jpg","The Push is an ingenious reincarnation of that most forbidden of suspense narratives","There are enough novels about unreliable female narrators and neglectful mothers to fill a minivan… But what makes [THE PUSH] stand out from the rest is Audrain’s nuanced understanding of how women’s voices are discounted, how a thousand little slights can curdle a solid marriage and—in defiance of maternal taboos—how mothers really feel, sometimes, toward difficult children."));
        allBooks.add(new Book(2,"1Q84","Haruki Murakami", 1350,"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1483103331l/10357575.jpg","A book of maddening brilliance","The book opens with a woman named Aomame (青豆) as she rides a taxi to a work assignment. She hears the Sinfonietta by Leoš Janáček playing on the radio and immediately recognizes it, somehow having detailed knowledge of its history and context. When the taxi gets stuck in a traffic jam on the Shibuya Route of the Shuto Expressway, the driver suggests she climb down an emergency escape to reach her meeting, warning her that it might change the very nature of reality. Aomame follows the driver's advice. "));
        allBooks.add(new Book(3,"Brave New World","Aldous Huxley", 1670,"https://upload.wikimedia.org/wikipedia/en/6/62/BraveNewWorld_FirstEdition.jpg","How beauteous mankind is!","Brave New World is a dystopian social science fiction novel by English author Aldous Huxley, written in 1931 and published in 1932. Largely set in a futuristic World State, whose citizens are environmentally engineered into an intelligence-based social hierarchy, the novel anticipates huge scientific advancements in reproductive technology, sleep-learning, psychological manipulation and classical conditioning that are combined to make a dystopian society which is challenged by only a single individual: the story's protagonist."));


    }

    public static Utils getInstance() {
        if (null != instance) {
            return instance;
        }
        else{
            instance= new Utils();
            return instance;
        }

    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBook() {
        return alreadyReadBook;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return CurrentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }
    public Book getBookById(int id){
        for (Book b: allBooks){
            if(b.getId()==id){
                return b;
            }

        }
        return null;
    }

    public boolean addToAlreadyRead(Book book){
        return alreadyReadBook.add(book);
    }
    public boolean addTWantToRead(Book book){
        return wantToReadBooks.add(book);
    }
    public boolean addToFavorite(Book book){
        return favoriteBooks.add(book);
    }

    public boolean addToCurrentlyReadingBooks(Book book){
        return CurrentlyReadingBooks.add(book);
    }

    public boolean removeFromAlreadyRead(Book book) {
        return alreadyReadBook.remove(book);
    }
    public boolean removeFromWantToRead(Book book) {
        return wantToReadBooks.remove(book);
    }
    public boolean removeFromFavoriteBook(Book book) {
        return favoriteBooks.remove(book);
    }
    public boolean removeFromCurrentlyReading(Book book) {return CurrentlyReadingBooks.remove(book);
    }
}


