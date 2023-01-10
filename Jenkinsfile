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
                sh 'sudo -S scp -v -o StrictHostKeyChecking=no -i ~/trip-service-key-pair-personal.pem target/ROOT.war docker-compose.yaml ' +
                        'Dockerfile ubuntu@ec2-13-41-203-41.eu-west-2.compute.amazonaws.com:~'
                sh 'sudo -S ssh -i ~/trip-service-key-pair-personal.pem ubuntu@ec2-13-41-203-41.eu-west-2.compute.amazonaws.com \'bash -s\' < update-server.sh'
            }
        }
    }
}
