/**
 * The NimRunner Class effectively runs the Game class, which then
 * causes the operations of the game, as well as initializing the board.
 */
public class NimRunner
{
    /** main method:
     *  Launches the Game of Nim game.
     * 
     * Preconditions:
     * - Other classes are defined.
     * Postconditions:
     * - Game of Nim gameplay.
     */ 
    public static void main(String[] args)
    {
        
        //Initializing the board to then be used by a Game object
        Board.populate();
        //Create new game object to run the game and plays it
        Game game = new Game();
        game.play();
    }
}
