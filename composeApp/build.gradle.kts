import org.jetbrains.compose.desktop.application.dsl.TargetFormat
        import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
        import org.jetbrains.kotlin.gradle.dsl.JvmTarget

        plugins {
            alias(libs.plugins.kotlinMultiplatform)
            alias(libs.plugins.androidApplication)
            alias(libs.plugins.composeMultiplatform)
            alias(libs.plugins.composeCompiler)
            alias(libs.plugins.ksp)
        }

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }


    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
            optimized = true
        }
    }

    sourceSets {

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.8.0-alpha10")

            //Room
            implementation(libs.androidx.room.runtime)
            implementation(libs.sqlite.bundled)
        }
    }
}

android {
    namespace = "com.finance.rjdjds"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.finance.rjdjds"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
        dependencies {
            debugImplementation(compose.uiTooling)
            add("kspAndroid", libs.androidx.room.compiler)
            add("kspIosSimulatorArm64", libs.androidx.room.compiler)
            add("kspIosX64", libs.androidx.room.compiler)
            add("kspIosArm64", libs.androidx.room.compiler)
        }

        ksp {
            arg("room.schemaLocation", "${projectDir}/schemas")
        }
