#!/usr/bin/env bash

[ -z "${JAVA_OPTS}" ] && JAVA_OPTS="-Xms256m -Xmx512m -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap"

export JAVA_OPTS

java ${JAVA_OPTS} Beat