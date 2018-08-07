package OysterCards;

public class Oyster {
	
	// constants
	static int MAXIMUM_BALANCE = 90; 
	static int MINIMUM_FARE = 1;
	static int MAXIMUM_FARE = 10;
	
	//variable declarations
	public Station entryStation;
	public int balance;
	public boolean inJourney;
	
	public Oyster() {
		balance = 0;
		inJourney = false;
	}
	public
		
	int show_balance() {
		return balance;
	}
	
	void topUp(int amount) {
		
		if(amount + balance > MAXIMUM_BALANCE) {
			throw new ArithmeticException("Cannot top up more than max balance");
		}
		else {
			balance += amount;
		}
		
	}
	
	void tapIn(Station station) {
		
		if(inJourney == true || entryStation != null) {
			balance -= MAXIMUM_FARE; // penalty fare is deducted
		}
		
		if(balance < MINIMUM_FARE) {
			throw new ArithmeticException("Please top up");
		}
		else {
			inJourney = true ;
			entryStation = station;
		}
	}
	// fares are calculated by the difference between zones bigger dif = further travelled
	void tapOut(Station station) {
		if(entryStation == null || inJourney == false) {
			balance -= MAXIMUM_FARE;
			inJourney = false;
		}
		else {
			balance -= (entryStation.stationZone + station.stationZone);
			entryStation = null;
			inJourney = false;
		}
	}
}
