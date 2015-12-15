package fr.android.androidexercises;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class BookActivity extends AppCompatActivity {

    private static final String BOOK = "BOOK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Intent intent = getIntent();
        Book book = intent.getParcelableExtra(BOOK);

        TextView authorTextView = (TextView) findViewById(R.id.authorTextView);
        authorTextView.setText(book.getAuthor());

        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        nameTextView.setText(book.getName());

        View reserveButton = findViewById(R.id.reserveButton);
        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(BookActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, final int year, final int monthOfYear, final int dayOfMonth) {
                        new TimePickerDialog(BookActivity.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                Toast.makeText(
                                        BookActivity.this,
                                        getString(
                                                R.string.reserved_for,
                                                year, monthOfYear, dayOfMonth, hourOfDay, minute),
                                        Toast.LENGTH_LONG).show();
                            }
                        }, 12, 0, true).show();
                    }
                }, 2015, 11, 15).show();
            }
        });
    }

}
