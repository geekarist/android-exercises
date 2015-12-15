package fr.android.androidexercises;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class BookRecyclerViewHolder extends RecyclerView.ViewHolder {

    private final TextView mNameView;
    private final TextView mPriceView;

    public BookRecyclerViewHolder(View itemView) {
        super(itemView);

        mNameView = (TextView) itemView.findViewById(R.id.nameTextView);
        mPriceView = (TextView) itemView.findViewById(R.id.priceTextView);
    }

    public void bind(Book book) {
        mNameView.setText(book.name);
        mPriceView.setText(String.valueOf(book.price));
    }
}
