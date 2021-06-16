
package com.vellu.journaling101;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {
    private DataOperations db;
   
    public MainFrame() {
        initDate();
        initComponents();
        db = new DataOperations();
        db.showNotesData(journalDataTb);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebarRight = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        journalDataTb = new javax.swing.JTable();
        header = new javax.swing.JPanel();
        menuIconLabel = new javax.swing.JLabel();
        headerTitleLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        editNotePane = new javax.swing.JPanel();
        dateLabel = new javax.swing.JLabel();
        dateTxt = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        titleTxt = new javax.swing.JTextField();
        moodLabel = new javax.swing.JLabel();
        moodTxt = new javax.swing.JTextField();
        activityLabel = new javax.swing.JLabel();
        activityTxt = new javax.swing.JTextField();
        healthLabel = new javax.swing.JLabel();
        healthTxt = new javax.swing.JTextField();
        dayLabel = new javax.swing.JLabel();
        dayTxt = new javax.swing.JTextField();
        notesLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        noteTxt = new javax.swing.JTextArea();
        saveNoteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        sidebarLeft = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(850, 700));

        sidebarRight.setBackground(new java.awt.Color(153, 102, 255));
        sidebarRight.setPreferredSize(new java.awt.Dimension(400, 460));
        sidebarRight.setLayout(new java.awt.BorderLayout());

        journalDataTb.setForeground(new java.awt.Color(51, 51, 51));
        journalDataTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "date", "day", "title", "note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        journalDataTb.setSelectionBackground(new java.awt.Color(51, 0, 51));
        jScrollPane2.setViewportView(journalDataTb);
        if (journalDataTb.getColumnModel().getColumnCount() > 0) {
            journalDataTb.getColumnModel().getColumn(0).setPreferredWidth(45);
            journalDataTb.getColumnModel().getColumn(1).setPreferredWidth(16);
        }

        sidebarRight.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(sidebarRight, java.awt.BorderLayout.LINE_END);

        header.setBackground(new java.awt.Color(204, 0, 204));
        header.setPreferredSize(new java.awt.Dimension(732, 40));

        menuIconLabel.setPreferredSize(new java.awt.Dimension(40, 40));
        menuIconLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuIconLabelMouseClicked(evt);
            }
        });

        headerTitleLabel.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        headerTitleLabel.setForeground(new java.awt.Color(255, 255, 102));
        headerTitleLabel.setText("Write your journal");

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(headerTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addComponent(editButton)
                .addGap(37, 37, 37)
                .addComponent(deleteButton)
                .addGap(37, 37, 37)
                .addComponent(menuIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(menuIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(headerTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(editButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        editNotePane.setBackground(new java.awt.Color(102, 0, 102));
        editNotePane.setPreferredSize(new java.awt.Dimension(360, 460));

        dateLabel.setForeground(new java.awt.Color(153, 153, 153));
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dateLabel.setText("Date");

        dateTxt.setBackground(new java.awt.Color(85, 94, 96));
        dateTxt.setForeground(new java.awt.Color(255, 255, 255));
        dateTxt.setText(initDate());
        dateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTxtActionPerformed(evt);
            }
        });

        titleLabel.setForeground(new java.awt.Color(153, 153, 153));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        titleLabel.setText("Title");
        titleLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        titleTxt.setBackground(new java.awt.Color(85, 94, 96));
        titleTxt.setForeground(new java.awt.Color(255, 255, 255));
        titleTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleTxtActionPerformed(evt);
            }
        });

        moodLabel.setForeground(new java.awt.Color(153, 153, 153));
        moodLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        moodLabel.setText("Mood");

        moodTxt.setBackground(new java.awt.Color(85, 94, 96));
        moodTxt.setForeground(new java.awt.Color(255, 255, 255));
        moodTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moodTxtActionPerformed(evt);
            }
        });

        activityLabel.setForeground(new java.awt.Color(153, 153, 153));
        activityLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        activityLabel.setText("Activities");

        activityTxt.setBackground(new java.awt.Color(85, 94, 96));
        activityTxt.setForeground(new java.awt.Color(255, 255, 255));

        healthLabel.setForeground(new java.awt.Color(153, 153, 153));
        healthLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        healthLabel.setText("Health");

        healthTxt.setBackground(new java.awt.Color(85, 94, 96));
        healthTxt.setForeground(new java.awt.Color(255, 255, 255));

        dayLabel.setForeground(new java.awt.Color(153, 153, 153));
        dayLabel.setText("Day");

        dayTxt.setBackground(new java.awt.Color(85, 94, 96));
        dayTxt.setForeground(new java.awt.Color(255, 255, 255));
        dayTxt.setText("1");

        notesLabel.setForeground(new java.awt.Color(153, 153, 153));
        notesLabel.setText("Notes");

        noteTxt.setBackground(new java.awt.Color(85, 94, 96));
        noteTxt.setColumns(20);
        noteTxt.setForeground(new java.awt.Color(255, 255, 255));
        noteTxt.setLineWrap(true);
        noteTxt.setRows(5);
        noteTxt.setWrapStyleWord(true);
        jScrollPane1.setViewportView(noteTxt);

        saveNoteButton.setText("Save");
        saveNoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveNoteButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editNotePaneLayout = new javax.swing.GroupLayout(editNotePane);
        editNotePane.setLayout(editNotePaneLayout);
        editNotePaneLayout.setHorizontalGroup(
            editNotePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editNotePaneLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(editNotePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editNotePaneLayout.createSequentialGroup()
                        .addComponent(clearButton)
                        .addGap(49, 49, 49)
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveNoteButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editNotePaneLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(dayLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editNotePaneLayout.createSequentialGroup()
                        .addGroup(editNotePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(activityLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(moodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthLabel)
                            .addComponent(notesLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(editNotePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(activityTxt)
                            .addComponent(moodTxt)
                            .addComponent(healthTxt, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editNotePaneLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(titleTxt))
                    .addComponent(jScrollPane1))
                .addGap(19, 19, 19))
        );
        editNotePaneLayout.setVerticalGroup(
            editNotePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editNotePaneLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(editNotePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateTxt)
                    .addComponent(dayLabel)
                    .addComponent(dayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editNotePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titleTxt)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editNotePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moodTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(editNotePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(activityTxt)
                    .addComponent(activityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editNotePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(healthTxt)
                    .addComponent(healthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(notesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editNotePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveNoteButton)
                    .addComponent(clearButton)
                    .addComponent(refreshButton))
                .addGap(10, 10, 10))
        );

        getContentPane().add(editNotePane, java.awt.BorderLayout.CENTER);

        sidebarLeft.setBackground(new java.awt.Color(204, 0, 204));
        sidebarLeft.setPreferredSize(new java.awt.Dimension(40, 460));
        sidebarLeft.setLayout(new java.awt.GridBagLayout());
        getContentPane().add(sidebarLeft, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void moodTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moodTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moodTxtActionPerformed

    private void menuIconLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuIconLabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuIconLabelMouseClicked

    private void dateTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTxtActionPerformed

    private void titleTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleTxtActionPerformed
    }//GEN-LAST:event_titleTxtActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearForm();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void saveNoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveNoteButtonActionPerformed
        
        DefaultTableModel model = (DefaultTableModel) journalDataTb.getModel();
        DataOperations addData = new DataOperations();
        int index = journalDataTb.getSelectedRow();
        String dateStr = dateTxt.getText();
        String dayStr = dayTxt.getText();
        String titleStr = titleTxt.getText();
        String moodStr = moodTxt.getText();
        String activityStr = activityTxt.getText();
        String healthStr = healthTxt.getText();
        String noteStr = noteTxt.getText();
        
// data and title are compulsory items
        if (titleStr.equals("") || dateStr.equals("")) {
            JOptionPane.showMessageDialog(editNotePane.getParent(),
                    "Please enter title and date correctly.",
                    "Title or date missing",
                    JOptionPane.WARNING_MESSAGE);
            titleTxt.grabFocus();
        } else {
// Check if there is already same date in JTable
            int row = getRowByValue(model, dateStr);
            if(row >= 0) {
                int input = JOptionPane.
                        showConfirmDialog(editNotePane.getParent(), 
                                "Overwrite note from " + dateStr +"?",
                                JOptionPane.OPTIONS_PROPERTY, 
                                JOptionPane.OK_CANCEL_OPTION);
                        if (input == 0) {
                            index = row;
                            addData = new DataOperations();
                            addData.updateRow(dateStr, dayStr, titleStr, moodStr, activityStr, healthStr, noteStr, index, journalDataTb);
                            refreshTable();
                        } 
            }
            else {
                addData.addNewNote(dateStr, dayStr, titleStr, moodStr, activityStr, healthStr, noteStr, journalDataTb);
            }
        }
    }//GEN-LAST:event_saveNoteButtonActionPerformed

    int getRowByValue(DefaultTableModel m, Object value) {
        int row = -4;
    for (int i = m.getRowCount() - 1; i >= 0; --i) {
            if (m.getValueAt(i, 0).equals(value)) {
                row = i;
            }
        }
    return row;
 }
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        db = new DataOperations();
        int input = JOptionPane.showConfirmDialog(null, "Delete this row?", JOptionPane.OPTIONS_PROPERTY, JOptionPane.OK_CANCEL_OPTION);
        if (input == 0 ) {
            int index = journalDataTb.getSelectedRow();
            db.removeRow(journalDataTb, index);
        }    }//GEN-LAST:event_deleteButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        editNotes();
    }//GEN-LAST:event_editButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        refreshTable();
    }//GEN-LAST:event_refreshButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activityLabel;
    private javax.swing.JTextField activityTxt;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JTextField dayTxt;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JPanel editNotePane;
    private javax.swing.JPanel header;
    private javax.swing.JLabel headerTitleLabel;
    private javax.swing.JLabel healthLabel;
    private javax.swing.JTextField healthTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable journalDataTb;
    private javax.swing.JLabel menuIconLabel;
    private javax.swing.JLabel moodLabel;
    private javax.swing.JTextField moodTxt;
    private javax.swing.JTextArea noteTxt;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveNoteButton;
    private javax.swing.JPanel sidebarLeft;
    private javax.swing.JPanel sidebarRight;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleTxt;
    // End of variables declaration//GEN-END:variables

    private String initDate() {
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate localDate = LocalDate.now();
        String dateNow = localDate.format(formatDate);
        return dateNow;
    }
    
    private void editNotes() {
        int index = journalDataTb.getSelectedRow();
        dateTxt.setText(db.getItem(index, "date", journalDataTb));
        dayTxt.setText(db.getItem(index, "day", journalDataTb));
        titleTxt.setText(db.getItem(index, "title", journalDataTb));
        moodTxt.setText(db.getItem(index, "mood", journalDataTb));
        healthTxt.setText(db.getItem(index, "health", journalDataTb));
        activityTxt.setText(db.getItem(index, "activity", journalDataTb));
        noteTxt.setText(db.getItem(index, "note", journalDataTb));
    }

    private void clearForm() {
        dateTxt.setText(initDate());
        dayTxt.setText("");
        titleTxt.setText("");
        moodTxt.setText("");
        healthTxt.setText("");
        activityTxt.setText("");
        noteTxt.setText("");    }

    private void refreshTable() {
        clearTable((DefaultTableModel)journalDataTb.getModel());
        db = new DataOperations();
        db.showNotesData(journalDataTb);    }
    
    private void clearTable(DefaultTableModel model) {
        model.setRowCount(0);
    }
}
