
public class DayState implements ReadableDayState {
	private static final Time
		DAY_START = new Time(9, 0),
		MORNING_MEAL = new Time(4, 0),
		MEAL_SPACING = new Time(4, 0),
		DAY_END = new Time (21,30);
	
	private static final Location HOME = Location.PETERS;
	
	private Time currentTime;
	private Time lastMealAt;
	private Location currentLocation;
	
	DayState(){
		currentTime = DAY_START;
		lastMealAt = MORNING_MEAL;
		currentLocation = HOME;
	}
	
	@Override
	public Time timeNow(){
		return currentTime;
	}

	@Override
	public Time timeOfLastMeal() {
		return lastMealAt;
	}

	@Override
	public boolean dayOver() {
		return currentTime.compareTo(DAY_END) == 1;
	}

	public boolean atHome() {
		return currentLocation == HOME;
	}

	public Location currentLocation() {
		return currentLocation;
	}
	
	public Location home() {
		return HOME;
	}

	public void incrimentTime(Time duration) {
		currentTime = currentTime.add(duration);
	}

	public void justAte() {
		lastMealAt = currentTime;
	}

	public void changeLocationTo(Location location) {
		currentLocation = location;
	}

	public boolean hungry() {
		return lastMealAt.add(MEAL_SPACING).compareTo(currentTime) == -1;
	}
}
