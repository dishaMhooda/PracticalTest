package com.disha.albums.Databasae;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.disha.albums.Dao.AlbumDao;
import com.disha.albums.Entity.Album;

@Database(entities = {Album.class},version = 1 ,exportSchema = false)
public abstract class AlbumDatabase extends RoomDatabase {
    public abstract AlbumDao albumDao();
}
