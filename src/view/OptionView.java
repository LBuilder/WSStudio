/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainViewController;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author s124392
 */
public class OptionView extends View {

    /**
     * Creates new form OptionView
     */
    public OptionView(MainViewController c) {
        super(c);
        initComponents();
        centerize();
    }
    
    public void clear() {
        buttonNameField.setText("");
        delayField.setText("");
        hideTimerRadioButton.setSelected(false);
        showValueRadioButton.setSelected(true);
        isFieldRadioButton.setSelected(false);
        setFieldField.setText("");
        dxLabel.setText("0.0");
        dyLabel.setText("0.0");
        dxSlider.setValue(0);
        dySlider.setValue(0);
        referenceList.setModel(new DefaultListModel());
        hideTimerRadioButton.setEnabled(true);
        showValueRadioButton.setEnabled(true);
        addButton.setEnabled(true);
        editButton.setEnabled(false);
        removeButton.setEnabled(false);
    }
    
    public void toggleAddButton(boolean enabled) {
        addButton.setEnabled(enabled);
    }
    
    //<editor-fold defaultstate="collapsed" desc="GUI Value Getters">
    public String getButtonName() {
        return buttonNameField.getText();
    }
    
    public String getDelay() {
        return delayField.getText();
    }
    
    public boolean hideTimer() {
        return hideTimerRadioButton.isSelected();
    }
    
    public boolean showValue() {
        return showValueRadioButton.isSelected();
    }
    
    public boolean isField() {
        return isFieldRadioButton.isSelected();
    }
    
    public String getSetField() {
        return setFieldField.getText();
    }
    
    public double getPivotX() {
        return (dxSlider.getValue() / 100.0);
    }
    
    public double getPivotY() {
        return (dySlider.getValue() / 100.0);
    }
    
    public ListModel getReferenceListModel() {
        return referenceList.getModel();
    }
    
