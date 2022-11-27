package com.cruds.gui;

import com.cruds.db.BookDAO;
import com.cruds.model.Student;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DialogAddStudent extends javax.swing.JDialog {

    public DialogAddStudent(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        labelUsn = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        txtUSN = new javax.swing.JTextField();
        txtNAME = new javax.swing.JTextField();
        btnAddStudent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Student");

        labelUsn.setFont(new java.awt.Font("Tahoma", 0, 14));
        labelUsn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsn.setText("USN");

        labelName.setFont(new java.awt.Font("Tahoma", 0, 14));
        labelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelName.setText("Name");

        txtUSN.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtUSN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUSNActionPerformed(evt);
            }
        });

        btnAddStudent.setFont(new java.awt.Font("Tahoma", 0, 14));
        btnAddStudent.setText("Add");
        btnAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUsn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelName, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUSN, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddStudent)
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUSN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnAddStudent)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }

    private void txtUSNActionPerformed(java.awt.event.ActionEvent evt) {

    }
    private void btnAddStudentActionPerformed(java.awt.event.ActionEvent evt) {
        usn = txtUSN.getText().trim();
        String name = txtNAME.getText().trim();
        
        if(name.length() == 0 || usn.length() == 0)
        {
            JOptionPane.showMessageDialog(rootPane, "Please enter Name and USN", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        BookDAO dao = new BookDAO();

        if (dao.studentExist(new Student(usn, name))) {
            JOptionPane.showMessageDialog(rootPane, "Student already Exist", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            dao.addStudent(new Student(usn, name));
            JOptionPane.showMessageDialog(rootPane, "Student Added Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }

    public static void main(String args[]) {



        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogAddStudent dialog = new DialogAddStudent(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public static String usn = "";

    private javax.swing.JButton btnAddStudent;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelUsn;
    private javax.swing.JTextField txtNAME;
    private javax.swing.JTextField txtUSN;

}
