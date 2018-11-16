/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ho.Antoine.GUI;

import Ho.Antoine.GUI.JeuPanel;

/**
 *
 * @author Antoine Ho
 */
public class GameThread extends Thread{
    
    // Attributes
    private int mTurns;
    private JeuPanel mGameBoard;
    private GameInfo mGameInfo;
    
    // Constructors
    public GameThread(int turns, JeuPanel gameBoard, GameInfo gameInfo) {
        this.mGameInfo = gameInfo;
        this.mTurns = turns;
        this.mGameBoard = gameBoard;
    }
    
    /**
     * Starts a game round.
     */
    @Override
    public void run(){
            // Resets turn and score back to zero since new round has started
            mGameInfo.mCurrentTurn = 0;
            mGameInfo.mScore = 0;
            mGameInfo.updateInfo();
            
            mGameBoard.playGame(mTurns);
            mGameInfo.mGameStats.setText("SCORE: " + mGameInfo.mScore);
    }
    
}
