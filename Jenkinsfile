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
                        'Dockerfile ec2-user@ec2-3-8-90-32.eu-west-2.compute.amazonaws.com:~'
                sh 'sudo -S ssh -i ~/trip-service-key-pair-personal.pem ec2-user@ec2-3-8-90-32.eu-west-2.compute.amazonaws.com \'bash -s\' < update-server.sh'
            }
        }
    }
}
