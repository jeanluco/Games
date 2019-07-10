package game;

import model.Battle;
import model.Match;
import model.Team;

public class GameEngine {

	private Team teamOne, teamTwo;
	private Battle battle;
	private int matchPerBattle;
	private static final int DEFAULT_MATCH_PER_BATTLE = 2;

	public GameEngine(Team teamOne, Team teamTwo) {
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
		this.matchPerBattle = DEFAULT_MATCH_PER_BATTLE;

	}

	public void start() {
		planBattle();
		System.out.println("Battle Sequence Began");
		for (Match match : battle.getMatches()) {
			System.out.println("Starting Match between " + match.getPlayerOne().getName() + " and "
					+ match.getPlayerTwo().getName());

			match.fight();
		}
		
		// after battle is over.. display leader board...
	}

	private void planBattle() {
		battle = new Battle(teamOne, teamTwo);
		for (int i = 0; i < matchPerBattle; i++) {
			Match match = new Match(teamOne.getRandomPlayer(), teamTwo.getRandomPlayer());
			battle.addMatch(match);
		}
	}

}
