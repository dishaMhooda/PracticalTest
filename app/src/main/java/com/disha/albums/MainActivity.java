package com.disha.albums;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.disha.albums.API.API;
import com.disha.albums.Adapters.AlbumListAdapter;
import com.disha.albums.Entity.Album;
import com.disha.albums.Service.Service;
import com.disha.albums.ViewModels.AlbumViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public Service retrofitService;
    public API apiCall;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        AlbumListAdapter albumListAdapter = new AlbumListAdapter(this);
        AlbumViewModel albumViewModel = ViewModelProviders.of(this).get(AlbumViewModel.class);
        albumViewModel.loadAlbums();
        albumViewModel.getAlbumList().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albumList) {
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(new AlbumListAdapter(albumList));
            }
        });


    }
}
