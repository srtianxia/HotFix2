package com.srtianxia.fix;

import android.content.Context;
import java.io.File;

/**
 * Created by srtianxia on 2016/12/7.
 */

public class HotFix {
    public static void init(Context context) {
        File dexDir = new File(context.getFilesDir(), "hotfix");
        dexDir.mkdir();
    }
}
