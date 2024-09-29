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
    }
}

rootProject.name = "SComposeComponentLibrary"
include(":app")
include(":scomposecomponent")
