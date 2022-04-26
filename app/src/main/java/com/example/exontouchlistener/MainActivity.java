package com.example.exontouchlistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView im;
    float xInitial;
    int[] mesImages = {R.drawable.img1, R.drawable.img2, R.drawable.img3,R.drawable.img4};
    int pos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        im = findViewById(R.id.img);

        im.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                int action = motionEvent.getAction();

                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        xInitial = motionEvent.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        float xFinal = motionEvent.getX();

                        if(xInitial<xFinal){
                            pos--;
                        }else
                            pos++;

                        if(pos<0)
                            pos=0;
                        else if(pos == mesImages.length)
                            pos = mesImages.length-1;

                        im.setImageResource(mesImages[pos]);
                        break;
                }


                return true;
            }
        });
    }
}