    public int[] getRefIndices() {
        return referenceList.getSelectedIndices();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GUI Value Setters">
    public void setButtonName(String name) {
        buttonNameField.setText(name);
    }
    
    public void setDelay(String delay) {
        delayField.setText(delay);
    }
    
    public void setHideDelay(boolean hide) {
        hideTimerRadioButton.setSelected(hide);
    }
    
    public void setShowValue(boolean show) {
        showValueRadioButton.setSelected(show);
    }
    
    public void setIsField(boolean isField) {
        isFieldRadioButton.setSelected(isField);
    }
    
    public void setSetField(String field) {
        setFieldField.setText(field);
    }
    
    public void setPivotX(double x) {
        dxLabel.setText(String.valueOf(x));
        dxSlider.setValue((int) (x * 100));
    }
    
    public void setPivotY(double y) {
        dyLabel.setText(String.valueOf(y));
        dySlider.setValue((int) (y * 100));
    }
    
    public void setReferenceListModel(ListModel model) {
        referenceList.setModel(model);
        addButton.setEnabled(model.getSize() > 0);
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        delayField = new javax.swing.JTextField();
        buttonNameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        hideTimerRadioButton = new javax.swing.JRadioButton();
        showValueRadioButton = new javax.swing.JRadioButton();
        settingsPanel = new javax.swing.JPanel();
        isFieldRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        setFieldField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dxLabel = new javax.swing.JLabel();
        dxSlider = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        dyLabel = new javax.swing.JLabel();
        dySlider = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        referenceList = new javax.swing.JList();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        displayPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Display"));

        jLabel2.setText("Timer Delay");

        delayField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                delayFieldKeyReleased(evt);
            }
        });

        buttonNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buttonNameFieldKeyReleased(evt);
            }
        });

        jLabel1.setText("Button Name");

        hideTimerRadioButton.setText("Hide Timer");
        hideTimerRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hideTimerRadioButtonStateChanged(evt);
            }
        });

        showValueRadioButton.setSelected(true);
        showValueRadioButton.setText("Show Timer Value");
        showValueRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                showValueRadioButtonStateChanged(evt);
            }
        });

        javax.swing.GroupLayout displayPanelLayout = new javax.swing.GroupLayout(displayPanel);
        displayPanel.setLayout(displayPanelLayout);
        displayPanelLayout.setHorizontalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(displayPanelLayout.createSequentialGroup()
                        .addComponent(delayField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showValueRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hideTimerRadioButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        displayPanelLayout.setVerticalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(8, 8, 8)
                .addGroup(displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showValueRadioButton)
                    .addComponent(hideTimerRadioButton))
                .addContainerGap())
        );

        settingsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Settings"));

        isFieldRadioButton.setText("Proceed by Distribution Field");
        isFieldRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                isFieldRadioButtonStateChanged(evt);
            }
        });

        jLabel3.setText("Set Distribution Field");

        setFieldField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                setFieldFieldKeyReleased(evt);
            }
        });

        jLabel4.setText("Pivot-x Displacement:");

        dxLabel.setText("0.0");

        dxSlider.setMinimum(-100);
        dxSlider.setValue(0);
        dxSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dxSliderStateChanged(evt);
            }
        });

        jLabel5.setText("Pivot-y Displacement:");

        dyLabel.setText("0.0");

        dySlider.setMinimum(-100);
        dySlider.setValue(0);
        dySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                dySliderStateChanged(evt);
            }
        });

        jLabel6.setText("Reference List");

        referenceList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                referenceListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(referenceList);

        addButton.setText("Add");
        addButton.setEnabled(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(isFieldRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(setFieldField)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dxLabel))
                    .addComponent(dxSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dyLabel))
                    .addComponent(dySlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(addButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(settingsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(isFieldRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(setFieldField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(dxLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dxSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(dyLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addButton)
                        .addComponent(editButton)
                        .addComponent(removeButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(settingsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(displayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Generated Event Methods">
    private void buttonNameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonNameFieldKeyReleased
        String text = buttonNameField.getText();
        boolean hasContent = text.length() > 0;
        if (hasContent) {
            delayField.setText("0");
        }
        delayField.setEnabled(!hasContent);
        hideTimerRadioButton.setEnabled(!hasContent);
        showValueRadioButton.setEnabled(!hasContent);
    }//GEN-LAST:event_buttonNameFieldKeyReleased

    private void delayFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_delayFieldKeyReleased
        String text = delayField.getText();
        boolean hasContent = text.length() > 0;
        if (hasContent) {
            buttonNameField.setText("");
        }
        buttonNameField.setEnabled(!hasContent);
        hideTimerRadioButton.setEnabled(hasContent);
        showValueRadioButton.setEnabled(hasContent);
    }//GEN-LAST:event_delayFieldKeyReleased

    private void hideTimerRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hideTimerRadioButtonStateChanged
        boolean state = hideTimerRadioButton.isSelected();
        if (state) {
            showValueRadioButton.setSelected(false);
        }
        showValueRadioButton.setEnabled(!state);
    }//GEN-LAST:event_hideTimerRadioButtonStateChanged

    private void showValueRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_showValueRadioButtonStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_showValueRadioButtonStateChanged

    private void isFieldRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_isFieldRadioButtonStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_isFieldRadioButtonStateChanged

    private void setFieldFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_setFieldFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_setFieldFieldKeyReleased

    private void dxSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dxSliderStateChanged
        int value = dxSlider.getValue();
        dxLabel.setText(String.valueOf((double) value / 100.0));
    }//GEN-LAST:event_dxSliderStateChanged

    private void dySliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_dySliderStateChanged
        int value = dxSlider.getValue();
        dyLabel.setText(String.valueOf((double) value / 100.0));
    }//GEN-LAST:event_dySliderStateChanged

    private void referenceListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_referenceListValueChanged
        int listSize = referenceList.getModel().getSize();
        int selectionSize = referenceList.getSelectedIndices().length;
        addButton.setEnabled(listSize > 0);
        editButton.setEnabled(selectionSize == 1);
        removeButton.setEnabled(listSize > 1 && selectionSize > 0
                && (listSize - selectionSize) > 0);
    }//GEN-LAST:event_referenceListValueChanged

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        controller.newReference();
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        controller.viewRef();
    }//GEN-LAST:event_editButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        controller.deleteReference();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        controller.saveOption();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        controller.cancelOption();
    }//GEN-LAST:event_cancelButtonActionPerformed
    //</editor-fold>
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
            java.util.logging.Logger.getLogger(OptionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField buttonNameField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField delayField;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JLabel dxLabel;
    private javax.swing.JSlider dxSlider;
    private javax.swing.JLabel dyLabel;
    private javax.swing.JSlider dySlider;
    private javax.swing.JButton editButton;
    private javax.swing.JRadioButton hideTimerRadioButton;
    private javax.swing.JRadioButton isFieldRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList referenceList;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField setFieldField;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JRadioButton showValueRadioButton;
    // End of variables declaration//GEN-END:variables
}
