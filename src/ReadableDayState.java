
public interface ReadableDayState {
	Time timeNow();
	Time timeOfLastMeal();
	boolean dayOver();
}
