package com.anastazijazivkovic.mome;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuoteViewHolder extends RecyclerView.ViewHolder {

    TextView tvQuote;
    View itemView;

    public QuoteViewHolder(@NonNull View itemView) {
        super(itemView);
        tvQuote = itemView.findViewById(R.id.tvQuote);
        this.itemView = itemView;
    }

    public void setQuote(String quote){
        tvQuote.setText(quote);
    }


public void setBackgroundColor (boolean isEven) {
    if(isEven)
        itemView.setBackgroundColor(Color.parseColor( "#008577"));
    else
        itemView. setBackgroundColor(Color.parseColor("#00574B"));
    }
}