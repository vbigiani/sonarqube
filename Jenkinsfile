pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v mvn_repository:$HOME/.m2'
        }
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -DskipTests clean package'
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
                withSonarQubeEnv('Localhost') {
					sh 'mvn sonar:sonar'
                }
            }
        }
        stage("Quality Gate"){
        	agent none
            steps {
                timeout(time: 1, unit: 'HOURS') {
		           script {
			           def qg = waitForQualityGate()
			           if (qg.status != 'OK') {
			             error "Pipeline aborted due to quality gate failure: ${qg.status}"
			           }
		           }
                }
            }
		}
//        stage('Deliver') { 
//            steps {
//                sh 'mvn deploy' 
//            }
//        }
    }
}
