#!/usr/bin/env bash
source ./setenv.sh server

cd "${ABSPATH2CLASSES}"

java -cp ${CLASSPATH} \
     -Djava.security.policy=${SERVER_SECURITY_POLICY} \
     -Djava.rmi.server.codebase=${SERVER_CODEBASE} \
     -D${JAVAPACKAGE}.activation.setup.codebase=${SERVER_CODEBASE} \
     -D${JAVAPACKAGE}.activation.impl.codebase=${SERVER_CODEBASE} \
     -D${JAVAPACKAGE}.activation.servicename=${SERVICE_NAME} \
     -D${JAVAPACKAGE}.activation.file=${SERVANT_PERSISTENT_STATE_FILENAME} \
     -D${JAVAPACKAGE}.activation.policy=${GROUP_SECURITY_POLICY} \
     ${JAVAPACKAGEROLE}.${SERVER_CLASS_PREFIX}${SETUP_CLASS_POSTFIX} ${REGISTRY_HOST} ${REGISTRY_PORT} ${SERVANT_ACTIVATABLE_IMPL_CLASS}

cd "${ABSPATH2SRC}"/"${JAVASCRIPTSPATH}"