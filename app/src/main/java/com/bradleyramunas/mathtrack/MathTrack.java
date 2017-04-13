package com.bradleyramunas.mathtrack;


import android.app.Application;
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

    public void ChangeColor(Colorful.ThemeColor themeColor) {
        Colorful.config(this)
                .primaryColor(themeColor)
                .accentColor(themeColor)
                .dark(false)
                .apply();
        ProcessPhoenix.triggerRebirth(this);
    }
}
