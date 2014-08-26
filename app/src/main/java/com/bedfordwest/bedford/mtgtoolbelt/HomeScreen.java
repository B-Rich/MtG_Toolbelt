package com.bedfordwest.bedford.mtgtoolbelt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class HomeScreen extends Activity {

    public final static String EXTRA_MESSAGE = "com.bedfordwest.bedford.mtgtoolbelt.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Change the displayed life totals when the +/- buttons are pressed
    public void adjustLife(View v){

        //Get the current life totals from the EditText views and convert them to integers
        final EditText yourlifelabel = (EditText)findViewById(R.id.your_life);
        final EditText opponentlifelabel = (EditText)findViewById(R.id.opponent_life);
        int yourlife = Integer.parseInt(yourlifelabel.getText().toString());
        int opponentlife = Integer.parseInt(opponentlifelabel.getText().toString());

        //Determine which button was pressed
        switch (v.getId()) {
            case(R.id.plus_your_life):
                yourlife++;
                yourlifelabel.setText(String.valueOf(yourlife));
                break;
            case(R.id.minus_your_life):
                yourlife--;
                yourlifelabel.setText((String.valueOf(yourlife)));
                break;
            case(R.id.plus_opponent_life):
                opponentlife++;
                opponentlifelabel.setText(String.valueOf(opponentlife));
                break;
            case(R.id.minus_opponent_life):
                opponentlife--;
                opponentlifelabel.setText((String.valueOf(opponentlife)));
                break;
            default:
                Log.i("HomeScreen", "adjustLife() - unhandled button press received!");

        }

    }

    //Method to handle input from the create token buttons on the right side of the screen
    public void createToken(View v)
    {

        String tokenType = "";

        if(v.getId() == R.id.opponent_token_button)
            tokenType = "opponent";


        else if(v.getId() == R.id.your_token_button)
            tokenType = "your";

        //The user is going to be making a few choices when they create a token,
        //so we will send them to a new page to make those decisions.
        Intent intent = new Intent(v.getContext(), TokenCreationActivity.class);
        intent.putExtra(EXTRA_MESSAGE, tokenType); //pass the token type to the activity as a string
        startActivity(intent);

    }

}
