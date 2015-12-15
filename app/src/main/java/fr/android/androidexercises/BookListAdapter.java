package fr.android.androidexercises;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class BookListAdapter extends BaseAdapter {
    private final List<Book> mBookList;

    public BookListAdapter(List<Book> books) {
        mBookList = books;
    }

    @Override
    public int getCount() {
        return mBookList.size();
    }

    @Override
    public Object getItem(int position) {
        return mBookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_view, parent, false);
        }
        Book book = mBookList.get(position);
        BookView bookView = (BookView) convertView;
        bookView.bind(book);
        return convertView;
    }
}
