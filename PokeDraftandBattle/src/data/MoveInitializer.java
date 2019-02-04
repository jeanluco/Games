package data;

import java.util.HashMap;
import java.util.Map;

import model.Move;
import model.MoveType;

public class MoveInitializer {
	public static final String SLUDGE_BOMB = "Sludge Bomb";
	public static final String GRASS_KNOT = "Grass Knot";
	public static final String ROCK_CLIMB = "Rock Climb";
	public static final String EARTH_QUAKE = "Earth Quake";
	public static final String SCALD = "Scald";
	public static final String DRAGON_TAIL = "Dragon Tail";
	public static final String ICE_BEAM = "Ice Beam";
	public static final String DRAGON_PULSE = "Dragon Pulse";
	public static final String FIRE_BLAST = "Fire Blast";
	public static final String AIR_SLASH = "Airr Slash";
	public static final String FOCUS_BLAST = "Focus Blast";
	public static final String WATER_FALL = "Water Fall";
	public static final String STONE_EDGE = "Stone Edge";
	public static final String ICE_FANG = "Ice Fang";
	public static final String SHADOW_BALL = "Shadow Ball";
	public static final String THUNDERBOLT = "Thunderbolt";
	public static final String DARK_PULSE = "Dark Pulse";
	public static final String PSYCHIC = "Psychic";
	public static final String SIGNAL_BEAM = "Signal Beam";

	private static Map<String, Move> moves = new HashMap<String, Move>();

	static {
		moves.put(SLUDGE_BOMB, new Move(SLUDGE_BOMB, 60, MoveType.POISON, true));
		moves.put(GRASS_KNOT, new Move(GRASS_KNOT, 70, MoveType.GRASS, true));
		moves.put(ROCK_CLIMB, new Move(ROCK_CLIMB, 90, MoveType.ROCK, true));
		moves.put(EARTH_QUAKE, new Move(EARTH_QUAKE, 50, MoveType.GROUND, true));
		moves.put(SCALD, new Move(SCALD, 80, MoveType.WATER, true));
		moves.put(DRAGON_TAIL, new Move(DRAGON_TAIL, 60, MoveType.FIRE, true));
		moves.put(ICE_BEAM, new Move(ICE_BEAM, 40, MoveType.ICE, true));
		moves.put(DRAGON_PULSE, new Move(DRAGON_PULSE, 70, MoveType.DRAGON, false));
		moves.put(FIRE_BLAST, new Move(FIRE_BLAST, 80, MoveType.FIRE, false));
		moves.put(AIR_SLASH, new Move(AIR_SLASH, 90, MoveType.FLYING, false));
		moves.put(FOCUS_BLAST, new Move(FOCUS_BLAST, 60, MoveType.FIGHTING, false));
		moves.put(WATER_FALL, new Move(WATER_FALL, 60, MoveType.WATER, true));
		moves.put(STONE_EDGE, new Move(STONE_EDGE, 60, MoveType.ROCK, true));
		moves.put(ICE_FANG, new Move(ICE_FANG, 60, MoveType.ICE, true));
		moves.put(SHADOW_BALL, new Move(SHADOW_BALL, 90, MoveType.GHOST, false));
		moves.put(THUNDERBOLT, new Move(THUNDERBOLT, 60, MoveType.ELECTRIC, false));
		moves.put(DARK_PULSE, new Move(DARK_PULSE, 70, MoveType.DARK, false));
		moves.put(PSYCHIC, new Move(PSYCHIC, 80, MoveType.PSYCHIC, false));
		moves.put(SIGNAL_BEAM, new Move(SIGNAL_BEAM, 90, MoveType.FIRE, false));
	}

	public static Move signalBeam() {
		return moves.get(SIGNAL_BEAM);
	}

	public static Move psychic() {
		return moves.get(PSYCHIC);
	}

	public static Move darkPulse() {
		return moves.get(DARK_PULSE);
	}

	public static Move thunderBolt() {
		return moves.get(THUNDERBOLT);
	}

	public static Move shadowBall() {
		return moves.get(SHADOW_BALL);
	}

	public static Move iceFang() {
		return moves.get(ICE_FANG);
	}

	public static Move stoneEdge() {
		return moves.get(STONE_EDGE);
	}

	public static Move waterFall() {
		return moves.get(WATER_FALL);
	}

	public static Move focusBlast() {
		return moves.get(FOCUS_BLAST);
	}

	public static Move airSlash() {
		return moves.get(AIR_SLASH);
	}

	public static Move fireBlast() {
		return moves.get(FIRE_BLAST);
	}

	public static Move dragonPulse() {
		return moves.get(DRAGON_PULSE);
	}

	public static Move sludgeBomb() {
		return moves.get(SLUDGE_BOMB);
	}

	public static Move grassKnot() {
		return moves.get(GRASS_KNOT);
	}

	public static Move rockClimb() {
		return moves.get(ROCK_CLIMB);
	}

	public static Move earthQuake() {
		return moves.get(EARTH_QUAKE);
	}

	public static Move scald() {
		return moves.get(SCALD);
	}

	public static Move dragonTail() {
		return moves.get(DRAGON_TAIL);
	}

	public static Move iceBeam() {
		return moves.get(ICE_BEAM);
	}
	
	public static Move getMoveByName(String name) {
		return moves.get(name);
	}
}
