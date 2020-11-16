import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapOutputCollector;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class AirportReducer extends Reducer<AirportWritable, Text, Text, Text> {
    protected void reduce(AirportWritable key, Iterable<Text> values, Context context) throws
            IOException, InterruptedException {
        long count = 0;
        float sum = 0;
        float min = 0;
        float max = Float.MAX_VALUE;
        Iterator iterator = values.iterator();
        Text name = new Text(iterator.next().toString());
        while (iterator.hasNext()){
            float delay = Float.parseFloat(iterator.next().toString());
            sum += delay;
            count++;
            max = Math.max(delay,max);
            min = Math.min(delay,min);
        }
        if (count > 0) {
            sum /= count;
            context.write(name, new Text( min + " , " + max + " , " + sum + " \n"));
        }
    }
}