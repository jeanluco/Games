package rules;

/**
 * 
 * Table for my pokemontype and movetype
 */
public class AttackTable {

	private static double[][] table = new double[][]
	/** */
	{ { 0.1, 0.1, 0.1, 0.1 }, { 0.1, 0.1, 0.1, 0.1 } };

	/** */

	public static double attackMultiplier(int one, int two) {
		return table[one][two];
	}

}
