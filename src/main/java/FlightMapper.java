import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        int airport_id_column = 14;
        int airport_delay_column = 18;
        String line = value.toString();
        String[] words = line.split(",");
        if (key.get() > 0){
            float arr_delay = 0;
            if (words[14])
            context.write(new AirportWritable(Integer.parseInt(id),0), new Text(description));
        }
    }
}