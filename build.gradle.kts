plugins {
	java
	id("org.springframework.boot") version "3.5.7"
	id("io.spring.dependency-management") version "1.1.7"
	id("io.github.redgreencoding.plantuml") version "0.3.0"
    kotlin("jvm")
}

group = "com.escolar"
version = "0.0.1-SNAPSHOT"
description = "Aplicação para gerenciar as atividades escolares"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")

	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")

	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("io.opentelemetry.instrumentation:opentelemetry-spring-boot-starter:2.8.0")

	// teste
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(kotlin("stdlib-jdk8"))

    // parte de segurança
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
    implementation("org.springframework.security:spring-security-crypto")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

plantuml{
	options{
		outputDir = project.file("docs/diagramas/images")
		format = "png"
	}
	diagrams{
		project.fileTree("docs/diagramas")
			.files
			.filter { it.extension == "puml" }
			.forEach{ file ->
				create(file.nameWithoutExtension){
					sourceFile = project.file(file.path)
				}
			}
	}
}