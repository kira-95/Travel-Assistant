success=$( javac -d ./bin/temp ./src/Main.java ./src/Controller.java )

# remove build files
rm ./bin/temp/*.class

if [ -z "$success" ]; then
	echo 0
else
	echo 1
fi
