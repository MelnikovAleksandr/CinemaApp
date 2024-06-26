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
include(":feature:signin")
include(":feature:signup")
include(":core:components")
include(":feature:home")
include(":feature:profile")
include(":feature:watchlist")
include(":feature:detail")
include(":feature:search")
include(":feature:video")
