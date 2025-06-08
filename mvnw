#!/bin/sh
# ----------------------------------------------------------------------------
# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
# ----------------------------------------------------------------------------

set -e
MAVEN_PROJECTBASEDIR="${MAVEN_BASEDIR:-$(dirname "$0")}"

if [ -r "$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.properties" ]; then
  MAVEN_WRAPPER_PROPERTIES="$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.properties"
else
  echo "Cannot find .mvn/wrapper/maven-wrapper.properties in $MAVEN_PROJECTBASEDIR"
  exit 1
fi

MAVEN_WRAPPER_JAR=$(grep -e "^wrapperUrl=" "$MAVEN_WRAPPER_PROPERTIES" | cut -d'=' -f2)

if [ ! -f "$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar" ]; then
  echo "Downloading Maven wrapper jar from $MAVEN_WRAPPER_JAR"
  curl -o "$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar" "$MAVEN_WRAPPER_JAR"
fi

exec java -jar "$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar" "$@"
