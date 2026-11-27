// Shared configuration for every Archivolt module: Kotlin/JVM, toolchain, tests.

plugins {
    id("org.jetbrains.kotlin.jvm")
}

group = "dev.archivolt"

val libs = the<VersionCatalogsExtension>().named("libs")
val jdkVersion = providers.gradleProperty("archivolt.jdk").map(String::toInt).get()

kotlin {
    jvmToolchain(jdkVersion)
}

dependencies {
    testImplementation(platform(libs.findLibrary("junit-bom").get()))
    testImplementation(kotlin("test"))
    testRuntimeOnly(libs.findLibrary("junit-platform-launcher").get())
}

tasks.test {
    useJUnitPlatform()
    systemProperty("archivolt.jdk", jdkVersion)
}
