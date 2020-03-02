#!/usr/bin/env bash
source ./setenv.sh client

cd "${ABSPATH2CLASSES}"
clear
#Run python 3:
#python -m http.server 8000
#Run python 2.7:
python -m SimpleHTTPServer 8000
cd "${ABSPATH2SRC}"/"${JAVASCRIPTSPATH}"