/*
 * AddFrame.java
 *
 * Created on 2008年8月8日, 下午2:00
 */

package com.Exam.controller;

import javax.swing.JOptionPane;

import com.Exam.bean.*;
import com.Exam.dao.*;

/**
 * @author Administrator
 */

/**
 * 用于添加用户信息。
 * 在该界面中，用户可以选择用户身份，
 * 输入用户名和密码，并确认密码后，点击“添加”按钮将新用户信息添加到数据库中。
 */
public class AddFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddFrame
     */
    public AddFrame() {// 构造方法
        initComponents();// 调用初始化组件
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // 初始化组件
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        qTypejComboBox = new javax.swing.JComboBox();
        userNameLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        userPassWord = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        okUserName = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        addButton = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {// 为窗口设置监听
            public void windowClosing(java.awt.event.WindowEvent evt) {// 关闭窗口
                formWindowClosing(evt);// 调用窗口监听的方法
            }
        });

        jLabel1.setText("用户类型：");

        qTypejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"--请选择用户身份--", "考生", "管理员"}));

        userNameLabel.setText("用户姓名：");
        jTextField1.setText("");
        userPassWord.setText("用户密码：");
        jPasswordField1.setText("");
        okUserName.setText("确认密码：");
        jPasswordField2.setText("");
        addButton.setText("添加");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        reset.setText("重置");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(64, 64, 64).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(okUserName).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPasswordField2, 0, 0, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addComponent(userPassWord).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPasswordField1, 0, 0, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addComponent(userNameLabel).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(qTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))).addGap(74, 74, 74)).addGroup(layout.createSequentialGroup().addGap(115, 115, 115).addComponent(addButton).addGap(31, 31, 31).addComponent(reset).addContainerGap(107, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(39, 39, 39).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(qTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(userNameLabel).addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(userPassWord).addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(okUserName).addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(reset).addComponent(addButton)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        pack();
    }

    // 重置按钮的事件处理方法
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String strQtype = qTypejComboBox.getSelectedItem().toString();// 获取用户类型
        if (jTextField1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "请输入用户姓名", "信息对话框", JOptionPane.WARNING_MESSAGE);// this表示此窗口
            return;
        }

        if (!jPasswordField1.getText().equals(jPasswordField2.getText())) {
            JOptionPane.showMessageDialog(this, "两次输入的密码不一致", "信息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }
        User user = new User();
        if (strQtype.equals("--请选择用户身份--")) {
            JOptionPane.showMessageDialog(this, "请选择用户身份", "信息对话框", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (strQtype.equals("考生")) {
            user.setUserType(0);
        }
        if (strQtype.equals("管理员")) {
            user.setUserType(1);
        }
        MyFindUserDao findUser = new MyFindUserDao();
        java.util.List list = findUser.findUser();
        for (int i = 0; i < list.size(); i++) {
            User users = (User) list.get(i);
            if (users.getUserName().equals(jTextField1.getText())) {
                System.out.println("USERNAME " + users.getUserName());
                JOptionPane.showMessageDialog(this, "该用户名已存在", "信息对话框", JOptionPane.WARNING_MESSAGE);
                return;
            }

        }// 判断用户名是否存在
        int i = findUser.getUserID();
        user.setUserName(jTextField1.getText());
        MyMD5 myMD5 = new MyMD5();
        user.setId(i + 1);
        System.out.println("list " + list.size() + 1);
        user.setPassWord(myMD5.createPassWord(jPasswordField1.getText()));
        InsertUserDao insertUser = new InsertUserDao();
        insertUser.setUserInfoToDBbean(user);
        JOptionPane.showMessageDialog(this, "用户添加", "信息对话框", JOptionPane.WARNING_MESSAGE);
    }

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {// 重置的监听方法
        jTextField1.setText("");
        jPasswordField1.setText("");
        jPasswordField2.setText("");
        qTypejComboBox.setSelectedIndex(0);
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {// 关闭窗体的监听方法
        dispose();
        ControllerFrame controll = new ControllerFrame();
        controll.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox qTypejComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel okUserName;
    private javax.swing.JButton reset;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JLabel userPassWord;
    // End of variables declaration//GEN-END:variables


}
