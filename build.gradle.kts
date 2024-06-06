import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

description = "kotlin-demo"
java.sourceCompatibility = JavaVersion.VERSION_11

object Versions {
    const val KOTLIN = "2.0.0"
}

plugins {
    kotlin("jvm") version "2.0.0" apply false
    java
}

allprojects {
    group = "com.unrec.demo"
    version = "1.0-SNAPSHOT"

    tasks.withType<KotlinCompile> {
        compilerOptions {
            freeCompilerArgs.add("-Xjsr305=strict")
            jvmTarget.set(JvmTarget.JVM_17)
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
