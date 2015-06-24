#!/bin/bash
OPS=$1
HELLO="hello world"

trap bashtrap INT

echo $HELLO `whoami`

bashtrap()
{
  local HELLO="goodbye"
  echo ''
  echo "caught in the trap house"
  echo $HELLO
  exit 9
}

if [ -z $OPS ]; then
  echo 'enter a username to check for'
  read OPS
fi

id $OPS &> /dev/null

if [ $? -eq 0 ]; then
  echo 'user' $OPS 'exists'
else
  echo 'user ' $OPS ' doesnt exist'
fi
