
public class Event {
	private Activity a;
	private Time start, end;
	
	public Event(Activity a, Time t){
		this.a = a;
		this.start = t;
		this.end = start.add(a.getDuration());
	}

	public Activity getActivity() {
		return a;
	}

	public Time getStart() {
		return start;
	}
	
	public Time getEnd() {
		return end;
	}
}
