package com.example.colors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        //activa la flecha en el actionbar
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //finaliza la actividad y devuelve a la anterior
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
