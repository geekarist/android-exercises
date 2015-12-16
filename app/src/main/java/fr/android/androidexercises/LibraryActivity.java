package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import timber.log.Timber;

public class LibraryActivity extends AppCompatActivity {

    private ArrayList<Book> mBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        // Plant logger cf. Android Timber
        Timber.plant(new Timber.DebugTree());

        // build Retrofit
        Retrofit.Builder builder = new Retrofit.Builder();

        // create a service
        Retrofit retrofit = builder
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HenriPotierService henriPotierService = retrofit.create(HenriPotierService.class);

        // listBooks()
        // enqueue call and display book title
        mBooks = new ArrayList<>();
        henriPotierService.listBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Response<List<Book>> response, Retrofit retrofit) {
                mBooks.addAll(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                Timber.e(t, "Error while retrieving books");
            }
        });

        // TODO display book as a list
        ListView bookListView = (ListView) findViewById(R.id.bookListView);
        BookListAdapter bookListAdapter = new BookListAdapter(mBooks);
        bookListView.setAdapter(bookListAdapter);
    }

}
