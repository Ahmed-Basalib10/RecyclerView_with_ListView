package com.example.recyclerview_with_listviewandcircleimageview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<String> titles= new ArrayList<>();
    ArrayList<String> status= new ArrayList<>();
    ArrayList<String> images=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.recycler_view);

        // loading the data for imageView from the internet
        // loading the data for textView from her only
        images.add("https://image.freepik.com/free-vector/white-phone-icon_23-2147627279.jpg");
        titles.add("Havasu Falls");

        images.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        titles.add("Trondheim");

        images.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        titles.add("Portugal");

        images.add("https://i.redd.it/j6myfqglup501.jpg");
        titles.add("Rocky Mountain National Park");


        images.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        titles.add("Mahahual");

        images.add("https://i.redd.it/k98uzl68eh501.jpg");
        titles.add("Frozen Lake");


        images.add("https://i.redd.it/glin0nwndo501.jpg");
        titles.add("White Sands Desert");

        images.add("https://i.redd.it/obx4zydshg601.jpg");
        titles.add("Austrailia");

        images.add("https://i.imgur.com/ZcLLrkY.jpg");
        titles.add("Washington");

        recyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        // specify the type of layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //passing the data to the adapter
        adapter=new Adapter(this,titles,images);
        recyclerView.setAdapter(adapter);
    }
}
