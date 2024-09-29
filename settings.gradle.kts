pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url =  uri("https://maven.google.com") }
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "SComposeComponentLibrary"
include(":app")
include(":scomposecomponent")
