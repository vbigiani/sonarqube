node {

	stage("Checkout") {
		checkout([$class: 'GitSCM', branches: [[name: 'master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'vbigiani-github', url: 'https://github.com/vbigiani/sonarqube.git']]])
	}

	stage("Build") {
		withMaven(maven:'maven-3.3.9',
				  mavenSettingsConfig: 'maven-3.3.9-settings.xml',
				  mavenOpts: '-Xmx512m -XX:MaxPermSize=1024m')
				{
					  sh "mvn clean install"
				}
	}

	stage("Sonarqube Quality Check") {
		withMaven(maven:'maven-3.3.9',
				  mavenSettingsConfig: 'maven-3.3.9-settings.xml',
				  mavenOpts: '-Xmx512m -XX:MaxPermSize=1024m')
				{
					 sh "mvn sonar:sonar"
				}
	}

	stage("Deploy") {
		withMaven(maven:'maven-3.3.9',
				  mavenSettingsConfig: 'maven-3.3.9-settings.xml',
				  mavenOpts: '-Xmx512m -XX:MaxPermSize=1024m')
				{
				  sh "mvn deploy"
				}
	}
}
	