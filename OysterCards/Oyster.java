package OysterCards;

public class Oyster {
	
	static int MAXIMUM_BALANCE = 90; // hard-coded maximum balance
	static int MINIMUM_FARE = 1;
	
	public int balance;
	
	public Oyster() {
		balance = 0;
	}
	
	public int show_balance(){
		return balance;
	}
	
	public void top_up(int amount) {
		try {
			if(amount + balance > MAXIMUM_BALANCE) {
				throw new ArithmeticException("cannot top up: maximum balance");
			}
			else {
				balance += amount;
			}
		}
		catch(ArithmeticException e) {
			System.out.println("cannot top up: maximum balance");
		}
	}
	
	public void tap_in(){
		if(a)
	}
	

}
