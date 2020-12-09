import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import scala.Tuple2;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static JavaRDD<String> flights;
    private static JavaRDD<String> airports;
    private static JavaPairRDD<String,String> airport;
    private static JavaPairRDD<Tuple2<String,String>, Flight> flight;
    private static void downloadData(JavaSparkContext sc,String[] args){
        boolean file = new File("output").delete();
        flights = sc.textFile(args[0]);
        airports = sc.textFile(args[1]);
        String finalFlights = flights.first();
        String finalAirports = airports.first();
        flights = flights.filter(a -> !a.equals(finalFlights));
        airports = airports.filter(a -> !a.equals(finalAirports));
    }
    private static void makePairRDD(){
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
                    String departure = columns[11];
                    System.out.println(columns[18].isEmpty());
                    String destination = columns[14];
                    float timeOfDelay = columns[18].isEmpty() ? 0 : Float.parseFloat(columns[18]);
                    return new Tuple2<>(new Tuple2<>(departure,destination),new Flight(destination,departure,cancelled,timeOfDelay));
                });
    }
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("lab3").setMaster("local[2]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        downloadData(sc,args);
        makePairRDD();
        final Broadcast<Map<String,String>> airpotsBroadcast = sc.broadcast(airport.collectAsMap());
        flight.groupByKey().mapValues(
                flights -> {
                    Iterator<Flight> iterator = flights.iterator();
                    int countOfCancelled = 0;
                    int countOfDelayed = 0;
                    int count = 0;
                    float maxTimeOfDelay = 0;
                    for (Iterator<Flight> flightIterator = iterator;iterator.hasNext();){
                        Flight flight = flightIterator.next();
                        if (flight.isCancelled())
                            countOfCancelled++;
                        if (flight.getTimeOfDelay() > 0){
                            countOfDelayed++;
                            if (maxTimeOfDelay < flight.getTimeOfDelay())
                                maxTimeOfDelay = flight.getTimeOfDelay();
                        }
                        count++;
                    }
                    String result =  "countOfCancelled = " + countOfCancelled/count + " countOfDelayed =" + countOfDelayed/count +
                            " maxTimeOfDelay = " + maxTimeOfDelay;
                    return result;
                }).map( fl -> {
                    String destName = airpotsBroadcast.value().get(fl._1._2);
                    String depName = airpotsBroadcast.value().get(fl._1._1);
                    String result = "departureName = " + depName + " destName = " + destName + " flight info :" + fl._2;
                    return result;
                }).saveAsTextFile(args[2]);
    }

}
