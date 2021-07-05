package From_OO_Design_to_Functional_Foundation_01;

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

    public static Criterion<Airplane> getAirplanesEmiratesCriterion()
    {   // return new AirplanesEmiratesCriterion();
        return AIRPLANES_EMIRATES_CRITERION;  // criterion hidden from caller , no impact on client on change
        // singleton pattern
        // question of quantity
    }

    public static Criterion<Airplane> getAirplanesFuelLevelCriterion(int fuelLevel)
    {   // return new AirplanesEmiratesCriterion();
        return (c -> c.getFuelLevel()==fuelLevel);  // criterion hidden from caller , no impact on client on change
        // not singleton pattern
        // question of quantity
    }

//    private static final AirplaneCriterion AIRPLANES_EMIRATES_CRITERION = new AirplaneCriterion()
//    {
//
//        @Override
//        public boolean test(Airplane airplane) {
//            return airplane.getAirline().equals("Emirates");
//        }
//    };

    // Lambda assignment
    private static final Criterion<Airplane> AIRPLANES_EMIRATES_CRITERION = (airplane) -> {
            return airplane.getAirline().equals("Emirates");
        };


//    private static final AirplanesEmiratesCriterion AIRPLANES_EMIRATES_CRITERION = new AirplanesEmiratesCriterion();
//
//
//   // public static final AirplanesEmiratesCriterion AIRPLANES_EMIRATES_CRITERION = new AirplanesEmiratesCriterion();
//
//    // Question of ownership
//   private static class AirplanesEmiratesCriterion implements AirplaneCriterion
//    {
//
//        @Override
//        public boolean test(Airplane airplane) {
//            return airplane.getAirline().equals("Emirates");
//        }
//    }

//   static class AirplanesFuelLevelCriterion implements Criterion<Airplane>
//    {
//
//        int fuelLevel;
//
//        public AirplanesFuelLevelCriterion(int fuelLevel) {
//            this.fuelLevel = fuelLevel;
//        }
//
//        @Override
//        public boolean test(Airplane airplane) {
//            return airplane.fuelLevel.equals(this.fuelLevel);
//        }
//    }
}
