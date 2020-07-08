package com.anastazijazivkovic.mome;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public CheckBox cbTask;
    ImageView ivRemoveTask;
    TaskClickListener listener;

    public TasksViewHolder(@NonNull View itemView, TaskClickListener listener) {
        super(itemView);
        this.listener = listener;
        cbTask = itemView.findViewById(R.id.cbTask);
        ivRemoveTask = itemView.findViewById(R.id.ivRemoveTask);
        ivRemoveTask.setOnClickListener(this);
    }

    public void setTask(String text){
        cbTask.setText(text);
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        if(position != RecyclerView.NO_POSITION) { //to stop the app from crashing on double clicks
            listener.onTaskClick(position);
        }
    }
}
