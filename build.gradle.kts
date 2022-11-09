group = "com.unrec.demo"
version = "1.0-SNAPSHOT"
description = "kotlin-demo"
java.sourceCompatibility = JavaVersion.VERSION_11

object Versions {
    const val KOTLIN = "1.7.20"
}

plugins {
    kotlin("jvm") version "1.7.20"
    java
}

dependencies {
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-stdlib-jdk8", version = Versions.KOTLIN)
    testImplementation(group = "org.jetbrains.kotlin", name = "kotlin-test", version = Versions.KOTLIN)
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.0")
}

repositories {
    mavenCentral()
    mavenLocal()
}
