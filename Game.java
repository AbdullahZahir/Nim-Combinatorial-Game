import java.util.Scanner;

/**
 * The Game class is responsible for running the entire game, and basically 
 * facilitating all the operations of the game, combining all 3 classes
 * to faciliate such.
 * It is responsible for: Creating players, managing turns, handling inputs, and 
 * determing round winners.
 */
public class Game {
    //Creates first player object, second player object, placeholder currentPlayer object
    // and input variable.
    private Player player1; 
    private Player player2;
    private Player currentPlayer;
    private Scanner input;
    
    /**
     * Game Constructor 
     * Creates a new Game Object to faciliate a game for player and player2.
     * Preconditions: 
     * - Inputs are allowed and registered from users
     * Postconditions: 
     * - Player1 and Player2 are initialized.
     */
    public Game() {
        input = new Scanner(System.in);
        
        System.out.println("Enter Player 1 name: ");
        player1 = new Player(input.nextLine());
        
        System.out.println("Enter Player 2 name: ");
        player2 = new Player(input.nextLine());
        
        
    }
    /**
     * play method:
     * This officially starts the gameplay of the Game of Nim game.
     * This method manages the turns between players, selects winners
     * and determines if players want to play again.
     * Preconditions: 
     * - player1 and player 2 exist
     * - Board is populated
     * - Board population is greater than 0
     * Postconditions: 
     * - Scores are updated after each round
     * - Winner is selected after some set of rounds.
     * - Users are asked if they want to play again
     */
    public void play() {
        boolean isActive = true;

        while (isActive){
            //Randomly chooses which player starrts
            if (Math.random()<0.5){
                currentPlayer = player1;
            }
            else {
                currentPlayer = player2;
            }
            
            //Prints initial starting size
            System.out.println("Starting pile: " + Board.getSize());
            System.out.println(currentPlayer.getName() + " goes first.");
            
            //Ensures that board game only operates when population is greater than 0.
            while (Board.getSize() > 0) {
                System.out.println("Pile size: " +  Board.getSize());
                //Halving logic for Game of Nim, and for determing 
                //max amount possible to remove
                int maxRemove = Board.getSize()/2;
                if (Board.getSize() ==1){
                    maxRemove = 1;
                }
                
                System.out.println("Max remove: " + maxRemove);
                System.out.println(currentPlayer.getName() + ", enter pieces to remove: ");
                
                int move = 0;
                boolean validMove = false;
            
                //Ensures that user input is valid (integer)
                while (!validMove) {
                    // https://www.w3schools.com/java/ref_scanner_hasnextint.asp
                    // https://fiveable.me/ap-comp-sci-a/unit-4/using-text-files/study-guide/JhiQXb5r4daUivzP1Xkm
                    //This checks if input is an integer, if it is not, prints requisite message
                    if (!input.hasNextInt()) {
                        System.out.println("You need to enter an integer!");
                        input.nextLine();
                    }
                    // If input is integer, continues
                    else {
                        move = input.nextInt();
                        input.nextLine();
                        //Ensures that there are still pieces left on board to move
                        if (Board.canMove(move)) {
                            validMove = true;
                            Board.removePieces(move);
                            System.out.println(currentPlayer.getName() + " removed " + move + " pieces.");
                        }
                        //If move is greater than half amount of pieces on board, prints message.
                        else {
                            System.out.println("You can't do that!");
                        }
                    }
                }
                //Sufficiently declares round winner when board population becomes 0.
                if (Board.getSize() == 0) {
                    declareRoundWinner();
                    break;
                }

                changeTurn(); 
            }
            //Asks users if they would like to play again, if both say Y, they play again.
            System.out.println("Current Score - " + player1.getName() + ": " + player1.getScore() + " | " + player2.getName() + ": " + player2.getScore());
            System.out.println("Perform a mutual decision, would you two like to play again? (Y/N)");
                
            String decision = input.nextLine().toUpperCase(); 

            if (!decision.equals("Y")) {
                isActive = false; 
                System.out.println("We hope you meet on the board again in the future!");
            }
        }
    }
    
    /**
     * changeTurn method:
     * Switches from one player to the other player
     * 
     * Preconditions: 
     * - Both player objects and currentPlayer must have been initialized
     * Postconditions: 
     * - currentPlayer is switched from Player 1 to Player 2, or vice versa 
     */ 
    private void changeTurn() {
        //Conditional logic for switching currentPlayer with other player object
        if (currentPlayer == player1) {
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
    }
    /**
     * declareRoundWinner() method:
     * Declares the sufficient round winner, the winner is the player who did not
     * make the final move.
     * 
     * Preconditions: 
     * - Board size is now 0
     * - currentPlayer made the last move of the game
     * 
     */
    private void declareRoundWinner() {
        //Creates winner object to determine winner.
        Player winner;
        //Conditional logic to ensure that player who did not make last move wins
        if (currentPlayer == player1) {
            winner = player2;
        }
        else {
            winner = player1;
        }    
        //Increments win tally.
        winner.updateScore();
        System.out.println("Game over! " + winner.getName() + " wins the round!");
    }
    
    
    
    
}
