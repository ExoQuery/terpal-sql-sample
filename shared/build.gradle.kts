import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.terpal)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.runtime)
            implementation(libs.kotlinx.datetime)
            implementation(libs.koin.core)
            implementation(libs.terpal.core)
        }
        androidMain.dependencies {
            implementation(libs.ktor.client.android)
            implementation(libs.android.driver)
            // not sure why putting this here blows things up
            //implementation(libs.terpal.android)
        }
        //iosMain.dependencies {
        //    implementation(libs.ktor.client.darwin)
        //    implementation(libs.native.driver)
        //}
    }
}

android {
    // Otherwise will complain there are duplicate annotations between jb-annotations and jb-annotations-kmp
    configurations.forEach {
        it.exclude(group = "com.sschr15.annotations", module = "jb-annotations-kmp")
    }

    namespace = "com.example.project.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("com.example.project.cache")
        }
    }
}

//repositories {
//        mavenLocal {
//            mavenContent {
//                includeModule("io.exoquery", "terpal-sql-core")
//                includeModule("io.exoquery", "terpal-sql-core-jvm")
//                includeModule("io.exoquery", "terpal-sql-android")
//            }
//        }
//}