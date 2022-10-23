package com.example.a1_todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private SQLiteDatabaseHandler db;
    private ArrayList<TaskModel> taskList;
    private Button btnAdd;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        recyclerView = findViewById(R.id.rvTaskList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = new SQLiteDatabaseHandler(this);
//        db.addTask(new TaskModel("Nugas"));
//        db.addTask(new TaskModel("Makan"));

        taskList = (ArrayList<TaskModel>) db.getAllTasks();
        taskAdapter = new TaskAdapter(taskList, db);
        recyclerView.setAdapter(taskAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = getLayoutInflater();
                View view = layoutInflater.inflate(R.layout.layout_add, null, false);
                popupWindow = new PopupWindow(view, 1000, 400, true);
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                final EditText etTaskName = view.findViewById(R.id.etTaskName);
                Button btnSave = view.findViewById(R.id.btnSave);
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.addTask(new TaskModel(etTaskName.getText().toString()));

                        if(taskAdapter==null) {
                            taskAdapter = new TaskAdapter(taskList, db);
                            recyclerView.setAdapter(taskAdapter);
                        }
                        taskAdapter.taskList = (ArrayList<TaskModel>) db.getAllTasks();
                        recyclerView.getAdapter().notifyDataSetChanged();
                        popupWindow.dismiss();
                    }
                });
            }
        });
    }
}