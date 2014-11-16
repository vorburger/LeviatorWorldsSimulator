package simulator.test;

import static org.junit.Assert.*;

import org.junit.Test;

import simulator.domain.Gender;
import simulator.domain.Statistics;

public class StatisticsTest {

	@Test
	public void testRandomEnum() {
		for (int i = 0; i < 10000; i++) {
			new Statistics().randomEnum(Gender.class);
			
//			assertEquals(Gender.FEMALE, new Statistics().randomEnum(Gender.class, 0.0));
//			assertEquals(Gender.MALE, new Statistics().randomEnum(Gender.class, 1.0));
		}
	}

}
