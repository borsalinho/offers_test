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
    }
}

rootProject.name = "OffersTest"
include(":app")
include(":data")
include(":domain")
include(":feature-email-verification")
include(":common")
include(":feature-find-worker")
include(":feature-code-validation")
include(":feature-vacantions-list")
include(":feature-offers-list")
