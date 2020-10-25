
import org.apache.log4j.BasicConfigurator;


public class JoinClass {
    public static void main(String[] args){
        BasicConfigurator.configure();
        if (args.length != 2) {
            System.err.println("Usage: WordCountApp <input path> <output path>");
            System.exit(-1);
        }
    }
}
