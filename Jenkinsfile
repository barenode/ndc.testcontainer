def version = ''
def app

pipeline {
    
    agent any    

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
                script {
                    app = docker.build("hylmar/ndc.testcontainer")    
                    docker {            
                        app.push("${version}")            
                        app.push("latest")        
                    } 
                }                    
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