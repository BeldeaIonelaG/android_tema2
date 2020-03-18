package com.example.recyclerviewproject;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@androidx.room.Database(entities = {User.class}, version = 1)
public abstract class ADatabase extends RoomDatabase {
    private static ADatabase instance;

    public abstract UserDao userDao();

    public static synchronized ADatabase getInstance(Context context) {
               if (instance == null){
                   Builder<ADatabase> aDatabaseBuilder = Room.databaseBuilder(context.getApplicationContext(), ADatabase.class, "user" );
                   aDatabaseBuilder.fallbackToDestructiveMigration().addCallback(roomCallback);
                   instance = aDatabaseBuilder.build();
               }
               return instance;
    }

    private static RoomDatabase.Callback   roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class  PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private UserDao userDao;

        private PopulateDbAsyncTask(ADatabase db){
           userDao = db.userDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            userDao.insert(new User("Popescu Ioana", 8));
            userDao.insert(new User("Alexandrescu Maria", 5));
            userDao.insert(new User("Stefanescu George", 10));
            userDao.insert(new User("Petrescu Ioan", 2));
            userDao.insert(new User("Pseudonim Atena", 4));
            return null;
        }
    }
}
