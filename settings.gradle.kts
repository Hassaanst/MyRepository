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
        maven ( url ="https://repository.liferay.com/nexus/content/repositories/public/" )

    }
}

rootProject.name = "JTM Student Helper"
include(":app")
