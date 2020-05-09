package com.example.colors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Palette extends AppCompatActivity
        implements SeekBar.OnSeekBarChangeListener {

    private SeekBar vRed = null;
    private SeekBar vGreen = null;
    private SeekBar vBlue = null;
    private SeekBar vAlpha = null;
    private View vFilter = null;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        message = findViewById(R.id.txtMessage);
        //Code here .....
        //Get components' id's
        vRed = findViewById(R.id.sbrRed);
        vGreen = findViewById(R.id.sbrGreen);
        vBlue = findViewById(R.id.sbrBlue);
        vAlpha = findViewById(R.id.sbrAlpha);
        vFilter = findViewById(R.id.vieColors);

        vRed.setOnSeekBarChangeListener(this);
        vGreen.setOnSeekBarChangeListener(this);
        vBlue.setOnSeekBarChangeListener(this);
        vAlpha.setOnSeekBarChangeListener(this);

        //Show the context menu WHEN I do a long press in the component
        registerForContextMenu(vFilter);
    }

    //#############################################
    //OPTIONS MENU
    //#############################################
    //Show the options menu on the Device.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Item actions.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.icHelp :
                Intent intent = new Intent(this, HelpActivity.class);
                startActivity(intent);
                break;

            case R.id.icTransparent :

                vAlpha.setProgress(0);
                break;

            case R.id.iteTransparent :
                Toast.makeText(this, "This color is going to change", Toast.LENGTH_SHORT).show();
                vAlpha.setProgress(0);
                message.setText("Transparent ");
                break;
            //Toast.makeText(this, "This color is going to change", Toast.LENGTH_SHORT).show();

            case R.id.iteSemitransparent :
                vAlpha.setProgress(128);
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                message.setText("Semitransparent");
                break;

            case R.id.iteOpaque :
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                vAlpha.setProgress(255);
                message.setText("Opaque");
                break;

            case R.id.iteBlack :
                vAlpha.setProgress(255);
                message.setText("Black");
                break;

            case R.id.iteWhite :
                vRed.setProgress(255);
                vGreen.setProgress(255);
                vBlue.setProgress(255);
                vAlpha.setProgress(128);
                message.setText("White");
                break;

            case R.id.iteRed :
                vRed.setProgress(255);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                message.setText("Red");
                break;

            case R.id.iteGreen :
                //Change color to green
                vRed.setProgress(0);
                vGreen.setProgress(255);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                message.setText("Green");
                break;

            case R.id.iteBlue :
                //Change color to blue
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(255);
                vAlpha.setProgress(128);
                message.setText("Blue");
                break;

            case R.id.iteCyan :
                vRed.setProgress(0);
                vGreen.setProgress(160);
                vBlue.setProgress(255);
                vAlpha.setProgress(128);
                message.setText("Cyan");
                break;

            case R.id.iteMagenta :
                vRed.setProgress(255);
                vGreen.setProgress(0);
                vBlue.setProgress(255);
                vAlpha.setProgress(128);
                message.setText("Magenta");
                break;

            case R.id.iteYellow :
                vRed.setProgress(255);
                vGreen.setProgress(255);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                message.setText("Yellow");
                break;

            case R.id.iteReset :
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                vAlpha.setProgress(0);
                break;

            case R.id.iteAboutof :
                //Go/jump to Aboutof Activity
            Intent intent2 = new Intent(this, AboutofActivity.class);
            startActivity(intent2);
            break;
            case  R.id.iteClose:
                Palette.this.finish();
                System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }


    //#############################################
    //CONTEXT MENU
    //#############################################


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater2 = getMenuInflater();
        inflater2.inflate(R.menu.menu2, menu);
    }

    @Override
        public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.iteHelp :
                Intent intent = new Intent(this,HelpActivity.class);
                startActivity(intent);
                break;
            case R.id.iteRed :
                vRed.setProgress(255);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                break;
            case R.id.iteReset:
                vAlpha.setProgress(0);
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                break;
        }

        return super.onContextItemSelected(item);
    }

    //#############################################
    //SEEKBARS
    //#############################################
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean bo) {
        //1. Get Seekbar values
        int r = vRed.getProgress();
        int g = vGreen.getProgress();
        int b = vBlue.getProgress();
        int a = vAlpha.getProgress();

        //2. Convert values (in step 1) to ARGB function
        int filter_color = Color.argb(a,r,g,b); //Alpha, Red, Green, Blue

        /*
        int filter_color = Color.argb(
            vRed.getProgress(),
            vGreen.getProgress(),
            vBlue.getProgress(),
            vAlpha.getProgress()
        );
        */

        //3. Set the new color to Image (View)
        vFilter.setBackgroundColor(filter_color);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
