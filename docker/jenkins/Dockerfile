FROM jenkins/jenkins:2.131

USER root
RUN apt-get update && apt-get install  -y --no-install-recommends  apt-transport-https  ca-certificates  curl  software-properties-common lsb-core && apt-get clean && apt-get autoclean

RUN curl -fsSL https://apt.dockerproject.org/gpg | apt-key add -

RUN add-apt-repository "deb https://apt.dockerproject.org/repo/ debian-$(lsb_release -cs) main"
       
RUN apt-get update && apt-get -y install docker-engine=1.13.1-0~debian-stretch && apt-get clean && apt-get autoclean

RUN groupadd -g 125 docker && usermod -a -G docker jenkins 
USER jenkins
RUN install-plugins.sh antisamy-markup-formatter matrix-auth blueocean:1.6.2 workflow-aggregator ws-cleanup sonar
