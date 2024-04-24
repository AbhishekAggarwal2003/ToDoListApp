pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from Git
                git credentialsId: 'your-git-credentials', url: 'your-git-repository-url'
            }
        }

        stage('Build') {
            steps {
                // Compile Java code and package into JAR
                sh 'mvn clean package'
            }
        }

        stage('Unit Tests') {
            steps {
                // Run unit tests
                sh 'mvn test'
                // Archive test reports
                junit 'target/surefire-reports/*.xml'
            }
        }

        stage('Deploy') {
            steps {
                // Deployment steps (if applicable)
            }
        }
    }

    post {
        always {
            // Publish test results and artifacts
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts 'target/*.jar'
        }
    }
}
