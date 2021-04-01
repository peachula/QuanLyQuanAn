/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author kieef
 */
public class frmReport extends javax.swing.JFrame {

    /**
     * Creates new form frmCategory
     */
    
    frmReport_DishSold frmDishSold;
    frmReport_Income frmIncome;
    
    public frmReport() {
        initComponents();
        setSize(794,612);
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnCustomer = new javax.swing.JButton();
        btnImcome = new javax.swing.JButton();
        btnDishSold = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setSize(new java.awt.Dimension(100, 100));

        jPanel1.setBackground(new java.awt.Color(207, 244, 210));
        jPanel1.setPreferredSize(new java.awt.Dimension(809, 612));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(207, 244, 210));

        btnMenu.setBackground(new java.awt.Color(32, 80, 114));
        btnMenu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("MENU");
        btnMenu.setBorderPainted(false);
        btnMenu.setMaximumSize(new java.awt.Dimension(75, 60));
        btnMenu.setMinimumSize(new java.awt.Dimension(75, 60));
        btnMenu.setPreferredSize(new java.awt.Dimension(75, 60));
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel2.add(btnMenu);

        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setBackground(new java.awt.Color(207, 244, 210));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnCustomer.setBackground(new java.awt.Color(32, 80, 114));
        btnCustomer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnCustomer.setText("CUSTOMER");
        btnCustomer.setBorderPainted(false);
        btnCustomer.setMaximumSize(new java.awt.Dimension(75, 60));
        btnCustomer.setMinimumSize(new java.awt.Dimension(75, 60));
        btnCustomer.setPreferredSize(new java.awt.Dimension(100, 60));
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });
        jPanel3.add(btnCustomer);

        btnImcome.setBackground(new java.awt.Color(32, 80, 114));
        btnImcome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnImcome.setForeground(new java.awt.Color(255, 255, 255));
        btnImcome.setText("INCOME");
        btnImcome.setBorderPainted(false);
        btnImcome.setMaximumSize(new java.awt.Dimension(75, 60));
        btnImcome.setMinimumSize(new java.awt.Dimension(75, 60));
        btnImcome.setPreferredSize(new java.awt.Dimension(100, 60));
        btnImcome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImcomeActionPerformed(evt);
            }
        });
        jPanel3.add(btnImcome);

        btnDishSold.setBackground(new java.awt.Color(32, 80, 114));
        btnDishSold.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDishSold.setForeground(new java.awt.Color(255, 255, 255));
        btnDishSold.setText("DISH SOLD");
        btnDishSold.setBorderPainted(false);
        btnDishSold.setMaximumSize(new java.awt.Dimension(75, 60));
        btnDishSold.setMinimumSize(new java.awt.Dimension(75, 60));
        btnDishSold.setPreferredSize(new java.awt.Dimension(100, 60));
        btnDishSold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDishSoldActionPerformed(evt);
            }
        });
        jPanel3.add(btnDishSold);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jDesktopPane1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new frmMenu().setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        // TODO add your handling code here:
        for (JInternalFrame frmChild : jDesktopPane1.getAllFrames()) {
            frmChild.dispose();
        }
        
        if(frmDishSold == null || frmDishSold.isClosed())
        {
            try {
                frmDishSold = new frmReport_DishSold();
            } catch (SQLException ex) {
                Logger.getLogger(frmReport.class.getName()).log(Level.SEVERE, null, ex);
            }
            jDesktopPane1.add(frmDishSold);
            frmDishSold.setSize(this.getWidth(),this.getHeight());
            frmDishSold.setLocation(0,0);
            frmDishSold.setVisible(true);
            }
            else
            {
            
                frmDishSold.setSize(this.getWidth(),this.getHeight());
                frmDishSold.setLocation(0,0);
                frmDishSold.setVisible(true);
        }
    }//GEN-LAST:event_btnCustomerActionPerformed

    private void btnImcomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImcomeActionPerformed
        // TODO add your handling code here:
        for (JInternalFrame frmChild : jDesktopPane1.getAllFrames()) {
            frmChild.dispose();
        }
        
        if(frmIncome == null || frmIncome.isClosed())
        {
            try {
                frmIncome = new frmReport_Income();
            } catch (SQLException ex) {
                Logger.getLogger(frmReport.class.getName()).log(Level.SEVERE, null, ex);
            }
            jDesktopPane1.add(frmIncome);
            frmIncome.setSize(this.getWidth(),this.getHeight());
            frmIncome.setLocation(0,0);
            frmIncome.setVisible(true);
            }
            else
            {
            
                frmIncome.setSize(this.getWidth(),this.getHeight());
                frmIncome.setLocation(0,0);
                frmIncome.setVisible(true);
        }
    }//GEN-LAST:event_btnImcomeActionPerformed

    private void btnDishSoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDishSoldActionPerformed
        // TODO add your handling code here:
        for (JInternalFrame frmChild : jDesktopPane1.getAllFrames()) {
            frmChild.dispose();
        }
        
        if(frmDishSold == null || frmDishSold.isClosed())
        {
            try {
                frmDishSold = new frmReport_DishSold();
            } catch (SQLException ex) {
                Logger.getLogger(frmReport.class.getName()).log(Level.SEVERE, null, ex);
            }
            jDesktopPane1.add(frmDishSold);
            frmDishSold.setSize(this.getWidth(),this.getHeight());
            frmDishSold.setLocation(0,0);
            frmDishSold.setVisible(true);
            }
            else
            {
            
                frmDishSold.setSize(this.getWidth(),this.getHeight());
                frmDishSold.setLocation(0,0);
                frmDishSold.setVisible(true);
        }
    }//GEN-LAST:event_btnDishSoldActionPerformed

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
            java.util.logging.Logger.getLogger(frmReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnDishSold;
    private javax.swing.JButton btnImcome;
    private javax.swing.JButton btnMenu;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}