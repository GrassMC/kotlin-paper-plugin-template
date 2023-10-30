import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun Project.prop(propName: String) = providers.gradleProperty(propName)

plugins {
    alias(libs.plugins.org.jetbrains.kotlin.jvm)
    alias(libs.plugins.io.github.grassmc.paperDev)
}

group = prop("group").get()
version = prop("version").get()
description = prop("description").get()

pluginYml {
    // https://github.com/GrassMC/paper-dev-gradle-plugin/issues/2
    main = "io.github.grassmc.template.KotlinPaperPlugin"
    // https://github.com/GrassMC/paper-dev-gradle-plugin/issues/3
    version = project.version as String
}

val jdkVersion = prop("jdk.version")
kotlin {
    jvmToolchain {
        languageVersion = jdkVersion.map { JavaLanguageVersion.of(it) }
        vendor = JvmVendorSpec.AZUL
    }
}

tasks {
    withType<KotlinCompile> {
        compilerOptions.jvmTarget = jdkVersion.map { JvmTarget.fromTarget(it) }
    }
}
