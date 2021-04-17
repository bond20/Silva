package com.groupproject.silva.to_do_model.data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import com.groupproject.silva.to_do_model.Task;
import com.groupproject.silva.to_do_model.util.TaskDatabase;

import java.util.List;

public class DataCentral {
    private final TaskDao taskDao;
    private final LiveData<List<Task>> theTasks;

    public DataCentral(Application application) {
        TaskDatabase database = TaskDatabase.getDatabase(application);
        this.taskDao = database.taskDao();
        this.theTasks = taskDao.getTasks();
    }

    //methods for retrieval, insertion, deletions

    public void insert(Task task) {
        TaskDatabase.databaseWriterExecutor.execute( () -> taskDao.insertTask(task));
    }

    public LiveData<List<Task>> getAllTasks() {
        return theTasks;
    }

    public LiveData<Task> get(long id) {
        return taskDao.get(id);
    }

    public void update(Task task) {
        TaskDatabase.databaseWriterExecutor.execute( () -> taskDao.update(task));
    }

    public void delete(Task task) {
        TaskDatabase.databaseWriterExecutor.execute(() -> taskDao.delete(task));
    }

}
