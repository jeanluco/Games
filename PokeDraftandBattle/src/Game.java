
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Team playerOne;
    private static Team playerTwo;

    // ArrayList that will hold 2 players
//    public static List<Player> players = new ArrayList<Player>();

    // Static Array of 6 player names
    private static String[] pokemonNames = {"venusaur", "blastoise", "charizard", "gyarados", "gengar", "alakazam"};
    private static ArrayList<String> availablePokemonNames = new ArrayList<>();

    private static Poke[] pokemonAvailable = new Poke[6];

//    ArrayList<Element> pokemonpool = new ArrayList<Element>(Arrays.asList(pokemonAvailable));
//    public static List<Player> playerone = new ArrayList<Player>();
//    public static List<Player> playertwo = new ArrayList<Player>();

    private static Team firstToPlay;







        // Main method
    public static void main(String[] args) {
        ArrayList<moves> venusaurMoves = new ArrayList<>();
        venusaurMoves.add(new moves("sludge bomb", 60, "poison", "yes"));
        venusaurMoves.add(new moves("grass knot", 70, "grass", "yes"));
        venusaurMoves.add(new moves("rock climb", 90, "rock", "yes"));
        venusaurMoves.add(new moves("earthquake", 50, "ground", "yes"));
        pokemonAvailable[0] = new Poke("venusaur", "grass", 82, 83, 100, 100, 80, 80, venusaurMoves);

        ArrayList<moves> blastoiseMoves = new ArrayList<>();
        blastoiseMoves.add(new moves("scald", 80, "water", "yes"));
        blastoiseMoves.add(new moves("dragontail", 60, "fire", "yes"));
        blastoiseMoves.add(new moves("ice beam", 40, "ice", "yes"));
        blastoiseMoves.add(new moves("earthquake", 50, "ground", "yes"));
        pokemonAvailable[1] = new Poke("blastoise", "water", 83, 100, 85, 105, 78, 79, blastoiseMoves);

        ArrayList<moves> charizardMoves = new ArrayList<>();
        charizardMoves.add(new moves("dragon pulse", 70, "dragon", "no"));
        charizardMoves.add(new moves("fire blast", 80, "fire", "no"));
        charizardMoves.add(new moves("air slash", 90, "flying", "no"));
        charizardMoves.add(new moves("focus blast", 60, "fighting", "no"));
        pokemonAvailable[2] = new Poke("charizard", "fire", 84, 78, 109, 85, 100, 78, charizardMoves);

        ArrayList<moves> gyaradosMoves = new ArrayList<>();
        gyaradosMoves.add(new moves("waterfall", 60, "water", "yes"));
        gyaradosMoves.add(new moves("stone edge", 60, "rock", "yes"));
        gyaradosMoves.add(new moves("ice fang", 60, "ice", "yes"));
        gyaradosMoves.add(new moves("earthquake", 50, "ground", "yes"));
        pokemonAvailable[3] = new Poke("gyarados", "flying", 125, 79, 60, 100, 81, 95, gyaradosMoves);

        ArrayList<moves> gengarMoves = new ArrayList<>();
        gengarMoves.add(new moves("shadow ball", 90, "ghost", "no"));
        gengarMoves.add(new moves("focus blast", 100, "fighting", "no"));
        gengarMoves.add(new moves("thunderbolt", 60, "electric", "no"));
        gengarMoves.add(new moves("dark pulse", 70, "dark", "no"));
        pokemonAvailable[4] = new Poke("gengar", "ghost", 65, 60, 130, 75, 110, 60, gengarMoves);

        ArrayList<moves> alakazamMoves = new ArrayList<>();
        alakazamMoves.add(new moves("psychic", 80, "psychic", "no"));
        alakazamMoves.add(new moves("shadow ball", 90, "ghost", "no"));
        alakazamMoves.add(new moves("focus blast", 80, "fighting", "no"));
        alakazamMoves.add(new moves("signal beam", 90, "fire", "no"));
        pokemonAvailable[5] = new Poke("alakazam", "psychic", 50, 45, 135, 85, 120, 55, alakazamMoves);

        availablePokemonNames.addAll(Arrays.asList(pokemonNames));

        playerOne = new Team("Player One");
        playerTwo = new Team("Player Two");

        // Assign a winning % to each team randomly and rank accordingly
        rankTeams();

        // Run the draft
        draftPick();

        // showTeams();

        fight();
    }

    // Ranks teams by random winning percentage and prints a table

        private static int generateRandomNumber(int upperLimit) {
        Random randomGenerator = new Random();

        return randomGenerator.nextInt(upperLimit) + 1;
    }

    public static double generateRandomModNumber(double rangeMin, double rangeMax) {


            double generatedDouble = rangeMin + new Random().nextDouble() * (rangeMax - rangeMin);
            return generatedDouble;
        }



        public static void rankTeams() {
        System.out.println("Figuring out who goes first...");

                // Generate random number
                int randomDraftOrderNumber = generateRandomNumber(100);

                if (randomDraftOrderNumber % 2 == 0) {
                    firstToPlay = playerOne;
                } else {
                    firstToPlay = playerTwo;
                }

                System.out.println(firstToPlay.getTeamName() + " goes first!");
            }

            // Generates a random number between 1 and upperLimit


    public static void draftPick() {
        //create scanner object
        Team nextToPick = firstToPlay;

        while (!availablePokemonNames.isEmpty()) {
            System.out.println(nextToPick.getTeamName() + " Choose your pokemon.");

            Scanner sc = new Scanner(System.in);
            String pokename = sc.nextLine();

            if (availablePokemonNames.contains(pokename)) {
                System.out.println(nextToPick.getTeamName() + " chose " + pokename);

                for (Poke poke : pokemonAvailable) {
                    if (poke.getName().equals(pokename)) {
                        nextToPick.getPokemon().add(poke);
                    }
                }

                availablePokemonNames.remove(pokename);

                if (nextToPick.getTeamName().equals(playerOne.getTeamName())) {
                    nextToPick = playerTwo;
                } else {
                    nextToPick = playerOne;
                }
            } else {
                // not availablePokemonNames
                System.out.println("Invalid pokemon nam. Please choose from the following: " + Arrays.toString(pokemonAvailable));
            }
        }

        System.out.println("The Teams are:");
        System.out.println(playerOne.toString());
        System.out.println(playerTwo.toString());
    }


    public static void fight() {
        Random ran = new Random();
        //print teams
        //ask which pokemon theyd like to use, using array digit, replace random with array
                Poke currentPlayerOnePokemon = playerOne.getPokemon().get(ran.nextInt(3));
                Poke currentPlayerTwoPokemon = playerTwo.getPokemon().get(ran.nextInt(3));

                while (true) {
                    while ((currentPlayerOnePokemon.getHealth() > 0) && (currentPlayerOnePokemon.getHealth() > 0)) {


                        // Player 1
                        System.out.println("Player one - " + currentPlayerOnePokemon.getName() + " moves available: " + currentPlayerOnePokemon.printMoves());
                        String typeOfPlayerOnePokemon = currentPlayerOnePokemon.getType();

                        moves currentPlayerOneMove = null;
                        System.out.println("Team One: What move would you like to use \n");
                        Scanner scanit = new Scanner(System.in);
                        String teamOneMove = scanit.nextLine();
                        for (moves move : currentPlayerOnePokemon.getMoves()) {
                            if (move.getName().equals(teamOneMove)) {
                                currentPlayerOneMove = move;
                            }
                        }

                        if (currentPlayerOneMove == null) {
                            System.out.println("Invalid move, please try again. \n");
                            System.out.println("Player one - " + currentPlayerOnePokemon.getName() + " moves available: " + currentPlayerOnePokemon.printMoves());
                        } else {
                            System.out.println(currentPlayerOnePokemon.getName() + " is attacking with " + currentPlayerOneMove.getName() + "\n\n");
                        }

                        // Player 2
                        String typeOfPlayerTwoPokemon = currentPlayerTwoPokemon.getType();

                        System.out.println("Player two - " + currentPlayerTwoPokemon.getName() + " moves available: " + currentPlayerTwoPokemon.printMoves());

                        moves currentPlayerTwoMove = null;
                        System.out.println("Team One: What move would you like to use \n");
                        String teamTwoMove = scanit.nextLine();
                        for (moves move : currentPlayerTwoPokemon.getMoves()) {
                            if (move.getName().equals(teamTwoMove)) {
                                currentPlayerTwoMove = move;
                            }
                        }
                        if (currentPlayerTwoMove == null) {
                            System.out.println("Invalid move, please try again. \n");
                            System.out.println("Player two - " + currentPlayerTwoPokemon.getName() + " moves available: " + currentPlayerTwoPokemon.printMoves() + "\n\n");
                        } else {
                            System.out.println(currentPlayerTwoPokemon.getName() + " is attacking with " + currentPlayerTwoMove.getName() + "\n\n");
                        }

                        String playerTwoMovePhysical = currentPlayerTwoMove.getPhysical();
                        String playerOneMovePhysical = currentPlayerOneMove.getPhysical();

                        String[] weatherArray = new String[]{"rainy", "harsh sunlight", "no weather", "no"};
                        String randomWeather = weatherArray[new Random().nextInt(weatherArray.length)];
                        String TeamOneType = currentPlayerTwoPokemon.getType();
                        String TeamTwoType = currentPlayerOnePokemon.getType();
                        String TeamOneMoveType = currentPlayerTwoMove.getType();
                        String TeamTwoMoveType = currentPlayerOneMove.getType();

                        // Attacking

                        {
                            if (playerOneMovePhysical.equals("yes")) {


                                if (currentPlayerTwoPokemon.getHealth() <= 0) {
                                    System.out.println(currentPlayerTwoPokemon.getName() + " has died. Player two lost!" + "\n\n");
                                    break;
                                } else {
                                    int speed = currentPlayerOnePokemon.getSpeed();

                                    double randomModNumber = generateRandomModNumber(.85, 1.00);

                                    double modOne = modifier(randomWeather, speed, randomModNumber, TeamOneMoveType, TeamOneType, TeamTwoType);

                                    int oneD = currentPlayerOneMove.getDamage();
                                    int oneA = currentPlayerOnePokemon.getAttack();
                                    int twoDe = currentPlayerTwoPokemon.getDefense();
                                    int d = (oneA / twoDe);
                                    double oneDamage = (((2.4 * oneD * d)/50)+2) * modOne;
                                    double playerTwoDamage = currentPlayerTwoPokemon.getHealth() - oneDamage;
                                    currentPlayerTwoPokemon.setHealth(playerTwoDamage);
                                }
                            } else if (playerOneMovePhysical.equals("no")) {
                                if (currentPlayerTwoPokemon.getHealth() <= 0) {
                                    System.out.println(currentPlayerTwoPokemon.getName() + " has died. Player two lost!" + "\n\n");
                                    break;
                                } else {
                                    int speed = currentPlayerOnePokemon.getSpeed();

                                    double randomModNumber = generateRandomModNumber(.85, 1.00);

                                    double modOne = modifier(randomWeather, speed, randomModNumber, TeamOneMoveType, TeamOneType, TeamTwoType);

                                    int oneD = currentPlayerOneMove.getDamage();
                                    int oneSa = currentPlayerOnePokemon.getSpattack();
                                    int twoSd = currentPlayerTwoPokemon.getSpdefense();
                                    int i = (oneSa / twoSd);
                                    double oneDamage = (((2.4 * oneD * i)/50)+2) * modOne;
                                    double playerTwoDamage = currentPlayerTwoPokemon.getHealth() - oneDamage;
                                    currentPlayerTwoPokemon.setHealth(playerTwoDamage);
                                }
                            }
                            System.out.println(currentPlayerOnePokemon.getName() + ":" + currentPlayerOnePokemon.getHealth() + "\n\n");
                            System.out.println(currentPlayerTwoPokemon.getName() + ":" + currentPlayerTwoPokemon.getHealth() + "\n\n");
                        }


                        {
                            if (playerTwoMovePhysical.equals("yes")) {


                                if (currentPlayerOnePokemon.getHealth() <= 0) {
                                    System.out.println(currentPlayerOnePokemon.getName() + " has died. Player two lost!" + "\n\n");
                                    break;
                                } else {
                                    int speed = currentPlayerTwoPokemon.getSpeed();

                                    double randomModNumber = generateRandomModNumber(.85, 1.00);

                                    double modOne = modifier(randomWeather, speed, randomModNumber, TeamOneMoveType, TeamOneType, TeamTwoType);
                                    int twoD = currentPlayerTwoMove.getDamage();
                                    int twoA = currentPlayerTwoPokemon.getAttack();
                                    int oneDe = currentPlayerOnePokemon.getDefense();
                                    int n = (twoA / oneDe);
                                    double twoDamage = ((2.4 * twoD * n)/50)+2 * modOne;
                                    double playerOneDamage = currentPlayerOnePokemon.getHealth() - twoDamage;
                                    currentPlayerOnePokemon.setHealth(playerOneDamage);
                                }
                            } else {
                                if (currentPlayerTwoPokemon.getHealth() <= 0) {
                                    System.out.println(currentPlayerTwoPokemon.getName() + " has died. Player two lost!" + "\n\n");
                                    break;
                                } else {


                                    int speed = currentPlayerTwoPokemon.getSpeed();

                                    double randomModNumber = generateRandomModNumber(.85, 1.00);

                                    double modOne = modifier(randomWeather, speed, randomModNumber, TeamTwoMoveType, TeamTwoType, TeamOneType);

                                    int twoDa = currentPlayerTwoMove.getDamage();
                                    int twoSa = currentPlayerTwoPokemon.getSpattack();
                                    int oneSd = currentPlayerOnePokemon.getSpdefense();
                                    int s = (twoSa / oneSd);
                                    double twoDamage = (((2.4 * twoDa * s)/50)+2) * modOne;
                                    double playerOneDamage = currentPlayerOnePokemon.getHealth() - twoDamage;
                                    currentPlayerOnePokemon.setHealth(playerOneDamage);
                                }
                            }
                            System.out.println(currentPlayerOnePokemon.getName() + ":" + currentPlayerOnePokemon.getHealth() + "\n\n");
                            System.out.println(currentPlayerTwoPokemon.getName() + ":" + currentPlayerTwoPokemon.getHealth() + "\n\n");


                        }
                    }
                }








                    }





    public static double modifier(String weatherData, int speedStat, double randomData, String playerMoveType, String playerPokemonType, String opponentPokemonType)
    {

        System.out.println("weather is: " + weatherData);
        double weatherNum;
        double STAB;
        double numType;
        double criticalAttack;

        int randomCriticalAttackNumber = generateRandomNumber(255);

        int T = speedStat / 2;

        {if (randomCriticalAttackNumber < T) {criticalAttack = 1.5;}
        else
        {criticalAttack = 1;}}

        {if ((weatherData.equals("rainy")) && (playerPokemonType.equals("water")))
        {weatherNum = 1.5;}
        else if ((weatherData.equals("harsh sunlight")) && (playerPokemonType.equals("water")))
        {weatherNum = 0.5;}
        else {weatherNum = 1;}}




            {if (playerPokemonType.equals(playerMoveType))
            {STAB = 1.5;}
            else{STAB = 1;};}


            {if ((playerMoveType.equals("water")) && ((opponentPokemonType.equals("fire")) || (opponentPokemonType == "rock") || (opponentPokemonType == "ground")))
            {numType = 2;}
            else if ((playerMoveType == "water") && ((opponentPokemonType == "fire and rock") || (opponentPokemonType == "fire and ground") || (opponentPokemonType == "ground and rock") || (opponentPokemonType == "rock and ground")))
            {numType = 4;}
            else if ((playerMoveType == "water") && ((opponentPokemonType == "water") || (opponentPokemonType == "dragon") || (opponentPokemonType == "grass")))
            {numType = 0.5;}
            else if ((playerMoveType == "normal") && (opponentPokemonType == "ghost"))
            {numType = 0;}
            else if ((playerMoveType == "normal") && ((opponentPokemonType == "steel") || (opponentPokemonType == "rock")))
            {numType = 0.5;}
            else if ((playerMoveType == "normal") && ((opponentPokemonType != "ghost") || (opponentPokemonType == "steel") || (opponentPokemonType == "rock")))
            {numType = 1;}
            else if ((playerMoveType == "fire") && ((opponentPokemonType == "grass") || (opponentPokemonType == "ice") || (opponentPokemonType == "steel") || (opponentPokemonType == "bug")))
            {numType = 2;}
            else if ((playerMoveType == "fire") && ((opponentPokemonType == "fire") || (opponentPokemonType == "ground") || (opponentPokemonType == "rock") || (opponentPokemonType == "dragon") || (opponentPokemonType == "water")))
            {numType = 0.5;}
            else if ((playerMoveType == "fire") && ((opponentPokemonType == "grass and ice") || (opponentPokemonType == "grass and steel") || (opponentPokemonType == "grass and bug") || (opponentPokemonType == "ice and grass") || (opponentPokemonType == "ice and steel") || (opponentPokemonType == "ice and bug") || (opponentPokemonType == ")steel and grass") || (opponentPokemonType == "steel and ice") || (opponentPokemonType == "steel and bug") || (opponentPokemonType == "bug and grass") || (opponentPokemonType == "bug and ice") || (opponentPokemonType == "bug and steel")))
            {numType = 4;}
            else if ((playerMoveType == "grass") && ((opponentPokemonType == "water") || (opponentPokemonType == "ground") || (opponentPokemonType == "rock")))
            {numType = 2;}
            else if ((playerMoveType == "grass") && ((opponentPokemonType == "steel") || (opponentPokemonType == "dragon") || (opponentPokemonType == "grass") || (opponentPokemonType == "bug") || (opponentPokemonType == "fire") || (opponentPokemonType == "flying") || (opponentPokemonType == ")poison")))
            {numType = 0.5;}
            else if ((playerMoveType == "grass") && ((opponentPokemonType == "water and ground") || (opponentPokemonType == "water and rock") || (opponentPokemonType == "ground and water") || (opponentPokemonType == "ground and rock") || (opponentPokemonType == "rock and water") || (opponentPokemonType == "rock and ground")))
            {numType = 4;}
            else if ((playerMoveType == "fairy") && ((opponentPokemonType == "dragon") || (opponentPokemonType == "fighting") || (opponentPokemonType == "dark")))
            {numType = 2;}
            else if ((playerMoveType == "fairy") && ((opponentPokemonType == "dragon and fighting") || (opponentPokemonType == "dragon and dark") || (opponentPokemonType == "fighting and dragon") || (opponentPokemonType == "fighting and dark") || (opponentPokemonType == "dark and dragon") || (opponentPokemonType == "dark and fighting")))
            {numType = 4;}
            else if ((playerMoveType == "fairy") && ((opponentPokemonType == "poison") || (opponentPokemonType == "fire") || (opponentPokemonType == "steel")))
            {numType = 0;}
            else if ((playerMoveType == "poison") && ((opponentPokemonType == "fairy") || (opponentPokemonType == "grass")))
            {numType = 2;}
            else if ((playerMoveType == "poison") && ((opponentPokemonType == "grass and fairy") || (opponentPokemonType == "fairy and grass")))
            {numType = 4;}
            else if ((playerMoveType == "poison") && (opponentPokemonType == "steel"))
            {numType = 0;}
            else if ((playerMoveType == "poison") && ((opponentPokemonType == "rock") || (opponentPokemonType == "ground") || (opponentPokemonType == "poison") || (opponentPokemonType == "ghost")))
            {numType = 0.5;}
            else if ((playerMoveType == "dark") && ((opponentPokemonType == "psychic") || (opponentPokemonType == "ghost")))
            {numType = 2;}
            else if ((playerMoveType == "dark") && ((opponentPokemonType == "psychic and ghost") || (opponentPokemonType == "ghost and psychic")))
            {numType = 4;}
            else if ((playerMoveType == "dark") && ((opponentPokemonType == "fighting") || (opponentPokemonType == "dark") || (opponentPokemonType == "fairy")))
            {numType = 0.5;}
            else if ((playerMoveType == "psychic") && ((opponentPokemonType == "fighting") || (opponentPokemonType == "poison")))
            {numType = 2;;}
            else if ((playerMoveType == "psychic") && ((opponentPokemonType == "fighting and poison") || (opponentPokemonType == "poison and fighting")))
            {numType = 4;}
            else if ((playerMoveType == "psychic") && ((opponentPokemonType == "psychic") || (opponentPokemonType == "steel")))
            {numType = 0.5;}
            else if ((playerMoveType == "psychic") && (opponentPokemonType == "dark"))
            {numType = 0;}
            else if ((playerMoveType == "steel") && ((opponentPokemonType == "fairy") || (opponentPokemonType == "rock") || (opponentPokemonType == "ice")))
            {numType = 2;}
            else if ((playerMoveType == "steel") && ((opponentPokemonType == "fairy and rock") || (opponentPokemonType == "rock and fairy") || (opponentPokemonType == "fairy and ice") || (opponentPokemonType == "rock and ice") || (opponentPokemonType == "ice and fairy") || (opponentPokemonType == "ice and rock")))
            {numType = 4;}
            else if ((playerMoveType == "steel") && ((opponentPokemonType == "steel") || (opponentPokemonType == "water") || (opponentPokemonType == "electric") || (opponentPokemonType == "fire")))
            {numType = 0.5;}
            else if ((playerMoveType == "fighting") && ((opponentPokemonType == "normal") || (opponentPokemonType == "rock") || (opponentPokemonType == "dark") || (opponentPokemonType == "steel") || (opponentPokemonType == "ice")))
            {numType = 2;}
            else if ((playerMoveType == "fighting") && ((opponentPokemonType == "normal and rock") || (opponentPokemonType == "normal and dark") || (opponentPokemonType == "normal and steel") || (opponentPokemonType == "normal and ice") || (opponentPokemonType == "rock and normal") || (opponentPokemonType == "rock and dark") || (opponentPokemonType == "rock and steel") || (opponentPokemonType == "rock and ice") || (opponentPokemonType == "dark and normal") || (opponentPokemonType == "dark and rock") || (opponentPokemonType == ")dark and steel") || (opponentPokemonType == "dark and ice") || (opponentPokemonType == "steel and normal") || (opponentPokemonType == "steel and rock") || (opponentPokemonType == "steel and dark") || (opponentPokemonType == "steel and ice") || (opponentPokemonType == "ice and normal") || (opponentPokemonType == "ice and rock") || (opponentPokemonType == "ice and dark") || (opponentPokemonType == "ice and steel")))
            {numType = 4;}
            else if ((playerMoveType == "fighting") && ((opponentPokemonType == "flying") || (opponentPokemonType == "psychic") || (opponentPokemonType == "fairy") || (opponentPokemonType == "bug") || (opponentPokemonType == "poison")))
            {numType = 0.5;}
            else if ((playerMoveType == "dragon") && (opponentPokemonType == "dragon"))
            {numType = 2;}
            else if ((playerMoveType == "dragon") && (opponentPokemonType == "fairy"))
            {numType = 0;}
            else if ((playerMoveType == "dragon") && (opponentPokemonType == "steel"))
            {numType = 0.5;}
            else if ((playerMoveType == "flying") && ((opponentPokemonType == "fighting") || (opponentPokemonType == "bug") || (opponentPokemonType == "grass")))
            {numType = 2;}
            else if ((playerMoveType == "flying") && ((opponentPokemonType == "fighting and bug") || (opponentPokemonType == "fighting and grass") || (opponentPokemonType == "bug and fighting") || (opponentPokemonType == "bug and grass") || (opponentPokemonType == "grass and fighting") || (opponentPokemonType == "grass and bug")))
            {numType = 4;}
            else if ((playerMoveType == "flying") && ((opponentPokemonType == "electric") || (opponentPokemonType == "rock") || (opponentPokemonType == "steel")))
            {numType = 0.5;}
            else if ((playerMoveType == "bug") && ((opponentPokemonType == "psychic") || (opponentPokemonType == "dark") || (opponentPokemonType == "grass")))
            {numType = 2;}
            else if ((playerMoveType == "bug") && ((opponentPokemonType == "psychic and dark") || (opponentPokemonType == "psychic and grass") || (opponentPokemonType == "psychic and dark") || (opponentPokemonType == "dark and psychic") || (opponentPokemonType == "dark and grass") || (opponentPokemonType == "grass and psychic") || (opponentPokemonType == "grass and dark")))
            {numType = 4;}
            else if ((playerMoveType == "bug") && ((opponentPokemonType == "fire") || (opponentPokemonType == "fighting") || (opponentPokemonType == "poison") || (opponentPokemonType == "flying") || (opponentPokemonType == "ghost") || (opponentPokemonType == "steel") || (opponentPokemonType == "fairy")))
            {numType = 0.5;}
            else if ((playerMoveType == "electric") && ((opponentPokemonType == "water") || (opponentPokemonType == "flying")))
            {numType = 2;}
            else if ((playerMoveType == "electric") && ((opponentPokemonType == "water and flying") || (opponentPokemonType == "flying and water")))
            {numType = 4;}
            else if ((playerMoveType == "electric") && (opponentPokemonType == "ground"))
            {numType = 0;}
            else if ((playerMoveType == "electric") && ((opponentPokemonType == "electric") || (opponentPokemonType == "grass") || (opponentPokemonType == "dragon")))
            {numType = 0.5;}
            else if ((playerMoveType == "ghost") && (opponentPokemonType == "normal"))
            {numType = 0;}
            else if ((playerMoveType == "ghost") && ((opponentPokemonType == "ghost") || (opponentPokemonType == "psychic")))
            {numType = 2;}
            else if ((playerMoveType == "ghost") && ((opponentPokemonType == "ghost and psychic") || (opponentPokemonType == "psychic and ghost")))
            {numType = 4;}
            else if ((playerMoveType == "ghost") && (opponentPokemonType == "dark"))
            {numType = 0.5;}
            else
            {numType = 1;}}

                double damageModifier = weatherNum * criticalAttack * randomData * STAB * numType;

                return damageModifier;
            }}
        //String printstring = printstringArray.toString()
        //system out print printstring
        //if pokemon health at zero sset currentPlayerOnePokemon to new pokemon

