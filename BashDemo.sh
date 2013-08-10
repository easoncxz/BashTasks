#!/bin/bash

i=0
a=(10 203 1)
is_done=0


while read line
do
	for word in $line
	do
		a[$i]=$word
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

#echo "${a[0]}"  # prints "10"

#echo "${#a}"  # prints "3"
#echo "${a}"
#echo "${#a[@]}"  # prints "2"
echo "${a[@]}"
	


#a=$a"/"

if [ ${a:$((${#a}-1))} != "/" ]
then
	a=$a"/"
fi

echo ${a[0]}${a[1]}"(${a[2]}).aa"

#echo "a: $a"
#echo "b: $b"
#echo "c: $c"
