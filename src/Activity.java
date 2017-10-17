
public class Activity {
	private String description;
	private ActType ac;
	private Time duration;
	private Location start;
	private Location end;
	
	public Activity(String description, ActType ac, Time duration, Location start, Location end){
		this.description = description;
		this.ac = ac;
		this.duration = duration;
		this.start = start;
		this.end = end;
	}
	
	public Activity(String description, ActType ac, int durationMinutes, Location start, Location end){
		this.description = description;
		this.ac = ac;
		duration = new Time(durationMinutes);
		this.start = start;
		this.end = end;
	}

	public String getDescription() {
		return description;
	}

	public ActType getAc() {
		return ac;
	}

	public Time getDuration() {
		return duration;
	}

	public Location getStart() {
		return start;
	}

	public Location getEnd() {
		return end;
	}

	public boolean isMeal() {
		return ac == ActType.MEAL;
	}

	public boolean isTravel() {
		return ac == ActType.TRAVEL;
	}

	public boolean isExercise() {
		return ac == ActType.EXERCISE;
	}
}
