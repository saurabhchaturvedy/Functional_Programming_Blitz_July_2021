package From_OO_Design_to_Functional_Foundation_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


class PassengerCountOrder implements Comparator<Airplane>
{


    @Override
    public int compare(Airplane o1, Airplane o2) {
        return o1.getPassengers().size()-o2.getPassengers().size();
    }
}

interface AirplaneCriterion
{

    boolean test(Airplane airplane);
}



public class AirplaneTests {


    public static void listAirplanes(List<Airplane> airplanes)
    {

        for(Airplane airplane : airplanes)
        {
            System.out.println(airplane);
        }
    }

//    public static List<Airplane> getAirplanesByAirlines(Iterable<Airplane> airplanes, String airline)
//    {
//
//        List<Airplane> airplanes1 = new ArrayList<>();
//
//        for(Airplane airplane : airplanes)
//        {
//
//            if(airplane.getAirline().equals(airline))
//            {
//                airplanes1.add(airplane);
//            }
//        }
//
//        return airplanes1;
//    }

    public static List<Airplane> getAirplanesByAirlines(Iterable<Airplane> airplanes, AirplaneCriterion airplaneCriterion)
    {

        List<Airplane> airplanes1 = new ArrayList<>();

        for(Airplane airplane : airplanes)
        {

            if(airplaneCriterion.test(airplane))
            {
                airplanes1.add(airplane);
            }
        }

        return airplanes1;
    }

    public static void main(String[] args) {
        List<Airplane> airplanes = Arrays.asList(

                Airplane.withFuelLevelAirlinePassengers(50, "Air India", "ram", "shyam"),
                Airplane.withFuelLevelAirlinePassengers(150, "Air India", "ram", "deepak","ramesh"),
                Airplane.withFuelLevelAirlinePassengers(250, "United Airlines", "john", "dave","billy","tom","peter"),
                Airplane.withFuelLevelAirlinePassengers(150, "Air Vistara", "shyam", "anil","suresh","prabha"),
                Airplane.withFuelLevelAirlinePassengers(50, "Emirates", "khalid"),
                Airplane.withFuelLevelAirlinePassengers(50, "Aero Mexico", "carlos", "pinto","martinez")
        );

        airplanes.sort(new PassengerCountOrder());
        listAirplanes(airplanes);

        System.out.println("Filtering Airplanes by airlines");
        System.out.println();

        List<Airplane> air_india = getAirplanesByAirlines(airplanes,new Airplane.AirplanesFuelLevelCriterion(150));

        for(Airplane airplane : air_india)
        {

            System.out.println(airplane);
        }
    }
}
