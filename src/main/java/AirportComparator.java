import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirportComparator extends WritableComparator {
    protected AirportComparator() {
        super(AirportWritable.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b){
        return (((AirportWritable)a).getAirport_ID() - ((AirportWritable)b).getAirport_ID());
    }
}
