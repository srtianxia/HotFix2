package com.srtianxia.hotfix;

import android.app.Application;
import com.srtianxia.fix.Nuwa;

/**
 * Created by srtianxia on 2016/12/7.
 */

public class HotFixApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();
        Nuwa.init(this);
    }
}
