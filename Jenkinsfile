pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/cygdrive/c/users/a03f/.m2 -Xmx 512'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Sonarqube') {
            steps {
                sh 'mvn sonar:sonar'
            }
        }
        stage('Deliver') { 
            steps {
                sh 'mvn deploy' 
            }
        }
    }
}
