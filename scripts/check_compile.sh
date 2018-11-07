#success=$( javac -d ./bin/temp ./src/Main.java ./src/Controller.java )
# remove build files
# rm ./bin/temp/*.class

compile=$( ant compile )

if [[ $compile == *"SUCCESSFUL"* ]]; then
	echo 0
else
	echo 1
fi

#if [ -z "$compile" ]; then
#	echo 0
#else
#	echo 1
#fi
