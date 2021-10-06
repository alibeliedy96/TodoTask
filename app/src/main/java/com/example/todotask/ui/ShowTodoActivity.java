package com.example.todotask.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.todotask.R;
import com.example.todotask.adapter.TodoRecyclerAdapter;
import com.example.todotask.dataBase.MyDataBase;
import com.example.todotask.model.Todo;

import java.util.List;

public class ShowTodoActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    TodoRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_todo);

        initViews();
    }

    private void initViews() {
        recyclerView=findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        adapter=new TodoRecyclerAdapter(this,null);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Todo> items= MyDataBase.getInstance(this)
                .todoDao().getAllTodo();
        adapter.dataChanged(items);
    }
}