package com.anastazijazivkovic.mome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TasksActivity extends AppCompatActivity implements TaskClickListener{

    EditText etTask;
    Button btnAddTask;
    RecyclerView rvTasks;
    TasksRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        setUpRecycler();
        etTask = findViewById(R.id.etTask);
        btnAddTask = findViewById(R.id.btnAddTask);
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = etTask.getText().toString();
                if(task.trim().isEmpty()){
                    displayToast("You didn't enter anything");
                }
                else{
                    adapter.addNewCell(task, adapter.getItemCount());
                    etTask.setText("");
                }
            }
        });
    }

    private void setUpRecycler(){
        rvTasks = findViewById(R.id.rvTasks);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TasksRecyclerAdapter(this);
        rvTasks.setAdapter(adapter);
    }

    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTaskClick(int position) {
        adapter.removeCell(position);
    }
}
