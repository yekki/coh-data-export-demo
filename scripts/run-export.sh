#!/bin/bash

. ./setenv.sh

COH_OPTS="$COH_OPTS -Dcoherence.distributed.localstorage=false -Dcoherence.clusterport=$CLUSTERPORT -Dcoherence.cluster=$CLUSTER -Dcoherence.cacheconfig=$CACHECONFIG"

$JAVA_HOME/bin/java -Xms256m -Xmx512m $COH_OPTS com.oracle.poc.coherence.GUI.GridWideExport $*
