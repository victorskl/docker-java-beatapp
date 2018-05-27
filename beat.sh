#!/usr/bin/env bash

JAVA_OPTS="-Xms256m -Xmx512m -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap"

export JAVA_OPTS

java ${JAVA_OPTS} Beat