/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
  id("org.openjfx.javafxplugin") version "0.0.13"
  application
  id("org.jetbrains.kotlin.jvm") version "1.7.22"
}

repositories {
  maven {
    name = "GitHubPackages"
    url = uri("https://maven.pkg.github.com/SilenLoc/vanity")
    credentials {
      username = System.getenv("GITHUB_USERNAME")
      password = System.getenv("GITHUB_TOKEN")
    }
  }
  mavenCentral()
  gradlePluginPortal()
}


javafx {
  version = "17.0.2"
  modules = listOf("javafx.controls")
}

dependencies {

  implementation("vanity:framework:unspecified")

  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:1.6.4")

  val koinVersion = "3.3.0"
  implementation("io.insert-koin:koin-core:$koinVersion")

  testImplementation("io.kotest:kotest-runner-junit5:5.5.4")

}
repositories {
  mavenCentral()
}

tasks.withType<Test>().configureEach {
  useJUnitPlatform()
}

application {
  // Define the main class for the application.
  mainClass.set("app.AppKt")

}



