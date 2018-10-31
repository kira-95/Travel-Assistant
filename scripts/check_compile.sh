success=$( javac ./src/Main.java ./src/Controller.java )

if [ -z "$success" ]; then
	echo 0
else
	echo 1
fi
