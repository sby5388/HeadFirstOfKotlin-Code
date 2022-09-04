import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
}

group = "com.shenby"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenLocal()
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-coroutines-core
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}