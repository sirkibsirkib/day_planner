import java.util.ArrayList;
import java.util.List;


public class Day {	
	private List<Event> events;
	private List<Activity> options;	
	
	public Day(){
		events = new ArrayList<>();
		build(new DayState());
	}

	public void print() {
		for(int i = 0; i < events.size(); i++){
			Event e = events.get(i);
			if(e.getActivity().isTravel()){
				System.out.println(i + "\t" + e.getStart().toString() + " --> " + e.getEnd().toString() +
						" (" + e.getActivity().getDuration().toString() + ") " +  e.getActivity().getDescription()
						+ " " + e.getActivity().getStart() + " --> " + e.getActivity().getEnd());
			}else{
				System.out.println(i + "\t" + e.getStart().toString() + " --> " + e.getEnd().toString()
						+ "\t\t" + e.getActivity().getDescription());
			}
		}
	}
	
	public double heuristicValue(){
		return -Math.abs(140-exerciseMinutes())
				- 3*travelMinutes();
	}
	
	public int travelMinutes(){
		int count = 0;
		for(Event e : events){
			if(e.getActivity().getAc() == ActType.TRAVEL){
				count += e.getActivity().getDuration().toMin();
			}
		}
		return count;
	}
	
	public int exerciseMinutes(){
		int count = 0;
		for(Event e : events){
			if(e.getActivity().getAc() == ActType.EXERCISE){
				count += e.getActivity().getDuration().toMin();
			}else if(e.getActivity().getAc() == ActType.TRAVEL){
				Trip trip = (Trip) e.getActivity();
				count += trip.getWalkMinutes();
			}
		}
		return count;
	}

	private void build(DayState dayState) {
		options = ActivityPool.getOptions();
		while(!dayState.dayOver()){
			addEvent(dayState);
		}
		if(!dayState.atHome()){
			events.add(new Event(LocationMap.travelBetween(dayState.currentLocation(), dayState.home()), dayState.timeNow()));
		}
	}

	private void addEvent(DayState dayState) {
		Activity a = null;
		do{
			a = getRandomActivity();
		}while(!activityOk(a, dayState));
		Activity travel = LocationMap.travelBetween(dayState.currentLocation(), a.getStart());
		if(travel != null){
			events.add(new Event(travel, dayState.timeNow()));
			dayState.incrimentTime(travel.getDuration());
		}
		events.add(new Event(a, dayState.timeNow()));
		dayState.incrimentTime(a.getDuration());
		if(a.isMeal()){
			dayState.justAte();
		}
		dayState.changeLocationTo(a.getEnd());
		options.remove(a);
	}
	
	private boolean activityOk(Activity a, DayState dayState) {
		return ((a.isMeal() && dayState.hungry()) ||
				(!a.isMeal() && !dayState.hungry())) &&
				ActivityPool.activityWithinConstraints(a, dayState.timeNow());
	}

	private Activity getRandomActivity() {
		return options.get(Fun.rng(options.size()));
	}

	public void incrimentAcceptanceSides() {
		for(Event e : events){
			if(!e.getActivity().isTravel()){
				ActivityPool.incrimentAcceptsanceSides(e.getActivity());
			}
		}
	}
}
