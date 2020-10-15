package com.tuki.data.io;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.tuki.data.entity.Notification;

@Database(entities = {
        Notification.class
}, version = 1, exportSchema = false)
public abstract class TukiDatabase extends RoomDatabase {


    private static volatile TukiDatabase INSTANCE;
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "tuki-database.db";


    public static TukiDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                            TukiDatabase.class, DATABASE_NAME).build();
                }
            }
        }
        return INSTANCE;
    }

    public void closeDatabase() {
        if (INSTANCE != null && INSTANCE.isOpen())
            INSTANCE.close();
    }

}
