package com.example.mytiket;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;
public class movieAdapter extends RecyclerView.Adapter<movieAdapter.movieViewHolder>{
    private Context mCtx;
    private int rowLayout;
    private List<movie>movieList;
    private ItemClickListener clickListener;
    public movieAdapter(Context mCtx, List<movie> movieList) {
        this.mCtx = mCtx;
        this.movieList = movieList;

    }

    @NonNull
    @Override
    public movieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.list_layout,null);
        movieViewHolder holder=new movieViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull movieViewHolder holder, int position) {
        movie movie=movieList.get(position);
        holder.textViewTitle.setText(movie.getTitle());
        holder.textViewlanguage.setText(movie.getLanguage());
        holder.textViewtype.setText(movie.getType());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(movie.getImage()));

    }

    @Override
    public int getItemCount() {
       return movieList.size();
    }


    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
    class movieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView textViewTitle,textViewlanguage,textViewtype;
        public movieViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewtype = itemView.findViewById(R.id.textViewtype);
            textViewlanguage = itemView.findViewById(R.id.textViewlanguage);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);


        }


        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition());
        }
    }

}
