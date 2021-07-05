package From_OO_Design_to_Functional_Foundation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Airplane {

    private final Integer fuelLevel;
    private final String airline;
    private final List<String> passengers;
    private final List<String> stops;

    private Airplane(Integer fuelLevel, String airline, List<String> passengers, List<String> stops) {
        this.fuelLevel = fuelLevel;
        this.airline = airline;
        this.passengers = passengers;
        this.stops = stops;
    }

    public static Airplane withFuelLevelAirlinePassengers(int fuelLevel, String airline, String...passengers)
    {
        List<String> passengrs = Collections.unmodifiableList(Arrays.asList(passengers));
        return new Airplane(fuelLevel,airline,passengrs,null);

    }

    private static Airplane withFuelLevelAirlinePassengersAndStops(int fuelLevel,String airline,List<String> passengers,String...stops)
    {
        List<String> passengrs = Collections.unmodifiableList(passengers);
        return new Airplane(fuelLevel,airline,passengrs,Arrays.asList(stops));


    }

    public Integer getFuelLevel() {
        return fuelLevel;
    }

    public String getAirline() {
        return airline;
    }

    public List<String> getPassengers() {
        return passengers;
    }

    public List<String> getStops() {
        return stops;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "fuelLevel=" + fuelLevel +
                ", airline='" + airline + '\'' +
                ", passengers=" + passengers +
                ", stops=" + stops +
                '}';
    }
}
