package com.example.myapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView pic1, pict,pic2,pic3,pic4,pic5;
    ImageView a1,a2,a3,a4,a5,a6,b1,b2,b3,b4,b5,b6,c1,c2,c3,c4,c5,c6,d1,d2,d3,d4,d5,d6,e1,e2,e3,e4,e5,e6;
    ImageView[] arr= new ImageView[5];
    ImageView[] arr3= new ImageView[3];
    ImageView[][] arr2= new ImageView[5][5];
    ImageButton btn_left, btn_right;
    RelativeLayout r;
    int index=2;
    int t =0;
    int row =0;
    int count=0;
    int rnd_number;
    boolean bol=true;
    public static boolean stopGame=false;
    int num_collision=0;
    ImageButton btn_pause;
    Chronometer chronometer;
    ImageView h1, h2,h3;
    Runnable myRun;
    static final Handler handler = new Handler();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = findViewById(R.id.r);
        btn_left = findViewById(R.id.btn_left);
        btn_right = findViewById(R.id.btn_right);
        btn_pause=findViewById(R.id.btn_pause);



        arr = new ImageView[]{findViewById(R.id.pic1), findViewById(R.id.pic2),
                findViewById(R.id.pic3), findViewById(R.id.pic4),
                findViewById(R.id.pic5)};
        arr2 = new ImageView[][]{{findViewById(R.id.a1), findViewById(R.id.a2), findViewById(R.id.a3), findViewById(R.id.a4),
                findViewById(R.id.a5)}, {findViewById(R.id.b1), findViewById(R.id.b2), findViewById(R.id.b3),
                findViewById(R.id.b4), findViewById(R.id.b5)}, {findViewById(R.id.c1), findViewById(R.id.c2),
                findViewById(R.id.c3), findViewById(R.id.c4), findViewById(R.id.c5)}, {findViewById(R.id.d1),
                findViewById(R.id.d2), findViewById(R.id.d3), findViewById(R.id.d4), findViewById(R.id.d5)}, {
                findViewById(R.id.e1), findViewById(R.id.e2), findViewById(R.id.e3), findViewById(R.id.e4),
                findViewById(R.id.e5)}
        };
        arr3= new ImageView[]{findViewById(R.id.h1),findViewById(R.id.h2),
        h3=findViewById(R.id.h3)};


        btn_pause.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                stopGame=true;
                //stop();
                PopActivity exNewEventDialog = new PopActivity();
                exNewEventDialog.show(getSupportFragmentManager(), "exe");

            }

        });
        Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);

        chronometer.start();

        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index==4)
                    index=0;
                else
                    index++;
                for(int i=0; i<5;i++)
                {
                    if(i==index)
                        arr[i].setVisibility(View.VISIBLE);
                    else
                        arr[i].setVisibility(View.INVISIBLE);
                }
            }
        });
        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index==0)
                    index=4;
                else
                    index--;
                for(int i=4; i>=0;i--)
                {
                    if(i==index)
                        arr[i].setVisibility(View.VISIBLE);
                    else
                        arr[i].setVisibility(View.INVISIBLE);

                }
            }
        });

        resetPlayer();
        resetBoard();
        rnd_number = getRnd();
       loopGame();

    }

    private int getRnd() {
        Random random = new Random();
        rnd_number = random.nextInt(5);
        return rnd_number;
    }
    public void stop(){
        handler.removeCallbacks(myRun);
    }
    private void loopGame() {
       if (stopGame == false) {
            myRun = new Runnable() {
                @Override
                public void run() {
                    loopGame();
                    t++;
                    play();
                }
            };
            handler.postDelayed(myRun, 500);
        }
    }

    private void play() {
            if(row == 5) {
            row = 0;
            rnd_number = getRnd();
        }
        setSqr();

            if(row == 4)
                if(collision()==0)
                {
                    if(num_collision<2) {
                        arr3[num_collision].setVisibility(View.INVISIBLE);
                        num_collision++;
                    }
                    else {
                        arr3[num_collision].setVisibility(View.INVISIBLE);
                        GameOver exNewEventDialog = new GameOver();
                        exNewEventDialog.show(getSupportFragmentManager(), "exe");
                        stop();
                    }

                }

        row++;
        }

    public int collision(){
        if(rnd_number==index)
            return 0;

        else
            return 1;
    }

    private void resetBoard() {
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {

                arr2[j][k].setVisibility(View.INVISIBLE);
            }
        }
    }

    private void resetPlayer() {
        for (int i = 0; i < 5; i++) {
            if (i == index)
                arr[i].setVisibility(View.VISIBLE);
            else
                arr[i].setVisibility(View.INVISIBLE);
        }
    }

    private void setSqr() {
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                if (k == row && j == rnd_number) {
                     arr2[j][k].setVisibility(View.VISIBLE);
                }
                else {
                    arr2[j][k].setVisibility(View.INVISIBLE);

                }
            }
        }
    }
}




