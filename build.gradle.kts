plugins {
    id("org.jetbrains.kotlin.js") version "1.5.10"
}

group = "org.olafneumann"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://jcenter.bintray.com")
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-html-js", version = "0.7.3")

    implementation(npm("js-base64", "> 3.0.0"))
    implementation(npm("file-saver", "> 2.0.0"))
}

kotlin {
    js {
        useCommonJs()
        browser {
            webpackTask {
                cssSupport.enabled = true
            }

            runTask {
                cssSupport.enabled = true
            }

            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
        binaries.executable()
    }
}