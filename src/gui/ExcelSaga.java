package gui;

import excelsaga.ExcelSagaTableModel;
import static excelsaga.ExcelSagaTableModel.COLS;
import static excelsaga.ExcelSagaTableModel.ROWS;
import excelsaga.ExcelSagaTableModelListener;
import excelsaga.Facade;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author hdlucas
 */
public class ExcelSaga extends javax.swing.JFrame {

    private JFrame frame = new JFrame("ExcelSaga");
    public static ExcelSagaTableModel excelSagaTableModel;
    ExcelSagaTableModelListener excelSagaTableModelListener;
    /**
     * Creates new form ExcelSaga
     */
    public ExcelSaga() {
        initComponents();
        //inicializate excelTable
        excelSagaTableModel = new ExcelSagaTableModel(ROWS, COLS, excelTable, jScrollExcelTable);
        excelTable.setModel(excelSagaTableModel);
        
        //excelSagaTableModelListener=new ExcelSagaTableModelListener(excelTable);
        //excelTable.getModel().addTableModelListener(excelSagaTableModelListener);
        
        // get the screen size as a java dimension
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int height = screenSize.height * 2 / 3;
        int width = screenSize.width * 2 / 3;

        frame.getContentPane().add(panelExcel);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //menu 
        frame.setJMenuBar(jMenuBar);
        jMenuBar.setVisible(true);

//        int index = 0;
//        while (index < COLS) {
//            TableColumn a = excelTable.getColumnModel().getColumn(index);
//            Dimension d = excelTable.getPreferredSize();
//            d.width = d.width + 180;
//            excelTable.setPreferredSize(d);
//            jScrollExcelTable.setPreferredSize(d);
//            index += 1;
//        }
        jScrollExcelTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollExcelTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //logged user
        jLabelLoggedInUser.setText("User: " + Facade.getUserLoggedIn().getName());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelExcel = new javax.swing.JPanel();
        jToggleButtonFunctionallMode = new javax.swing.JToggleButton();
        jButtonStepForward = new javax.swing.JButton();
        jToggleButtonNormalMode = new javax.swing.JToggleButton();
        jLabelViewMode = new javax.swing.JLabel();
        jButtonStepBack = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollExcelTable = new javax.swing.JScrollPane();
        excelTable = new javax.swing.JTable();
        jButtonRecord = new javax.swing.JButton();
        jButtonPlay = new javax.swing.JButton();
        jLabelLoggedInUser = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemNew = new javax.swing.JMenuItem();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemExport = new javax.swing.JMenuItem();
        jMenuItemImport = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToggleButtonFunctionallMode.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jToggleButtonFunctionallMode.setText("Functional");

        jButtonStepForward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/step_forward .png"))); // NOI18N
        jButtonStepForward.setBorderPainted(false);
        jButtonStepForward.setContentAreaFilled(false);
        jButtonStepForward.setFocusPainted(false);
        jButtonStepForward.setOpaque(true);
        jButtonStepForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStepForwardActionPerformed(evt);
            }
        });

        jToggleButtonNormalMode.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jToggleButtonNormalMode.setSelected(true);
        jToggleButtonNormalMode.setText("Normal");

        jLabelViewMode.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabelViewMode.setText("View Mode");

        jButtonStepBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/step_back.png"))); // NOI18N
        jButtonStepBack.setBorderPainted(false);
        jButtonStepBack.setContentAreaFilled(false);
        jButtonStepBack.setFocusPainted(false);
        jButtonStepBack.setOpaque(true);
        jButtonStepBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStepBackActionPerformed(evt);
            }
        });

        jScrollExcelTable.setPreferredSize(new java.awt.Dimension(452, 700));

        excelTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        excelTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        excelTable.setAutoscrolls(false);
        excelTable.setCellSelectionEnabled(true);
        excelTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        excelTable.setMinimumSize(new java.awt.Dimension(100, 220));
        excelTable.setRowHeight(40);
        excelTable.setSelectionBackground(new java.awt.Color(76, 163, 97));
        jScrollExcelTable.setViewportView(excelTable);

        jButtonRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/record_macro.png"))); // NOI18N
        jButtonRecord.setBorderPainted(false);
        jButtonRecord.setContentAreaFilled(false);
        jButtonRecord.setFocusPainted(false);
        jButtonRecord.setOpaque(true);
        jButtonRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecordActionPerformed(evt);
            }
        });

        jButtonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play_macro.png"))); // NOI18N
        jButtonPlay.setBorderPainted(false);
        jButtonPlay.setContentAreaFilled(false);
        jButtonPlay.setFocusPainted(false);
        jButtonPlay.setOpaque(true);
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });

        jLabelLoggedInUser.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabelLoggedInUser.setText("Logged User");

        javax.swing.GroupLayout panelExcelLayout = new javax.swing.GroupLayout(panelExcel);
        panelExcel.setLayout(panelExcelLayout);
        panelExcelLayout.setHorizontalGroup(
            panelExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelExcelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelExcelLayout.createSequentialGroup()
                        .addGroup(panelExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollExcelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelExcelLayout.createSequentialGroup()
                                .addComponent(jLabelViewMode, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(panelExcelLayout.createSequentialGroup()
                        .addComponent(jToggleButtonFunctionallMode)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButtonNormalMode)
                        .addGap(4, 4, 4)
                        .addComponent(jButtonStepBack, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonStepForward, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 478, Short.MAX_VALUE)
                        .addComponent(jLabelLoggedInUser)
                        .addGap(40, 40, 40))))
        );
        panelExcelLayout.setVerticalGroup(
            panelExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelExcelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabelViewMode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelExcelLayout.createSequentialGroup()
                        .addGroup(panelExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonStepBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelExcelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jToggleButtonFunctionallMode)
                                .addComponent(jToggleButtonNormalMode))
                            .addComponent(jButtonStepForward, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLoggedInUser))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollExcelTable, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuFile.setText("File");
        jMenuFile.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jMenuItemNew.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItemNew.setText("New");
        jMenuItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNewActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemNew);

        jMenuItemOpen.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItemOpen.setText("Open");
        jMenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpen);

        jMenuItemSave.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItemSave.setText("Save");
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSave);

        jMenuItemExport.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItemExport.setText("Export");
        jMenuItemExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemExport);

        jMenuItemImport.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItemImport.setText("Import");
        jMenuItemImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImportActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemImport);

        jMenuItemExit.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemExit);

        jMenuBar.add(jMenuFile);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panelExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStepBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStepBackActionPerformed
        Facade.undo();
    }//GEN-LAST:event_jButtonStepBackActionPerformed

    private void jButtonStepForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStepForwardActionPerformed
        Facade.redo();
    }//GEN-LAST:event_jButtonStepForwardActionPerformed

    private void jButtonRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecordActionPerformed
        JOptionPane.showMessageDialog(null, "Record");
    }//GEN-LAST:event_jButtonRecordActionPerformed

    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed
        JOptionPane.showMessageDialog(null, "Play");
    }//GEN-LAST:event_jButtonPlayActionPerformed

    private void jMenuItemImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImportActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("CSV", "csv"));
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setSelectedFile(new File(""));
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        if (chooser.showOpenDialog(frame) == JFileChooser.OPEN_DIALOG) {
            //do when open
        } else {
            // do when cancel
        }

        File selectedFile = chooser.getSelectedFile();
        if (selectedFile != null) {
            String fileName = selectedFile.getName();
            Facade.importFile(selectedFile, fileName.substring(fileName.lastIndexOf(".") + 1, selectedFile.getName().length()));
        }
    }//GEN-LAST:event_jMenuItemImportActionPerformed

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jMenuItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNewActionPerformed
        excelSagaTableModel = new ExcelSagaTableModel(ROWS, COLS, excelTable, jScrollExcelTable);
        excelTable.setModel(excelSagaTableModel);

    }//GEN-LAST:event_jMenuItemNewActionPerformed
    private void jMenuItemExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportActionPerformed
        //CREATE FILE CHOOSER
        JFileChooser fileChooser = new JFileChooser();

        //CREATE FILTER TO CSV FILE
        FileFilter filter = new FileNameExtensionFilter("CSV", "csv");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);

        //CREATE FILTER TO HTML FILE
        filter = new FileNameExtensionFilter("HTML", "html");
        fileChooser.addChoosableFileFilter(filter);

        //CREATE FILTER TO TXT FILE
        filter = new FileNameExtensionFilter("TXT", "txt");
        fileChooser.addChoosableFileFilter(filter);

        //SHOW DIALOG WINDOWS
        fileChooser.showSaveDialog(this);

        //CREATE OBJECT WITH SELECTED FILE
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            FileFilter selectedFileFilter = fileChooser.getFileFilter();
            String fileType = selectedFileFilter.getDescription().toLowerCase();

            file = new File(file.getAbsolutePath() + "." + fileType);

            try {
                Facade.exportFile(fileType, file);
            } catch (Exception ex) {
                Logger.getLogger(ExcelSaga.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItemExportActionPerformed

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        //CREATE FILE CHOOSER
        JFileChooser fileChooser = new JFileChooser();

        //CREATE FILTER TO CSV FILE
        FileFilter filter = new FileNameExtensionFilter("excelSaga", "dat");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);

        //SHOW DIALOG WINDOWS
        fileChooser.showSaveDialog(this);

        //CREATE OBJECT WITH SELECTED FILE
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            FileFilter selectedFileFilter = fileChooser.getFileFilter();
            String fileType = selectedFileFilter.getDescription().toLowerCase();

            file = new File(file.getAbsolutePath() + "." + fileType);

            try {
                Facade.exportFile(fileType, file);
            } catch (Exception ex) {
                Logger.getLogger(ExcelSaga.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("excelSaga", "excelSaga"));
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setSelectedFile(new File(""));
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        if (chooser.showOpenDialog(frame) == JFileChooser.OPEN_DIALOG) {
            //do when open
        } else {
            // do when cancel
        }
        File selectedFile = chooser.getSelectedFile();
        if (selectedFile != null) {
            String fileName = selectedFile.getName();
            Facade.importFile(selectedFile, fileName.substring(fileName.lastIndexOf(".") + 1, selectedFile.getName().length()));
        }
    }//GEN-LAST:event_jMenuItemOpenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable excelTable;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JButton jButtonRecord;
    private javax.swing.JButton jButtonStepBack;
    private javax.swing.JButton jButtonStepForward;
    private javax.swing.JLabel jLabelLoggedInUser;
    private javax.swing.JLabel jLabelViewMode;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemExport;
    private javax.swing.JMenuItem jMenuItemImport;
    private javax.swing.JMenuItem jMenuItemNew;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JScrollPane jScrollExcelTable;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButtonFunctionallMode;
    private javax.swing.JToggleButton jToggleButtonNormalMode;
    private javax.swing.JPanel panelExcel;
    // End of variables declaration//GEN-END:variables
}
