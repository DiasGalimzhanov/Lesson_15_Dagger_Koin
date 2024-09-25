plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.lesson_15_dagger_koin"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.lesson_15_dagger_koin"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    annotationProcessor("com.google.dagger:dagger-compiler:2.52")
    implementation("com.google.dagger:dagger:2.52")
//    implementation("com.squareup.retrofit2:retrofit:2.11.0")
//    implementation("io.insert-koin:koin-core:3.4.0")
//    implementation("io.insert-koin:koin-java:3.4.0")
//    implementation("io.insert-koin:koin-android:4.0.0")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}