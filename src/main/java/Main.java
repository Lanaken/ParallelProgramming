import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class main {
    SparkConf conf = new SparkConf().setAppName("lab3");
    JavaSparkContext sc = new JavaSparkContext(conf);
    

}
