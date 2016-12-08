package com.srtianxia.hotfix

import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.api.ApplicationVariant
import com.android.build.gradle.api.BaseVariant
import org.gradle.api.DomainObjectCollection
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.internal.DefaultDomainObjectSet

class FixPlugin implements Plugin<Project> {
    private static final String EXTENSION_NAME = "fix"
    private static final String FIX_DIR = "fix"
    private static final String VERSION = "version"
    private static final String DIVIDE = "_"
    private static final String PATCH_DIR = "patch"

    private static final String MAPPING_TXT = "mapping.txt"
    private static final String HASH_TXT = "hash.txt"

    @Override
    void apply(Project project) {
        def android = project.extensions.findByType(AppExtension)
        android.registerTransform(new FixTransform(project))
        //        DefaultDomainObjectSet<ApplicationVariant> variants
        //        if (project.getPlugins().hasPlugin(AppPlugin)) {
        //            variants = project.android.applicationVariants
        //            project.extensions.create(EXTENSION_NAME, FixExtension)
        //            applyTask(project, variants)
        //        }
        //        def android = project.extensions.findByType(AppExtension)
        //        android.registerTransform(new FixTransform())
    }

    private void applyTask(Project project, DomainObjectCollection<BaseVariant> variants) {
        project.afterEvaluate {
            variants.each { variant ->
                def fixRootDir = new File(
                        "${project.projectDir}${File.separator}${FIX_DIR}${File.separator}${VERSION}${DIVIDE}${variant.getVersionCode()}")
                if (!fixRootDir.exists()) fixRootDir.mkdirs()

                def dirName = variant.dirName

                def outputDir = new File("${fixRootDir}${File.separator}${dirName}")
                if (!outputDir.exists()) outputDir.mkdirs()

                def patchDir = new File("${fixRootDir}${File.separator}${PATCH_DIR}")
                if (!patchDir.exists()) patchDir.mkdirs()
            }
        }
    }

    private void applyMapping() {}
}