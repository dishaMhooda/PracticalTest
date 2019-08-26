package com.disha.albums.Databasae;

import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class DatabaseClient {
    private Context mContext;
    private AlbumDatabase albumDatabase;
    private static DatabaseClient mInstance;

    private DatabaseClient(Context context){
        this.mContext = context;
        albumDatabase = Room.databaseBuilder(mContext,AlbumDatabase.class,"Album").fallbackToDestructiveMigration().build();
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
        }
    };
    public static DatabaseClient getInstance(Context context){
        if(mInstance == null){
            mInstance = new DatabaseClient(context);
        }
        return mInstance;
    }

    public AlbumDatabase getAlbumDatabase(){
        return albumDatabase;
    }
}
