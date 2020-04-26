package com.samyak.tictactoe;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int active = 0;
    int[] game = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningpostions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean gameisactive = true;

    public void dropin(View view) {

        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1000f);

        counter.getTag();
        int tappedcounter = Integer.parseInt(counter.getTag().toString());
        
        if (game[tappedcounter] == 2 && gameisactive) {
            game[tappedcounter] = active;

            counter.setTranslationY(-1000f);
            if (active == 0) {
                counter.setImageResource(R.drawable.tac);
                active = 1;
            } else if (active == 1) {

                counter.setImageResource(R.drawable.toe);
                active = 0;
            }

            counter.animate().translationYBy(1000f).rotation(360f).setDuration(300);
        }

        for (int winningpostion[] : winningpostions) {
            if (game[winningpostion[0]] == game[winningpostion[1]] &&
                    game[winningpostion[1]] == game[winningpostion[2]] &&
                    game[winningpostion[0]] != 2) {



                // someone has won
                gameisactive = false;
                String winner = "CIRCLE";
                if (game[winningpostion[0]] == 0) {
                    winner = "CROSS";
                }

                TextView winnermessage = (TextView) findViewById(R.id.winnermessage);
                winnermessage.setText(winner + " Has Won");


                LinearLayout layout = (LinearLayout) findViewById(R.id.playagainlayout);

                layout.setVisibility(View.VISIBLE);


            } else {
                boolean gameisover = true;

                for (int counterstate : game) {

                    if (counterstate == 2)
                        gameisover = false;
                }
                if (gameisover) {
                    TextView winnermessage = (TextView) findViewById(R.id.winnermessage);
                    winnermessage.setText("It's a draw ");

                    LinearLayout layout = (LinearLayout) findViewById(R.id.playagainlayout);

                    layout.setVisibility(View.VISIBLE);


                }


            }

        }
    }
     /*   public void playme(View view) {

        gameisactive = true;
        LinearLayout layout = (LinearLayout) findViewById(R.id.playagainlayout);

        layout.setVisibility(View.INVISIBLE);
        active = 0;

        for (int i = 0; i < game.length; i++) {

            game[i] = 2;
        }

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridlayout);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
