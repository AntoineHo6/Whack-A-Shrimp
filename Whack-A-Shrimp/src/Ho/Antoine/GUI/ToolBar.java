/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ho.Antoine.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author Antoine Ho
 */
public class ToolBar extends JMenuBar {

    // Attributes
    private JMenu mMenu;
    private JMenuItem mSubMenuStart;
    private JMenuItem mSubMenuQuit;
    private JeuPanel mGameBoard;
    private GameInfo mGameInfo;
    private GameThread mThread;

    // Constructors
    public ToolBar(JeuPanel gameBoard, GameInfo gameInfo) {
        setBackground(new Color(0, 64, 128));
        this.mGameBoard = gameBoard;
        this.mGameInfo = gameInfo;
        mMenu = new JMenu("Menu");
        mMenu.setForeground(Color.WHITE);

        // This will instantiate "subMenuStart" and "subMenuQuit"
        initializeSubMenus();

        add(mMenu);
        mMenu.add(mSubMenuStart);
        mMenu.add(mSubMenuQuit);
    }

    /**
     * Instantiates "subMenuStart" and "subMenuQuit"
     */
    private void initializeSubMenus() {
        // Instantiate subMenu "Demarrer" with game functionality
        mSubMenuStart = new JMenuItem(new AbstractAction("Demarrer") {
            @Override
            public void actionPerformed(ActionEvent event) {
                // Asks for the number of turns
                String nbrOfTurns;

                while (true) {
                    try {
                        nbrOfTurns = JOptionPane.showInputDialog(null,
                                "Entrez le nombre de chances: ",
                                "Nombre de chances",
                                JOptionPane.PLAIN_MESSAGE);

                        mGameInfo.mTotalTurns = Integer.parseInt(nbrOfTurns);
                        break;
                    } catch (NumberFormatException e) {
                        // Can't convert user input to int
                    }
                }
                
                // Starts the thread
                mThread = new GameThread(mGameInfo.mTotalTurns,
                        mGameBoard, mGameInfo);
                mThread.start();
            }
        });

        // Instantiate subMenu "Quitter" with exit functionality
        mSubMenuQuit = new JMenuItem(new AbstractAction("Quitter") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
