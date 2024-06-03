pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "CinemaApp"
include(":app")
include(":feature:auth")
include(":core:util")
include(":data")
include(":core:domain")
include(":feature:splash")
include(":feature:onboarding")
