package com.example.recyclerview_with_listviewandcircleimageview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater layoutInflater;
    List<String> title;
    ArrayList<String> image;
    private Context context;

    public Adapter(Context context, ArrayList<String> titles, ArrayList<String> images) {
        this.title = titles;
        this.image = images;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custm_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context)
                .asBitmap()
                .load(image.get(position))
                .into(holder.imgV);
        holder.t1.setText(title.get(position));
        // handling the recyclerViews
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sending data to new activity
                Intent intent =new Intent(v.getContext(),SecondActivity.class);
                intent.putExtra("image",image.get(position));
                intent.putExtra("name",title.get(position));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return image.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView t1,t2;
        CircleImageView imgV;
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.text1);
            t2=itemView.findViewById(R.id.text2);
            imgV=itemView.findViewById(R.id.imgView);
            relativeLayout=itemView.findViewById(R.id.parent);

        }
    }
}
