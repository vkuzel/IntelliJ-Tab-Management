plugins {
    id("org.jetbrains.intellij.platform") version "2.7.1"
    java
}

group = "com.vkuzel.intellij"
version = "0.0.1"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
	intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaUltimate("2026.1")
        bundledPlugin("com.intellij.java")
    }
}

intellijPlatform {
    pluginConfiguration {
        version.set(project.version.toString())

        ideaVersion {
            sinceBuild.set("261")
        }
    }
}
