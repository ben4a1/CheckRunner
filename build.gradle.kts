/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    java
    `maven-publish`
    id("org.springframework.boot") version "2.7.5"
}

springBoot {
    mainClass.set("by.paramonov.CheckApplication")
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    testImplementation("junit:junit:3.8.2")
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

    implementation ("org.postgresql:postgresql:42.2.27")

    implementation (dependencyNotation = "org.springframework.boot:spring-boot-starter-data-jpa:2.7.5") //Для работы с БД ORM

    implementation ("org.springframework.boot:spring-boot-starter-data-rest:2.7.5") //Для создания REST контроллера

    implementation ("org.springframework.boot:spring-boot-autoconfigure:2.7.5")

    testImplementation ("org.springframework.boot:spring-boot-starter-test:2.7.5") //Для сервера Tomcat

    implementation ("javax.xml.bind:jaxb-api:2.3.0")
}



group = "by.paramonov"
version = "1.0-SNAPSHOT"
description = "check-runnerV2"
java.sourceCompatibility = JavaVersion.VERSION_17

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.test {
    useJUnitPlatform()
}