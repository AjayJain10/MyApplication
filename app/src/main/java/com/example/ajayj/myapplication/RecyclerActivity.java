package com.example.ajayj.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {
    RecyclerView.LayoutManager layoutManager,layoutManager1;
    RecyclerView recycleview;

    CarouselView carouselView;

    int[] sampleImages = {R.drawable.download, R.drawable.download1, R.drawable.download2, R.drawable.download3, R.drawable.download4};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recycleview= (RecyclerView) findViewById(R.id.recyclerid);


        carouselView = (CarouselView) findViewById(R.id.corousel);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        });



        GridLayoutManager gridlayoutmanager=new GridLayoutManager(this,2);
        layoutManager=new LinearLayoutManager(this);

        layoutManager1=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true);

        //HORIZONTAL

        recycleview.setLayoutManager(gridlayoutmanager);
        recycleview.setLayoutManager(layoutManager);

        recycleview.setLayoutManager(layoutManager1);


        recycleview.setHasFixedSize(true);

        recycleview.setItemAnimator(new DefaultItemAnimator());


        ArrayList<BMSEntites> bmsEntites1 = new ArrayList<>();
        String[] title = {"Abcd", "Tiger", "DJ", "Bangalore Days", "Sairaat","Abcd", "Tiger", "DJ", "Bangalore Days", "Sairaat"};
        String[] language = {"Hindi", "Kannada", "Telugu", "Malayalam", "Marati","Hindi", "Kannada", "Telugu", "Malayalam", "Marati"};
        Integer[] coverphotos={R.drawable.download,R.drawable.download1,R.drawable.download4,R.drawable.download2,R.drawable.download3,R.drawable.download,R.drawable.download1,R.drawable.download4,R.drawable.download2,R.drawable.download3};
        for (int i = 0; i < title.length; i++) {
            BMSEntites bmsEntites = new BMSEntites();
            bmsEntites.setLanguage(language[i]);
            bmsEntites.setTitle(title[i]);
            bmsEntites.setImage(coverphotos[i]);
            bmsEntites1.add(bmsEntites);
        }

        RecyclerView.Adapter recyclerViewAdapter = new BMSAdapter(bmsEntites1);
        recycleview.setAdapter(recyclerViewAdapter);

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(RecyclerActivity.this, "Clicked item: "+ position, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
