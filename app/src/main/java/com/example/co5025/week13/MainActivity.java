package com.example.co5025.week13;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtSwaps;
    Button butReset;
    Button butBubble;
    Button butMerge;

    public static final int ARRAY_SIZE = 100;
    TextView[] tblUnsorted = new TextView[ARRAY_SIZE];
    TextView[] tblSorted = new TextView[ARRAY_SIZE];
    int[] numbers = new int[ARRAY_SIZE];
    NumberFormat d = new DecimalFormat("00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        txtSwaps = (TextView) findViewById(R.id.tot_swaps);
        butReset = (Button) findViewById(R.id.reset);
        butBubble = (Button) findViewById(R.id.bubble);
        butMerge = (Button) findViewById(R.id.merge);
        butReset.setOnClickListener(this);
        butBubble.setOnClickListener(this);
        butMerge.setOnClickListener(this);

        for (int i = 1; i <= ARRAY_SIZE; i++){
            String textID = "TextView" + i;
            int resID = getResources().getIdentifier(textID,"id", getPackageName());
            tblUnsorted[i-1] = ((TextView) findViewById(resID));
        }

        for (int i = 1; i <= ARRAY_SIZE; i++){
            String textID = "TextView" + (ARRAY_SIZE + i);
            int resID = getResources().getIdentifier(textID,"id", getPackageName());
            tblSorted[i-1] = ((TextView) findViewById(resID));
        }
        displayTable(tblUnsorted);
    }

    void displayTable (TextView[] table){
        for (int i = 0; i < ARRAY_SIZE; i++){
            table[i].setText(d.format(numbers[i]));
        }
    }

    void clearTable (TextView[] table){
        for (int i = 0; i < ARRAY_SIZE; i++){
            table[i].setText("");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.merge:
                break;
            case R.id.bubble:
                break;
            case R.id.reset:
                for (int i = 0; i < ARRAY_SIZE; i++){
                    numbers[i] = 1 + (int) (Math.random() * 99);
                }
                clearTable(tblSorted);
                break;
        }
    }
}
