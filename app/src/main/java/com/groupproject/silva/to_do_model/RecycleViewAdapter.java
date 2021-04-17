package com.groupproject.silva.to_do_model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.groupproject.silva.R;
import com.groupproject.silva.to_do_model.util.Utils;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private final List<Task> taskList;
    private final OnTodoListener todoListener;

    public RecycleViewAdapter(List<Task> taskList,  OnTodoListener onTodoListener) {
        this.taskList = taskList;
        this.todoListener = onTodoListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.to_do_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Task task = taskList.get(position);

        String formatted = Utils.formatDate(task.getDueDate());


        holder.taskName.setText(task.getTaskName());
        holder.toDoChip.setText(formatted);


    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public AppCompatRadioButton radioButton;
        public AppCompatTextView taskName;
        public Chip toDoChip;

        OnTodoListener onTodoListener;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            radioButton = itemView.findViewById(R.id.radioButton);
            taskName = itemView.findViewById(R.id.taskName);
            toDoChip = itemView.findViewById(R.id.toDoChip);
            this.onTodoListener = todoListener;

            itemView.setOnClickListener(this);
            radioButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.todo_row_layout) {
                onTodoListener.onTodoClick(taskList.get(getAdapterPosition()));
            } else if (id == R.id.radioButton) {
                onTodoListener.onTodoRadioButtonClick(taskList.get(getAdapterPosition()));
            }
        }
    }

}
