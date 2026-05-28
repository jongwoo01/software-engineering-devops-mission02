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

