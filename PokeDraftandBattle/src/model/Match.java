package model;

import java.util.List;

import rules.RuleEngine;

public class Match {
	private Player playerOne;
	private Player playerTwo;
	private Player winner;
	private int winningScore;
	private boolean draw;

	public Match(Player one, Player two) {
		this.playerOne = one;
		this.playerTwo = two;
	}

	public Player getPlayerOne() {
		return playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public int getWinningScore() {
		return winningScore;
	}

	public void setWinningScore(int winningScore) {
		this.winningScore = winningScore;
	}

	public boolean isDraw() {
		return draw;
	}

	public void setDraw(boolean draw) {
		this.draw = draw;
	}

	public void fight() {
		List<Pokemon> pokemons = playerOne.getPokemons();
		// display and ask to select
		Pokemon playerOnePoke = pokemons.get(0);

		List<Pokemon> pokemonsTwo = playerOne.getPokemons();
		// display and ask to select
		Pokemon playerTwoPoke = pokemonsTwo.get(0);
		int random = 0;
		WeatherType weather = WeatherType.values()[random];
		int roundCounter = 0;
		while (winner == null) {
			System.out.println("Round " + roundCounter + " between ");
			RuleEngine.getRemainingHealth(playerOnePoke, playerTwoPoke, weather);
			if (playerOnePoke.getHealth() <= 0) {
				if (!isPokemonAvailable(playerOne)) {
					winner = playerTwo;
					displayWinner(winner);
					break;
				} else {
					playerOnePoke = findAlivePokemon(playerOne);
				}
			} else if (playerTwoPoke.getHealth() <= 0) {
				if (!isPokemonAvailable(playerTwo)) {
					winner = playerOne;
					displayWinner(winner);
					break;
				} else {
					playerTwoPoke = findAlivePokemon(playerTwo);
				}
			}
		}
		return;
	}

	private Pokemon findAlivePokemon(Player playerOne2) {
		return null;
	}

	private boolean isPokemonAvailable(Player playerOne2) {
		// heck for alive pokemons
		return false;
	}

	private void displayWinner(Player winner2) {

	}
}
