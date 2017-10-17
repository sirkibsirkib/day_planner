

public class Time implements Comparable<Time>{
	private int hour;
	private int min;
	
	public Time(int hour, int min){
		this.hour = hour;
		this.min = min;
	}

	public Time(int minutes) {
		hour = 0;
		min = minutes;
		while(min > 60){
			hour++;
			min -= 60;
		}
	}

	public Time add(Time t){
		int resultHour = hour + t.hour;
		int resultMin = min + t.min;
		while(resultMin > 60){
			resultHour++;
			resultMin -= 60;
		}
		return new Time(resultHour, resultMin);
	}
	
	public Time subtract(Time t){
		int resultHour = hour - t.hour;
		int resultMin = min - t.min;
		while(resultMin < 0){
			resultMin += 60;
			resultHour -= 1;
		}
		return new Time(resultHour, resultMin);
	}

	@Override
	public int compareTo(Time other) {
		int hourDifference = hour - other.hour;
		if(hourDifference > 0){
			return 1;
		}
		if(hourDifference < 0){
			return -1;
		}
		int minDifference = min - other.min;
		if(minDifference > 0){
			return 1;
		}
		if(minDifference < 0){
			return -1;
		}
		return 0;
	}
	
	@Override
	public String toString(){
		String s = "";
		if(hour <= 9){
			s += '0';
		}
		s += hour + ":";
		if(min <= 9){
			s += '0';
		}
		s += min;
		return s;
	}

	public int toMin() {
		return hour*60 + min;
	}
}
