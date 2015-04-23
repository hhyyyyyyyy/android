package com.example.be127_mac.bacon;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;



public class fin extends ActionBarActivity {
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            TextView bucky = (TextView) findViewById(R.id.bucky);
            bucky.setText("Woo!");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
    }

    public void clickBuckk(View view){
        long futureTime = System.currentTimeMillis() + 1000;
        while (System.currentTimeMillis() < futureTime){
            synchronized (this){
                try {
                    wait(futureTime-System.currentTimeMillis());

                }catch(Exception e){}
            }

        }
        TextView bucky = (TextView) findViewById(R.id.bucky);
        bucky.setText("Made i!");
    }


    public void sendOutBrodcast(View view){
        Intent i = new Intent();
        i.setAction("com.thenewboston.sendbroadcast");
        i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(i);

    }

    public void onClick(View view){
        Intent i = new Intent(this, booo.class);


        final EditText hel = (EditText) findViewById(R.id.hel);

        String userMessage = hel.getText().toString();
        i.putExtra("appppp", userMessage);
        startActivity(i);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fin, menu);
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
}
