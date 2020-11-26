import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    id("com.github.johnrengelman.shadow").version("6.1.0")
}

group = "com.github.ponclure"
version = "RELEASE 1.0.0"
description = "Among Us"

defaultTasks("clean", "build", "shadowJar")

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

sourceSets {
    main {
        java.srcDir("src/main/java")
        resources.srcDir("src/main/resources")
    }
}

tasks {
    withType(JavaCompile::class) {
        options.encoding = "UTF-8"
    }

    named("shadowJar", ShadowJar::class) {
        archiveFileName.set("${rootProject.name}-${project.version}-shaded.jar")

        relocate("me.mattstudios.mfgui", "com.github.amongus.mfgui")
    }
}

repositories {
    maven {
        url = uri("https://libraries.minecraft.net")
    }

    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }

    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("me.mattstudios.utils:matt-framework-gui:2.0.3")
    implementation("com.github.ponclure:SimpleNPCFramework-API:2.11-SNAPSHOT")
    compileOnly("org.spigotmc:spigot-api:1.16.4-R0.1-SNAPSHOT")
    compileOnly("org.spigotmc:spigot:1.16.4-R0.1-SNAPSHOT")
    compileOnly("com.mojang:authlib:1.5.25")
    compileOnly("org.jetbrains:annotations:20.1.0")
    compileOnly("com.github.ponclure:securitycams:RELEASE-1.0.1")
}

