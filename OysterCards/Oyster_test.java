package OysterCards;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;


class Oyster_test {
	
	Oyster oyster;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@BeforeEach
	void initialize() {
		oyster = new Oyster();
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
	void TapI() {
		oyster.tap_in();
	}
	
	/* will be added once i work out exception testing
	@Test(Assertions.assertThrows(ArithmeticException.class, () -> m.div(5, 0)));
	void TopUp_Maximum() {
		
	}
	*/
	
	
}
