package com.example.todotask.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Todo {
    @PrimaryKey(autoGenerate = true)
     int id ;
    @ColumnInfo
     String title;
    @ColumnInfo
     String body;


    public Todo() {
    }
    @Ignore  //to using in code
    public Todo(String title, String body) {
        this.title = title;
        this.body = body;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


}
