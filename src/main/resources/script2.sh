#!/bin/bash

ARGS=($@)
SIZE=${#ARGS[@]}

echo
echo $SIZE arguments passed in
echo ${ARGS[@]}


echo 
echo "printing for loop now"
for f in ${ARGS[@]}; do
  echo $f
done


if [ ${#ARGS[@]} -gt 1 ]; then
  echo 
  echo
  echo "Usage:"
  echo "script2.sh [group_name]"
  exit 1
fi



echo
echo "Check the existance of a group :"

GROUP=$1

if [ -z $GROUP ]; then
  read GROUP
fi

cat /etc/group | grep $GROUP  &> /dev/null

if [ $? == 0 ]; then
  echo Group $GROUP exists
else
  echo Group $GROUP doesnt exist
fi
