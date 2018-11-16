/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ho.Antoine.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Antoine Ho
 */
public class JeuPanel extends JPanel implements ActionListener {

    // Attributes
    private JButton[][] mButtons = new JButton[5][5];
    //private ImageIcon mGenieIcon = new ImageIcon("./shrimp.JPG");
    protected int mScore = 0;
    private int mRandX;
    private int mRandY;
    private GameInfo mGameInfo;

    // Constructor
    public JeuPanel(GameInfo gameInfo) {
        setBackground(new Color(0, 64, 128));
        this.mGameInfo = gameInfo;

        // Creating shrimp icon for buttons and resizing it
        ImageIcon lShrimpIcon = new ImageIcon("./shrimp.JPG");
        Image img = lShrimpIcon.getImage();
        Image newShrimpImg
                = img.getScaledInstance(72, 72, java.awt.Image.SCALE_SMOOTH);
        lShrimpIcon = new ImageIcon(newShrimpImg);

        // Initializing JButtons in the array
        for (int i = 0; i < mButtons.length; i++) {
            for (int j = 0; j < mButtons[0].length; j++) {
                mButtons[i][j] = new JButton(lShrimpIcon);
                mButtons[i][j].setPreferredSize(new Dimension(76, 76));
                mButtons[i][j].setEnabled(false);
                mButtons[i][j].addActionListener(this);
                add(mButtons[i][j]);
            }
        }
    }

    
    /**
     * Disables the button and attributes a point to the player
     *
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton button = (JButton) ae.getSource();
        button.setEnabled(false);
        mGameInfo.mScore++;
        mGameInfo.updateInfo();
    }

    
    /**
     * Enables a random button to become clickable. Avoids buttons that are
     * already enabled.
     *
     */
    public void enableRandomGenie() {
        // Randomize values between 0 and 5 inclusively
        mRandX = ThreadLocalRandom.current().nextInt(0, 4 + 1);
        mRandY = ThreadLocalRandom.current().nextInt(0, 4 + 1);

        mButtons[mRandX][mRandY].setEnabled(true);
    }

    
    /**
     * Disables the enabled genie
     */
    public void disableGenie() {
        mButtons[mRandX][mRandY].setEnabled(false);
    }

    
    /**
     * Makes buttons clickable and disappear after a certain amount of time
     *
     * @param nbrOfTurns
     */
    public void playGame(int nbrOfTurns) {
        // Quick 1 second pause so player can get ready before game stats
        pause(1000);
        
        for (int i = 0; i < nbrOfTurns; i++) {
            mGameInfo.mCurrentTurn++;
            mGameInfo.updateInfo(); 
            enableRandomGenie();
            
            int randTime = ThreadLocalRandom.current().nextInt(500, 999);
            pause(randTime);
            
            disableGenie();
        }
    }

    
    /**
     * Sleeps according to the time parameter
     *
     * @param time
     */
    public void pause(int time) {
        try {
            sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameThread.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
