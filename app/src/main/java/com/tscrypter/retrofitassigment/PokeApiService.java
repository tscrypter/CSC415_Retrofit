package com.tscrypter.retrofitassigment;

import com.tscrypter.retrofitassigment.dto.PokemonDto;
import com.tscrypter.retrofitassigment.dto.PokemonList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeApiService {
    @GET("pokemon")
    Call<PokemonList> listPokemon(@Query("offset") int offset, @Query("limit") int limit);

    @GET("pokemon/{name}")
    Call<PokemonDto> getPokemon(@Path("name") String pokemonName);
}
