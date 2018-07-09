FROM jenkins/jenkins:2.131

USER root
RUN apt-get update && apt-get install docker
RUN groupadd -g 125 docker && usermod -a -G docker jenkins 
USER jenkins
RUN install-plugins.sh antisamy-markup-formatter matrix-auth blueocean:1.6.2 workflow-aggregator ws-cleanup sonar
