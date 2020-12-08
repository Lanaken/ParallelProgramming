import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

public class Main {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> flights = sc.textFile(args[0]);
        JavaRDD<String> airports = sc.textFile(args[1]);
        JavaRDD<String> finalFlights = flights;
        JavaRDD<String> finalAirports = airports;
        flights = flights.filter(a -> !a.equals(finalFlights.first()));
        airports = airports.filter(a -> !a.equals(finalAirports.first()));
        JavaPairRDD<String,String> airport = airports.mapToPair(
                line -> {
                String[] columns = line.split(",");
                String code = columns[0].replace("\"","");
                String description = columns[1].replace("\"","");
                return new Tuple2<>(code,description);
                });
    }

}
