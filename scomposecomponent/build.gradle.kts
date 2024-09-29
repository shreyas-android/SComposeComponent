plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.androidai.framework.scomposecomponent"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose= true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.compose.compiler.get().version
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }

}

group = "com.androidai.framework"
version = "1.0"

afterEvaluate {
    publishing{
        publications {
            create<MavenPublication>("release") {
                groupId = "com.androidai.framework"
                artifactId = "scompose-component"
                version = "1.0.0"

                afterEvaluate {
                    from(components["release"])
                }
            }
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.compose.activity)
    implementation(libs.compose.constraintlayout)
    implementation(libs.compose.material)
    implementation(libs.compose.foundation.foundation)
    implementation(libs.compose.viewmodel)
    implementation(libs.compose.material3)
}