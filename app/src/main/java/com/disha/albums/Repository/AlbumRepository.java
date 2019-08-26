package com.disha.albums.Repository;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.disha.albums.Dao.AlbumDao;
import com.disha.albums.Databasae.AlbumDatabase;
import com.disha.albums.Databasae.DatabaseClient;
import com.disha.albums.Entity.Album;

import java.util.List;

public class AlbumRepository {

    private AlbumDao albumDao;
    private LiveData<List<Album>> albumList;

    public AlbumRepository(Application application){
        AlbumDatabase albumDatabase = DatabaseClient.getInstance(application).getAlbumDatabase();
        albumDao = albumDatabase.albumDao();
        albumList = albumDao.getAlbumList();
    }

   public LiveData<List<Album>> getAlbumList(){
        //albumList = albumDao.getAlbumList();
        return albumList;
    }


    public void insert(Album album){
        //albumDao.insertAll(album);
        new InsertAlbumAsynTask(albumDao, album).execute(album);
    }

    private static class InsertAlbumAsynTask extends AsyncTask<Album,Void,Void>{

        Album albumList;
        AlbumDao albumDao;
        InsertAlbumAsynTask(AlbumDao albumDao,Album albumList){
        this.albumDao = albumDao;
        this.albumList = albumList;
        }


        @Override
        protected Void doInBackground(Album... albums) {
            albumDao.insert(albums[0]);
            return null;
        }
    }
}
