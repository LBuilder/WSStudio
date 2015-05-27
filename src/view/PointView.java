/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainViewController;
import generated.ActivityT;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author s124392
 */
public class PointView extends View {

    /**
     * Creates new form PointView
     */
    public PointView(final MainViewController c) {
        super(c);
        initComponents();
        centerize();
    }
    
    public void setXValue(double value) {
        xValueLabel.setText(String.valueOf(value));
        xValueSlider.setValue((int)(value * 100));
    }
    
    public void setYValue(double value) {
        yValueLabel.setText(String.valueOf(value));
        yValueSlider.setValue((int)(value * 100));
    }
    
    public void populateActivityList(List<ActivityT> activities, String text) {
        DefaultListModel lm = new DefaultListModel();
        for (ActivityT activity : activities) {
            if (activity.getName().contains(text)) {
                lm.addElement(activity.getName());
            }
        }
        activitiesList.setModel(lm);
    }
    
    public void setReferenceList(ListModel lm) {
        referencesList.setModel(lm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        xValueLabel = new javax.swing.JLabel();
        yValueSlider = new javax.swing.JSlider();
        xValueSlider = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        yValueLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        activitiesList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        referencesList = new javax.swing.JList();
        toReferencesButton = new javax.swing.JButton();
        toActivitiesButton = new javax.swing.JButton();
        activitySearchField = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Edit ActivityPoint");

        jLabel1.setText("X-value:");

        xValueLabel.setText("0.0");

        yValueSlider.setMinimum(-100);
        yValueSlider.setValue(0);

        xValueSlider.setMinimum(-100);
        xValueSlider.setValue(0);
        xValueSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                xValueSliderStateChanged(evt);
            }
        });

        jLabel2.setText("X-value:");

        yValueLabel.setText("0.0");

        jLabel3.setText("All Activities");

        jLabel4.setText("Reference List");

        activitiesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                activitiesListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(activitiesList);

        referencesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                referencesListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(referencesList);

        toReferencesButton.setText(">>");
        toReferencesButton.setEnabled(false);

        toActivitiesButton.setText("<<");
        toActivitiesButton.setEnabled(false);
        toActivitiesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toActivitiesButtonActionPerformed(evt);
            }
        });

        activitySearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                activitySearchFieldKeyReleased(evt);
            }
        });

        jButton3.setText("Save");

        jButton4.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(xValueSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(activitySearchField)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toReferencesButton)
                            .addComponent(toActivitiesButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xValueLabel))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(yValueLabel))
                        .addComponent(jLabel4)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(yValueSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(xValueLabel)
                    .addComponent(jLabel2)
                    .addComponent(yValueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xValueSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yValueSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(activitySearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                                .addComponent(toReferencesButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(toActivitiesButton)
                                .addGap(134, 134, 134))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void xValueSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_xValueSliderStateChanged
        System.out.println("Hello");
    }//GEN-LAST:event_xValueSliderStateChanged

    private void toActivitiesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toActivitiesButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toActivitiesButtonActionPerformed

    private void activitySearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_activitySearchFieldKeyReleased
        //populateActivityList(activitySearchField.getText());
    }//GEN-LAST:event_activitySearchFieldKeyReleased

    private void activitiesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_activitiesListValueChanged
        toReferencesButton.setEnabled(
                activitiesList.getSelectedValuesList().size() > 0);
        referencesList.setSelectedIndices(null);
    }//GEN-LAST:event_activitiesListValueChanged

    private void referencesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_referencesListValueChanged
        toActivitiesButton.setEnabled(
                referencesList.getSelectedValuesList().size() > 0);
        activitiesList.setSelectedIndices(null);
    }//GEN-LAST:event_referencesListValueChanged

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
            java.util.logging.Logger.getLogger(PointView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PointView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PointView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PointView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList activitiesList;
    private javax.swing.JTextField activitySearchField;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList referencesList;
    private javax.swing.JButton toActivitiesButton;
    private javax.swing.JButton toReferencesButton;
    private javax.swing.JLabel xValueLabel;
    private javax.swing.JSlider xValueSlider;
    private javax.swing.JLabel yValueLabel;
    private javax.swing.JSlider yValueSlider;
    // End of variables declaration//GEN-END:variables
}
