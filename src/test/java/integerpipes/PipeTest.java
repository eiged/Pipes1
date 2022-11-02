/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package integerpipes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

class PipeTest {

	@Test
	void testClassDiagramConformance() throws NoSuchMethodException, SecurityException, NoSuchFieldException {
		// class declaration
		assertEquals(Modifier.PUBLIC | Modifier.ABSTRACT, Pipe.class.getModifiers());

		// constructor
		Constructor<Pipe> constructor = Pipe.class.getDeclaredConstructor(Pipe.class);
		assertEquals(Modifier.PUBLIC, constructor.getModifiers());
		assertThrows(NoSuchMethodException.class, () -> Pipe.class.getDeclaredConstructor());

		// fields
		Field field = Pipe.class.getDeclaredField("feedingPipe");
		assertEquals(Modifier.PRIVATE | Modifier.FINAL, field.getModifiers());
		assertEquals(Pipe.class, field.getType());

		// methods
		Method method = Pipe.class.getDeclaredMethod("getFeedingPipe");
		assertEquals(Modifier.PROTECTED | Modifier.FINAL, method.getModifiers());
		assertEquals(Pipe.class, method.getReturnType());
		method = Pipe.class.getDeclaredMethod("hasNextInteger");
		assertEquals(Modifier.PUBLIC | Modifier.ABSTRACT, method.getModifiers());
		assertEquals("boolean", method.getReturnType().getTypeName());
		method = Pipe.class.getDeclaredMethod("nextInteger");
		assertEquals(Modifier.PUBLIC | Modifier.ABSTRACT, method.getModifiers());
		assertEquals(Integer.class, method.getReturnType());
	}
}
