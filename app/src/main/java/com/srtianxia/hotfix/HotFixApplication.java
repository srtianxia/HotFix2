package com.srtianxia.hotfix;

import android.app.Application;
import android.os.Environment;

import com.srtianxia.fix.HotPatch;

/**
 * Created by srtianxia on 2016/12/7.
 */

public class HotFixApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();
        HotPatch.init(this);
        String dexPath = Environment.getExternalStorageDirectory().getAbsolutePath().concat("/patch_dex.jar");
        HotPatch.inject(dexPath);
    }
}
