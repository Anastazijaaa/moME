package com.anastazijazivkovic.mome;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuoteRecyclerAdapter extends RecyclerView.Adapter<QuoteViewHolder> {

    private String[] quotes;

    public QuoteRecyclerAdapter(String[] quotes){
        this.quotes = quotes;
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_quote, parent,false);
        return new QuoteViewHolder(cellView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {
        holder.setQuote(quotes[position]);
        holder.setBackgroundColor(position%2==0);

    }

    @Override
    public int getItemCount() {
        return quotes.length;
    }
}
