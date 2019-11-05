package com.example.mytiket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.CardView;
import android.view.*;
import android.content.*;
public class HomeActivity extends AppCompatActivity {
    ViewFlipper v_flipper;


    int[] images={
            R.drawable.movie1,
            R.drawable.movie2,
            R.drawable.movie3,
            R.drawable.movie4,
            R.drawable.movie5

    };
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        v_flipper=findViewById(R.id.flippervw);
        for(int i=0;i<images.length;i++){
            flip_image(images[i]);

        }

    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

// Handle item selection
        switch (item.getItemId()) {
            case R.id.addtocart:

                Toast.makeText(HomeActivity.this, "clicking on add to cart", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.signin:
                Intent homeIntent=new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(homeIntent);
                finish();
                Toast.makeText(HomeActivity.this, "clicking on login", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void flip_image(int i) {
        ImageView view=new ImageView(this);
        view.setBackgroundResource(i);
        v_flipper.addView(view);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }
    public void card1(View v) {
        Intent intent = new Intent(HomeActivity.this, Desc1Activity.class);
        startActivity(intent);
    }

}
