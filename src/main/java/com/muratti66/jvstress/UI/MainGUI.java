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

import com.muratti66.jvstress.MailOps;
import com.muratti66.jvstress.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.Timer;
import java.awt.event.KeyEvent;
import java.util.Collections;
import static com.muratti66.jvstress.SystemOps.writeLogger;
import static com.muratti66.jvstress.Main.viewLogger;
import static com.muratti66.jvstress.SystemOps.getClipBoard;
import static com.muratti66.jvstress.SystemOps.setClipBoard;
import static com.muratti66.jvstress.SystemOps.whatOS;
import javax.swing.UIManager;
/**
 * This class is UI starter
 */
public class MainGUI extends javax.swing.JFrame {
    
    private static int selectionItems = 1000;
    public static HashMap<String, Object> mailSendConfig = 
            new HashMap<String, Object>();
    private final static String thisClass  = String.class.getName();
    /**
     * Creates new form GUI
     */
    private MainGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outputScrool = new javax.swing.JScrollPane();
        output = new javax.swing.JLabel();
        footer = new javax.swing.JLabel();
        header1 = new javax.swing.JLabel();
        settingsjPanel = new javax.swing.JPanel();
        ServerjLabel = new javax.swing.JLabel();
        FieldHost = new javax.swing.JTextField();
        FieldPort = new javax.swing.JTextField();
        PortjLabel = new javax.swing.JLabel();
        ContentField = new javax.swing.JTextField();
        ContentjLabel = new javax.swing.JLabel();
        AttachField = new javax.swing.JTextField();
        AttachjLabel = new javax.swing.JLabel();
        EnvRecjScroll = new javax.swing.JScrollPane();
        EnvRecjText = new javax.swing.JTextArea();
        SubjectjScroll = new javax.swing.JScrollPane();
        SubjectjText = new javax.swing.JTextArea();
        EnvSendjLabel = new javax.swing.JLabel();
        EnvRecipjLabel = new javax.swing.JLabel();
        SubjectsjLabel = new javax.swing.JLabel();
        EnvSendjScroll = new javax.swing.JScrollPane();
        EnvSendjText = new javax.swing.JTextArea();
        StartjButton = new javax.swing.JButton();
        Lbl1jLabel = new javax.swing.JLabel();
        Lbl1jLabel2 = new javax.swing.JLabel();
        Lbl1jLabel3 = new javax.swing.JLabel();
        ProcessField = new javax.swing.JTextField();
        ThreadField = new javax.swing.JTextField();
        ThreadjLabel = new javax.swing.JLabel();
        ProcessjLabel2 = new javax.swing.JLabel();
        TimeoutField = new javax.swing.JTextField();
        TimeoutjLabel = new javax.swing.JLabel();
        ClearjButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/muratti66/jvstress/Bundle"); // NOI18N
        setTitle(bundle.getString("MainGUI.title")); // NOI18N
        setBounds(new java.awt.Rectangle(200, 70, 759, 874));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        outputScrool.setBorder(null);
        outputScrool.setName(""); // NOI18N

