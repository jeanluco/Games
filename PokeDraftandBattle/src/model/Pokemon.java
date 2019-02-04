package model;

import java.util.HashSet;
import java.util.Set;

public class Pokemon {
	private String name;
	private PokemonType type;
	private int attack;
	private int defense;
	private int spAttack;
	private int spDefense;
	private int speed;
	private double health;
	private Set<Move> moves;

	private Pokemon() {
		this.moves = new HashSet<Move>();
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public PokemonType getType() {
		return type;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getSpAttack() {
		return spAttack;
	}

	public int getSpDefense() {
		return spDefense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Set<Move> getMoves() {
		return moves;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Pokemon other = (Pokemon) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", type=" + type + ", attack=" + attack + ", defense=" + defense
				+ ", spAttack=" + spAttack + ", spDefense=" + spDefense + ", speed=" + speed + ", health=" + health
				+ ", moves=" + moves + "]";
	}

	/**
	 * Builder Pattern
	 */
	public static class PokemonBuilder {

		private String name;
		private PokemonType type;

		private int attack;
		private int defense;
		private int spAttack;
		private int spDefense;
		private int speed;
		private double health;

		private Set<Move> moves;

		public PokemonBuilder(String name, PokemonType type) {
			this.name = name;
			this.type = type;
			this.moves = new HashSet<Move>();
		}

		public PokemonBuilder attack(int attack) {
			this.attack = attack;
			return this;
		}

		public PokemonBuilder defense(int defense) {
			this.defense = defense;
			return this;
		}

		public PokemonBuilder spAttack(int attack) {
			this.spAttack = attack;
			return this;
		}

		public PokemonBuilder spDefense(int defense) {
			this.spDefense = defense;
			return this;
		}

		public PokemonBuilder speed(int speed) {
			this.speed = speed;
			return this;
		}

		public PokemonBuilder health(double health) {
			this.health = health;
			return this;
		}

		public PokemonBuilder move(Move move) {
			this.moves.add(move);
			return this;
		}

		public Pokemon build() {
			Pokemon pokemon = new Pokemon();
			pokemon.attack = this.attack;
			pokemon.defense = this.defense;
			pokemon.health = this.health;
			pokemon.name = this.name;
			pokemon.spAttack = this.spAttack;
			pokemon.spDefense = this.spDefense;
			pokemon.speed = this.speed;
			pokemon.type = this.type;
			pokemon.moves.addAll(this.moves);
			return pokemon;
		}
	}
}
