/**
 * JVMailStress - Mail Server Stress Test Tool
 * The class illustrates how to write comments used 
 * to generate JavaDoc documentation
 *
 * @author Murat B.
 * @url https://github.com/muratti66/jvmailstress
 * @version 1.00, 28 May 2017
 */
package com.muratti66.jvstress.UI;

import static com.muratti66.jvstress.SystemOps.whatOS;
import java.io.File;
import javax.swing.UIManager;
/**
 * This class is file chooser ui
 */
public class FileChooserTwo extends javax.swing.JFrame {
    public static String selectedAttach = "Please Select";
    /**
     * Creates new form FileChoser
     */
    public FileChooserTwo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFolderChooser = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("E-Posta Body Klasörü Seçimi");
        setBounds(new java.awt.Rectangle(350, 250, 0, 0));

        jFolderChooser.setCurrentDirectory(new java.io.File("/"));
        jFolderChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        jFolderChooser.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jFolderChooser.setFocusCycleRoot(true);
        jFolderChooser.setFocusTraversalKeysEnabled(false);
        jFolderChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windowAction(evt);
            }
        });
        jFolderChooser.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                FileChooserTwo.this.vetoableChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFolderChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jFolderChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void windowAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_windowAction
        // TODO add your handling code here:
        
            if (evt.getActionCommand().equals(
                    javax.swing.JFileChooser.APPROVE_SELECTION)) {
                selectedAttach = jFolderChooser
                        .getSelectedFile().getAbsolutePath();
                dispose();
            } else if (evt.getActionCommand().equals(
                    javax.swing.JFileChooser.CANCEL_SELECTION)) {
                dispose();
            }
            
    }//GEN-LAST:event_windowAction

    private void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_vetoableChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_vetoableChange

    /**
     * This method is window starter (main method)
     */
    public static void start() {
        try {
            if (whatOS() == "WINDOWS") {
                UIManager.setLookAndFeel(
                        "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } else {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.
                        UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FileChooserTwo.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileChooserTwo.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileChooserTwo.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileChooserTwo.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileChooserTwo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFolderChooser;
    // End of variables declaration//GEN-END:variables
}
