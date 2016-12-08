package com.srtianxia.hotfix

import com.android.build.gradle.api.BaseVariant
import org.gradle.api.Project

class DexUtils {
    public static def getPerDexTask(Project project, BaseVariant variant) {
        return project.tasks.findByName("preDex${variant.name.capitalize()}")
    }

    public static def getDexTask(Project project, BaseVariant variant) {
        return project.tasks.findByName("dex${variant.name.capitalize()}")
    }

    public static def getProGuardTask(Project project, BaseVariant variant) {
        return project.tasks.findByName("proguard${variant.name.capitalize()}")
    }
}