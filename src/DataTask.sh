#!/bin/bash

cat `ls | grep 'contact'` . | sort | uniq > data.txt
