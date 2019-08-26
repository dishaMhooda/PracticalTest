package com.disha.albums.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.disha.albums.Entity.Album;

import java.lang.annotation.Target;
import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface AlbumDao {

    @Query("Select * from Album order by title ASC")
    LiveData<List<Album>> getAlbumList();


    //void insert(List<Album> album);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Album user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Album user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Album> album);
}
