import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import scala.Tuple2;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static JavaRDD<String> flights;
    private static JavaRDD<String> airports;
    private static JavaPairRDD<String,String> airport;
    private static JavaPairRDD<Tuple2<String,String>, Flight> flight;
    private static AtomicInteger countOfLate = new AtomicInteger();
    private static AtomicInteger countOfCancelled = new AtomicInteger();
    private static float maxTimeOfDelay = 0;

    private static void downloadData(JavaSparkContext sc,String[] args){
        flights = sc.textFile(args[0]);
        airports = sc.textFile(args[1]);
        JavaRDD<String> finalFlights = flights;
        JavaRDD<String> finalAirports = airports;
        flights = flights.filter(a -> !a.equals(finalFlights.first()));
        airports = airports.filter(a -> !a.equals(finalAirports.first()));
    }
    private static double makePairRDD(){
        airport = airports.mapToPair(
                line -> {
                    String[] columns = line.split(",");
                    String code = columns[0].replace("\"","");
                    String description = columns[1].replace("\"","");
                    return new Tuple2<>(code,description);
                });
        flight = flights
                .mapToPair(line -> {
                    String[] columns = line.split(",");
                    boolean cancelled = columns[19].isEmpty();
                    if (cancelled)
                        countOfCancelled.getAndIncrement();
                    String departure = columns[11];
                    String destination = columns[14];
                    float timeOfDelay = Float.parseFloat(columns[18]);
                    if (timeOfDelay > 0) {
                        countOfLate.getAndIncrement();
                        if (timeOfDelay > maxTimeOfDelay)
                            maxTimeOfDelay = timeOfDelay;
                    }
                    return new Tuple2<>(new Tuple2<>(departure,destination),new Flight(destination,departure,cancelled,timeOfDelay));
                });
    }
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);
        downloadData(sc,args);
        makePairRDD();
        final Broadcast<Map<String,String>> airpotsBroadcast = sc.broadcast(airport.collectAsMap());
        flight.groupByKey().mapValues(
                pair -> {

                }
        )
    }

}
