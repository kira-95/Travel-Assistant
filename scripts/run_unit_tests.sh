test=$( ant test )

if [[ $test == *"SUCCESSFUL"* ]]; then
	echo 0
else
	echo 1
fi