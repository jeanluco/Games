package rules;

/**
 * Multiplier for weather & pokemon
 */
public class SpeedTable {
	private static double[][] table = new double[][]
	/** */
	{ { 0.1, 0.1, 0.1, 0.1 }, { 0.1, 0.1, 0.1, 0.1 } };

	/** */

	public static double speedMultiplier(int one, int two) {
		return table[one][two];
	}
}
