
import java.util.ArrayList;

class Poke {

    private String name;
    private String type;
    private int attack;
    private int defense;
    private int spattack;
    private int spdefense;
    private int speed;
    private double health;
    private ArrayList<moves> moves;

    public Poke() {
    }

    public Poke(String name, String type, int attack, int defense, int spattack, int spdefense, int speed, int health, ArrayList<moves> moves) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
        this.spattack = spattack;
        this.spdefense = spdefense;
        this.speed = speed;
        this.health = health;
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpattack() {
        return spattack;
    }

    public void setSpattack(int spattack) {
        this.spattack = spattack;
    }

    public int getSpdefense() {
        return spdefense;
    }

    public void setSpdefense(int spdefense) {
        this.spdefense = spdefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public ArrayList<moves> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<moves> moves) {
        this.moves = moves;
    }

    @Override
    public String toString() {
        return "Poke{" +
                "name='" + name + '\'' +
                '}';
    }

    public String printMoves() {
        StringBuilder moveNames = new StringBuilder();

        for (moves move: moves) {
            moveNames.append(" - ");
            moveNames.append(move.getName());
        }

        return moveNames.toString();
    }
}