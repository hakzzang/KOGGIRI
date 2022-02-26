buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
        //7.2.0-beta02 올리면 버그 발생
        classpath("com.android.tools.build:gradle:7.2.0-beta01")
        classpath("com.squareup.sqldelight:gradle-plugin:1.5.0")
    }

    extra.apply {
        set("activity_compose_version", "1.5.0-alpha03")
        set("compose_version", "1.1.0-beta04")
        set("material3_version", "1.0.0-alpha02")
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