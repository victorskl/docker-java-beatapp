#!/usr/bin/env bash

[ -z "${JAVA_OPTS}" ] && JAVA_OPTS="-Xms256m -Xmx512m"

export JAVA_OPTS="${JAVA_OPTS} -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap"

java ${JAVA_OPTS} Beat