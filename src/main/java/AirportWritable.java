import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportWritable extends Text implements WritableComparable<AirportWritable> {
    private int Airport_ID;
    private int indicator;

    AirportWritable(){}

    AirportWritable(int Airport_ID,int indicator){
        this.Airport_ID = Airport_ID;
        this.indicator = indicator;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(Airport_ID);
        dataOutput.writeInt(indicator);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        Airport_ID = dataInput.readInt();
        indicator = dataInput.readInt();
    }

    public void setAirport_ID(int airport_ID) {
        Airport_ID = airport_ID;
    }

    public void setIndicator(int indicator) {
        this.indicator = indicator;
    }

    public int getAirport_ID() {
        return Airport_ID;
    }

    public int getIndicator() {
        return indicator;
    }

    @Override
    public int compareTo(AirportWritable o) {
        int a = this.Airport_ID - o.Airport_ID;
        int b = this.indicator - o.indicator;
        if (a == 1 || a == -1)
            a += a;
        return a + b;
    }
}
