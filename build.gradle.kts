buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("com.android.tools.build:gradle:7.3.0-alpha07")
        classpath("com.squareup.sqldelight:gradle-plugin:1.5.3")
    }
    extra.apply {
        set("activity_compose_version", "1.5.0-alpha05")
        set("compose_version", "1.2.0-alpha07")
        set("material3_version", "1.0.0-alpha09")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}