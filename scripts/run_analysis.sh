today=`date '+%Y_%m_%d_%H:%M:%S'`;
warning=$(sh ./pmd-bin-6.9.0/bin/run.sh pmd -d ./src/ -f text -R rulesets/java/basic.xml)

if [ -z "$warning" ]; then
	echo 0
else 
	echo "$warning" > ./logs/$today.static_analysis.txt
	echo 1
fi

