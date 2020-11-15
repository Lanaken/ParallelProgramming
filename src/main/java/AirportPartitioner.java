import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AirportPartitioner extends Partitioner<AirportWritable, Text> {

    @Override
    public int getPartition(AirportWritable airportWritable, Text text, int i) {
        return (airportWritable.getAirport_ID() % i);
    }
}
