# Software Engineering DevOps Mission02

Software Engineering DevOps team assignment repository.

## Mission

1. Create and manage a GitHub repository.
2. Collaborate with EGit using clone, commit, push, pull request, and merge.
3. Trigger a Jenkins build automatically whenever code is pushed to GitHub.
4. Analyze and fix build failures.
5. Save successful build results as a text artifact or send an email notification.

## Team Workflow

- `main`: stable merged branch.
- Feature work should be done on separate branches.
- Open a pull request before merging into `main`.
- Keep screenshots of EGit, pull requests, merge history, Jenkins settings, webhook settings, and build results for the final report.

## Jenkins

The Jenkins Pipeline should:

- checkout the source code from GitHub
- build the Java project
- run tests if available
- save build or test output as a `.txt` artifact

## Project

This repository contains a small Java console project for the DevOps pipeline.

- `Test2/src/Book.java`: book data model
- `Test2/src/BookManager.java`: book add/list/search logic
- `Test2/src/Main.java`: sample program entry point
- `Test2/src/BookManagerTest.java`: JUnit test
- `Jenkinsfile`: Jenkins Pipeline definition

## Local Build

```bash
mkdir -p classes
mkdir -p lib test-reports
curl -L -o lib/junit.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.7.1/junit-platform-console-standalone-1.7.1.jar
cd Test2
find src -name "*.java" > sources.txt
javac -encoding UTF-8 -d ../classes -cp ../lib/junit.jar @sources.txt
cd ..
java -jar lib/junit.jar --class-path classes --scan-class-path --reports-dir test-reports
```
