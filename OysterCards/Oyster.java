package OysterCards;

public class Oyster {
	
	// constants
	static int MAXIMUM_BALANCE = 90; 
	static int MINIMUM_FARE = 1;
	
	//variable declarations
	public Station entry_station;
	public int balance;
	public boolean in_journey;
	
	public Oyster() {
		balance = 0;
		in_journey = false;
	}
	
	public int show_balance(){
		return balance;
	}
	
	public void top_up(int amount) {
		
		if(amount + balance > MAXIMUM_BALANCE) {
			throw new ArithmeticException("Cannot top up more than max balance");
		}
		else {
			balance += amount;
		}
		
	}
	
	public void tap_in(Station station){
		
		if(balance < MINIMUM_FARE) {
			throw new ArithmeticException("Please top up");
		}
		else {
			in_journey = true ;
			entry_station = station;
		}
	}
}
