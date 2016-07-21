#!/bin/bash

export JAVA_HOME=/Users/gniu/.jenv/versions/1.8.0.92
export COHERENCE_HOME=/Users/gniu/Oracle/mw12c/coherence
export DEMO_HOME=/Users/gniu/Workspaces/CoherenceDataExportDemo
export EXPORT_DIR=/Users/gniu

export COH_OPTS="-Djava.net.preferIPv4Stack=true"
export CLASSPATH=$DEMO_HOME/classes:$DEMO_HOME/config:$COHERENCE_HOME/lib/coherence.jar

export CLUSTER=CoherenceDataExportDemo
export CLUSTERPORT=15555
export CACHECONFIG=demo-cache-config.xml
