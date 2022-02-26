plugins {
    id("com.android.application")
    kotlin("android")
}
val activityComposeVersion = rootProject.extra["activity_compose_version"]
val composeVersion = rootProject.extra["compose_version"]
val material3Version = rootProject.extra["material3_version"]

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.hbs.koggiri"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
        isCoreLibraryDesugaringEnabled = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=all")
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion.toString()
    }
}

dependencies {
    implementation(project(":shared"))

    implementation("androidx.core:core-ktx:1.7.0")

    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("androidx.navigation:navigation-compose:2.5.0-alpha03")

    implementation("androidx.compose.material3:material3:$material3Version")
    implementation("androidx.compose.material:material:1.2.0-alpha04")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation("androidx.activity:activity-compose:$activityComposeVersion")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")

    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

}