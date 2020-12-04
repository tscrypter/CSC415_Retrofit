package com.tscrypter.retrofitassigment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.tscrypter.retrofitassigment.dto.PokemonDto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class DetailActivity extends AppCompatActivity {

    private static final Logger logger = Logger.getLogger(DetailActivity.class.getName());
    PokeApiService service;
    private String pokemonName;
    ExecutorService executor = Executors.newFixedThreadPool(10);
    private ImageView pokemonImage;
    private TextView pokemonNameTextView;
    private Pokemon pokemon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        pokemonImage = findViewById(R.id.pokemonImageDetail);
        pokemonNameTextView = findViewById(R.id.titleDetail);
        pokemonName = getIntent().getStringExtra("name");
        retrievePokemon();
    }

    protected void retrievePokemon() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(PokeApiService.class);

        Call<PokemonDto> pokemonDto = service.getPokemon(pokemonName);

        pokemonDto.enqueue(new Callback<PokemonDto>() {
            @Override
            public void onResponse(Call<PokemonDto> call, Response<PokemonDto> response) {
                if(response.isSuccessful()) {
                    logger.info("Retrieved pokemon " + pokemonName);
                    PokemonDto body = response.body();
                    List<PokemonDto.BaseStat> stats = body.getStats();

                    pokemon = new Pokemon(
                            body.getName(), body.getHeight(), body.getWeight(), body.getBaseExperience(),
                            0, 0, 0, 0,
                    body.getSprites().getOther().getOfficial_artwork().getFront_default());
                    for (PokemonDto.BaseStat stat :
                            stats) {
                        switch (stat.getStat().getName()){
                            case "hp": {
                                pokemon.setHp(stat.getBase_stat());
                                break;
                            }
                            case "attack": {
                                pokemon.setAttack(stat.getBase_stat());
                                break;
                            }
                            case  "defense": {
                                pokemon.setDefense(stat.getBase_stat());
                                break;
                            }
                            case "speed": {
                                pokemon.setSpeed(stat.getBase_stat());
                                break;
                            }
                        }
                    }
                }
                refreshView();
            }

            @Override
            public void onFailure(Call<PokemonDto> call, Throwable t) {
                logger.info("Failed to retrieve pokemon");
            }
        });
    }

    void refreshView() {
        Glide.with(this).load(this.pokemon.getOfficialArtworkUrl()).into(pokemonImage);
        pokemonNameTextView.setText(pokemon.getName());
    }
}