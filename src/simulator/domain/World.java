package simulator.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class World {

	Collection<Human> humans = new HashSet<>(1000);
	
	void tick(Parameters p) {
		List<Human> newHumans = new ArrayList<>(1000);
		for (Iterator<Human> iterator = humans.iterator(); iterator.hasNext();) {
			Human human = iterator.next();
			++human.age;
			if (human.age == p.maxAge) {
				iterator.remove();
			}
			if (human.age == p.childrenAtAge) {
				for (int i = 0; i < p.children; i++) {
					newHumans.add(new Human());
				}
			}
		}
		humans.addAll(newHumans);
	}

	void summarize() {
		long men = 0;
		long women = 0;
		long totalAge = 0;
		long totalMoney = 0;
		
		for (Human human : humans) {
			if (human.gender.equals(Gender.FEMALE)) {
				++women;
			} else {
				++men;
			}
			totalAge += human.age;
			totalMoney += human.money;
		}
		int menPercent = (int) (100 * men / humans.size());
		int womenPercent = (int) (100 * women / humans.size());
		
		long avgAge = totalAge / humans.size();
		long avgMoney = totalMoney / humans.size();
		
		System.out.printf("Total population %d, %d/%d men/women, avg. %d yrs, avg $%d\n", humans.size(), menPercent, womenPercent, avgAge, avgMoney);
	}
	
}
