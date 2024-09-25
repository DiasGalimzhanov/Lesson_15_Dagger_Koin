package com.example.lesson_15_dagger_koin;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson_15_dagger_koin.model.Book;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private BookRepository bookRepository = DaggerBookComponnt.create().getBookRepository();
    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        bookRepository = new BookRepository();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        bookAdapter = new BookAdapter(bookRepository.getBooks());
        recyclerView.setAdapter(bookAdapter);

        findViewById(R.id.addButton).setOnClickListener(v -> showAddBookDialog());
    }

    private void showAddBookDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_book, null);
        builder.setView(dialogView);

        EditText titleEditText = dialogView.findViewById(R.id.titleEditText);
        EditText authorEditText = dialogView.findViewById(R.id.authorEditText);

        builder.setPositiveButton("Add", (dialog, which) -> {
            String title = titleEditText.getText().toString();
            String author = authorEditText.getText().toString();

            if (!title.isEmpty() && !author.isEmpty()) {
                bookRepository.addBook(new Book(title, author));
                bookAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "Enter all", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        builder.create().show();
    }
}