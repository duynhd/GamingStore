package com.example.prm_project.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.prm_project.data.models.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insert(User... user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("select * from User")
    List<User> getAllUser();

    @Query("Select * from User where User.ID = :id")
    User getUserById(int id);
}
