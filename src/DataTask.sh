#!/bin/bash
# Xuzong Chen - xche985 - 6471321
# SOFTENG 206 - Assignment 1 - Aug. 2013

cat `ls | grep 'contact'` . | sort | uniq > data.txt

# Although the "." always produces irrelevant output on standard output,
# it allows this script to be funcitonally correct for the case where
# there are no files named *.contact in the current directory.
