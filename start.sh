#!/bin/bash

cd frontend
npm start &
sleep 5
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/
cd ..
mvn exec:java -Dexec.mainClass="mainPack.BooksAndFeedback.BooksAndFeedbackApplication" &