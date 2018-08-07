package OysterCards;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Station_test {
	
	Station station;
	
	@BeforeEach 
	void initialize() {
		station = new Station("Test Station", 2);
	}

	@Test
	void stationName() {
		assertEquals("Test Station", station.stationName);
	}
	
	@Test
	void stationZone() {
		assertEquals(2, station.stationZone);
	}

}
