plugins {
    id("java")
    application
}

version = "v1.0"
group = "ru.bardinpetr.delivery.backend.authentication"

repositories {
    mavenCentral()
}

application {
    mainClass.set("${group}.Main")
}

tasks.register("prepareKotlinBuildScriptModel") {}


dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    implementation(project(":libs:crypto"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}