#!/bin/bash

docker build -t vbigiani/jenkins .

sudo docker push vbigiani/jenkins
