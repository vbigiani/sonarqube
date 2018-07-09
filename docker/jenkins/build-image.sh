#!/bin/bash

docker --tlsverify=false login 192.168.56.100

docker --tlsverify=false build -t gft/jenkins .

