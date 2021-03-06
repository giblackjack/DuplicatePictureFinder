/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duplicatepicturefinder;

import java.awt.FlowLayout;
import java.awt.Image;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ListModel;
import javax.swing.SwingWorker;

/**
 *
 * @author STIVY
 * TODO: set max horizontal size for image/button display to size of current area to allow vertical scrolling only.
 */
public class MainWindow extends javax.swing.JFrame {

    
    public String BaseDirectory;
    DuplicatePictureFinder appEngine = new DuplicatePictureFinder(this);
    
    /**
     * TODO: add method to interrupt and/or stop processing of pictures in event of large number of pictures selected.
     */
    private class ImgProcess extends SwingWorker <Void, JButton> {
        private List<String> values;
        public ImgProcess (List<String> values){
            this.values = values;
        }
        
        @Override
        protected Void doInBackground() {
            for(String item : values) {
                ImageIcon ImageIconTemp = new ImageIcon(item);
                ImageIconTemp.setImage(ImageIconTemp.getImage().getScaledInstance(200, 200, Image.SCALE_FAST));
                JButton JButtonTemp = new JButton(ImageIconTemp);
                publish(JButtonTemp);
            }
            return null;
        }
        
        @Override
        public void process(List<JButton> temp){
            for (JButton JButtonTemp : temp) {
                jPanelResults.add(JButtonTemp);
            }
            jPanelResults.revalidate();
            jPanelResults.repaint();
        }
        
    }
    
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        //jPanelResults.setLayout(new BoxLayout(jPanelResults, BoxLayout.Y_AXIS));
        jPanelResults.setLayout(new FlowLayout());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jToolBar1 = new javax.swing.JToolBar();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButtonMoveFiles = new javax.swing.JButton();
        jButtonDeleteFiles = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldDirectory = new javax.swing.JTextField();
        jButtonSelectDirectory = new javax.swing.JButton();
        jCheckBoxSubfolders = new javax.swing.JCheckBox();
        jComboBoxFileFilter = new javax.swing.JComboBox<>();
        jButtonQuickSearch = new javax.swing.JButton();
        jButtonDeepSearch = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListResults = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanelResults = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuOptions = new javax.swing.JMenu();
        jMenuHelp = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Duplicate Image Finder");

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jProgressBar1);

        jButtonMoveFiles.setText("Move Files");
        jButtonMoveFiles.setFocusable(false);
        jButtonMoveFiles.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonMoveFiles.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonMoveFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMoveFilesActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonMoveFiles);

        jButtonDeleteFiles.setText("Delete Files");
        jButtonDeleteFiles.setFocusable(false);
        jButtonDeleteFiles.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDeleteFiles.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonDeleteFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteFilesActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonDeleteFiles);

        jTextFieldDirectory.setText("Select directory");

        jButtonSelectDirectory.setText("Select Dir");
        jButtonSelectDirectory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectDirectoryActionPerformed(evt);
            }
        });

        jCheckBoxSubfolders.setText("include subfolders");
        jCheckBoxSubfolders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSubfoldersActionPerformed(evt);
            }
        });

        jComboBoxFileFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxFileFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFileFilterActionPerformed(evt);
            }
        });

        jButtonQuickSearch.setText("Quick Search");
        jButtonQuickSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuickSearchActionPerformed(evt);
            }
        });

        jButtonDeepSearch.setText("Deep Search");
        jButtonDeepSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeepSearchActionPerformed(evt);
            }
        });

        jListResults.setToolTipText("");
        jListResults.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListResultsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListResults);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jScrollPane2.setDoubleBuffered(true);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jScrollPane2, org.jdesktop.beansbinding.ELProperty.create("${maximumSize}"), jPanelResults, org.jdesktop.beansbinding.BeanProperty.create("maximumSize"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanelResultsLayout = new javax.swing.GroupLayout(jPanelResults);
        jPanelResults.setLayout(jPanelResultsLayout);
        jPanelResultsLayout.setHorizontalGroup(
            jPanelResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelResultsLayout.setVerticalGroup(
            jPanelResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanelResults);

        jSplitPane1.setRightComponent(jScrollPane2);

        jMenuOptions.setText("Options");
        jMenuBar1.add(jMenuOptions);

        jMenuHelp.setText("Help");
        jMenuBar1.add(jMenuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBoxFileFilter, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldDirectory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSelectDirectory)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxSubfolders))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonQuickSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDeepSearch)))
                        .addGap(0, 49, Short.MAX_VALUE))
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSelectDirectory)
                    .addComponent(jCheckBoxSubfolders))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxFileFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonQuickSearch)
                    .addComponent(jButtonDeepSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxSubfoldersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSubfoldersActionPerformed
        appEngine.setVisitSubDir(jCheckBoxSubfolders.isSelected());
    }//GEN-LAST:event_jCheckBoxSubfoldersActionPerformed

    private void jComboBoxFileFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFileFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFileFilterActionPerformed

    private void jButtonQuickSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuickSearchActionPerformed
        appEngine.quickSearchDirectory();
        
    }//GEN-LAST:event_jButtonQuickSearchActionPerformed

    private void jButtonSelectDirectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectDirectoryActionPerformed
        BaseDirectory = getBaseDirectory();
        jTextFieldDirectory.setText(BaseDirectory);
        appEngine.setBaseDir(BaseDirectory);
    }//GEN-LAST:event_jButtonSelectDirectoryActionPerformed

    private void jListResultsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListResultsValueChanged
        //TODO: pull ImgProcess object out of method to allow interruption of worker thread
        if(!jListResults.getValueIsAdjusting()){
            jPanelResults.removeAll();
            List<String> values = jListResults.getSelectedValuesList();
            ImgProcess ImgProcessBW = new ImgProcess(values);
            ImgProcessBW.execute();
        }
    }//GEN-LAST:event_jListResultsValueChanged

    private void jButtonDeepSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeepSearchActionPerformed
        appEngine.deepSearchDirectory();
    }//GEN-LAST:event_jButtonDeepSearchActionPerformed

    private void jButtonMoveFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMoveFilesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMoveFilesActionPerformed

    private void jButtonDeleteFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteFilesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteFilesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainWindow().setVisible(true);
        });
    }
    
    public String getBaseDirectory(){
        String result = "";
        JFileChooser Dialog = new JFileChooser();
        Dialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal;
        returnVal = Dialog.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                result = Dialog.getSelectedFile().getCanonicalPath();
            }
            catch (IOException e){
                System.err.print(e);
                System.exit(1);
            }
        }
        return result;
    }
    
    public void DisplayResult(Collection<ArrayList<String>> fileNames){
        DefaultListModel<String> resultsListModel = new DefaultListModel<>();
        for (ArrayList<String> fileSet : fileNames){
            if(fileSet.size() == 1) continue;
            for (String name : fileSet){
                resultsListModel.addElement(name);
            }
        }
        jListResults.setModel(resultsListModel);
        jListResults.revalidate();
        jListResults.repaint();
    }
    
    void DisplayResult(ArrayList<String> ALFilesResults) {
        DefaultListModel<String> resultsListModel = new DefaultListModel<>();
        for (String files : ALFilesResults){
            resultsListModel.addElement(files);            
        }
        jListResults.setModel(resultsListModel);
        jListResults.revalidate();
        jListResults.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeepSearch;
    private javax.swing.JButton jButtonDeleteFiles;
    private javax.swing.JButton jButtonMoveFiles;
    private javax.swing.JButton jButtonQuickSearch;
    private javax.swing.JButton jButtonSelectDirectory;
    private javax.swing.JCheckBox jCheckBoxSubfolders;
    private javax.swing.JComboBox<String> jComboBoxFileFilter;
    private javax.swing.JList<String> jListResults;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenu jMenuOptions;
    private javax.swing.JPanel jPanelResults;
    protected javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jTextFieldDirectory;
    private javax.swing.JToolBar jToolBar1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
