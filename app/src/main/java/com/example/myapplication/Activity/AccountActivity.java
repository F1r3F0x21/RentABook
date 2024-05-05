package com.example.myapplication.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class AccountActivity extends AppCompatActivity {
    private TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        textViewEmail = findViewById(R.id.textView_username);

        SharedPreferences sharedPreferences = getSharedPreferences("LoginData", MODE_PRIVATE);
        String email = sharedPreferences.getString("username", "");

        textViewEmail.setText(email);
    }
}