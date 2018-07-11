#!/bin/bash

docker build -t vbigiani/elk .

docker login

docker push vbigiani/elk
