@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.android.library.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id(libs.plugins.kotlin.kapt.get().pluginId)
    id(libs.plugins.ksp.get().pluginId) version libs.versions.ksp.get()
}

android {
    namespace = "com.example.core_network"
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }

}

dependencies {
    implementation(project(":core-model"))

    //coroutines
    implementation(libs.coroutines)
    testImplementation(libs.coroutines)
    testImplementation(libs.coroutines.test)
    
    // network
    implementation(libs.sandwich)
    implementation(libs.retrofit)
    implementation(libs.retrofit.moshi)
    implementation(libs.okhttp.interceptor)
    testImplementation(libs.okhttp.mockserver)
    testImplementation(libs.androidx.arch.core)

    // json parsing
    implementation(libs.moshi)
    ksp(libs.moshi.codegen)

    // di
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

}