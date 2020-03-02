#!/usr/bin/env bash
source ./setenv.sh server

rmid -J-Djava.security.policy="${RMID_SECURITY_POLICY}" \
     -J-Djava.rmi.server.codebase=${SERVER_CODEBASE} \
     -J-D${JAVAPACKAGE}.activation.policy=${GROUP_SECURITY_POLICY}