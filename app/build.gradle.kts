plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.github"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.github"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true // habilitar minimización
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
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Dependencias adicionales
    implementation("com.squareup.retrofit2:retrofit:2.9.0") // ejemplo de Retrofit
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03") // inyección de dependencias

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation("androidx.test.ext:junit:1.1.3") // dependencias de prueba
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
