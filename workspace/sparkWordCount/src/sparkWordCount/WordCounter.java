package sparkWordCount;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

/**
 * 
 * @author cloudera
 * 
 * input file 
 * 
 * hi i m neha 
i live with my family 
nice talking to u
hi how r u?
 * 
 * 
 * spark-submit --class sparkWordCount.WordCounter --master local /home/cloudera/Desktop/sparkWordCount.jar /user/spark/sparkWordcount/hello.txt /user/spark/sparkWordcount/sparkoutput

 * 
 */



public class WordCounter {
	
	///usr/lib/spark/bin/spark-submit --class com.javaeight.poc.WordCounter --master localhost --deploy-mode client SparkRun.jar /home/cloudera/Downloads/hello.txt 

    private static void wordCount(String fileName) {
    	
    	System.out.println("enterd the word count method");
    	
    	fileName = "/user/spark/sparkWordcount/hello.txt";

        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("Spark code two");

        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

        JavaRDD<String> lines = sparkContext.textFile(fileName);

        JavaRDD<String> wordsInLine = lines.flatMap(content -> Arrays.asList(content.split(" ")));

        JavaPairRDD countData = wordsInLine.mapToPair(t -> new Tuple2(t, 1)).reduceByKey((x, y) -> (int) x + (int) y);

        countData.saveAsTextFile("/user/spark/sparkWordcount/CountData1");
        
        sparkContext.stop();
    }

    public static void main(String[] args) {

       /* if (args.length == 0) {
            System.out.println("No files provided.");
            System.exit(0);
        }*/

        wordCount("/user/spark/sparkWordcount/hello.txt");
    }
}



/**
 * ______-----------------output ------------------------------------
(hi,2)
(family,1)
(i,2)
(how,1)
(u,1)
(with,1)
(neha,1)
(to,1)
(live,1)
(nice,1)
(my,1)
(u?,1)
(r,1)
(talking,1)
(m,1)
-------------------------------------------------------------------------
 * 
 */


