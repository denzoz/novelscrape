package deniz.project.novelscrape;

/**
 *
 * @author denzoz
 */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Container;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import javax.swing.BorderFactory;
//import javax.swing.JLabel; For adding read-only text to oldgui

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


public class oldgui extends JFrame {
    private JPanel pane = new JPanel();
    private JButton testButton = new JButton("This is test button 1");
    private listener tbListener = new listener();
    private JButton testButton2 = new JButton("This is test button 2");
    
    private GridBagConstraints gbcs = new GridBagConstraints();
    private GridBagLayout gbl = new GridBagLayout();
    private Insets externalSpaces = new Insets(5,5,5,5);
    
    
    
    oldgui() { // the frame constructor
        super ("NovelScraper"); setSize(400, 400); // same as saying super.setSize(..);
        Container con = this.getContentPane();
        con.add(pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
//        con.setLayout(new BorderLayout());
//        this.getRootPane().setBackground(Color.gray);
        
        // associate hotkey to button: testButton.setMnemonic('P');
        
        con.setLayout(gbl);
        
        gbcs.fill = GridBagConstraints.NONE; // default anyways, means to not resize the component to fill page
        gbcs.insets = externalSpaces;
        gbcs.anchor = GridBagConstraints.NORTHWEST;
        
        con.add(testButton, gbcs);
        testButton.addActionListener(tbListener);
        

        
        con.add(testButton2, gbcs);
        

        
        
        setVisible(true);
        
    }
    
    // this is an inner class
    
    private class listener implements ActionListener {
        
        @Override // since we are implementing an interface method
        public void actionPerformed(ActionEvent ae) {
            // this is the code that is run on button press
            System.out.println("Button pressed");
        }
    }
    
}
