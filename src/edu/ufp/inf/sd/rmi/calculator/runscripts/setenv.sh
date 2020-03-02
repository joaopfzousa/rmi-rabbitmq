#!/usr/bin/env bash
export SCRIPT_ROLE=$1

export JDK=/Library/Java/JavaVirtualMachines/jdk-13.0.2.jdk/Contents/Home
export CURRENT_IDE=IntelliJ

#@REM ==== JAVA NAMING STUFF ====
export JAVAPROJ=/Users/joaosousa/IdeaProjects/SD
export JAVAPROJ_NAME=SD


export PACKAGE=calculator
export PACKAGE_PREFIX=edu.ufp.inf.sd.rmi
export PACKAGE_PREFIX_FOLDERS=edu/ufp/inf/sd/rmi
export SERVICE_NAME_ON_REGISTRY=CalculatorService
export CLIENT_CLASS_PREFIX=Calculator
export SERVER_CLASS_PREFIX=Calculator
export CLIENT_CLASS_POSTFIX=Client
export SERVER_CLASS_POSTFIX=Server
export SETUP_CLASS_POSTFIX=Setup
export SERVANT_IMPL_CLASS_POSTFIX=Impl
export SERVANT_ACTIVATABLE_IMPL_CLASS_POSTFIX=ActivatableImpl

#@REM ==== NETWORK STUFF ====
#@REM Must run http server on codebase host:
#@REM Python 2: python -m SimpleHTTPServer 8000
#@REM Python 3: python -m http.server 8000
export MYLOCALIP=localhost
#export MYLOCALIP=192.168.1.80
export REGISTRY_HOST=${MYLOCALIP}
export REGISTRY_PORT=1099
export SERVER_RMI_HOST=${REGISTRY_HOST}
export SERVER_RMI_PORT=1098
export SERVER_CODEBASE_HOST=${SERVER_RMI_HOST}
export SERVER_CODEBASE_PORT=8000
export CLIENT_RMI_HOST=${REGISTRY_HOST}
export CLIENT_RMI_PORT=1097
export CLIENT_CODEBASE_HOST=${CLIENT_RMI_HOST}
export CLIENT_CODEBASE_PORT=8000


#@REM =====================================================================================================
#@REM ======================== DO NOT CHANGE AFTER THIS POINT =============================================
#@REM =====================================================================================================
export JAVAPACKAGE=${PACKAGE_PREFIX}.${PACKAGE}
export JAVAPACKAGEROLE=${PACKAGE_PREFIX}.${PACKAGE}.${SCRIPT_ROLE}
export JAVAPACKAGEPATH=${PACKAGE_PREFIX_FOLDERS}/${PACKAGE}/${SCRIPT_ROLE}
export JAVASCRIPTSPATH=${PACKAGE_PREFIX_FOLDERS}/${PACKAGE}/runscripts
export JAVASECURITYPATH=${PACKAGE_PREFIX_FOLDERS}/${PACKAGE}/securitypolicies
export SERVICE_NAME=${SERVICE_PREFIX}Service
export SERVICE_URL=rmi://${REGISTRY_HOST}:${REGISTRY_PORT}/${SERVICE_NAME}

export SERVANT_ACTIVATABLE_IMPL_CLASS=${JAVAPACKAGEROLE}.${SERVER_CLASS_PREFIX}${SERVANT_ACTIVATABLE_IMPL_CLASS_POSTFIX}
export SERVANT_PERSISTENT_STATE_FILENAME=${SERVICE_PREFIX}Persistent.State

export PATH=${PATH}:${JDK}/bin

if [ "${CURRENT_IDE}" == "Netbeans" ]; then
    export JAVAPROJ_CLASSES=build/classes/
    export JAVAPROJ_DIST=dist
    export JAVAPROJ_SRC=src
    export JAVAPROJ_DIST_LIB=lib
elif [ "${CURRENT_IDE}" == "IntelliJ" ]; then
    export JAVAPROJ_CLASSES=out/production/${JAVAPROJ_NAME}/
    export JAVAPROJ_DIST=out/artifacts/${JAVAPROJ_NAME}
    export JAVAPROJ_SRC=src
    export JAVAPROJ_DIST_LIB=lib
fi

export JAVAPROJ_CLASSES_FOLDER="${JAVAPROJ}"/${JAVAPROJ_CLASSES}
export JAVAPROJ_DIST_FOLDER="${JAVAPROJ}"/${JAVAPROJ_DIST}
export JAVAPROJ_DIST_LIB_FOLDER="${JAVAPROJ}"/${JAVAPROJ_DIST_LIB}
export JAVAPROJ_JAR_FILE=${JAVAPROJ_NAME}.jar
export MYSQL_CON_JAR=mysql-connector-java-5.1.38-bin.jar

export CLASSPATH=.:${JAVAPROJ_CLASSES_FOLDER}

export ABSPATH2CLASSES="${JAVAPROJ}"/${JAVAPROJ_CLASSES}
export ABSPATH2SRC="${JAVAPROJ}"/${JAVAPROJ_SRC}
export ABSPATH2DIST="${JAVAPROJ}"/${JAVAPROJ_DIST}


export SERVER_CODEBASE=http://${SERVER_CODEBASE_HOST}:${SERVER_CODEBASE_PORT}/${JAVAPROJ_JAR_FILE}
export CLIENT_CODEBASE=http://${CLIENT_CODEBASE_HOST}:${CLIENT_CODEBASE_PORT}/${JAVAPROJ_JAR_FILE}

export SERVER_SECURITY_POLICY=file:///"${JAVAPROJ}"/${JAVAPROJ_SRC}/${JAVASECURITYPATH}/serverAllPermition.policy
export CLIENT_SECURITY_POLICY=file:///"${JAVAPROJ}"/${JAVAPROJ_SRC}/${JAVASECURITYPATH}/clientAllPermition.policy
export SETUP_SECURITY_POLICY=file:///"${JAVAPROJ}"/${JAVAPROJ_SRC}/${JAVASECURITYPATH}/setup.policy
export RMID_SECURITY_POLICY=file:///"${JAVAPROJ}"/${JAVAPROJ_SRC}/${JAVASECURITYPATH}/rmid.policy
export GROUP_SECURITY_POLICY=file:///"${JAVAPROJ}"/${JAVAPROJ_SRC}/${JAVASECURITYPATH}/group.policy