pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building now'
                sh 'mvn clean package'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh 'sudo -S scp -v -o StrictHostKeyChecking=no -i ~/trip-service-key-pair-personal.pem target/ROOT.war docker-compose.yaml ' +
                        'Dockerfile ubuntu@ec2-18-156-178-29.eu-central-1.compute.amazonaws.com:~'
                sh 'sudo -S ssh -i ~/backoffice-bastion-key-pair-personal.pem ubuntu@ec2-18-156-178-29.eu-central-1.compute.amazonaws.com \'bash -s\' < update-server.sh'
            }
        }
    }
}
