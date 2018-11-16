/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ho.Antoine.GUI;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Antoine Ho
 */
public class GameInfo extends JPanel {

    // Attributes
    protected int mCurrentTurn = 0;
    protected int mTotalTurns = 0;
    protected int mScore = 0;
    protected JLabel mGameStats;
    private String mInitialInfo = "Tour 0 / 0.  Score: 0";
    
    // Contructor
    public GameInfo() {
        setBackground(new Color(0, 64, 128));
        
        mGameStats = new JLabel(mInitialInfo, JLabel.CENTER);
        mGameStats.setForeground(Color.WHITE);
        add(mGameStats);
    }
    
    
    /**
     * Updates the game statistics
     */
    public void updateInfo() {
        mGameStats.setText("Tour " + mCurrentTurn + " / " + mTotalTurns
            + ".  Score: " + mScore);
    }
    
    
    /**
     * Replaces statistics with score in all caps
     */
    public void endOfRoundScoreUpdate(){
        mGameStats.setText("SCORE: " + mScore);
    }
}
