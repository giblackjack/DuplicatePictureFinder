/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duplicatepicturefinder;

import java.awt.*;
import java.awt.event.*;
import java.swing.*;
import java.swing.event.*;

/**
 *
 * @author STIVY
 */
public class GUI {
    Frame F1;
    //FileDialog chooser;
    JFileChooser JFolderDialog;
    WindowAdapter myWindowAdapter;
    String baseDirectory;
    
    public GUI() {
        //construct needed objects
        myWindowAdapter = new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we) {
                super.windowClosing(we); //To change body of generated methods, choose Tools | Templates.
                System.exit(0);
            }
        };
    }
    //setup main window and show window
    public void show(){
        this.F1 = new Frame("test frame");
        F1.add(new Label("Hello World!"));
        F1.addWindowListener(myWindowAdapter);
        F1.pack();
        F1.setVisible(true);
        
        //chooser = new FileDialog(F1,"Choose a Folder",FileDialog.LOAD);
        //chooser.setVisible(true);
        //String dir = chooser.getDirectory();
        JFolderDialog = new JFileChooser();
        JFolderDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = JFolderDialog.showOpenDialog(F1);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            baseDirectory = JFolderDialog.getSelectedFile().getName();
        }
        
        F1.add(new Label(dir));
        F1.pack();
    }
    
    
}
