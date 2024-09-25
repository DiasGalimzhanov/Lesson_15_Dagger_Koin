package com.example.lesson_15_dagger_koin;

import com.example.lesson_15_dagger_koin.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> bookList = new ArrayList<>();

    public List<Book> getBooks() {
        return bookList;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }
}