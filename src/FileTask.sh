#!/bin/bash

# init
argv=(0 0 0)
argc=$#
i=0

# get user input
if [ $argc == 3 ]
then
	argv=($1 $2 $3)
	i=3
elif [ $argc == 2 ]
then
	argv=($1 $2 0)
	i=2
elif [ $argc == 1 ]
then
	argv=($1 0 0)
	i=1
fi

while read line
do
	is_done=0
	if [ i == 3 ]
	then
		break
	fi
	for word in $line
	do
		argv[$i]="$word"
		i=$(($i+1))
		if [ $i == 3 ]
		then
			is_done=1
			break
		fi
	done
	if [ $is_done == 1 ]
	then
		break
	fi
done
dir=${argv[0]}
name=${argv[1]}
num=${argv[2]}
if [ ${dir:$((${#dir}-1))} != "/" ]
then
	dir=$dir"/"
fi

# find available file name, and store it in $full_path
if [ ! -f "$dir$name.contact" ]
then
	full_path="$dir$name.contact"
else
	j=1
	while [ -f "$dir$name($j).contact" ]
	do
		j=$(($j+1))
	done
	full_path="$dir$name($j).contact"
fi

# write to file
echo "$num" > "$full_path"
