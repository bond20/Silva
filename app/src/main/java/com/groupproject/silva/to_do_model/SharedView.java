package com.groupproject.silva.to_do_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedView extends ViewModel {
    private final MutableLiveData<Task> selectedItem = new MutableLiveData<>();
    private boolean editing;

    public void setSelectedItem(Task task) {
        selectedItem.setValue(task);
    }

    public LiveData<Task> getSelectedItem() {
        return selectedItem;
    }

    public void setEditing(boolean isEdit){
        this.editing = editing;
    }

    public boolean getEditing() {
        return editing;
    }
}
