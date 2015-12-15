package fr.android.androidexercises;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class BookRecyclerAdapter extends RecyclerView.Adapter<BookRecyclerViewHolder> {
    private final List<Book> mBooks;
    private LayoutInflater inflater;

    public BookRecyclerAdapter(List<Book> books, Context context) {
        mBooks = books;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public BookRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_view_item_book, parent, false);
        return new BookRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookRecyclerViewHolder holder, int position) {
        Book book = mBooks.get(position);
        holder.bind(book);
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }
}
