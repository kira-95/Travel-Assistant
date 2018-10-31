today=`date '+%Y_%m_%d_%H:%M:%S'`;
sh ../pmd-bin-6.9.0/bin/run.sh pmd -d ../src/ -f text -R rulesets/java/basic.xml > ./logs/$today.static_analysis.txt
