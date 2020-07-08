package com.anastazijazivkovic.mome;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TasksRecyclerAdapter extends RecyclerView.Adapter<TasksViewHolder> {

    private List<Task> tasks = new ArrayList<>();
    private TaskClickListener listener;

    public TasksRecyclerAdapter(TaskClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public TasksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_task, parent,false);
        return new TasksViewHolder(cellView, listener);
    }

    @Override
    public void onBindViewHolder(final @NonNull TasksViewHolder holder, final int position) {

        holder.setTask(tasks.get(position).getText());


        holder.cbTask.setOnCheckedChangeListener(null);

        holder.cbTask.setChecked(tasks.get(position).getChecked());


        if(tasks.get(position).getChecked()){
            holder.cbTask.setPaintFlags(holder.cbTask.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
        else{
            holder.cbTask.setPaintFlags(holder.cbTask.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
        }

        holder.cbTask.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tasks.get(position).setChecked(isChecked);
                if(tasks.get(position).getChecked()){
                    holder.cbTask.setPaintFlags(holder.cbTask.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                else{
                    holder.cbTask.setPaintFlags(holder.cbTask.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void addNewCell(String task, int position){
        if(tasks.size() >= position) {
            tasks.add(position, new Task(task, false));
            notifyItemInserted(position);
        }
    }

    public void removeCell(int position){
        if(tasks.size() > position){
            tasks.remove(position);
            notifyItemRemoved(position);
        }
    }
}
