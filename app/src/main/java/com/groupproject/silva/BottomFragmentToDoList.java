package com.groupproject.silva;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.snackbar.Snackbar;
import com.groupproject.silva.to_do_model.SharedView;
import com.groupproject.silva.to_do_model.Task;
import com.groupproject.silva.to_do_model.TaskViewInterface;
import com.groupproject.silva.to_do_model.util.Utils;

import java.util.Calendar;
import java.util.Date;

public class BottomFragmentToDoList extends BottomSheetDialogFragment {
    private EditText enterToDoTitle;
    private Button calendarButton;
    private Button confirmButton;
    private int selectedButtonId;
    private CalendarView calendarView;
    private Group calendarGroup;
    Date dueDate;
    Calendar calendar = Calendar.getInstance();
    private SharedView sharedView;

    public BottomFragmentToDoList() {

    }

    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.bottom_frag, container, false);
        calendarGroup = view.findViewById(R.id.calGroup);
        calendarView = view.findViewById(R.id.calendarView2);
        calendarButton = view.findViewById(R.id.setDateButton);
        enterToDoTitle = view.findViewById(R.id.toDoEnterText);
        confirmButton = view.findViewById(R.id.confirmButton);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (sharedView.getSelectedItem().getValue() != null) {

            Task task = sharedView.getSelectedItem().getValue();
            enterToDoTitle.setText(task.getTaskName());
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedView = new ViewModelProvider(requireActivity()).get(SharedView.class);



        confirmButton.setOnClickListener(v -> {
            String taskName = enterToDoTitle.getText().toString().trim();
            if (!TextUtils.isEmpty(taskName)) {
                if (dueDate == null) {
                    dueDate = Calendar.getInstance().getTime();
                }
                Task newTask = new Task(taskName, dueDate, Calendar.getInstance().getTime(), false);
                TaskViewInterface.insert(newTask);

                if (this.isVisible()) {
                    this.dismiss();
                }

            } else {
                Snackbar.make(confirmButton, "Empty Task ", Snackbar.LENGTH_LONG).show();
            }
        });

        calendarButton.setOnClickListener( v -> {
            if (calendarGroup.getVisibility() == View.GONE) {
                calendarGroup.setVisibility(View.VISIBLE);
            }
            else {
                calendarGroup.setVisibility(View.GONE);
            }
            Utils.hideKeyboard(view);
        });
        calendarView.setOnDateChangeListener((calendarView, year, month, day) -> {
            calendar.clear();
            calendar.set(year, month, day);
            dueDate = calendar.getTime();
            Log.d("Cal", "OnViewCreated: ===> month" + (month+1) + ", day" + day);

        });
    }

}
