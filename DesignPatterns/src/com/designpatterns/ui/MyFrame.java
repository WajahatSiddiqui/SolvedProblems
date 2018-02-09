package com.designpatterns.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

// www.leadows.com/javadp.zip

// ali.shakeel@leadows.com

// 9845567086
class MyFrame extends JFrame {

    JButton button1 = new JButton() ;

    public MyFrame() {

        this.setSize ( 600, 600 ) ;
        this.setTitle( "First GUI application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when frame window is closed app should shut down
        this.setLayout(null);

        button1.setLocation( 10, 10 );
        button1.setSize ( 100, 40 );
        button1.setText( "GET HTML" );

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonClicked(e);
            }
        });

        this.add ( button1 ) ;
    }

    
    void buttonClicked ( ActionEvent e ) {
        JOptionPane.showMessageDialog(this, "Button is Clicked");
        // send HTTP request to the remote server to obtain the daa ~4 secs - EDT is blocked
        
        // Java8 : Completable future
        
        // communication with remote machine or something that runs more than 50 msecs
        
        // Access data from database
        // Access 
    
    }
}
