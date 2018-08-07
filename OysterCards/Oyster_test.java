package OysterCards;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;


class Oyster_test {
	
	Oyster oyster;
	Station entryStation; 
	Station exitStation;
	 
	@BeforeEach 
	void initialize() {
		oyster = new Oyster();
		entryStation = new Station("Entry Station", 2);
		exitStation = new Station("Exit Station", 1);
	}
	
	// helpers
	
	void tapInAndOut() {
		oyster.topUp(10);
		oyster.tapIn(entryStation);
		oyster.tapOut(exitStation);
	}

	@Test
	@DisplayName("Balance")
	void Balance() {
		int balance = oyster.show_balance();
		assertEquals(0, balance);
	}
	
	@Test
	void topUp() {
		oyster.topUp(1);
		assertEquals(1, oyster.show_balance());
		
	}

	@Test
	void topUp_Maximum() {
		try {
			oyster.topUp(1000);
			fail("no exception thrown");
		} catch(ArithmeticException e) {
			assertThat(e.getMessage(), is("Cannot top up more than max balance")) ;
		}
	}
	
	// Successfully tapin/out tests
	
	@Test
	void tapIn() {
		oyster.balance = Oyster.MINIMUM_FARE; //set balance to minimum
		oyster.tapIn(entryStation); // simulate a tap in
		assertEquals(true, oyster.inJourney);
		assertEquals(entryStation, oyster.entryStation);
	}
	
	@Test
	void tapOut() {
		int newBal = 10 - (entryStation.stationZone + exitStation.stationZone);
		tapInAndOut(); 
		assertEquals(oyster.entryStation, null);
		assertEquals(oyster.inJourney, false);
		assertEquals(newBal, oyster.balance);
	}
	
	// tap in and out exception tests
	
	@Test
	void tapInNoBalance() {
		try {
			oyster.tapIn(entryStation);
			fail("no exception thrown");
		} catch(ArithmeticException e) {
			assertThat(e.getMessage(), is("Please top up"));
		}
	}
	
	@Test
	void tapInNOtTappedOut() {
		oyster.topUp(50);
		oyster.tapIn(entryStation);
		oyster.tapIn(exitStation);
		assertEquals(oyster.show_balance(), 40);
	}
	
	@Test
	void tapOutNotTappedIn() {
		oyster.tapOut(exitStation);
		assertEquals(oyster.entryStation, null);
		assertEquals(oyster.show_balance(), -10);
		assertEquals(oyster.inJourney, false);
	}
	
	@Test
	void tapInNegativeBalance() {
		oyster.tapOut(exitStation);
		try {
			oyster.tapIn(entryStation);
			fail("no exception thrown");
		} catch(ArithmeticException e) {
			assertThat(e.getMessage(), is("Please top up"));
		}
	}
}
