pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://grassmc-repo.s3.ap-southeast-1.amazonaws.com/")
    }
}

plugins {
    id("io.github.grassmc.infra") version "0.1.2"
}

rootProject.name = "kotlin-paper-plugin-template"
