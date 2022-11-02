/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package integerpipes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModuloFilterPipeTest {
	private int[] integers;
	private int divisor;
	private int[] filtered;
	private Feeder feeder;
	private ModuloFilterPipe filter;

	@BeforeEach
	void setup() {
		Random r = new Random();
		integers = r.ints(r.nextInt(100), -200, 200).toArray();
		divisor = r.nextInt(1, 10);
		filtered = Arrays.stream(integers).filter(x -> x % divisor == 0).toArray();
		feeder = new Feeder(integers);
		filter = new ModuloFilterPipe(feeder, divisor);
	}

	@Test
	void testModuloFilterPipe() {
		for (int i = 0; i < filtered.length; i++) {
			assertTrue(filter.hasNextInteger());
			assertEquals(filtered[i], filter.nextInteger());
		}
		assertFalse(filter.hasNextInteger());
	}

	@Test
	void testStarvedModuloFilterPipe() {
		int[] integersWithoutZero = Arrays.stream(integers).filter(x -> x != 0).toArray();
		feeder = new Feeder(integersWithoutZero);
		filter = new ModuloFilterPipe(feeder, 1000);
		assertFalse(filter.hasNextInteger());
		assertNull(filter.nextInteger());
	}

	@Test
	void testModuloFilterPipeWithEmptyFeeder() {
		feeder = new Feeder(new int[]{});
		filter = new ModuloFilterPipe(feeder, 2);
		assertFalse(filter.hasNextInteger());
		assertNull(filter.nextInteger());
	}

	@Test
	void testClassDiagramConformance() throws NoSuchFieldException, SecurityException {
		// base class and modifiers
		assertEquals(Pipe.class, ModuloFilterPipe.class.getSuperclass());
		assertEquals(Modifier.PUBLIC | Modifier.FINAL, Feeder.class.getModifiers());

		// fields
		Field field = ModuloFilterPipe.class.getDeclaredField("divisor");
		assertEquals(Modifier.PRIVATE | Modifier.FINAL, field.getModifiers());
		assertEquals("int", field.getType().getName());
	}

}
