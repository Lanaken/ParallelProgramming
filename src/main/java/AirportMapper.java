import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] words = line.split(",[\"]");
        if (key.get() > 0){
            String id = words[0].replaceAll("\"","");
            String description = words[1].replaceAll("\"","");
            context.write(new AirportWritable(Integer.parseInt(id),0), new Text(description));
        }
    }
}