package game;

import java.util.List;
import java.util.Scanner;

import data.PokemonInitializer;
import model.Player;
import model.PlayerLevel;
import model.Pokemon;
import model.Team;

public class GameStarter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the name of your team");
		String teamOneName = sc.nextLine();
		Team teamOne = new Team(teamOneName);

		System.out.println("Enter the name of opponent team");
		String teamTwoName = sc.nextLine();
		Team teamTwo = new Team(teamTwoName);

		addPlayers(sc, teamOne);
		addPlayers(sc, teamTwo);

		int totalPokemons = PokemonInitializer.totalPokemons();
		int pokemonPerTeam = totalPokemons / 2;
		List<String> pokemonNames = PokemonInitializer.pokemonNames();

		for (int i = 0; i < pokemonPerTeam; i++) {
			Player playerOne = teamOne.getPlayers()[i % teamOne.getPlayers().length];
			addPokemonToPlayer(playerOne, pokemonNames, sc);
			Player playerTwo = teamTwo.getPlayers()[i % teamTwo.getPlayers().length];
			addPokemonToPlayer(playerTwo, pokemonNames, sc);
		}

		new GameEngine(teamOne, teamTwo).start();
	}

	public static void addPokemonToPlayer(Player player, List<String> pokemonNames, Scanner sc) {
		for (int i = 0; i < pokemonNames.size(); i++) {
			System.out.println(i + ". " + pokemonNames.get(i));
		}
		System.out.println("Player " + player.getName() + ", please select your pokemon.");
		String pokemonIndex = sc.nextLine();
		while (Integer.parseInt(pokemonIndex) >= pokemonNames.size()) {
			System.out.println("Index out of range, please select a valid pokemon.");
			pokemonIndex = sc.nextLine();
		}
		String pokemonName = pokemonNames.get(Integer.parseInt(pokemonIndex));
		Pokemon pokemon = PokemonInitializer.getByName(pokemonName);
		player.addPokemon(pokemon);
		pokemonNames.remove(pokemonName);
	}

	public static int addPlayers(Scanner sc, Team team) {
		System.out.println("Add player to team : " + team.getTeamName());
		System.out.println("Enter player name (type EXIT to stop adding players): ");
		String playerName = sc.nextLine();
		int count = 0;
		while (!"EXIT".equalsIgnoreCase(playerName)) {
			count++;
			Player player = new Player(playerName, PlayerLevel.BEGINNER);
			team.addPlayer(player);
			System.out.println("Enter player name (type EXIT to stop adding players): ");
			playerName = sc.nextLine();
		}
		return count;
	}
}
