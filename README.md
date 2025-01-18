# TPRenduBigData

Bonjour, 
Voici les instructions à suivre pour lancer les différents jobs.

	Mettre le fichier data.txt dans hdfs 
hadoop fs -put /tmp/data/relationships/data.txt /data/
	Lancer le premier job
hadoop jar /tmp/jars/hadoop-tp3-collaborativeFiltering-job1-1.0.jar /data/data.txt /data/output/
	Voir les resultats des 5 premieres lignes
hadoop fs -cat /data/output/part-r-00000 | head -n 5
	Lancer le deuxieme job
hadoop jar /tmp/jars/hadoop-tp3-collaborativeFiltering-job2-1.0.jar /data/output/ /data/output-job2/
	Voir les resultats des 5 premieres lignes
hadoop fs -cat /data/output-job2/part-r-00000 | head -n 5

	Lancer le troisieme job
hadoop jar /tmp/jars/hadoop-tp3-collaborativeFiltering-job3-1.0.jar /data/output-job2/ /data/output-job3/
	Voir les resultats des 5 premieres lignes
hadoop fs -cat /data/output-job3/part-r-00000 | head -n 5
