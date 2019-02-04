package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private PlayerLevel level;
	private List<Pokemon> pokemons;

	public Player(String name, PlayerLevel level) {
		super();
		this.name = name;
		this.level = level;
		this.pokemons = new ArrayList<Pokemon>();
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public String getName() {
		return name;
	}

	public PlayerLevel getLevel() {
		return level;
	}

	public void setLevel(PlayerLevel level) {
		this.level = level;
	}

	public void addPokemon(Pokemon pokemon) {
		this.pokemons.add(pokemon);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Player other = (Player) obj;
		if (level != other.level)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", level=" + level + "]";
	}

}
