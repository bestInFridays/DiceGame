package com.example.user.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Random;

public class diceSpin extends AppCompatActivity {

    private static int player = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_spin);

        TextView playertext = (TextView) findViewById(R.id.textView5);
        playertext.setText(String.format("Player " + player + " rolls."));

        Button start = (Button) findViewById(R.id.button3);
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /*declare animation*/
                final Animation anim1 = AnimationUtils.loadAnimation(diceSpin.this, R.anim.shakeanim);
                final Animation anim2 = AnimationUtils.loadAnimation(diceSpin.this, R.anim.shakeanim);
                final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                };

                anim1.setAnimationListener(animationListener);
                anim2.setAnimationListener(animationListener);

                int dice1 = 0;
                int dice2 = 0;

                Random random = new Random();

                dice1 = random.nextInt(6) + 1; /*randomly roll the dice*/

                /*All image.startAnimation(anim1); are for animation*/
                switch (dice1) {
                    case 1: {
                        ImageView image = (ImageView) findViewById(R.id.imageView1);
                        Resources res = getResources();
                        image.setImageDrawable(res.getDrawable(R.drawable.img1));
                        image.startAnimation(anim1);
                        break;
                    }
                    case 2: {
                        ImageView image = (ImageView) findViewById(R.id.imageView1);
                        Resources res = getResources();
                        image.setImageDrawable(res.getDrawable(R.drawable.img2));
                        image.startAnimation(anim1);
                        break;
                    }
                    case 3: {
                        ImageView image = (ImageView) findViewById(R.id.imageView1);
                        Resources res = getResources();
                        image.setImageDrawable(res.getDrawable(R.drawable.img3));
                        image.startAnimation(anim1);
                        break;
                    }
                    case 4: {
                        ImageView image = (ImageView) findViewById(R.id.imageView1);
                        Resources res = getResources();
                        image.setImageDrawable(res.getDrawable(R.drawable.img4));
                        image.startAnimation(anim1);
                        break;
                    }
                    case 5: {
                        ImageView image = (ImageView) findViewById(R.id.imageView1);
                        Resources res = getResources();
                        image.setImageDrawable(res.getDrawable(R.drawable.img5));
                        image.startAnimation(anim1);
                        break;
                    }
                    case 6: {
                        ImageView image = (ImageView) findViewById(R.id.imageView1);
                        Resources res = getResources();
                        image.setImageDrawable(res.getDrawable(R.drawable.img6));
                        image.startAnimation(anim1);
                        break;
                    }
                }

                dice2 = random.nextInt(6) + 1;
                switch (dice2) {
                    case 1: {
                        ImageView image = (ImageView) findViewById(R.id.imageView2);
                        Resources res = getResources();
                        image.setImageDrawable(res.getDrawable(R.drawable.img1));
                        image.startAnimation(anim2);
                        break;
                    }
                    case 2: {
                        ImageView image = (ImageView) findViewById(R.id.imageView2);
                        Resources res = getResources();
                        image.setImageDrawable(res.getDrawable(R.drawable.img2));
                        image.startAnimation(anim2);
                        break;
                    }
                    case 3: {
                        ImageView image = (ImageView) findViewById(R.id.imageView2);
                        Resources res = getResources();
                        image.setImageDrawable(res.getDrawable(R.drawable.img3));
                        image.startAnimation(anim2);
                        break;
                    }
                    case 4: {
                        ImageView image = (ImageView) findViewById(R.id.imageView2);
                        Resources res = getResources();
                        image.setImageDrawable(res.getDrawable(R.drawable.img4));
                        image.startAnimation(anim2);
                        break;
                    }
                    case 5: {
                        ImageView image = (ImageView) findViewById(R.id.imageView2);
                        Resources res = getResources();
                        image.setImageDrawable(res.getDrawable(R.drawable.img5));
                        image.startAnimation(anim2);
                        break;
                    }
                    case 6: {
                        ImageView image = (ImageView) findViewById(R.id.imageView2);
                        Resources res = getResources();
                        image.setImageDrawable(res.getDrawable(R.drawable.img6));
                        image.startAnimation(anim2);
                        break;
                    }

                }
                int playerscoreone=1;
                int playerscoretwo=1;

                SharedPreferences sp = getSharedPreferences("myScore", Context.MODE_PRIVATE); /*database to store scores*/

                if (dice1 == dice2) {
                    if(player==1){
                        SharedPreferences show = getSharedPreferences("myScore", Context.MODE_PRIVATE);
                        playerscoreone = show.getInt("score1",playerscoreone); /*load the current player's score*/

                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("score1",playerscoreone+1); /*if player 1 wins, add one point*/
                        editor.apply();

                        TextView viewscore = (TextView) findViewById(R.id.p1score);
                        viewscore.setText("Player 1: "+(playerscoreone)); /*place the score onto the text*/

                    }else{
                        SharedPreferences show = getSharedPreferences("myScore", Context.MODE_PRIVATE);
                        playerscoretwo = show.getInt("score2",playerscoretwo);

                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("score2",playerscoretwo+1); /*if player 2 wins, add one point*/
                        editor.apply();

                        TextView viewscore = (TextView) findViewById(R.id.p1score);
                        viewscore.setText("Player 2: "+(playerscoretwo));

                    }

                    for (int loops = 1; loops <= 10; loops++) /*keep the loop for rolling the dice until it hits the same dices*/
                        {
                        TextView myTextView = (TextView) findViewById(R.id.textView6);
                        myTextView.setVisibility(View.VISIBLE);

                        Button start = (Button) findViewById(R.id.button3);
                        start.setEnabled(false);

                        RelativeLayout wl = (RelativeLayout) findViewById(R.id.winlayout);
                        wl.setVisibility(View.VISIBLE); /*show the "win" layout*/

                        Button close = (Button) findViewById(R.id.button5);
                        close.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                try {
                                    RelativeLayout cl = (RelativeLayout) findViewById(R.id.winlayout);
                                    cl.setVisibility(View.INVISIBLE); /*hide the "win" layout*/

                                    Button changePlayer = (Button) findViewById(R.id.button6);
                                    changePlayer.setVisibility(View.VISIBLE);

                                    /*after click the "Continue" button, it switch to another player*/
                                    if (player == 1) {
                                        player=2;
                                    } else {
                                        player=1;
                                    }

                                    Button cp = (Button) findViewById(R.id.button6);
                                    cp.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) {
                                            try {
                                                /*continue the game after clicking "Continue" */
                                                Intent a = new Intent(diceSpin.this,diceSpin.class);
                                                startActivity(a);
                                            } catch (NullPointerException e) {
                                                throw new IllegalStateException("NULL", e);
                                            }
                                        }
                                    });
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }else{

                    /*if no dices are the same, switch player and refresh the roll*/
                    if(player==1){
                        Intent a = new Intent(diceSpin.this,diceSpin.class);
                        startActivity(a);
                        player=2;
                    }else{
                        Intent a = new Intent(diceSpin.this,diceSpin.class);
                        startActivity(a);
                        player=1;
                    }

                }

            }

        });
        SystemClock.sleep(500);

        /*go back to Menu*/
        Button back = (Button) findViewById(R.id.button4);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), diceGame.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                finish();
            }
        });
    }
}