        output.setBackground(new java.awt.Color(255, 255, 255));
        output.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        output.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ActionListener timerListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText(compileLog());
            }
        };

        Timer timer = new Timer(200, timerListener);
        timer.setInitialDelay(0);
        timer.start();
        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("com/muratti66/jvstress/UI/Bundle"); // NOI18N
        output.setText(bundle1.getString("MainGUI.output.text")); // NOI18N
        output.setToolTipText(bundle1.getString("MainGUI.output.toolTipText")); // NOI18N
        output.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        output.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        output.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        output.setOpaque(true);
        outputScrool.setViewportView(output);

        footer.setFont(new java.awt.Font("Verdana", 2, 10)); // NOI18N
        footer.setText(bundle1.getString("MainGUI.footer.text")); // NOI18N

        header1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        header1.setText(bundle1.getString("MainGUI.header1.text")); // NOI18N

        settingsjPanel.setBackground(new java.awt.Color(211, 211, 211));

        ServerjLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        ServerjLabel.setText(bundle1.getString("MainGUI.ServerjLabel.text")); // NOI18N

        FieldHost.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        FieldHost.setText(bundle1.getString("MainGUI.FieldHost.text")); // NOI18N
        FieldHost.setToolTipText(bundle1.getString("MainGUI.FieldHost.toolTipText")); // NOI18N
        FieldHost.setAlignmentX(0.2F);
        FieldHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldHostActionPerformed(evt);
            }
        });
        FieldHost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FieldHostKeyPressed(evt);
            }
        });

        FieldPort.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        FieldPort.setText(bundle1.getString("MainGUI.FieldPort.text")); // NOI18N
        FieldPort.setToolTipText(bundle1.getString("MainGUI.FieldPort.toolTipText")); // NOI18N
        FieldPort.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        FieldPort.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                FieldPortİnputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        FieldPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldPortActionPerformed(evt);
            }
        });

        PortjLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        PortjLabel.setText(bundle1.getString("MainGUI.PortjLabel.text")); // NOI18N

        ContentField.setEditable(false);
        ContentField.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        ContentField.setText(FileChooserContent.selectedContent);
        ContentField.setToolTipText(bundle1.getString("MainGUI.ContentField.toolTipText")); // NOI18N
        ContentField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ContentField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ContentFieldMouseClicked(evt);
            }
        });

        ContentjLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        ContentjLabel.setText(bundle1.getString("MainGUI.ContentjLabel.text")); // NOI18N

        AttachField.setEditable(false);
        AttachField.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        AttachField.setText(FileChooserAttach.selectedAttach);
        AttachField.setToolTipText(bundle1.getString("MainGUI.AttachField.toolTipText")); // NOI18N
        AttachField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AttachField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AttachFieldMouseClicked(evt);
            }
        });

        AttachjLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        AttachjLabel.setText(bundle1.getString("MainGUI.AttachjLabel.text")); // NOI18N

        EnvRecjText.setColumns(20);
        EnvRecjText.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        EnvRecjText.setRows(5);
        EnvRecjText.setToolTipText(bundle1.getString("MainGUI.EnvRecjText.toolTipText")); // NOI18N
        EnvRecjText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EnvRecjTextKeyPressed(evt);
            }
        });
        EnvRecjScroll.setViewportView(EnvRecjText);

        SubjectjText.setColumns(20);
        SubjectjText.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        SubjectjText.setRows(5);
        SubjectjText.setToolTipText(bundle1.getString("MainGUI.SubjectjText.toolTipText")); // NOI18N
        SubjectjText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SubjectjTextKeyPressed(evt);
            }
        });
        SubjectjScroll.setViewportView(SubjectjText);

        EnvSendjLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        EnvSendjLabel.setText(bundle1.getString("MainGUI.EnvSendjLabel.text")); // NOI18N

        EnvRecipjLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        EnvRecipjLabel.setText(bundle1.getString("MainGUI.EnvRecipjLabel.text")); // NOI18N

        SubjectsjLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        SubjectsjLabel.setText(bundle1.getString("MainGUI.SubjectsjLabel.text")); // NOI18N

        EnvSendjText.setColumns(20);
        EnvSendjText.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        EnvSendjText.setRows(5);
        EnvSendjText.setToolTipText(bundle1.getString("MainGUI.EnvSendjText.toolTipText")); // NOI18N
        EnvSendjText.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        EnvSendjText.setDropMode(javax.swing.DropMode.INSERT);
        EnvSendjText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EnvSendjTextKeyPressed(evt);
            }
        });
        EnvSendjScroll.setViewportView(EnvSendjText);

        StartjButton.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        StartjButton.setText(bundle1.getString("MainGUI.StartjButton.text")); // NOI18N
        StartjButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartjButtonMouseClicked(evt);
            }
        });

        Lbl1jLabel.setFont(new java.awt.Font("Lucida Grande", 2, 11)); // NOI18N
        Lbl1jLabel.setText(bundle1.getString("MainGUI.Lbl1jLabel.text")); // NOI18N

        Lbl1jLabel2.setFont(new java.awt.Font("Lucida Grande", 2, 11)); // NOI18N
        Lbl1jLabel2.setText(bundle1.getString("MainGUI.Lbl1jLabel2.text")); // NOI18N

        Lbl1jLabel3.setFont(new java.awt.Font("Lucida Grande", 2, 11)); // NOI18N
        Lbl1jLabel3.setText(bundle1.getString("MainGUI.Lbl1jLabel3.text")); // NOI18N

        ProcessField.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        ProcessField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ProcessField.setText(bundle1.getString("MainGUI.ProcessField.text")); // NOI18N
        ProcessField.setToolTipText(bundle1.getString("MainGUI.ProcessField.toolTipText")); // NOI18N
        ProcessField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessFieldActionPerformed(evt);
            }
        });

        ThreadField.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        ThreadField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ThreadField.setText(bundle1.getString("MainGUI.ThreadField.text")); // NOI18N
        ThreadField.setToolTipText(bundle1.getString("MainGUI.ThreadField.toolTipText")); // NOI18N
        ThreadField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThreadFieldActionPerformed(evt);
            }
        });

        ThreadjLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        ThreadjLabel.setText(bundle1.getString("MainGUI.ThreadjLabel.text")); // NOI18N

        ProcessjLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        ProcessjLabel2.setText(bundle1.getString("MainGUI.ProcessjLabel2.text")); // NOI18N

        TimeoutField.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        TimeoutField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TimeoutField.setText(bundle1.getString("MainGUI.TimeoutField.text")); // NOI18N
        TimeoutField.setToolTipText(bundle1.getString("MainGUI.TimeoutField.toolTipText")); // NOI18N
        TimeoutField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        TimeoutField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                TimeoutFieldİnputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        TimeoutField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeoutFieldActionPerformed(evt);
            }
        });

        TimeoutjLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        TimeoutjLabel.setText(bundle1.getString("MainGUI.TimeoutjLabel.text")); // NOI18N

        ClearjButton.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        ClearjButton.setText(bundle1.getString("MainGUI.ClearjButton.text")); // NOI18N
        ClearjButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearjButtonMouseClicked(evt);
            }
        });
        ClearjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearjButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout settingsjPanelLayout = new org.jdesktop.layout.GroupLayout(settingsjPanel);
        settingsjPanel.setLayout(settingsjPanelLayout);
        settingsjPanelLayout.setHorizontalGroup(
            settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(settingsjPanelLayout.createSequentialGroup()
                .add(29, 29, 29)
                .add(settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, settingsjPanelLayout.createSequentialGroup()
                            .add(SubjectsjLabel)
                            .add(72, 72, 72))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, settingsjPanelLayout.createSequentialGroup()
                            .add(EnvSendjLabel)
                            .add(18, 18, 18)))
                    .add(settingsjPanelLayout.createSequentialGroup()
                        .add(settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(ContentjLabel)
                            .add(ServerjLabel)
                            .add(Lbl1jLabel)
                            .add(Lbl1jLabel3))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .add(settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(settingsjPanelLayout.createSequentialGroup()
                        .add(settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(FieldHost, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(settingsjPanelLayout.createSequentialGroup()
                                .add(settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(EnvSendjScroll, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                    .add(ContentField))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(PortjLabel)
                                    .add(AttachjLabel)
                                    .add(EnvRecipjLabel)
                                    .add(Lbl1jLabel2))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(FieldPort, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(AttachField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .add(EnvRecjScroll)))
                    .add(SubjectjScroll))
                .add(settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(settingsjPanelLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(ThreadjLabel)
                            .add(ProcessjLabel2)
                            .add(TimeoutjLabel)
                            .add(settingsjPanelLayout.createSequentialGroup()
                                .add(16, 16, 16)
                                .add(TimeoutField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(settingsjPanelLayout.createSequentialGroup()
                        .add(29, 29, 29)
                        .add(ThreadField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(settingsjPanelLayout.createSequentialGroup()
                        .add(31, 31, 31)
                        .add(ProcessField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(settingsjPanelLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(StartjButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(ClearjButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        settingsjPanelLayout.setVerticalGroup(
            settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(settingsjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(ServerjLabel)
                    .add(FieldHost, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(PortjLabel)
                    .add(FieldPort, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(ContentField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(ContentjLabel)
                    .add(AttachField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(AttachjLabel))
                .add(18, 18, 18)
                .add(settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, EnvRecjScroll)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, settingsjPanelLayout.createSequentialGroup()
                            .add(EnvRecipjLabel)
                            .add(4, 4, 4)
                            .add(Lbl1jLabel2))
                        .add(org.jdesktop.layout.GroupLayout.LEADING, EnvSendjScroll, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, settingsjPanelLayout.createSequentialGroup()
                            .add(EnvSendjLabel)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(Lbl1jLabel)))
                    .add(settingsjPanelLayout.createSequentialGroup()
                        .add(ThreadjLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(ThreadField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(ProcessjLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(ProcessField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(TimeoutjLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(TimeoutField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(settingsjPanelLayout.createSequentialGroup()
                        .add(SubjectsjLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Lbl1jLabel3)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(settingsjPanelLayout.createSequentialGroup()
                        .add(settingsjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, SubjectjScroll, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .add(settingsjPanelLayout.createSequentialGroup()
                                .add(ClearjButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(StartjButton)))
                        .add(22, 22, 22))))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(14, 14, 14)
                .add(header1)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(settingsjPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(outputScrool)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(footer)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(header1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(settingsjPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(outputScrool, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(footer)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FieldHostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldHostActionPerformed
    }//GEN-LAST:event_FieldHostActionPerformed
    /**
     * Set the form text after attachment and content folder select
     * @param   evt 
     */
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ContentField.setText(FileChooserContent.selectedContent);
        AttachField.setText(FileChooserAttach.selectedAttach);
    }//GEN-LAST:event_formWindowActivated
    /**
     * Start the content filechooser
     * @param   evt 
     */
    private void ContentFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContentFieldMouseClicked
        FileChooserContent.start();
    }//GEN-LAST:event_ContentFieldMouseClicked
    /**
     * Start the attach filechooser
     * @param   evt 
     */
    private void AttachFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AttachFieldMouseClicked
        FileChooserAttach.start();
    }//GEN-LAST:event_AttachFieldMouseClicked
    /**
     * mailSendConfig general configuration is setting 
     * after press the start button
     * @param   evt 
     */
    private void StartjButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartjButtonMouseClicked
        if ((!AttachField.getText().equals("Please Select")) && 
                (!ContentField.getText().equals("Please Select")) && 
                (!FieldHost.getText().equals("ms.domain.com"))) {
            mailSendConfig = new HashMap<String, Object>();
            mailSendConfig.put("attachPath", AttachField.getText());
            mailSendConfig.put("contentPath", ContentField.getText());
            mailSendConfig.put("host", FieldHost.getText());
            mailSendConfig.put("port", FieldPort.getText());
            mailSendConfig.put("envSendr", EnvSendjText.getText());
            mailSendConfig.put("envRecp", EnvRecjText.getText());
            mailSendConfig.put("subject", SubjectjText.getText());
            mailSendConfig.put("thread", ThreadField.getText());
            mailSendConfig.put("process", ProcessField.getText());
            mailSendConfig.put("timeout", TimeoutField.getText());
            MailOps.start();
            int totalMail = Integer.parseInt(ThreadField.getText()) * 
                    Integer.parseInt(ProcessField.getText());
            writeLogger("Sending process started, " + totalMail 
                    + " emails sent to host " 
                    + FieldHost.getText() + ".", false);
        } else {
            writeLogger("Please fill the "
                    + "\"Attach, Content and ServerName\" fileds.... ", true);
        }
    }//GEN-LAST:event_StartjButtonMouseClicked
    /**
     * mailSendConfig getter
     * @return  HashMap
     */
    public static HashMap<String, Object> getmailSendConfig() {
        return mailSendConfig;
    }
    /**
     * Compile and sort logs for the viewer 
     * @return  String
     */
    private static String compileLog() {
        ArrayList viewLoggerDump = new ArrayList(viewLogger);
        Collections.reverse(viewLoggerDump);
        StringBuilder log = new StringBuilder();
        log.append("<html><head></head><body>");
        for (int i=0; i < viewLoggerDump.size(); i++) {
            log.append(viewLoggerDump.get(i) + "<br>");
        }
        log.append("</body></html>");
        return log.toString();
    }
    private void ProcessFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessFieldActionPerformed
    }//GEN-LAST:event_ProcessFieldActionPerformed

    private void ThreadFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThreadFieldActionPerformed
    }//GEN-LAST:event_ThreadFieldActionPerformed
    /**
     * Clipboard operations for FieldHost
     * @param   evt 
     */
    private void FieldHostKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FieldHostKeyPressed
        if ((evt.getKeyCode() == KeyEvent.CTRL_MASK) || 
                (evt.getKeyCode() == KeyEvent.VK_V)){
            FieldHost.setText(getClipBoard());
        }
        if ((evt.getKeyCode() == KeyEvent.CTRL_MASK) || 
                (evt.getKeyCode() == KeyEvent.VK_C)){
            setClipBoard(FieldHost.getText());
        }
    }//GEN-LAST:event_FieldHostKeyPressed
    /**
     * Clipboard operations for EnvSend
     * @param   evt 
     */
    private void EnvSendjTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EnvSendjTextKeyPressed
        if ((evt.getKeyCode() == KeyEvent.CTRL_MASK) || 
                (evt.getKeyCode() == KeyEvent.VK_V)){
            EnvSendjText.setText(getClipBoard());
        }
        if ((evt.getKeyCode() == KeyEvent.CTRL_MASK) || 
                (evt.getKeyCode() == KeyEvent.VK_C)){
            setClipBoard(EnvSendjText.getText());
        }
    }//GEN-LAST:event_EnvSendjTextKeyPressed
    /**
     * Clipboard operations for EnvRec
     * @param   evt 
     */
    private void EnvRecjTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EnvRecjTextKeyPressed
        if ((evt.getKeyCode() == KeyEvent.CTRL_MASK) || 
                (evt.getKeyCode() == KeyEvent.VK_V)){
            EnvRecjText.setText(getClipBoard());
        }
        if ((evt.getKeyCode() == KeyEvent.CTRL_MASK) || 
                (evt.getKeyCode() == KeyEvent.VK_C)){
            setClipBoard(EnvRecjText.getText());
        }
    }//GEN-LAST:event_EnvRecjTextKeyPressed
    /**
     * Clipboard operations for Subject
     * @param   evt 
     */
    private void SubjectjTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SubjectjTextKeyPressed

        if ((evt.getKeyCode() == KeyEvent.CTRL_MASK) || 
                (evt.getKeyCode() == KeyEvent.VK_V)){
            SubjectjText.setText(getClipBoard());
        }
        if ((evt.getKeyCode() == KeyEvent.CTRL_MASK) || 
                (evt.getKeyCode() == KeyEvent.VK_C)){
            setClipBoard(SubjectjText.getText());
        }
    }//GEN-LAST:event_SubjectjTextKeyPressed

    private void FieldPortİnputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_FieldPortİnputMethodTextChanged
    }//GEN-LAST:event_FieldPortİnputMethodTextChanged

    private void FieldPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldPortActionPerformed
    }//GEN-LAST:event_FieldPortActionPerformed

    private void TimeoutFieldİnputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_TimeoutFieldİnputMethodTextChanged
    }//GEN-LAST:event_TimeoutFieldİnputMethodTextChanged

    private void TimeoutFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeoutFieldActionPerformed
    }//GEN-LAST:event_TimeoutFieldActionPerformed
    /**
     * Clearlog operations
     * @param   evt 
     */
    private void ClearjButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearjButtonMouseClicked
        Main.clearLog();
        compileLog();
    }//GEN-LAST:event_ClearjButtonMouseClicked

    private void ClearjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearjButtonActionPerformed
    }//GEN-LAST:event_ClearjButtonActionPerformed
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
                        javax.swing.UIManager.
                                setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AttachField;
    private javax.swing.JLabel AttachjLabel;
    private javax.swing.JButton ClearjButton;
    private javax.swing.JTextField ContentField;
    private javax.swing.JLabel ContentjLabel;
    private javax.swing.JLabel EnvRecipjLabel;
    private javax.swing.JScrollPane EnvRecjScroll;
    private javax.swing.JTextArea EnvRecjText;
    private javax.swing.JLabel EnvSendjLabel;
    private javax.swing.JScrollPane EnvSendjScroll;
    private javax.swing.JTextArea EnvSendjText;
    private javax.swing.JTextField FieldHost;
    private javax.swing.JTextField FieldPort;
    private javax.swing.JLabel Lbl1jLabel;
    private javax.swing.JLabel Lbl1jLabel2;
    private javax.swing.JLabel Lbl1jLabel3;
    private javax.swing.JLabel PortjLabel;
    private javax.swing.JTextField ProcessField;
    private javax.swing.JLabel ProcessjLabel2;
    private javax.swing.JLabel ServerjLabel;
    private javax.swing.JButton StartjButton;
    private javax.swing.JScrollPane SubjectjScroll;
    private javax.swing.JTextArea SubjectjText;
    private javax.swing.JLabel SubjectsjLabel;
    private javax.swing.JTextField ThreadField;
    private javax.swing.JLabel ThreadjLabel;
    private javax.swing.JTextField TimeoutField;
    private javax.swing.JLabel TimeoutjLabel;
    private javax.swing.JLabel footer;
    private javax.swing.JLabel header1;
    private javax.swing.JLabel output;
    private javax.swing.JScrollPane outputScrool;
    private javax.swing.JPanel settingsjPanel;
    // End of variables declaration//GEN-END:variables
}
