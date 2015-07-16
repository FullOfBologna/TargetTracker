package com.example.appbrewery.targettracker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity implements View.OnTouchListener {
    public TextView pressLabel;
    public ImageView indSpot;
    public float x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        pressLabel = (TextView) findViewById(R.id.pressIndic);
//        pressLabel.setText("Not Pressed.");
        indSpot = (ImageView) findViewById(R.id.indicatorView);

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
    public boolean onTouch(View v, MotionEvent ev){
        if(ev.getAction() == ev.ACTION_DOWN) {
            x = ev.getX();
            y = ev.getY();
            indSpot.layout((int)x,(int)y, 200, 200); 
            indSpot.setVisibility(View.VISIBLE);
        }

      return true;
    }
}
