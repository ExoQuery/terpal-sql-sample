rootProject.name = "terpal-sql-sample"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            //mavenContent {
            //    includeGroupAndSubgroups("androidx")
            //    includeGroupAndSubgroups("com.android")
            //    includeGroupAndSubgroups("com.google")
            //}
        }
        mavenCentral()
        gradlePluginPortal()
        //mavenLocal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        mavenLocal()
//        {
//            mavenContent {
//                includeModule("io.exoquery", "terpal-sql-core")
//                includeModule("io.exoquery", "terpal-sql-core-jvm")
//                includeModule("io.exoquery", "terpal-sql-android")
//            }
//        }
    }
}

include(":composeApp")
include(":shared")
