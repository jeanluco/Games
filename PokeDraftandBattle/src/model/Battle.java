package model;

import java.util.HashSet;
import java.util.Set;

public class Battle {
	private Team first;
	private Team second;

	private Set<Match> matches;

	public Battle(Team one, Team two) {
		this.first = one;
		this.second = two;
		this.matches = new HashSet<Match>();
	}

	public void addMatch(Match match) {
		matches.add(match);
	}

	public Team getFirst() {
		return first;
	}

	public Team getSecond() {
		return second;
	}

	public Set<Match> getMatches() {
		return matches;
	}

}
