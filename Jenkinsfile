pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building now'
                sh 'mvn clean package spring-boot:repackage'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh 'docker compose -f docker-compose.yaml up -d'
            }
        }
    }
}
