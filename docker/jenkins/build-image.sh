#!/bin/bash

docker build -t gft-jenkins/jenkins .

echo '{ "insecure-registries" : ["172.30.1.1:5000"] }' | sudo tee /etc/docker/daemon.json

service docker restart

sudo docker tag gft-jenkins/jenkins 172.30.1.1:5000/gft-jenkins/jenkins
sudo docker push 172.30.1.1:5000/gft-jenkins/jenkins
