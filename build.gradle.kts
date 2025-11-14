plugins {
	java
	id("org.springframework.boot") version "3.5.7"
	id("io.spring.dependency-management") version "1.1.7"
	id("io.github.redgreencoding.plantuml") version "0.3.0"
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
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")

	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")

	//runtimeOnly("io.micrometer:micrometer-registry-otlp")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
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