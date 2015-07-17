package com.example.appbrewery.targettracker;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
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
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity{
    public TextView xData,yData;
    public ImageView indSpot;
    RelativeLayout.LayoutParams params;

    BluetoothAdapter btAdapter;

    public float x,y,dx=0,dy=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        pressLabel = (TextView) findViewById(R.id.pressIndic);
//        pressLabel.setText("Not Pressed.");
        indSpot = (ImageView) findViewById(R.id.indicatorView);
        xData = (TextView) findViewById(R.id.xPos);
        yData = (TextView) findViewById(R.id.yPos);

        btAdapter = BluetoothAdapter.getDefaultAdapter();
        if(btAdapter==null){
            Toast.makeText(getApplicationContext(),"No bluetooth detected",Toast.LENGTH_SHORT).show();
        }
        else{
            if(btAdapter.isEnabled()){
                Intent intent = new Intent((BluetoothAdapter.ACTION_REQUEST_ENABLE));
                startActivityForResult(intent,1);
            }
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
    public boolean onTouchEvent(MotionEvent ev){
        if(ev.getAction() == ev.ACTION_DOWN) {
            x = ev.getX();
            y = ev.getY();


            xData.setText(String.valueOf(x));
            yData.setText(String.valueOf(y));

            //Save this for later. Try to get wireless protocol for connection and data transfer first.
//            params = (RelativeLayout.LayoutParams) indSpot.getLayoutParams();
//            dx = ev.getRawX()-params.leftMargin;
//            dy = ev.getRawY()-params.topMargin;

//            indSpot.layout((int)x,(int)y, (int)dx, (int)dy);
//            indSpot.setVisibility(View.VISIBLE);
//
        }

      return true;
    }
}
