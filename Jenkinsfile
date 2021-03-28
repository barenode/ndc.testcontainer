pipeline {
    agent any

    stages {
        stage('Maven Build') {
            steps {
               bat 'mvn -B -DskipTests clean package' 
            }
        }
        stage('Docker Image') {
            steps {
                echo 'Docker Image..'
            }
        }
        stage('Helm Chart') {
            steps {
                echo 'Helm Chart....'
            }
        }
        stage('Deploy to k8s') {
            steps {
                echo 'Deploy to k8s....'
            }
        }
    }
}