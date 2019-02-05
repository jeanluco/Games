package rules;

/**
 * Table for opponent move type & pokemon
 *
 */
public class DefenceTable {
	private static double[][] table = new double[][]
	/** */
	{   { 0.1, 0.1, 0.1, 0.1 }, 
		{ 0.1, 0.1, 0.1, 0.1 },
		{ 0.1, 0.1, 0.1, 0.1 },
		{ 0.1, 0.1, 0.1, 0.1 }};

	/** */

	public static double defenceMultiplier(int one, int two) {
		return table[one][two];
	}
}
