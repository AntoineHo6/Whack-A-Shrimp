/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ho.Antoine.GUI;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author Antoine Ho
 */
public class MainFrame extends JFrame{
    
    // Attributes
    private ToolBar mToolBar;
    private JeuPanel mJeuPanel;
    private GameInfo mGameInfo;
    
    // Constructor
    public MainFrame() {
        super("TP1");
        
        initializeMainFrame();
        
        mGameInfo = new GameInfo();
        mJeuPanel = new JeuPanel(mGameInfo);
        mToolBar = new ToolBar(mJeuPanel, mGameInfo);

        add(mToolBar, BorderLayout.PAGE_START);
        add(mJeuPanel, BorderLayout.CENTER);
        //gameInfo.setPreferredSize(new Dimension(0, 110));
        add(mGameInfo, BorderLayout.PAGE_END);
    }
    
    
    /**
     * Initializes the MainFrame
     */
    private void initializeMainFrame(){
        setLayout(new BorderLayout(0, 0));
        setSize(500, 500);
        setLocation(300, 200);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
}
