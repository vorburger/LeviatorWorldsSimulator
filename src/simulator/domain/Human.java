package simulator.domain;

import static simulator.domain.Statistics.randomEnum;

public class Human {

	Gender gender = randomEnum(Gender.class /*, p.femaleMaleBirthRatio*/);
	
	int money = 0;
	
	int age = 0;

	// do NOT hashCode() & equals(Object obj)
	
	// no name
	
}
