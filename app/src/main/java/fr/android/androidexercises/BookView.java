package fr.android.androidexercises;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BookView extends RelativeLayout {
    private TextView mPriceView;
    private TextView mNameView;

    public BookView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BookView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BookView(Context context) {
        this(context, null);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mPriceView = (TextView) findViewById(R.id.text_book_price);
        mNameView = (TextView) findViewById(R.id.text_book_name);
    }

    public void bind(Book book) {
        mPriceView.setText(String.valueOf(book.price));
        mNameView.setText(String.valueOf(book.name));
    }
}
