FROM jenkins/jenkins:2.131

USER root
RUN apt-get update && apt-get install docker
RUN usermod -a -G `getent group 1000 | cut -d : -f1` jenkins 
USER jenkins
RUN install-plugins.sh antisamy-markup-formatter matrix-auth sonarqube-scanner blueocean:1.6.2 workflow-aggregator ws-cleanup sonar
