pipeline {
    agent any
    
    def version

    stages {
        stage('Maven Build') {
            steps {
                bat 'mvn -B -DskipTests clean package' 
                script {
                    version = readMavenPom().getVersion()
                }
                echo("VERSION=${version}")
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