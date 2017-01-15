#!/usr/bin/env bash

mvn compile exec:java -Dexec.mainClass="com.rea.botsim.Main" -Dexec.args="input.txt"