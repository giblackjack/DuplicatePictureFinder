/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duplicatepicturefinder;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
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
    HashMap<String, ArrayList<String>> HMFiles;
    ArrayList<String> FileExt;
    
    /**
     * Variables for use by logger
     */
    private static final String logDir = "C:\\Users\\STIVY\\Desktop\\log.txt";
    private static FileHandler logFileHandler;
    private Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private SimpleFormatter fmtr;
    private duplicatepicturefinder.MainWindow parentContainer;
    
    public DuplicatePictureFinder(duplicatepicturefinder.MainWindow parent){
        this.fmtr = new SimpleFormatter();
        try {
            setupLogger();
        } catch (IOException ex) {
            Logger.getLogger(DuplicatePictureFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
        parentContainer = parent;
        FileExt = new ArrayList();
        FileExt.add(".jpg");
        FileExt.add(".jpeg");
        FileExt.add(".png");
        LLFiles = new LinkedList();
        HMFiles = new HashMap<>();
    }
    
    private void setupLogger() throws IOException{
        LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        LOGGER.setLevel(Level.ALL);
        logFileHandler = new FileHandler(logDir);
        logFileHandler.setFormatter(fmtr);
        LOGGER.addHandler(logFileHandler);
    }
    
    public void quickSearchDirectory(){
        if (!baseDir.isEmpty() && Files.exists(Paths.get(baseDir), LinkOption.NOFOLLOW_LINKS)){
            try {
                Path baseDirPath = Paths.get(baseDir);
                HMFiles.clear();
                int fileMaxDepth;
                if(visitSubDir){
                    fileMaxDepth = Integer.MAX_VALUE;
                }else{
                    fileMaxDepth = 0;
                }
                Files.walkFileTree(baseDirPath, EnumSet.noneOf(FileVisitOption.class), fileMaxDepth, new SimpleFileVisitor<Path>(){
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
                        //TODO: add in code to skip hidden files
                        for (String ext : FileExt){
                            if(file.toString().toLowerCase().endsWith(ext)){
                                HMFileAdd(file.getName(file.getNameCount()-1).toString(), file.toString());
                                break;
                            }
                        }
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException ex) {
                Logger.getLogger(DuplicatePictureFinder.class.getName()).log(Level.SEVERE, null, ex);
            }
            sendHMResults();
        } 
    }
    
    public void HMFileAdd(String key, String value){
        if(HMFiles.containsKey(key)){
            HMFiles.get(key).add(value);
        } else {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(value);
            HMFiles.put(key, temp);
        }
    }
    
    public void deepSearchDirectory(){
        if (!baseDir.isEmpty() && Files.exists(Paths.get(baseDir), LinkOption.NOFOLLOW_LINKS)){
            try {
                Path baseDirPath = Paths.get(baseDir);
                LLFiles.clear();
                int fileMaxDepth;
                if(visitSubDir){
                    fileMaxDepth = Integer.MAX_VALUE;
                }else{
                    fileMaxDepth = 0;
                }
                Files.walkFileTree(baseDirPath, EnumSet.noneOf(FileVisitOption.class), fileMaxDepth, new SimpleFileVisitor<Path>(){
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
                        //TODO: implement deep search functionality into code, refactor to change function name to reflect
                        //TODO: add in code to skip hidden files
                        for (String ext : FileExt){
                            if(file.toString().toLowerCase().endsWith(ext)){
                                LLFiles.add(file.toString());
                                break;
                            }
                        }
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException ex) {
                Logger.getLogger(DuplicatePictureFinder.class.getName()).log(Level.SEVERE, null, ex);
            }
            sendLLResults();
        } 
    }
    
    /**
     * 
     */
    public void sendHMResults(){
        parentContainer.DisplayResult(HMFiles.values());
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

    private void sendLLResults() {
        
    }
}
