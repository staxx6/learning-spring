#!/bin/bash

if [ "$1" = "start" ]
then
	echo "Start mariadb and apach http server."
	systemctl start mariadb.service
	systemctl start httpd.service	
	echo "finished starting servers."
elif [ "$1" = "stop" ]
then
	echo "Stop mariadb and apach http server."
	systemctl stop mariadb.service
	systemctl stop httpd.service
	echo "finished stopping servers."	
else
	echo "Usage: $0 start | stop" >&2 # redirect to stderr
    exit 2
fi
