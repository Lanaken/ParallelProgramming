
import scala.Serializable;

public class Airport implements Serializable {
    private int code = 0;
    private int description = 1;
    private String[] airport;

    public int getCode() {
        return code;
    }

    public int getDescription() {
        return description;
    }
}
