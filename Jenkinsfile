pipeline {
    agent any

    environment {
        JAVA_HOME = '/opt/java/openjdk'
        PATH = "/opt/java/openjdk/bin:${env.PATH}"
        JUNIT_JAR_URL = 'https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.7.1/junit-platform-console-standalone-1.7.1.jar'
        JUNIT_JAR_PATH = 'lib/junit.jar'
        CLASS_DIR = 'classes'
        REPORT_DIR = 'test-reports'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Prepare') {
            steps {
                sh '''
                    rm -rf ${CLASS_DIR} ${REPORT_DIR} build_results.txt
                    mkdir -p ${CLASS_DIR} ${REPORT_DIR} lib
                    echo "[+] Downloading JUnit JAR..."
                    curl -L -o ${JUNIT_JAR_PATH} ${JUNIT_JAR_URL}
                '''
            }
        }

        stage('Build') {
            steps {
                sh '''
                    echo "[+] Compiling source and test files..."
                    find src test -name "*.java" > sources.txt
                    javac -encoding UTF-8 -d ${CLASS_DIR} -cp ${JUNIT_JAR_PATH} @sources.txt
                    echo "Build succeeded at $(date)" > build_results.txt
                '''
            }
        }

        stage('Test') {
            steps {
                sh '''
                    echo "[+] Running tests with JUnit..."
                    java -jar ${JUNIT_JAR_PATH} \
                         --class-path ${CLASS_DIR} \
                         --scan-class-path \
                         --details=tree \
                         --details-theme=ascii \
                         --reports-dir ${REPORT_DIR} \
                         --config=junit.platform.output.capture.stdout=true \
                         --config=junit.platform.reporting.open.xml.enabled=true \
                         > ${REPORT_DIR}/test-output.txt
                '''
            }
        }

        stage('Run') {
            steps {
                sh 'java -cp ${CLASS_DIR} Main >> build_results.txt'
            }
        }
    }

    post {
        always {
            junit "${REPORT_DIR}/**/*.xml"
            archiveArtifacts artifacts: "${REPORT_DIR}/**/*, build_results.txt", allowEmptyArchive: true
        }
        success {
            echo 'Build and test succeeded'
        }
        failure {
            echo 'Build or test failed'
        }
    }
}
