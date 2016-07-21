#!/bin/bash

. ./setenv.sh

pids=`ps aux | grep "cluster=$CLUSTER" | grep -v grep | awk '{print $2}'`

if [ -z $pids ] ; then
	echo "No cache member found in $CLUSTER"
else
	kill -9 $pids
	echo "All members in $CLUSTER were killed!"
fi

exit 0
