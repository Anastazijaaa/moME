package com.anastazijazivkovic.mome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MenuActivity extends AppCompatActivity {

    Button btnDaily, btnStudying, btnFriends, btnSurprise, btnTasks;
    List<String[]> quotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        String message = intent.getStringExtra("NAME");
        displayToast("Welcome, " + message + "!");
        btnDaily = findViewById(R.id.btnDaily);
        btnStudying = findViewById(R.id.btnStudying);
        btnFriends = findViewById(R.id.btnFriends);
        btnSurprise = findViewById(R.id.btnSurprise);
        btnTasks = findViewById(R.id.btnTasks);
        quotes = new ArrayList<>();
        quotes.add(getResources().getStringArray(R.array.strArDaily));
        quotes.add(getResources().getStringArray(R.array.strArStudying));
        quotes.add(getResources().getStringArray(R.array.strArFriends));
        setUpCategoryButtons();
        setUpSurpriseButton();
        setUpTasksButton();
    }

    private void setUpCategoryButtons(){
        btnDaily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, QuotesActivity.class);
                intent.putExtra("QUOTES", quotes.get(0));
                startActivity(intent);
            }
        });

        btnStudying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, QuotesActivity.class);
                intent.putExtra("QUOTES", quotes.get(1));
                startActivity(intent);
            }
        });

        btnFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, QuotesActivity.class);
                intent.putExtra("QUOTES", quotes.get(2));
                startActivity(intent);
            }
        });
    }

    private void setUpSurpriseButton(){
        btnSurprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                String[] stringArray = quotes.get(rnd.nextInt(quotes.size()));
                displayToast(stringArray[rnd.nextInt(stringArray.length)]);
            }
        });
    }

    private void setUpTasksButton(){
        btnTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, TasksActivity.class);
                startActivity(intent);
            }
        });
    }

    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
