plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.tests.offerstest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.tests.offerstest"
        minSdk = 28
        targetSdk = 33
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(project(":feature-email-verification"))
    implementation(project(":feature-find-worker"))
    implementation(project(":feature-code-validation"))
    implementation(project(":common"))
    implementation(project(":feature-vacantions-list"))

    //parselize
    implementation("org.jetbrains.kotlin:kotlin-parcelize-runtime:1.5.31")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //GSON
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //Dagger2
    implementation("com.google.dagger:dagger:2.45")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    kapt("com.google.dagger:dagger-compiler:2.45")

    //AdapterDelegate
    implementation("com.hannesdorfmann:adapterdelegates4-pagination:4.3.0")


    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")


    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
//    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}