package com.groupproject.silva.to_do_model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "task_table")

public class Task {
    @ColumnInfo(name = "task_id")
    @PrimaryKey(autoGenerate = true)
    public long taskIdNumber;
    @ColumnInfo(name = "task")
    public String taskName;
    //@ColumnInfo(name = "priority")
    //public Priority taskPriority;
    @ColumnInfo(name = "due_date")
    public Date dueDate;
    @ColumnInfo(name = "date_created")
    public Date dateCreated;
    @ColumnInfo(name = "is_done")
    public boolean isDone;


    public Task(String taskName, Date dueDate, Date dateCreated, boolean isDone) {
        this.taskName = taskName;
        //this.taskPriority = taskPriority;
        this.dueDate = dueDate;
        this.dateCreated = dateCreated;
        this.isDone = isDone;
    }

    public long getTaskIdNumber() {
        return taskIdNumber;
    }

    public void setTaskIdNumber(long taskIdNumber) {
        this.taskIdNumber = taskIdNumber;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /* public Priority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(Priority taskPriority) {
        this.taskPriority = taskPriority;
    } */

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskIdNumber=" + taskIdNumber +
                ", taskName='" + taskName + '\'' +
                ", dueDate=" + dueDate +
                ", dateCreated=" + dateCreated +
                ", isDone=" + isDone +
                '}';
    }
}
