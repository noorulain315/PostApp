object Versions {

    // Build Config
    const val COMPILE_SDK = 33
    const val MIN_SDK = 23
    const val TARGET_SDK = 32
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0.0"

    // Deps
    const val ANDROID_GRADLE_PLUGIN = "7.3.1"
    const val KOTLIN_VERSION = "1.6.21"
    const val SUPPORT_LIBRARY_ANDROID_X = "1.5.1"
    const val DESIGN = "1.3.0"
    const val NAVIGATION = "2.3.5"
    const val HILT_VERSION = "2.44"
    const val HILT_COMPILER = "2.44"
    const val JUNIT = "4.12"
    const val JUNIT_EXT = "1.1.2"
    const val ESPRESSO = "3.2.0"
    const val CORE_TESTING = "1.0.0"
    const val ARCH_CORE_TESTING = "2.1.0"
    const val COROUTINE = "1.3.7"
    const val COROUTINE_TEST = "1.6.1"
    const val CONSTRAINT_LAYOUT = "1.1.3"
    const val MOSHI_VERSION = "1.13.0"
    const val MOSHI_CONVERTER = "2.9.0"
    const val RETROFIT = "2.9.0"
    const val MOCKK = "1.12.3"
    const val MOCK_WEB_SERVER = "4.10.0"
    const val NAVIGATION_FRAGMENT = "2.5.3"
    const val ANDROID_TEST_RUNNER = "1.1.0"
    const val LIFECYCLE_KTX_VERSION = "2.2.0"
    const val COMPOSE_VERSION = "1.3.1"
    const val COMPOSE_COMPILER_VERSION = "1.2.0-rc02"
}

object Libs {

    // Kotlin
    const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}"
    const val COROUTINE_CORE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINE}'"

    // Android
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.SUPPORT_LIBRARY_ANDROID_X}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val DESIGN = "com.google.android.material:material:${Versions.DESIGN}"

    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val JUNIT_EXT = "androidx.test.ext:junit:${Versions.JUNIT_EXT}"
    const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    const val ESPRESSO_CONTRIB = "androidx.test.espresso:espresso-contrib:${Versions.ESPRESSO}"
    const val CORE_TESTING = "androidx.test:core:${Versions.CORE_TESTING}"
    const val ARCH_CORE_TESTING = "androidx.arch.core:core-testing:${Versions.ARCH_CORE_TESTING}"
    const val COROUTINE_TESTING =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINE_TEST}"
    const val ANDROID_TEST_RUNNER = "androidx.test:runner:${Versions.ANDROID_TEST_RUNNER}"
    const val MOCK_WEB_SERVER = "com.squareup.okhttp3:mockwebserver:${Versions.MOCK_WEB_SERVER}"
    const val MOSHI_CONVERTER = "com.squareup.retrofit2:converter-moshi:${Versions.MOSHI_CONVERTER}"
    const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI_VERSION}"
    const val MOSHI_KOTLIN_CODE_GEN =
        "com.squareup.moshi:moshi-kotlin-codegen:${Versions.MOSHI_VERSION}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val HILT = "com.google.dagger:hilt-android:${Versions.HILT_VERSION}"
    const val HILT_COMPILER = "com.google.dagger:hilt-compiler:${Versions.HILT_COMPILER}"


    //Jetpack
    const val LIFECYCLE_VIEWMODEL_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_KTX_VERSION}"
    const val LIFECYCLE_LIVEDATA_KTX =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_KTX_VERSION}"
    const val NAV_FRAGMENT_KTX =
        "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION_FRAGMENT}"
    const val NAV_UI_KTX = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION_FRAGMENT}"

    //Jetpack Compose
    const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE_VERSION}"
    const val COMPOSE_UI_PREVIEW =
        "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE_VERSION}"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE_VERSION}"
    const val COMPOSE_MATERIAL_ICON =
        "androidx.compose.material:material-icons-extended:${Versions.COMPOSE_VERSION}"
    const val COMPOSE_FOUNDATION =
        "androidx.compose.foundation:foundation:${Versions.COMPOSE_VERSION}"
}

object Config {
    const val PROD_API_BASE_URL = "https://jsonplaceholder.typicode.com/"
    const val STAGING_API_BASE_URL =
        "https://jsonplaceholder.typicode.com/" // Future perspective if we implement Staging Env.
}
