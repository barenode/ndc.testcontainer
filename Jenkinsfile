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
                bat 'helm lint target/classes/helm/ndc-testcontainer'
                bat 'helm package -d target/helm target/classes/helm/ndc-testcontainer'
                bat "curl -u helm:helm http://localhost:8081/repository/helm-internal/ --upload-file target/helm/ndc-testcontainer-${version}.tgz -v"
            }
        }
        stage('OKD Deployment') {
            steps {
                echo 'Deploy to OKD....'
                bat 'helm repo update'              
                bat 'helm search repo --devel'     
                script {
                    catchError {         
                        bat 'helm delete ndc-testcontainer'                
                    }
                    return true;
                }
                bat 'helm upgrade --install --devel ndc-testcontainer helm-internal/ndc-testcontainer'
            }
        }
    }
}