package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Pokemon;
import model.PokemonType;


public class PokemonInitializer {
	public static final String VENASAUR = "Venasaur";
	public static final String BLASTOISE = "Blastoise";
	public static final String CHARIZARD = "Charizard";
	public static final String GYARADOS = "Gyarados";
	public static final String GENGAR = "Gengar";
	public static final String ALAKAZAM = "Alakazam";

	private static Map<String, Pokemon> pokemons = new HashMap<String, Pokemon>();
	
	static {
		pokemons.put(VENASAUR, 
				new Pokemon.PokemonBuilder(VENASAUR, PokemonType.GRASS)
				.attack(82)
				.defense(83)
				.spAttack(100)
				.spDefense(100)
				.speed(80)
				.health(80)
				.move(MoveInitializer.sludgeBomb())
				.move(MoveInitializer.grassKnot())
				.move(MoveInitializer.earthQuake())
				.move(MoveInitializer.rockClimb())
				.build()
				);
		
		pokemons.put(BLASTOISE, 
				new Pokemon.PokemonBuilder(BLASTOISE, PokemonType.WATER)
				.attack(83)
				.defense(100)
				.spAttack(85)
				.spDefense(105)
				.speed(78)
				.health(79)
				.move(MoveInitializer.scald())
				.move(MoveInitializer.dragonTail())
				.move(MoveInitializer.earthQuake())
				.move(MoveInitializer.iceBeam())
				.build()
				);
		
		pokemons.put(CHARIZARD, 
				new Pokemon.PokemonBuilder(CHARIZARD, PokemonType.FIRE)
				.attack(84)
				.defense(78)
				.spAttack(109)
				.spDefense(85)
				.speed(100)
				.health(78)
				.move(MoveInitializer.fireBlast())
				.move(MoveInitializer.airSlash())
				.move(MoveInitializer.focusBlast())
				.move(MoveInitializer.dragonPulse())
				.build()
				);
		
		pokemons.put(GYARADOS, 
				new Pokemon.PokemonBuilder(GYARADOS, PokemonType.FLYING)
				.attack(125)
				.defense(79)
				.spAttack(60)
				.spDefense(100)
				.speed(81)
				.health(95)
				.move(MoveInitializer.waterFall())
				.move(MoveInitializer.stoneEdge())
				.move(MoveInitializer.iceFang())
				.move(MoveInitializer.earthQuake())
				.build()
				);
		
		pokemons.put(GENGAR, 
				new Pokemon.PokemonBuilder(GENGAR, PokemonType.GHOST)
				.attack(65)
				.defense(60)
				.spAttack(130)
				.spDefense(75)
				.speed(110)
				.health(60)
				.move(MoveInitializer.shadowBall())
				.move(MoveInitializer.focusBlast())
				.move(MoveInitializer.thunderBolt())
				.move(MoveInitializer.darkPulse())
				.build()
				);
		
		pokemons.put(ALAKAZAM, 
				new Pokemon.PokemonBuilder(ALAKAZAM, PokemonType.GRASS)
				.attack(50)
				.defense(45)
				.spAttack(135)
				.spDefense(85)
				.speed(120)
				.health(55)
				.move(MoveInitializer.psychic())
				.move(MoveInitializer.shadowBall())
				.move(MoveInitializer.focusBlast())
				.move(MoveInitializer.signalBeam())
				.build()
				);
		
	}		
	
	public static Pokemon getByName(String name) {
		return pokemons.get(name);
	}
	
	public static int totalPokemons() {
		return pokemons.size();
	}
	
	public static List<String> pokemonNames(){
		return new ArrayList<String>(pokemons.keySet());
	}

}
