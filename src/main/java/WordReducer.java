import org.apache.hadoop.fs.shell.Display;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapred.MapOutputCollector;

import java.io.IOException;

public class WordReducer extends Reducer<Display.Text, IntWritable, Display.Text, LongWritable> {
    @Override
    protected void reduce(Display.Text key, Iterable<IntWritable> values, MapOutputCollector.Context context) throws
            IOException, InterruptedException {

    }
}