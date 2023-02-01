pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building now'
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh 'sudo -S scp -v -o StrictHostKeyChecking=no -i ~/backoffice-bastion-key-pair-personal.pem target/ROOT.war docker-compose.yml ' +
                        'Dockerfile ubuntu@ec2-18-156-77-61.eu-central-1.compute.amazonaws.com:~'
                sh 'sudo -S ssh -i ~/backoffice-bastion-key-pair-personal.pem ubuntu@ec2-18-156-77-61.eu-central-1.compute.amazonaws.com\'bash -s\' < update-server.sh'
            }
        }
    }
}
