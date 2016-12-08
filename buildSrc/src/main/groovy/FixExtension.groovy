package com.srtianxia.hotfix

import groovy.transform.CompileStatic
import org.gradle.api.Project
import org.gradle.api.tasks.Input

@CompileStatic
class FixExtension {
    @Input
    String version;

    static FixExtension getConfig(Project project) {
        FixExtension config = project.getExtensions().findByType(FixExtension.class);
        if (config == null) {
            config = new FixExtension();
        }
        return config;
    }
}