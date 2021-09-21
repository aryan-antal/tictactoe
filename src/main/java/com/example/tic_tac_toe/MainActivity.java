package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive=true;

    //player Representation
    //0--x
    //1--0

    int activePlayer=0;
    int[] gameState={2, 2, 2, 2, 2, 2, 2, 2, 2};
    //state meaning
    //0--x
    //1--0
    //2--null

    int[][] winPositions={{0,1,2},{3,4,5},{6,7,8},
                        {0,3,6},{1,4,7},{2,5,8},
                        {0,4,8},{2,4,6}};



    public void playerTap(View view){
        ImageView img =(ImageView) view;
        int tapedImage = Integer.parseInt(img.getTag().toString());
        if (!gameActive)
            {
                 gameReset(view);
            }

        if (gameState[tapedImage]==2) {
            gameState[tapedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.ttt4);
                activePlayer = 1;
                TextView Status=findViewById(R.id.textView2);
                Status.setText("O's turn--Tap to play");
            } else {
                img.setImageResource(R.drawable.ttt3);
                activePlayer = 0;
                TextView Status=findViewById(R.id.textView2);
                Status.setText("X's turn--Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        //check if any player won
        for (int[] winPosition:winPositions)
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    (gameState[winPosition[1]] == gameState[winPosition[2]]) &&
                    (gameState[winPosition[0]] != 2)) {
                //somebody has won ! - find out who?
                String WinnerStr;
                gameActive = false;
                if (activePlayer==1) {
                    WinnerStr = "0 has won";
                } else {

                    WinnerStr = "X has won";
                }
                // update the status bar for Winner announcement

                TextView Status = findViewById(R.id.textView2);
                Status.setText(WinnerStr);

            }

    }


    public void gameReset(View view)
    {
        gameActive=true;
        activePlayer=0;
        for (int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        ( (ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ( (ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ( (ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ( (ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ( (ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ( (ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ( (ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ( (ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ( (ImageView)findViewById(R.id.imageView10)).setImageResource(0);
        TextView Status=findViewById(R.id.textView2);
        Status.setText("O's turn--Tap to play");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}