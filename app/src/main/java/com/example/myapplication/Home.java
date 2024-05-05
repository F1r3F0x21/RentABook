package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.example.myapplication.Activity.AccountActivity;
import com.example.myapplication.Activity.SettingsActivity;
import com.example.myapplication.Book.Book;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.myapplication.Book.BookAdapter;

public class Home extends AppCompatActivity{
    RecyclerView rv;
    BookAdapter adapter;
    DatabaseReference databaseReference;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        rv = (RecyclerView) findViewById(R.id.rview);
        rv.setLayoutManager(new LinearLayoutManager(this));

        adapter = new BookAdapter();
        rv.setAdapter(adapter);

        // Inicializa la referencia de Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference("Libros");

        // Agrega un ValueEventListener a la referencia
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Este método se activará cuando los datos en la referencia cambien
                for (DataSnapshot bookSnapshot : dataSnapshot.getChildren()) {
                    // Obtiene un libro de la instantánea y lo registra
                    Book book = bookSnapshot.getValue(Book.class);
                    Log.d("FirebaseData", "com.example.myapplication.Book.Book title: " + book.title + ", author: " + book.author + ", release date: " + book.releaseDate);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Este método se activará si se produce un error al leer los datos
                Log.w("FirebaseData", "Failed to read books.", databaseError.toException());
            }
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.navigation_home) {
                    // Navigate to the home activity
                    Intent homeIntent = new Intent(Home.this, Home.class);
                    startActivity(homeIntent);
                    return true;
                } else if (id == R.id.navigation_settings) {
                    Intent settingsIntent = new Intent(Home.this, SettingsActivity.class);
                    startActivity(settingsIntent);
                    return true;
                } else if (id == R.id.navigation_account) {
                    // Navigate to the account activity
                    Intent accountIntent = new Intent(Home.this, AccountActivity.class);
                    startActivity(accountIntent);
                    return true;
                }
                return false;
            }
        });
    }
}

