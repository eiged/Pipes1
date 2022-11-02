/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package integerpipes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FeederTest {
	private int[] integers;
	private Feeder feeder;

	@BeforeEach
	void setup() {
		Random r = new Random();
		integers = r.ints(r.nextInt(100), -200, 200).toArray();
		feeder = new Feeder(integers);
	}

	@Test
	void testFeeder() {
		assertNull(feeder.getFeedingPipe());
		if (integers.length > 0) {
			for (int i = 0; i < integers.length; i++) {
				assertTrue(feeder.hasNextInteger());
				assertEquals(integers[i], feeder.nextInteger());
			}
		}
		assertFalse(feeder.hasNextInteger());
	}

	@Test
	void testEmptyFeeder() {
		Feeder emptyFeeder = new Feeder(new int[] {});
		assertFalse(emptyFeeder.hasNextInteger());
		assertNull(emptyFeeder.nextInteger());
	}

	@Test
	void testClassDiagramConformance() throws NoSuchFieldException, SecurityException {
		// base class and modifiers
		assertEquals(Pipe.class, Feeder.class.getSuperclass());
		assertEquals(Modifier.PUBLIC | Modifier.FINAL, Feeder.class.getModifiers());

		// fields
		Field field = Feeder.class.getDeclaredField("integers");
		assertEquals(Modifier.PRIVATE | Modifier.FINAL, field.getModifiers());
		assertEquals(int[].class, field.getType());
	}
}
