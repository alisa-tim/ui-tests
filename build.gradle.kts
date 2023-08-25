import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.21"
    id("io.qameta.allure") version "2.10.0"
    application
}
allure {
    adapter {
        autoconfigure.set(true)
        aspectjWeaver.set(true)
        version.set("2.23.0")
    }
}

group = "tests"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("com.codeborne:selenide:6.17.1")
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.2")
}

tasks.test {
    useJUnitPlatform()
    systemProperties(
        mapOf(
            "platform" to (System.getProperty("platform") ?: "desktop"),
            "wdAddress" to (System.getProperty("wdAddress") ?: "http://localhost:4444/wd/hub"),
            "junit.jupiter.execution.parallel.enabled" to true,
            "junit.jupiter.execution.parallel.mode.default" to "CONCURRENT"
        )
    )
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}
