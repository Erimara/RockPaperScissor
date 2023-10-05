package org.example.logic;


import org.example.data.GameData;
import org.example.data.SpecificStats;
import org.example.entities.opponent.Opponent;
import org.example.moves.Move;
import org.example.utils.ReturnToMenu;
import java.util.List;
public class WinnerData {
    private Opponent opponent;
    String originalName;
    List<Move> opponentMoves;
    List<Move> playerMoves;
    int playerWins;
    int opponentWins;

    public WinnerData(Opponent opponent,  String originalName,
                      List<Move> opponentMoves, List<Move> playerMoves,
                      int playerWins, int opponentWins) {
        this.opponent = opponent;
        this.originalName = originalName;
        this.opponentMoves = opponentMoves;
        this.playerMoves = playerMoves;
        this.playerWins = playerWins;
        this.opponentWins = opponentWins;
    }

    public void calculateWinner() {
        String opponentName = opponent.getName();

        int playerScore = 0;
        int opponentScore = 0;

        if (opponentWins > playerWins) {
            System.out.println("Computer wins: " + opponentWins + "-" + playerWins);
            addData(2, playerScore,  opponentScore,  opponentName);
            ReturnToMenu.returnToMainMenu();
        }
        if (playerWins > opponentWins) {
            System.out.println("Player wins: " + playerWins + "-" + opponentWins);
            addData(1, playerScore,  opponentScore,  opponentName);
            ReturnToMenu.returnToMainMenu();
        }
        if (playerWins == opponentWins) {
            addData(3, playerScore,  opponentScore,  opponentName);
            ReturnToMenu.returnToMainMenu();
        }
    }
    private void addData(int drawPlayerOpponent, int playerScore, int opponentScore, String opponentName){

        if (drawPlayerOpponent == 1){
            playerScore++;
            GameData.getInstance().addTotalWins(originalName, playerScore);
            GameData.getInstance().startNewGame(opponentName, originalName, opponentMoves, playerMoves);
            SpecificStats.getInstance().addPlayerWins(originalName, opponentName);
        } else if (drawPlayerOpponent == 2) {
            opponentScore++;
            GameData.getInstance().addTotalWins(opponentName, opponentScore);
            GameData.getInstance().startNewGame(opponentName, originalName, opponentMoves, playerMoves);
        } else if (drawPlayerOpponent == 3) {
            System.out.println("DRAW : " + playerWins + "-" + opponentWins);
            GameData.getInstance().startNewGame(opponentName, originalName, opponentMoves, playerMoves);
            GameData.getInstance().addTotalWins("Draw".toUpperCase(), 0);
        }
    }
}
