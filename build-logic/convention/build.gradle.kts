plugins {
    `kotlin-dsl`
}

group = "com.relly.buildlogic"

dependencies {
    compileOnly("com.android.tools.build:gradle:${libs.versions.agp.get()}")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.kotlin.get()}")
    compileOnly("com.google.dagger:hilt-android-gradle-plugin:${libs.versions.hilt.get()}")
    compileOnly("com.google.devtools.ksp:symbol-processing-gradle-plugin:${libs.versions.ksp.get()}")
}

gradlePlugin {
    plugins {
        register("androidCompose") {
            id = "relly.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "relly.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
    }
}
