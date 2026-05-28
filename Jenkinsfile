pipeline {
    agent any

    environment {
        JAVA_HOME = '/opt/java/openjdk'
        PATH = "/opt/java/openjdk/bin:${env.PATH}"
    }

    stages {
        stage('Prepare') {
            steps {
                sh 'rm -rf classes build_results.txt test_results.txt'
                sh 'mkdir -p classes'
            }
        }

        stage('Build') {
            steps {
                sh 'javac -encoding UTF-8 -d classes src/*.java test/*.java'
                sh 'echo "Build succeeded at $(date)" > build_results.txt'
            }
        }

        stage('Test') {
            steps {
                sh 'java -cp classes BookManagerTest | tee test_results.txt'
            }
        }

        stage('Run') {
            steps {
                sh 'java -cp classes Main >> build_results.txt'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '*.txt', allowEmptyArchive: true
        }
        success {
            echo 'Build and test succeeded'
        }
        failure {
            echo 'Build or test failed'
        }
    }
}
