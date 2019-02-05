package rules;

import model.Pokemon;
import model.WeatherType;

public class RuleEngine {

	// it takes attcking pokemon, weather info and finds the attack
	// it takes the defending pokemon, weather infor and finds the defence
	// it returns the health/energy/ for the defending pokemon

	public static double getRemainingHealth(Pokemon attacking, Pokemon defending, WeatherType weather) {
		// use attack table, defence table, weather table
		double attackMultiplier = AttackTable.attackMultiplier(1, 2);
		
		return 0.0;
	}
}
