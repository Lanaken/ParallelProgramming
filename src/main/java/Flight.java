import scala.Serializable;

public class Flight implements Serializable {
    private String airportOfDeparture;
    private String airportOfArrival;
    private boolean cancelled;
    private Float timeOfDelay;
    Flight(String airportOfArrival,String airportOfDeparture, boolean cancelled, Float timeOfDelay){
        this.airportOfArrival = airportOfArrival;
        this.airportOfDeparture = airportOfDeparture;
        this.cancelled = cancelled;
        this.timeOfDelay = timeOfDelay;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public Float getTimeOfDelay() {
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
                "isCancelled = " + cancelled +
                "timeOfDelay = " + timeOfDelay + "}";
    }
}
