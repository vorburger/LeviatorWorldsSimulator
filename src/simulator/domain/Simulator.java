package simulator.domain;



public class Simulator {

	World world = new World();
	Parameters p = new ParametersEquilibrium();
	
	void init() {
		for (int i = 0; i < p.initialPopulation; i++) {
			Human newHuman = new Human();
			world.humans.add(newHuman);
		}
	}

	private void liveLifes() {
		long age = 0;
//		long ms = 0;
//		long lastTimeMillis = System.currentTimeMillis(); 
		do {
			System.out.print(age);
			System.out.print(". ");
//			System.out.print(". in ");
//			ms += System.currentTimeMillis() - lastTimeMillis;
//			System.out.print(ms);
//			System.out.print("ms: ");
			world.summarize();
			world.tick(p);
			++age;
		} while (!world.humans.isEmpty());
	}

	public static void main(String[] args) {
		Simulator s = new Simulator();
		s.init();
		s.liveLifes();
	}

}
