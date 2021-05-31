package com.example.videomaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.VideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<videomodel> videos;
ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        viewPager2=findViewById(R.id.viewpager);

        videos=new ArrayList<>();
        videomodel obj1=new videomodel("android.resource://"+getPackageName()+"/"+R.raw.videoa,"Title1","Video_1 desc");
        videos.add(obj1);
        videomodel obj2=new videomodel("android.resource://"+getPackageName()+"/"+R.raw.videob,"Title2","Video_2 desc");
        videos.add(obj2);
        videomodel obj3=new videomodel("android.resource://"+getPackageName()+"/"+R.raw.videoc,"Title3","Video_3 desc");
        videos.add(obj3);
        videomodel obj4=new videomodel("android.resource://"+getPackageName()+"/"+R.raw.videod,"Title4","Video_4 desc");
        videos.add(obj4);

viewPager2.setAdapter(new videoadapter(videos));
    }
}