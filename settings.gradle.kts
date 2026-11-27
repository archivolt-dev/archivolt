pluginManagement {
    includeBuild("build-logic")
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        mavenCentral()
    }
}

rootProject.name = "archivolt"

include(
    "archivolt-core",
    "archivolt-analyzer",
    "archivolt-schema",
    "archivolt-graph",
    "archivolt-ai",
    "archivolt-mcp",
    "archivolt-app",
    "archivolt-cli",
    "archivolt-eval",
)
