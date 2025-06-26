plugins {
    kotlin("jvm") version "2.0.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sourceSets {
    main {
        java {
            setSrcDirs(
                listOf(
                    "original/buffer/src/main/kotlin",
                    "original/cache/src/main/kotlin",
                    "original/compress/src/main/kotlin",
                    "original/crypto/src/main/kotlin",
                    "original/util/src/main/kotlin",
                )
            )
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.0")
    implementation("io.github.oshai:kotlin-logging-jvm:5.1.0")
    implementation("org.slf4j:slf4j-api:2.1.0-alpha1")
    implementation("io.netty:netty-buffer:4.1.107.Final")
    implementation("com.google.guava:guava:33.4.0-jre")
    implementation("org.tukaani:xz:1.10")
    implementation("org.apache.commons:commons-compress:1.27.1")
    
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}