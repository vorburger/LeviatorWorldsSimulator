package simulator.domain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class Statistics {

	private static Random r = new Random();

	@SuppressWarnings("unchecked")
	public static <T extends Enum<?>> T randomEnum(Class<T> enumClass /*, double... ratio */) {
		try {
			Method valuesMethod = enumClass.getMethod("values");
			T[] values = (T[]) valuesMethod.invoke(null);
//			if (values.length != ratio.length + 1)
//				throw new IllegalArgumentException("doh");
			int i = r.nextInt(values.length);
			return values[i];
			
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException("Huh?!", e);
		}
	}

}
