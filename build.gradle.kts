
allprojects {

    extra.apply {
        // Moshi
        set("moshiVersion", "1.15.0")
        // Retrofit
        set("retrofitVersion", "2.9.0")
        // Okhttp
        set("okhttpVersion", "4.12.0")
    }
}

plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
    id("com.android.library") version "8.1.2" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    id("com.google.firebase.crashlytics") version "3.0.1" apply false
}