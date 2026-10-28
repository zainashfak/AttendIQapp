plugins {
}

android {
    namespace = "com.zainashfaq.myapplication"

    defaultConfig {
        applicationId = "com.zainashfaq.myapplication"
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
}

dependencies {
}