package com.tscrypter.retrofitassigment;

import android.util.Log;
import android.util.Pair;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tscrypter.retrofitassigment.dto.PokemonList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private static final Logger logger = Logger.getLogger(MainActivity.class.getName());
    // Member variables
    PokeApiService service;
    private RecyclerView recyclerView;
    private List<PokemonList.PokemonListItem> pokemonListItems;
    private PokemonAdapter pokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the RecyclerView
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        //Set the layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the list that will contain the data
        pokemonListItems = new LinkedList<>();

        // Initialize the adapter and set it to the RecyclerView
        pokemonAdapter = new PokemonAdapter(pokemonListItems, this);
        recyclerView.setAdapter(pokemonAdapter);

        // Get the initial data
        retrievePokemonList();
    }

    protected void retrievePokemonList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(PokeApiService.class);
        Call<PokemonList> pokemonListCall = service.listPokemon(0, 20);
        pokemonListCall.enqueue(new Callback<PokemonList>() {
            @Override
            public void onResponse(Call<PokemonList> call, Response<PokemonList> response) {
                // Clear the existing data
                pokemonListItems.clear();
                pokemonListItems.addAll(response.body().getResults());
                pokemonAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PokemonList> call, Throwable t) {
                logger.info("Failed to retrieve pokemon");
            }
        });
    }
}