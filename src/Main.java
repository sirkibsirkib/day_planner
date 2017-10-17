

public class Main {
	private Day d;
	
	Main(){
		ActivityPool.init();
		LocationMap.init();
		for(int i = 0; i < 14; i++){
			System.out.println("DAY " + (i+1));
			getDay();
			d.print();
			System.out.println();
		}
//		ActivityPool.printAcceptance();
	}

	private void getDay() {
		d = new Day();
		double h = d.heuristicValue();
		for(int i = 0; i < 1500; i++){
			Day newDay = new Day();
			double newH = newDay.heuristicValue();
			if(newH > h){
				d = newDay;
				h = newH;
			}
		}
//		System.out.println(h);
		d.incrimentAcceptanceSides();
		ActivityPool.decayAcceptance();
	}

	private void start() {
		
	}
	
	public static void main(String[] args){
		new Main().start();
	}
}
