package com.groupproject.silva;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.groupproject.silva.to_do_model.OnTodoListener;
import com.groupproject.silva.to_do_model.RecycleViewAdapter;
import com.groupproject.silva.to_do_model.SharedView;
import com.groupproject.silva.to_do_model.Task;
import com.groupproject.silva.to_do_model.TaskViewInterface;


public class ToDoList extends AppCompatActivity implements OnTodoListener {

    private static final String TAG = "ITEM";
    private RecyclerView recyclerView;
    private RecycleViewAdapter recycleViewAdapter;
    BottomFragmentToDoList bottomFragmentToDoList;
    private SharedView sharedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_page);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        bottomFragmentToDoList = new BottomFragmentToDoList();
        ConstraintLayout constraintLayout = findViewById(R.id.bottomSheet);
//        BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = BottomSheetBehavior.from(constraintLayout);
        //bottomSheetBehavior.setPeekHeight(BottomSheetBehavior.STATE_HIDDEN);



        TaskViewInterface taskViewInterface = new ViewModelProvider.AndroidViewModelFactory(
                ToDoList.this.getApplication()).create(TaskViewInterface.class);

        taskViewInterface.getTheTasks().observe(this, tasks -> {
            recycleViewAdapter = new RecycleViewAdapter(tasks, this);
            recyclerView.setAdapter(recycleViewAdapter);
        });

        sharedView = new ViewModelProvider(this).get(SharedView.class);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Task task = new Task("Task Right now",
//                        Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), false);
//
//                TaskViewInterface.insert(task);
                showBottomSheetDialog();

            }

        });
    }

    private void showBottomSheetDialog() {
        bottomFragmentToDoList.show(getSupportFragmentManager(), bottomFragmentToDoList.getTag());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTodoClick(Task task) {
//        sharedView.setSelectedItem(task);
//        showBottomSheetDialog();
    }

    @Override
    public void onTodoRadioButtonClick(Task task) {
        openDialog(task);
        recycleViewAdapter.notifyDataSetChanged();
    }

    private void openDialog(Task task) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Delete Item");
        alertDialog.setMessage("Do you want to continue?");
        alertDialog.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TaskViewInterface.delete(task);
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.create().show();

    }
}