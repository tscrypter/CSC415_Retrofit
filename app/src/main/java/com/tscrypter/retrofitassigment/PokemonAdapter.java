package com.tscrypter.retrofitassigment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tscrypter.retrofitassigment.dto.PokemonList;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    // Member variables
    private List<PokemonList.PokemonListItem> pokemonListItems;
    private Context context;

    /**
     * Constructor that passes in the pokemon data and the context
     * @param pokemonListItems List containing pokemon
     * @param context Context of the application
     */
    public PokemonAdapter(List<PokemonList.PokemonListItem> pokemonListItems, Context context) {
        this.pokemonListItems = pokemonListItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.pokemon_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAdapter.ViewHolder holder, int position) {
        // Get current pokemon
        PokemonList.PokemonListItem currentPokemon = pokemonListItems.get(position);
        // Populate the textviews with data
        holder.bindTo(currentPokemon);
    }

    @Override
    public int getItemCount() {
        return pokemonListItems.size();
    }

    /**
     * ViewHolder class that represents each row of data in the RecyclerView
     */
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView pokemonName;
        private final TextView pokemonUrl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemonName = itemView.findViewById(R.id.pokemonName);
            pokemonUrl = itemView.findViewById(R.id.pokemonUrl);

            itemView.setOnClickListener(this);
        }

        void bindTo(PokemonList.PokemonListItem currentPokemon) {
            // Populate the TextViews with data
            pokemonName.setText(currentPokemon.getName());
            pokemonUrl.setText(currentPokemon.getUrl());
        }

        @Override
        public void onClick(View v) {
            PokemonList.PokemonListItem currentPokemon = pokemonListItems.get(getAdapterPosition());
            Intent detailIntent = new Intent(context, DetailActivity.class);
            detailIntent.putExtra("name", currentPokemon.getName());
            detailIntent.putExtra("url",
                    currentPokemon.getUrl());
            context.startActivity(detailIntent);
        }
    }
}
