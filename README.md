# test-lib

[![.github/workflows/ci.yml](https://github.com/dmadunic/test-lib/actions/workflows/ci.yml/badge.svg)](https://github.com/dmadunic/test-lib/actions/workflows/ci.yml)
![](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white&style=flat)
![](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white&style=flat)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

Test Java library repository, used to test library publishing to maven repositories with github actions.

Library is published in:
- Google Artifact Regitry
- Github package

**Current project version 0.0.9**

## Usage
To use this jar in your project add the following to the dependencies section:

```groovy
dependencies {
    implementation "com.ag04.utils:test-lib:$LATEST_VERSION"
    ...
}
```
(build.gradle)

```xml
<dependency>
  <groupId>com.ag04.utils</groupId>
  <artifactId>test-lib</artifactId>
  <version>$LATEST_VERSION</version>
</dependency>
```
(pom.xml)

And regitser github package as maven repository, as is for example show in the snippet bellow:

```groovy
def props = new Properties()
if (file(".env").exists()) {
    file(".env").withInputStream { props.load(it) }
} 

repositories {
    mavenCentral()
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/dmadunic/test-lib")
        credentials {
            username = System.getenv("gh_username") ?: props.getProperty("gh_username")
            password = System.getenv("gh_token") ?: props.getProperty("gh_token")
        }
    }
}
```

**gh_token** should contain the value of (PAT) "personal access token" that has Access to public repositories.
You can store this value in (1) .env file (do not forget to add this file to .gitignore!) or (2) configure system environment variable to save it.
First option is the simplest for local development, while the second is more suitable for ci/cd workflows.

For more see:
* [Personal GitHub access tokens](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)
* [Working with the Gradle registry](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry)

## Development
### Setup (First time)
1. Clone the repository: `git clone git@github.com:dmadunic/test-lib.git`
4. Build project with: ` ./gradlew clean build `

### Manual Release
Make sure that file gradle.properties in the folder ${USER_HOME}/.gradle/ contains the following two variables defined:

* github_username
* github_password : personal github token to be used to install/update packages

1) Commit and push everything
2) `./gradlew release`

And simply follow the instructions on the console

### Github Actions release

New version of library jar  is released with the "Release next version" github action script.
Once everything is pushed simply run this workflow script.
It will perform the following:
- build new jar version
- publish jar to github packages
- Create new Relase with comments from CHANGELOG.md for this release.
- Update README.md to contain latest version number.



