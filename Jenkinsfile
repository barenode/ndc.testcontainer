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
                    app.push("${version}")            
                    app.push("latest")  
                }                    
            }
        }
        stage('Helm Chart') {
            steps {
                echo 'Helm Chart....'
                bat 'helm package -d target/helm target/classes/helm/ndc.testcontainer'
                bat "curl -u helm:helm http://localhost:8081/repository/helm-internal/ --upload-file ndc.testcontainer-${version}.tgz -v"
            }
        }
        stage('Deploy to k8s') {
            steps {
                echo 'Deploy to k8s....'
            }
        }
    }
}