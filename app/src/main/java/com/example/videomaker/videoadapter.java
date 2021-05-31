package com.example.videomaker;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class videoadapter extends RecyclerView.Adapter<videoadapter.myviewholder> {

    ArrayList<videomodel> videos;

    public videoadapter(ArrayList<videomodel> videos) {
        this.videos = videos;

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_video,parent,false);
        return new myviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
holder.setData(videos.get(position));
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
VideoView videoView;
        TextView title,desc;
        ProgressBar progressBar;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
        videoView=itemView.findViewById(R.id.videoView);
        title=itemView.findViewById(R.id.Title);
        desc=itemView.findViewById(R.id.desc);
        }
        void setData(videomodel obj){
            videoView.setVideoPath(obj.getUrl());
            title.setText(obj.getTitle());
            desc.setText(obj.getDesc());
            progressBar=itemView.findViewById(R.id.prograss_bar);
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    progressBar.setVisibility(itemView.INVISIBLE);
                    mp.start();
                }
            });
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });
        }
    }
}
