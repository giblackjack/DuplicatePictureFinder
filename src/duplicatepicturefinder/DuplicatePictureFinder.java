/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duplicatepicturefinder;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author STIVY
 */
public class DuplicatePictureFinder {
    
    /**
     * Variables for use by file visitor
     */
    boolean visitSubDir = false;
    String baseDir;
    LinkedList LLFiles;
    HashMap HMFiles;
    
    /**
     * Variables for use by logger
     */
    private static final String logDir = "C:\\Users\\STIVY\\Desktop\\log.txt";
    private static FileHandler logFileHandler;
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private SimpleFormatter fmtr;
    
    public DuplicatePictureFinder(){
        this.fmtr = new SimpleFormatter();
        try {
            setupLogger();
        } catch (IOException ex) {
            Logger.getLogger(DuplicatePictureFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
        //LOGGER.severe("testing");
        
    }
    
    private void setupLogger() throws IOException{
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.setLevel(Level.ALL);
        logFileHandler = new FileHandler(logDir);
        logFileHandler.setFormatter(fmtr);
        logger.addHandler(logFileHandler);
    }
    
    public boolean isVisitSubDir() {
        return visitSubDir;
    }

    public void setVisitSubDir(boolean visitSubDir) {
        this.visitSubDir = visitSubDir;
    }

    public String getBaseDir() {
        return baseDir;
    }

    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }
}
