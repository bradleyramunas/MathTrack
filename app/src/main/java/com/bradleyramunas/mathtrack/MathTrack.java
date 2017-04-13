package com.bradleyramunas.mathtrack;


import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.jakewharton.processphoenix.ProcessPhoenix;

import org.polaric.colorful.Colorful;

/**
 * Created by Bradley on 4/12/2017.
 */

public class MathTrack extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Colorful.defaults()
                .primaryColor(Colorful.ThemeColor.DEEP_PURPLE)
                .accentColor(Colorful.ThemeColor.DEEP_ORANGE)
                .translucent(false)
                .dark(true);
        Colorful.init(this);
    }

    public void ChangeColor(Colorful.ThemeColor themeColor, Intent callingIntent) {
        Colorful.config(this)
                .primaryColor(themeColor)
                .accentColor(themeColor)
                .apply();
        ProcessPhoenix.triggerRebirth(this, callingIntent);
    }

    public void EnableDarkMode(boolean enable, Intent callingIntent){
        if(enable){
            Colorful.config(this)
                    .dark(true)
                    .apply();
        }else{
            Colorful.config(this)
                    .dark(false)
                    .apply();
        }
        ProcessPhoenix.triggerRebirth(this, callingIntent);
    }
}
