package deniz.project.novelscrape;

/**
 *
 * @author denzoz
 */

import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;

public class gui extends JFrame {
    JPanel pane = new JPanel();
    JButton testButton = new JButton("This is test button 1");
    JButton testButton2 = new JButton("This is test button 2");
    
    
    
    gui() { // the frame constructor
        super ("NovelScraper"); setSize(800, 800); // same as saying super.setSize(..);
        Container con = this.getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con.add(pane);
        
        // associate hotkey to button: testButton.setMnemonic('P');
        pane.add(testButton);
        pane.add(testButton2);
        
        setVisible(true);
        
    }
    
    
}
