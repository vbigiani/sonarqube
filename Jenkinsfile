pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v $HOME/.m2:$HOME/.m2'
        }
    }
    stages {
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
            withSonarQubeEnv('localhost') {
                sh 'mvn sonar:sonar'
	        }
        }
        stage("Quality Gate"){
			timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
		    def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
		    if (qg.status != 'OK') {
		    	error "Pipeline aborted due to quality gate failure: ${qg.status}"
		    }
		}
//        stage('Deliver') { 
//            steps {
//                sh 'mvn deploy' 
//            }
//        }
    }
}
