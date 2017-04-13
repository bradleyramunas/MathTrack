package com.bradleyramunas.mathtrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import org.polaric.colorful.CActivity;
import org.polaric.colorful.ColorPickerDialog;
import org.polaric.colorful.Colorful;

public class SettingsActivity extends CActivity {

    private Button colorSelectButton;
    private ToggleButton nightmodeSelectButton;
    private Intent callingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        callingIntent = getIntent();
        colorSelectButton = (Button) findViewById(R.id.color_select_button);
        colorSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorPickerDialog dialog = new ColorPickerDialog(view.getContext());
                dialog.setOnColorSelectedListener(new ColorPickerDialog.OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(Colorful.ThemeColor themeColor) {
                        changeColor(themeColor);
                    }
                });
                dialog.show();
            }
        });
        nightmodeSelectButton = (ToggleButton) findViewById(R.id.nightmode_select_button);
        nightmodeSelectButton.setChecked(Colorful.getThemeDelegate().isDark());
        nightmodeSelectButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                enableDarkMode(b);
            }
        });
    }

    public void changeColor(Colorful.ThemeColor themeColor){
        MathTrack mathTrack = (MathTrack) getApplicationContext();
        mathTrack.ChangeColor(themeColor, callingIntent);
    }

    public void enableDarkMode(boolean enable){
        MathTrack mathTrack = (MathTrack) getApplicationContext();
        mathTrack.EnableDarkMode(enable, callingIntent);

    }

}
