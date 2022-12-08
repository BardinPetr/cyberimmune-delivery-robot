plugins {
    id("delivery.lib-conventions")
}

version = "1.0"
group = "ru.bardinpetr.delivery.libs.crypto"

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}