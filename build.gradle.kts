plugins {
    id("java")
    id("org.springframework.boot") version "3.4.3"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "com.danhoh.user"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // reactive web
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    // liquibase
    implementation("org.liquibase:liquibase-core")
    // datasource dependencies
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.postgresql:r2dbc-postgresql")
    // lombok
    annotationProcessor("org.projectlombok:lombok")
    implementation("org.projectlombok:lombok")
    // jakarta validation
    implementation("jakarta.validation:jakarta.validation-api:3.1.1")
    implementation("org.hibernate.validator:hibernate-validator:8.0.0.Final")

    // test dependencies
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.assertj:assertj-core:3.27.3")
    testImplementation("org.mockito:mockito-junit-jupiter:5.15.2")
}


tasks.test {
    useJUnitPlatform()
}