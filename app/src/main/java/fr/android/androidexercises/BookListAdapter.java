package fr.android.androidexercises;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by cp on 16/12/15.
 */
public class BookListAdapter extends BaseAdapter {
    private final ArrayList<Book> mBooks;

    public BookListAdapter(ArrayList<Book> books) {
        mBooks = books;
    }

    @Override
    public int getCount() {
        return mBooks.size();
    }

    @Override
    public Object getItem(int position) {
        return mBooks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_book, parent, false);
        }
        TextView titleView = (TextView) convertView.findViewById(R.id.titleTextView);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        Book book = (Book) getItem(position);
        titleView.setText(book.getTitle());
        Glide.with(convertView.getContext()).load(book.getCover()).into(imageView);
        return convertView;
    }
}
