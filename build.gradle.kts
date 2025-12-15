plugins {
	java
	id("org.springframework.boot") version "4.0.0" apply false
	id("io.spring.dependency-management") version "1.1.7"
	id("maven-publish")
}

group = "edu.raijin"
version = "0.0.1-SNAPSHOT"
description = "Common configurations and models for raijin project"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	mavenLocal()
}

dependencyManagement {
	imports {
		mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-data-jpa")
	implementation("org.springframework.boot:spring-boot-security")
	implementation("org.springframework.boot:spring-boot-security-oauth2-resource-server")
	implementation("org.springframework.boot:spring-boot-webmvc")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-data-jpa-test")
	testImplementation("org.springframework.boot:spring-boot-security-test")
	testImplementation("org.springframework.boot:spring-boot-webmvc-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("bootJava") {
			artifact(tasks.named("jar"))
		}
    }
}
