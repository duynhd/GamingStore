package com.example.prm_project.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.prm_project.R;
import com.example.prm_project.data.DAO;
import com.example.prm_project.data.dao.UserDAO;
import com.example.prm_project.data.models.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DAO database = Room.databaseBuilder(getApplicationContext(), DAO.class, DAO.DB_NAME)
                .allowMainThreadQueries().build();
        UserDAO userdao = database.userDAO();
        User user = new User();
        user.setUsername("test");
        user.setPassword("Test@1234");
        user.setPhone_number("0862065228");
        userdao.insert(user);
        List<User> thisuer = userdao.getAllUser();
        for (User u : thisuer) {
            Log.d("list",u.getUsername());
        }
    }
}