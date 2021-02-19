package com.example.dicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.util.Log;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // we have two images left dice and right dice
        // link the code to those two image view inside your layout.....(activity main)
        final ImageView userDie = findViewById(R.id.User_dice);
        final ImageView computerDie = findViewById(R.id.Computer_dice);
        final TextView textView=findViewById(R.id.result_id);
        Button higherButton = findViewById(R.id.higher_button);
        Button lowerButton = findViewById(R.id.lower_button);

        //-------------------------------------------------------------------

        final int [] diceArray = {R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6};
        // we want to pick one of the dices in array randomly and replace it with left and right
        // image view inside your app!
        // Click listener look for an event on your view components.
       higherButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Random rand = new Random();
               int randUserDie = rand.nextInt(6);
               int randComputerDie = rand.nextInt(6);
               Log.d("user die",String.valueOf(randUserDie));
               Log.d("computer die",String.valueOf(randComputerDie));
               // the bigger number will be displayed in the
               // textView as the winner otherwise draw..
               if (randUserDie> randComputerDie) {
                   textView.setText("WINNER : USER");
               } else if (randComputerDie> randUserDie) {
                   textView.setText("WINNER : COMPUTER");
               } else {
                   textView.setText("RESULT : IT'S A TIE");
               }
               userDie.setImageResource(diceArray[randUserDie]);
               computerDie.setImageResource(diceArray[randComputerDie]);
               // we need to create a random integer for picking the dices randomly!


           }
       });
        lowerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rand = new Random();
                int randUserDie = rand.nextInt(6);
                int randComputerDie = rand.nextInt(6);
                Log.d("user die",String.valueOf(randUserDie));
                Log.d("computer die",String.valueOf(randComputerDie));
                // the bigger number will be displayed in the
                // textView as the winner otherwise draw..
                if (randUserDie< randComputerDie) {
                    textView.setText("RESULT : USER WINNER");
                } else if (randComputerDie< randUserDie) {
                    textView.setText("RESULT : COMPUTER WINNER");
                } else {
                    textView.setText("RESULT : IT'S A TIE");
                }
                userDie.setImageResource(diceArray[randUserDie]);
                computerDie.setImageResource(diceArray[randComputerDie]);
                // we need to create a random integer for picking the dices randomly!


            }
        });
    }



}
