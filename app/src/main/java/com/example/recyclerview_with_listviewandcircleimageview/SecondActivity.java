package com.example.recyclerview_with_listviewandcircleimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class SecondActivity extends AppCompatActivity {
    CircleImageView circleImageView;
    TextView textView;
    String imageurl;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        circleImageView = (CircleImageView) findViewById(R.id.circleImageView2);
        textView = (TextView) findViewById(R.id.textView);
        getIncomingIntent();
    }
    //receiving the date from the intent you can do it directly without methods inside the onCreate() method
    private void getIncomingIntent(){
        if(getIntent().hasExtra("image")&& getIntent().hasExtra("name")){
            String imageurl = getIntent().getStringExtra("image");
            String name =getIntent().getStringExtra("name");
            setImage(imageurl,name);
        }
    }
        // seting the data neme and image in the activity
    private void setImage(String imageurl,String name){
        textView.setText(name);
        Glide.with(this)
                .asBitmap()
                .load(imageurl)
                .into(circleImageView);
    }

}
