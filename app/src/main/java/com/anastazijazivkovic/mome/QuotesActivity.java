package com.anastazijazivkovic.mome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class QuotesActivity extends AppCompatActivity {

    String[] quotes;
    RecyclerView rvQuotes;
    QuoteRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        Intent intent = getIntent();
        quotes = intent.getStringArrayExtra("QUOTES");
        setUpRecycler();
    }

    private void setUpRecycler(){
        rvQuotes = findViewById(R.id.rvQuotes);
        rvQuotes.setLayoutManager(new LinearLayoutManager(this));
        adapter = new QuoteRecyclerAdapter(quotes);
        rvQuotes.setAdapter(adapter);
    }
}
