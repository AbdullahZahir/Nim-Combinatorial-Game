 /**
     * Board Class: This class controls the Board operations and pieces operations
     * of the game.
     * 
     * This class populates the board, can return the amount of pieces
     * of the board, removes pieces from the pile and ensures moves are valid.
     */
public class Board {
     
    //Defines the number of pieces currently in a Board object
    private static int totalPieces;
    
    /**Populate Method:
    * Populates a Board object with a random number of pieces between 10-50
    * 
    * Preconditions: 
    * - Game is about to start
    * Postconditions: 
    * - Board has a random number of pieces that can be played with
    */
    public static void populate() {
        totalPieces = (int)((Math.random() * 41)+10);
    }
    /** getSize Method:
     * Returns current size of the board object (how many pieces)
     * 
     * Preconditions:
     * - Board is populated
     * Postconditions:
     * - Returns totalPieces. (totalPieces unchanged)
     */
    public static int getSize() {
        return totalPieces;
    }
    /** canMove Method:
     * This determines if a move is valid.
     * 
     * Preconditions:
     * - Pieces is positive
     * Postconditions:
     * - boolean value is returned for if move is possible (totalPieces unchanged)
     */
    public static boolean canMove(int pieces) {
        if (totalPieces == 1) {
            return pieces==1;
        }
        int maximum = totalPieces/2;
        return pieces >= 1 && pieces<=maximum;
    }
    /** removePieces method:
     * This removes a set amount of pieces from a board object
     * based on user input.
     * 
     * Precondition:
     * - User inputted amount of pieces they want removed
     * - canMovie(pieces) is true
     * 
     * Postcondition:
     * - totalPieces is subtracted by pieces to give a new value if valid, unchanged if not
     * 
     */
    public static void removePieces(int pieces) {
        if (canMove(pieces)) {
            totalPieces -= pieces;
        } 
    }
}
