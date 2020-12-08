import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import scala.Tuple2;

import java.util.Map;

public class Main {
    private static JavaRDD<String> flights;
    private static JavaRDD<String> airports;

    private static void downloadData(JavaSparkContext sc,String[] args){
        flights = sc.textFile(args[0]);
        airports = sc.textFile(args[1]);
        JavaRDD<String> finalFlights = flights;
        JavaRDD<String> finalAirports = airports;
        flights = flights.filter(a -> !a.equals(finalFlights.first()));
        airports = airports.filter(a -> !a.equals(finalAirports.first()));
    }
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);
        downloadData(sc,args);
        JavaPairRDD<String,String> airport = airports.mapToPair(
                line -> {
                String[] columns = line.split(",");
                String code = columns[0].replace("\"","");
                String description = columns[1].replace("\"","");
                return new Tuple2<>(code,description);
                });
        final Broadcast<Map<String,String>> broadcast = sc.broadcast(airport.collectAsMap());
        JavaPairRDD<Tuple2<String,String>, Flight> flightJavaPairRDD = flights
                .mapToPair(line -> {

                })
    }

}
