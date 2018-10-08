import java.util.ArrayList;

public class Team {

    private String teamName;
    private ArrayList<Poke> pokemon;

    public Team() {
        pokemon = new ArrayList<>();
    }

    public Team(String teamName) {
        this.teamName = teamName;
        pokemon = new ArrayList<>();
    }

    public Team(String teamName, ArrayList<Poke> pokemon) {
        this.teamName = teamName;
        this.pokemon = pokemon;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public ArrayList<Poke> getPokemon() {
        return pokemon;
    }

    public void setPokemon(ArrayList<Poke> pokemon) {
        this.pokemon = pokemon;
    }

    //Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", pokemon=" + pokemon +
                '}';
    }
}