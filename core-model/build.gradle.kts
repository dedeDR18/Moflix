@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id(libs.plugins.kotlin.parcelize.get().pluginId)
    id(libs.plugins.ksp.get().pluginId) version libs.versions.ksp.get()
}


android {
    namespace = "com.example.core_model"
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

    }
}



dependencies {
    implementation(libs.moshi)
    ksp(libs.moshi.codegen)
    api(libs.timber)
}