package com.groupproject.silva.to_do_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.groupproject.silva.to_do_model.data.DataCentral;

import java.util.List;

public class TaskViewInterface extends AndroidViewModel {

    public final LiveData<List<Task>> theTasks;
    public static DataCentral repository;


    public TaskViewInterface(@NonNull Application application) {
        super(application);
        repository = new DataCentral(application);
        theTasks = repository.getAllTasks();

    }

    public LiveData<Task> get(long id) {
        return repository.get(id);
    }

    public LiveData<List<Task>> getTheTasks() {
        return theTasks;
    }

    public static void update(Task task) {
        repository.update(task);
    }


    public static void insert(Task task) {
        repository.insert(task);
    }

    public static void delete(Task task) {
        repository.delete(task);
    }

}
