/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package integerpipes;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultiplyingPipeTest {
	private int[] integers;
	private int[] expected;
	private Feeder feeder;
	MultiplyingPipe multiplyer;

	@BeforeEach
	void setup() {
		Random r = new Random();
		integers = r.ints(r.nextInt(100), -200, 200).toArray();
		feeder = new Feeder(integers);
		int factor = r.nextInt(200);
		multiplyer = new MultiplyingPipe(feeder, factor);
		expected = Arrays.stream(integers).map(i -> i * factor).toArray();
	}

	@Test
	void testMultiplyingPipe() {
		if (integers.length > 0) {
			for (int i = 0; i < expected.length; i++) {
				assertTrue(multiplyer.hasNextInteger());
				assertEquals(expected[i], multiplyer.nextInteger());
			}
		}
		assertFalse(multiplyer.hasNextInteger());
	}

	@Test
	void testMultiplyingPipeWithEmptyFeeder() {
		multiplyer = new MultiplyingPipe(new Feeder(new int[]{}), 2);
		assertFalse(multiplyer.hasNextInteger());
	}

	@Test
	void testClassDiagramConformance() throws NoSuchFieldException, SecurityException {
		// base class and modifiers
		assertEquals(Pipe.class, MultiplyingPipe.class.getSuperclass());
		assertEquals(Modifier.PUBLIC | Modifier.FINAL, Feeder.class.getModifiers());

		// fields
		Field field = MultiplyingPipe.class.getDeclaredField("factor");
		assertEquals(Modifier.PRIVATE | Modifier.FINAL, field.getModifiers());
		assertEquals("int", field.getType().getName());
	}
}
