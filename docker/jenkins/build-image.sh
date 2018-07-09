#!/bin/bash

docker build -t vbigiani/jenkins .

docker login

docker push vbigiani/jenkins
