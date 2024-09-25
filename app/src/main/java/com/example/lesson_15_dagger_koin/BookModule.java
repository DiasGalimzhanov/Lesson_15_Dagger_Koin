package com.example.lesson_15_dagger_koin;


import dagger.Module;
import dagger.Provides;

@Module
public class BookModule {
    @Provides
    BookRepository provideBook(){
        return new BookRepository();
    }

}
