package OysterCards;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;


class Oyster_test {
	
	Oyster oyster;
	Station station;
	
	
	@BeforeEach
	void initialize() {
		oyster = new Oyster();
		station = new Station();
	}

	@Test
	void Balance() {
		int balance = oyster.show_balance();
		assertEquals(0, balance);
	}
	
	@Test
	void TopUp() {
		oyster.top_up(1);
		assertEquals(1, oyster.show_balance());
		
	}

	@Test
	void TopUp_Maximum() {
		try {
			oyster.top_up(1000);
			fail("no exception thrown");
		} catch(ArithmeticException e) {
			assertThat(e.getMessage(), is("Cannot top up more than max balance")) ;
		}
	}
	
	@Test
	void TapIn() {
		oyster.balance = Oyster.MINIMUM_FARE; //set balance to minimum
		oyster.tap_in(station); // simulate a tap in
		assertEquals(true, oyster.in_journey);
		assertEquals(station, oyster.entry_station);
	}
	
	@Test
	void TapInNoBalance() {
		try {
			oyster.tap_in(station);
			fail("no exception thrown");
		} catch(ArithmeticException e) {
			assertThat(e.getMessage(), is("Please top up"));
		}
	}
	
}
