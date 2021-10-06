package com.example.todotask.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todotask.R;
import com.example.todotask.dataBase.MyDataBase;
import com.example.todotask.model.Todo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mTitle;
    private EditText mBody;
    private Button mInsertBtn;
    private Button mShowBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews(){
        mTitle = findViewById(R.id.ed_title);
        mBody = findViewById(R.id.ed_body);
        mInsertBtn = findViewById(R.id.bt_insert);
        mShowBtn = findViewById(R.id.bt_show);
        mInsertBtn.setOnClickListener(this);
        mShowBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.bt_insert){
            String title=mTitle.getText().toString();
            String body=mBody.getText().toString();
            if (!title.isEmpty() && !body.isEmpty()){
                Todo todoItem = new Todo(title, body);
                MyDataBase.getInstance(this)
                        .todoDao()
                        .AddTodo(todoItem);
                Toast.makeText(getApplicationContext(), getString(R.string.todo_Add_successfully), Toast.LENGTH_SHORT).show();
             startActivity(new Intent(MainActivity.this,ShowTodoActivity.class));

            }else {
                Toast.makeText(getApplicationContext(), getString(R.string.some_field_is_empty), Toast.LENGTH_SHORT).show();
            }



        }
        else if (v.getId()==R.id.bt_show){
            startActivity(new Intent(MainActivity.this,ShowTodoActivity.class));
        }
    }
}