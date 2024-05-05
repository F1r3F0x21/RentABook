package com.example.myapplication.Book;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class BookViewHolder extends RecyclerView.ViewHolder {
    public TextView titleView;
    public TextView authorView;
    public TextView releaseDateView;

    public BookViewHolder(View itemView) {
        super(itemView);
        titleView = itemView.findViewById(R.id.book_title);
        authorView = itemView.findViewById(R.id.book_author);
        releaseDateView = itemView.findViewById(R.id.book_release_date);
    }

    public void bindToBook(Book book) {
        titleView.setText(book.title);
        authorView.setText(book.author);
        releaseDateView.setText(book.releaseDate);
    }
}