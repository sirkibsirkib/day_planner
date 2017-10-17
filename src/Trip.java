
public class Trip extends Activity{
	private int walkMinutes;

	public Trip(String description, int durationMinutes, Location start, Location end, int walkMinutes) {
		super(description, ActType.TRAVEL, durationMinutes, start, end);
	}
	
	@Override
	public String toString(){
		return getDuration().toString() + " " + getDescription() + " " + getStart().name() + " --> " + getEnd().name();
	}

	public int getWalkMinutes() {
		return walkMinutes;
	}
}
