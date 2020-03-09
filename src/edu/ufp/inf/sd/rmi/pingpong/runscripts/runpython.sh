#!/usr/bin/env bash
source ./setenv.sh client

cd "${ABSPATH2CLASSES}"
clear
python -m SimpleHTTPServer 8000

cd "${ABSPATH2SRC}"/"${JAVASCRIPTSPATH}"