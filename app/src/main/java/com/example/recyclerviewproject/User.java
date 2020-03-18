package com.example.recyclerviewproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
   private int uid;

    @ColumnInfo(name="name")
    public String name;

    @ColumnInfo(name="mark")
    public int mark;

    public User(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }
}
