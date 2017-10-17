import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class ActivityPool {
	private static List<Activity> activities;
	private static Map<Activity, Time> opens;
	private static Map<Activity, Time> closes;
	private static Map<Activity, Double> acceptanceSides;
	
	public static void init(){
		activities = new ArrayList<>();
		opens = new HashMap<>();
		closes = new HashMap<>();
		acceptanceSides = new HashMap<>();
		populateMeals();
		populateExercise();
		populateTourism();
		populatePersonal();
	}
	
	private static void lastActivityOpensAt(Time t){
		opens.put(activities.get(activities.size()-1), t);
	}

	private static void lastActivityClosesAt(Time t){
		Activity a = activities.get(activities.size()-1);
		closes.put(a, t.subtract(a.getDuration()));
	}

	private static void populatePersonal() {
		addPersonal("Show Uni", 30, Location.PETERS, Location.PETERS);
		lastActivityClosesAt(new Time(19,0));
		addPersonal("Show Code @ peter", 30, Location.PETERS, Location.PETERS);
		addPersonal("Show Code @ tiengemeten", 30, Location.TIENGEMETEN, Location.TIENGEMETEN);
		addPersonal("Uilenstede Tour", 30, Location.JUMBO, Location.JUMBO);
		addPersonal("Cup of Tea @ peters", 15, Location.PETERS, Location.PETERS);
		addPersonal("Cup of Tea @ Tiengemeten", 15, Location.TIENGEMETEN, Location.TIENGEMETEN);
		addPersonal("Drinks @ Tiengemeten", 35, Location.TIENGEMETEN, Location.TIENGEMETEN);
		lastActivityOpensAt(new Time(19,0));
		addPersonal("GelderlandPlein", 40, Location.PETERS, Location.PETERS);
		lastActivityClosesAt(new Time(20,0));
		addPersonal("Beer places", 60, Location.LEIDSPLEIN, Location.RIJKSMUSEUM);
		lastActivityOpensAt(new Time(19,0));
		addPersonal("Home Movie", 120, Location.PETERS, Location.PETERS);
		lastActivityOpensAt(new Time(15,0));
	}

	private static void populateTourism() {
		addTourism("De Oude Kerk", 20, Location.CENTRAL, Location.CENTRAL);
		lastActivityClosesAt(new Time(20,0));
		addPersonal("Anno 1980", 30, Location.ANNO1890, Location.ANNO1890);
		lastActivityOpensAt(new Time(19,0));
		addPersonal("Albert Cuijp", 30, Location.RIJKSMUSEUM, Location.RIJKSMUSEUM);
		lastActivityOpensAt(new Time(10,0));
		lastActivityClosesAt(new Time(16,0));
		addPersonal("Niewemarkt", 30, Location.EASTSIDE, Location.EASTSIDE);
		addPersonal("Red Light District", 30, Location.EASTSIDE, Location.EASTSIDE);
		lastActivityOpensAt(new Time(19,0));
		addPersonal("Uilenstede Bar", 45, Location.JUMBO, Location.JUMBO);
		lastActivityOpensAt(new Time(19,0));
		addPersonal("Rijksmuseum", 140, Location.RIJKSMUSEUM, Location.RIJKSMUSEUM);
		lastActivityClosesAt(new Time(17,0));
		addPersonal("Fo Guang Shan", 20, Location.CENTRAL, Location.CENTRAL);
		lastActivityClosesAt(new Time(17,0));
		addPersonal("Tuschinski", 140, Location.EASTSIDE, Location.EASTSIDE);
		lastActivityOpensAt(new Time(11,0));
		lastActivityClosesAt(new Time(22,0));
		addPersonal("Oublie", 17, Location.EASTSIDE, Location.EASTSIDE);
		lastActivityClosesAt(new Time(20,0));
		addPersonal("Amstelveen Center", 50, Location.AMSTELVEENCENTER, Location.AMSTELVEENCENTER);
		lastActivityOpensAt(new Time(11,0));
		lastActivityClosesAt(new Time(20,0));
		addPersonal("Torensluis", 140, Location.CENTRAL, Location.CENTRAL);
		addPersonal("Jordaan", 50, Location.CENTRAL, Location.CENTRAL);
		lastActivityClosesAt(new Time(22,0));
		addPersonal("Anne Frank House", 140, Location.CENTRAL, Location.CENTRAL);
		lastActivityOpensAt(new Time(9,0));
		lastActivityClosesAt(new Time(15,30));
		addPersonal("Begijnkorf", 30, Location.CENTRAL, Location.CENTRAL);
		lastActivityOpensAt(new Time(11,0));
		lastActivityClosesAt(new Time(22,0));
		addPersonal("ABC Bookstore", 30, Location.CENTRAL, Location.CENTRAL);
		lastActivityOpensAt(new Time(11,0));
		lastActivityClosesAt(new Time(17,30));
	}

	private static void populateExercise() {
		addExercise("Bos Walk", 30, Location.BOS, Location.BOS);
		addExercise("Bos Slacklining", 60, Location.BOS, Location.BOS);
		lastActivityClosesAt(new Time(19,0));
		addExercise("Tiengemeten Slacklining", 30, Location.TIENGEMETEN, Location.TIENGEMETEN);
		lastActivityClosesAt(new Time(19,0));
		addExercise("Amstel Walk @ peter", 30, Location.PETERS, Location.PETERS);
		addExercise("Amstel Walk peter -> jumbo", 30, Location.PETERS, Location.JUMBO);
		addExercise("Big Walk", 180, Location.TIENGEMETEN, Location.RIJKSMUSEUM);
		lastActivityClosesAt(new Time(14,0));
		addExercise("VondelPark westward", 180, Location.RIJKSMUSEUM, Location.STARINGATJAKOB);
		lastActivityClosesAt(new Time(60,0));
		addExercise("VondelPark eastward", 180, Location.STARINGATJAKOB, Location.RIJKSMUSEUM);
		lastActivityClosesAt(new Time(60,0));
	}

	private static void populateMeals() {
		addMeal("Staring at Jacob", 90, Location.STARINGATJAKOB);
		lastActivityClosesAt(new Time(15,0));
		addMeal("Sumo", 110, Location.LEIDSPLEIN);
		lastActivityOpensAt(new Time(12,0));
		lastActivityClosesAt(new Time(20,0));
		addMeal("Burger Bar east", 70, Location.EASTSIDE);
		addMeal("Burger Bar central", 70, Location.CENTRAL);
		addMeal("Burger Zaken", 70, Location.EASTSIDE);
		lastActivityOpensAt(new Time(12,0));
		addMeal("Rijks Albert Heijn", 70, Location.RIJKSMUSEUM);
		addMeal("Bolognese @ teingemeten", 120, Location.TIENGEMETEN);
		lastActivityOpensAt(new Time(17,0));
		addMeal("Bratkartoffel @ teingemeten", 120, Location.TIENGEMETEN);
		lastActivityOpensAt(new Time(17,0));
		addMeal("Jumbo Food Stall", 50, Location.JUMBO);
		lastActivityClosesAt(new Time(13, 0));
		addMeal("New York Steakhouse", 110, Location.LEIDSPLEIN);
		lastActivityOpensAt(new Time(18,0));
		addMeal("Flammkuchen Place", 90, Location.CENTRAL);
		lastActivityOpensAt(new Time(19,0));
		addMeal("Muesli @ peter", 40, Location.PETERS);
		lastActivityClosesAt(new Time(14,0));
		addMeal("Toast @ peter", 40, Location.PETERS);
		addMeal("Greek", 70, Location.KOSTVERLORENHUIS);
		lastActivityOpensAt(new Time(18,0));
		addMeal("Mannekin Pis", 30, Location.CENTRAL);
		addMeal("VondelPark barbecue", 170, Location.LEIDSPLEIN);
		lastActivityOpensAt(new Time(12,0));
		addMeal("The Lobby Nesplien", 100, Location.CENTRAL);
		lastActivityOpensAt(new Time(18,0));
		addMeal("Pesto Pasta @ peters", 100, Location.PETERS);
		lastActivityOpensAt(new Time(18,0));
		addMeal("Bos picnic", 40, Location.BOS);
		lastActivityClosesAt(new Time(19,0));
	}

	private static void addExercise(String description, int durationMinutes, Location start, Location end) {
		activities.add(new Activity(description, ActType.EXERCISE, durationMinutes, start, end));
	}
	
	private static void addTourism(String description, int durationMinutes, Location start, Location end) {
		activities.add(new Activity(description, ActType.TOURISM, durationMinutes, start, end));
	}
	
	private static void addPersonal(String description, int durationMinutes, Location start, Location end) {
		activities.add(new Activity(description, ActType.PERSONAL, durationMinutes, start, end));
	}
	
	private static void addMeal(String description, int durationMinutes, Location loc) {
		activities.add(new Activity(description, ActType.MEAL, durationMinutes, loc, loc));
	}

	public static List<Activity> getOptions() {
		return new ArrayList<>(activities);
	}
	
	public static boolean activityWithinConstraints(Activity a, Time currentTime){
		return activityOpen(a, currentTime) && activityAccepted(a);
	}
	
	private static boolean activityAccepted(Activity a) {
		return !acceptanceSides.containsKey(a) || Fun.rdg(acceptanceSides.get(a)) < 1;
	}

	private static boolean activityOpen(Activity a, Time currentTime) {
		if(opens.containsKey(a)){
			if(opens.get(a).compareTo(currentTime) == 1){
				return false;
			}
		}
		if(closes.containsKey(a)){
			if(closes.get(a).compareTo(currentTime) == -1){
				return false;
			}
		}
//		System.out.println(a.getDescription() + " open at " + currentTime);
		return true;
	}

	public static void resetAcceptanceSides(){
		acceptanceSides.clear();
	}
	
	public static void decayAcceptance(){
		for(Activity d : acceptanceSides.keySet()){
			double mult = d.getAc() == ActType.TOURISM ? .97 : .85;
			acceptanceSides.put(d, acceptanceSides.get(d)*mult);
		}
	}
	
	public static void incrimentAcceptsanceSides(Activity a){
		double dividend = 18;
		if(!acceptanceSides.containsKey(a)){
			acceptanceSides.put(a, 1D);
		}
		acceptanceSides.put(a, acceptanceSides.get(a) + (a.getDuration().toMin()/dividend));
	}
	
	public static void printAcceptance(){
		System.out.println("ACTIVITY ACCEPTANCE SIDES");
		for(Activity d : acceptanceSides.keySet()){
			System.out.println(d.getDescription() + "\t\t" + acceptanceSides.get(d));
		}
	}
}
