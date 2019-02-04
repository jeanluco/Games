package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team {
	private List<Player> players;
	private String teamName;
	private Random rand = new Random();

	public Team(String teamName) {
		this.teamName = teamName;
		this.players = new ArrayList<Player>();
	}

	public Player getRandomPlayer() {
		int index = rand.nextInt(players.size());
		return players.get(index);
	}

	public void addPlayer(final Player player) {
		this.players.add(player);
	}

	public Player removePlayer(final Player player) {
		boolean remove = players.remove(player);
		if (remove) {
			return player;
		}
		return null;
	}

	public Player[] getPlayers() {
		return players.toArray(new Player[0]);
	}

	public String getTeamName() {
		return teamName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Team [teamName=" + teamName + "]";
	}
}
