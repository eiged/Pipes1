/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package integerpipes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SummationPipeTest {
	private int[] integers;
	private int sum;
	private Feeder feeder;
	private SummationPipe summator;

	@BeforeEach
	void setup() {
		Random r = new Random();
		integers = r.ints(r.nextInt(100), -200, 200).toArray();
		sum = Arrays.stream(integers).sum();
		feeder = new Feeder(integers);
		summator = new SummationPipe(feeder);
	}

	@Test
	void testSummationPipe() {
		if (summator.hasNextInteger()) {
			assertEquals(sum, summator.nextInteger());
		}
		assertFalse(summator.hasNextInteger());
	}

	@Test
	void testSummationPipeWithEmptyFeeder() {
		summator = new SummationPipe(new Feeder(new int[]{}));
		assertFalse(summator.hasNextInteger());
	}

	@Test
	void testClassDiagramConformance() throws NoSuchFieldException, SecurityException {
		// base class and modifiers
		assertEquals(Pipe.class, SummationPipe.class.getSuperclass());
		assertEquals(Modifier.PUBLIC | Modifier.FINAL, Feeder.class.getModifiers());
	}
}
