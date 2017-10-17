import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public abstract class LocationMap {
	static List<Trip> trips;
	static Map<String, Trip> travelTimes;

	public static void init() {
		trips = new ArrayList<>();
		addTrip(Location.CENTRAL, Location.LEIDSPLEIN, "Walk", 20);
		addTrip(Location.BOS, Location.TIENGEMETEN, "Walk", 30);
		addTrip(Location.KOSTVERLORENHUIS, Location.TIENGEMETEN, "Walk", 15);
		addTrip(Location.TIENGEMETEN, Location.UNIVERSITY, "Walk", 35);
		addTrip(Location.UNIVERSITY, Location.RIJKSMUSEUM, "Tram", 30);
		addTrip(Location.RIJKSMUSEUM, Location.CENTRAL, "Tram", 15);
		addTrip(Location.TIENGEMETEN, Location.RIJKSMUSEUM, "Tram", 35);
		addTrip(Location.UNIVERSITY, Location.PETERS, "Walk", 3);
		addTrip(Location.LEIDSPLEIN, Location.RIJKSMUSEUM, "Tram", 10);
		addTrip(Location.LEIDSPLEIN, Location.STARINGATJAKOB, "Walk", 20);
		addTrip(Location.PETERS, Location.BOS, "Walk", 40);
		addTrip(Location.TIENGEMETEN, Location.JUMBO, "Walk", 15);
		addTrip(Location.UNIVERSITY, Location.JUMBO, "Walk", 30);
		addTrip(Location.JUMBO, Location.RIJKSMUSEUM, "Walk", 33);
		addTrip(Location.ANNO1890, Location.TIENGEMETEN, "Walk", 15);
		addTrip(Location.ANNO1890, Location.BOS, "Walk", 20);
		addTrip(Location.ANNO1890, Location.UNIVERSITY, "Walk", 25);
		addTrip(Location.UNIVERSITY, Location.EASTSIDE, "Metro 5", 35);
		addTrip(Location.TIENGEMETEN, Location.EASTSIDE, "Metro 5", 40);
		addTrip(Location.EASTSIDE, Location.CENTRAL, "Walk", 14);
		addTrip(Location.TIENGEMETEN, Location.OUDEKERK, "Walk", 60);
		addTrip(Location.TIENGEMETEN, Location.MULDERSLOOT, "Car", 30);
		addTrip(Location.TIENGEMETEN, Location.AMSTELVEENCENTER, "Tram", 25);
		
		travelTimes = LocationSinker.sink(trips);
	}
	
	private static void addTrip(Location a, Location b, String mode, int min) {
		trips.add(new Trip(mode, min, a, b, mode.equals("Walk") ? min : 0));
	}

	public static Activity travelBetween(Location a, Location b){
		if(a == b){
			return null;
		}
		Trip x = null;
		if(travelTimes.containsKey(a.name() + b.name())){
			x = travelTimes.get(a.name() + b.name());
		}else if(travelTimes.containsKey(b.name() + a.name())){
			x = travelTimes.get(b.name() + a.name());
		}else{
			throw new Error("No data for traven between [" + a.name() + "] and [" + b.name() + "]");
		}
		return x;
	}
}
