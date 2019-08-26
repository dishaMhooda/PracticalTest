package com.disha.albums.API;

import com.disha.albums.Entity.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {
    @GET("albums")
    Call<List<Album>> getAlbums();
}
