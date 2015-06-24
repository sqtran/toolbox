#!/bin/bash

ARGS=($@)

echo "arg size = "${#ARGS[@]}
echo "done"

for i in ${ARGS[@]}; do  
 echo $i
done



