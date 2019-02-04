package model;

public class Move {
	private String name;
	private int damage;
	private MoveType type;
	private boolean physical;

	public Move(final String name, final int damage, final MoveType type, final boolean physical) {
		this.name = name;
		this.damage = damage;
		this.type = type;
		this.physical = physical;
	}

	public String getName() {
		return name;
	}

	public int getDamage() {
		return damage;
	}

	public MoveType getType() {
		return type;
	}

	public boolean isPhysical() {
		return physical;
	}

	@Override
	public String toString() {
		return "Move [name=" + name + ", damage=" + damage + ", type=" + type + ", physical=" + physical + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + damage;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (physical ? 1231 : 1237);
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
		Move other = (Move) obj;
		if (damage != other.damage)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (physical != other.physical)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
