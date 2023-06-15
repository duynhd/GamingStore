package com.example.prm_project.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.prm_project.data.dao.UserDAO;
import com.example.prm_project.data.models.User;


@Database(entities = {User.class}, version = 1)
public abstract class DAO extends RoomDatabase {
    public static final String DB_NAME = "GamingStore";
    public abstract UserDAO userDAO();
    private static DAO INSTANCE;
    public static synchronized DAO getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, DAO.class, DB_NAME).addCallback(
                    new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }

    public static final int DB_VERSION = 1;
}
