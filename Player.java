/** Player class:
 *  Faciliates the player objects for the game, ensures that users
 * are defined as player objects within code function.
 * 
 * This class keeps score of how many wins a player has, and saves
 * their name.
 */ 

public class Player {
    //Name of player, user-inputted
    private String name;
    //Amount of wins player has.
    private int score;
    
    /**
     * Player constructor:
     * Creates a player object, and initiates that object with 0 wins.
     * 
     * Preconditions: 
     * - User input is accepted from user for name
     * - Score instance variable is defined properly
     * Postconditions:
     * - Player object for user is defined for gameplay
     * - Player starts with 0 wins
     */
    public Player(String name1) {
        name = name1;
        score = 0;
    }
    /**
     * getName method:
     * Returns the name of a player.
     * 
     * Precondition:
     * - Player object initiated
     * Postcondition:
     * - Returns name of player (name is not changed)
     */
    public String getName() {
        return name;
    }
    /**
     * getScore method:
     * Returns the score,or amount of wins a player has.
     * 
     * Precondition:
     * - Player object initiated
     * Postcondition:
     * - Returns their score (score is not changed)
     */
    public int getScore() {
        return score;
    }
    /**
     * updateScore:
     * Increments score value for a player object by 1
     * 
     * Precondition:
     * - Player object initiated
     * - That said player object has won a round of Game of Nim
     * Postcondition:
     * - Player's score value (or amount of wins) is incremented.
     */
    public void updateScore() {
        score++;
    }
}
