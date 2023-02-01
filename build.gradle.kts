import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

description = "kotlin-demo"
java.sourceCompatibility = JavaVersion.VERSION_11

object Versions {
    const val KOTLIN = "1.7.20"
}

plugins {
    kotlin("jvm") version "1.7.20" apply false
    java
}

allprojects {
    group = "com.unrec.demo"
    version = "1.0-SNAPSHOT"

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

subprojects {
    apply {
        plugin("kotlin")
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        testImplementation("org.jetbrains.kotlin:kotlin-test")
    }

    repositories {
        mavenCentral()
    }
}

dependencies {
    implementation("org.jetbrains.kotlin", "kotlin-stdlib-jdk8", Versions.KOTLIN)
    testImplementation("org.jetbrains.kotlin", "kotlin-test", Versions.KOTLIN)
}

repositories {
    mavenCentral()
    mavenLocal()
}
