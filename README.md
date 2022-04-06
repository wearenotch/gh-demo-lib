# test-lib

[![.github/workflows/ci.yml](https://github.com/dmadunic/test-lib/actions/workflows/ci.yml/badge.svg)](https://github.com/dmadunic/test-lib/actions/workflows/ci.yml)
![](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white&style=flat)
![](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white&style=flat)


Test Java library repository, used to test library publishing to maven repositories with github actions.

Library is published in:
- Google Artifact Regitry
- Github package

**Current project version 0.0.8**

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



