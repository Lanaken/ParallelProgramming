import scala.Serializable;

public class Flight implements Serializable {
    private String airportOfDeparture;
    private String airportOfArrival;
    private boolean isCancelled;
    private int timeOfDelay;
    Flight(String airportOfArrival,String airportOfDeparture, boolean isCancelled, int timeOfDelay){
        this.airportOfArrival = airportOfArrival;
        this.airportOfDeparture = airportOfDeparture;
        this.isCancelled = isCancelled;
        this.timeOfDelay = timeOfDelay;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public int getTimeOfDelay() {
        return timeOfDelay;
    }

    public String getAirportOfArrival() {
        return airportOfArrival;
    }

    public String getAirportOfDeparture() {
        return airportOfDeparture;
    }

    @Override
    public String toString(){
        return "Flight{" +
                "airportOfDeparture = " + airportOfDeparture +
                "airportOfArrival = " + airportOfArrival +
                "isCancelled = " + isCancelled +
                "timeOfDelay = " + timeOfDelay + "}";
    }
}
