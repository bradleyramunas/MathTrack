package com.bradleyramunas.mathtrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jakewharton.processphoenix.ProcessPhoenix;

import org.polaric.colorful.CActivity;
import org.polaric.colorful.ColorPickerDialog;
import org.polaric.colorful.Colorful;

public class MainActivity extends CActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.settings){
            ColorPickerDialog dialog = new ColorPickerDialog(this);
            dialog.setOnColorSelectedListener(new ColorPickerDialog.OnColorSelectedListener() {
                @Override
                public void onColorSelected(Colorful.ThemeColor themeColor) {
                    changeColor(themeColor);
                }
            });
            dialog.show();
            return true;
        }

        return false;
    }

    public void changeColor(Colorful.ThemeColor themeColor){
        MathTrack mathTrack = (MathTrack) getApplicationContext();
        mathTrack.ChangeColor(themeColor);
    }


}
