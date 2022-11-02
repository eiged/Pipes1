/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package integerpipes;

public final class Main {

	public static void main(String[] args) {
		Feeder feeder = new Feeder(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		MultiplyingPipe multiplyer = new MultiplyingPipe(feeder, 3);
		ModuloFilterPipe filter = new ModuloFilterPipe(multiplyer, 2);
		SummationPipe sum = new SummationPipe(filter);
		while (sum.hasNextInteger()) {
			System.out.println(sum.nextInteger());
		}
	}
}
