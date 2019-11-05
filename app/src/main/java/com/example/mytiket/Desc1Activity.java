package com.example.mytiket;
import java.util.*;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class Desc1Activity extends AppCompatActivity implements ItemClickListener{
    RecyclerView recyclerView;
    movieAdapter adapter;
    List<movie>movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc1);
        movieList=new ArrayList<>();
        recyclerView=(RecyclerView)findViewById(R.id.descrecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieList.add(
                new movie(
                        1,
                        "The Toy Story 4",
                        "English,Hindi",
                        "U/A",
                        R.drawable.toystory4));

        movieList.add(
                new movie(
                        2,
                        "Chhichhore",
                        "Hindi",
                        "U/A,U",
                        R.drawable.chhichhore));

        movieList.add(
                new movie(
                        3,
                        "The Joya",
                        "Hindi,Tamil",
                        "U",
                        R.drawable.the_joya));

         movieList.add(
                new movie(
                        4,
                        "Dream Girl",
                        "Hindi",
                        "U/A",
                        R.drawable.dream_girl));
        //creating recyclerview adapter
        movieAdapter adapter = new movieAdapter(this, movieList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        // The onClick implementation of the RecyclerView item click
        final movie movie1 = movieList.get(position);
        Intent i = new Intent(this,MovieActivity.class);
        i.putExtra("movieTitle", movie1.getTitle());
        i.putExtra("movieType", movie1.getType());
        i.putExtra("movieLanguage", movie1.getLanguage());
        startActivity(i);

    }
}
