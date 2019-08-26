package com.disha.albums.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.disha.albums.API.API;
import com.disha.albums.Adapters.AlbumListAdapter;
import com.disha.albums.Entity.Album;
import com.disha.albums.MainActivity;
import com.disha.albums.Repository.AlbumRepository;
import com.disha.albums.Service.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumViewModel extends AndroidViewModel {

    public Service retrofitService;
    public API apiCall;

    private AlbumRepository albumRepository;

    private LiveData<List<Album>> albumList;
    public AlbumViewModel(@NonNull Application application) {
        super(application);
        albumRepository = new AlbumRepository(application);
        albumList = albumRepository.getAlbumList();
    }

    public LiveData<List<Album>> getAlbumList(){
        return albumList;
    }

    public void insert(Album album){
        albumRepository.insert(album);
    }

    public void loadAlbums(){
        apiCall = Service.getRetrofitInstance().create(API.class);
        final Call<List<Album>> albumList = apiCall.getAlbums();

        albumList.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                System.out.println("CA:::: "+response.body());
                for (int i = 0 ; i<response.body().size();i++){
                    insert(response.body().get(i));
                }


            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });


    }
}
