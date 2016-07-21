#!/bin/bash

. ./setenv.sh

COH_OPTS="$COH_OPTS -Dcoherence.clusterport=$CLUSTERPORT -Dcoherence.cluster=$CLUSTER -Dcoherence.cacheconfig=$CACHECONFIG"

for ((i=1;i<=6;i++))
do
echo "Starting node $i, please check the log file ${DEMO_HOME}/logs/node_${i}.log..."
exec $JAVA_HOME/bin/java ${COH_OPTS} -Dapp.nodeName=node_${i} -cp $CLASSPATH -Xms1024m -Xmx1024m com.tangosol.net.DefaultCacheServer > ${DEMO_HOME}/logs/node_${i}.log 2>&1 &
sleep 3
done
