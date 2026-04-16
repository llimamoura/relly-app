plugins {
    `kotlin-dsl`
}

group = "com.relly.buildlogic"

dependencies {
    compileOnly("com.android.tools.build:gradle:${libs.versions.agp.get()}")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.kotlin.get()}")
}

gradlePlugin {
    plugins {
        register("androidCompose") {
            id = "relly.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }
    }
}
