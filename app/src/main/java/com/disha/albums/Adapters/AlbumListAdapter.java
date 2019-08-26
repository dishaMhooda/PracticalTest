package com.disha.albums.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.disha.albums.Entity.Album;
import com.disha.albums.R;

import java.util.List;

public class AlbumListAdapter extends RecyclerView.Adapter<AlbumListAdapter.CustomViewHolder>  {

    private List<Album> albumList;

    public AlbumListAdapter(Context context){

    }

    public AlbumListAdapter(List<Album> album){
        albumList = album;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.album_list,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.txtAlbumName.setText(albumList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

      public TextView txtAlbumName;

     public CustomViewHolder(@NonNull View itemView) {
         super(itemView);
         txtAlbumName = itemView.findViewById(R.id.txtAlbumName);
     }
 }

}
