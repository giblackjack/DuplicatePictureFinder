/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duplicatepicturefinder;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author STIVY
 */
public class GUI {
    JFrame F1;
    JFileChooser JFolderDialog;
    
    
    WindowAdapter myWindowAdapter;
    public String baseDirectory;
    
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
        this.F1 = new JFrame("Duplicate File Finder");
        F1.setSize(600, 600);
        F1.addWindowListener(myWindowAdapter);
        F1.pack();
        F1.setVisible(true);
        getBaseDirectory();
        
        
        
        F1.add(new Label(baseDirectory));
        F1.pack();
    }
    
    private void getBaseDirectory(){
        JFolderDialog = new JFileChooser();
        JFolderDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = JFolderDialog.showOpenDialog(F1);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                baseDirectory = JFolderDialog.getSelectedFile().getCanonicalPath();
            }
            catch (IOException e){
                System.err.print(e);
                System.exit(1);
            }
        }
    
    }
    
}
