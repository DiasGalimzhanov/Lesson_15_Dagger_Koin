package com.example.lesson_15_dagger_koin;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {BookModule.class})
public interface BookComponnt {
    BookRepository getBookRepository();
}
