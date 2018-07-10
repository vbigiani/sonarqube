FROM jenkins/jenkins:2.131-alpine

USER root

RUN apk -U add docker

USER jenkins
RUN install-plugins.sh antisamy-markup-formatter matrix-auth blueocean:1.6.2 workflow-aggregator ws-cleanup sonar
