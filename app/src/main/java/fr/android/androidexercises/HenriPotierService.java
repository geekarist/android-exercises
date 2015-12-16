package fr.android.androidexercises;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

public interface HenriPotierService {

    // Method GET books which return a List<Book>
    @GET("/books")
    Call<List<Book>> listBooks();
}
