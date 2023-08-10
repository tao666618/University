/*
 * UserAddFrame.java
 *
 * Created on 2008年8月9日, 上午8:37
 */

package com.Exam.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.Exam.bean.*;
import com.Exam.dao.FindGrade;
import com.Exam.dao.InsertUserDao;
import com.Exam.dao.MyFindUserDao;

/**
 * 用户添加窗口
 */
public class UserAddFrame extends javax.swing.JFrame {

    /** Creates new form UserAddFrame */

    public UserAddFrame() {
        initComponents(); // 初始化界面组件
        addTableListener1(); // 调用添加表格监听器的方法

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        userAddButton = new javax.swing.JButton();
        userUpdateButton = new javax.swing.JButton();
        userdeleteButton = new javax.swing.JButton();
        closeJButton = new javax.swing.JButton();
        jButton1.setText("jButton1");
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        setTitle("用户管理");
        userTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "编号", "用户类型", "用户名", "考试科目","是否参加考试"
                }
        ));

        userTable.setSelectionMode(0);
        DefaultTableModel model = (DefaultTableModel)userTable.getModel();
        MyFindUserDao findUser = new MyFindUserDao();
        java.util.List list  = findUser.findUser();
        if(list.size()>0){
            for(int i = 0;i<list.size();i++){
                User user = (User)list.get(i);
                model.addRow(new Object[] {
                        user.getId(),user.getUserType(),ChDeal.toChinese(user.getUserName()),
                        user.getSubject(),user.getHaveIn()==1?"是":"否"
                });
            }
        }
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(userTable);
        userAddButton.setText("添加用户");
        userAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAddButtonActionPerformed(evt);
            }
        });
        userUpdateButton.setText("修改用户");
        userUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userUpdateButtonActionPerformed(evt);
            }
        });
        userdeleteButton.setText("删除用户");
        userdeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userdeleteButtonActionPerformed(evt);
            }
        });
        closeJButton.setText("退出");
        closeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(userAddButton)
                                .addGap(18, 18, 18)
                                .addComponent(userUpdateButton)
                                .addGap(18, 18, 18)
                                .addComponent(userdeleteButton)
                                .addGap(18, 18, 18)
                                .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(closeJButton)
                                        .addComponent(userdeleteButton)
                                        .addComponent(userUpdateButton)
                                        .addComponent(userAddButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
    }
    private void userAddButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        AddFrame addFram = new AddFrame();
        addFram.setVisible(true);
        addFram.setBounds(200, 200, 400,280);
        addFram.setTitle("添加用户窗体");
    }
    private void userUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(tempCount == null){
            JOptionPane.showMessageDialog(this, "还没有选择要修改的用户信息！",
                    "信息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }
        UpdateUserFrame updateUser = new UpdateUserFrame();
        updateUser.setVisible(true);
        updateUser.setBounds(200, 200, 450, 330);
        dispose();
    }
    private void userdeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(tempCount == null){
            JOptionPane.showMessageDialog(this, "还没有选择要删除的用户信息！",
                    "信息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }
        else{
            int n =	JOptionPane.showConfirmDialog(this, "确定要删除所选用户吗？","确认对话框", JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.YES_OPTION){
                MyFindUserDao myFindUser = new MyFindUserDao();
                boolean bool = myFindUser.delUseInfo(getUserId());
                if(bool == true){
                    JOptionPane.showMessageDialog(this,"用户信息删除成功", "信息对话框", JOptionPane.WARNING_MESSAGE);
                }
                userTable.revalidate();
            }
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        ControllerFrame controll = new ControllerFrame();
        controll.setVisible(true);
    }
    private void userTableMousePressed(java.awt.event.MouseEvent evt) {
        int count = userTable.getSelectedRow();// 获得被选定行的索引
        tempCount = (Integer) userTable.getValueAt(count,0);// 从表的字段中提取输入的数据
        getUserId();
        File file = new File("tableId.txt");
        try {
            FileOutputStream out = new FileOutputStream(file);
            byte buy[] = (""+tempCount).getBytes();
            out.write(buy);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private int getUserId(){
        return tempCount;
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        dispose();
        ControllerFrame controll = new ControllerFrame();
        controll.setVisible(true);
    }



    private void addTableListener1() {
        userTable.addMouseListener(new MouseAdapter() {
            User user = new User();
            InsertUserDao dao = new InsertUserDao();
            FindGrade findGrade = new FindGrade();
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // 双击事件
                    int row = userTable.getSelectedRow();
                    int column = userTable.getSelectedColumn();

                    DefaultTableModel model = (DefaultTableModel) userTable.getModel();
                    int id = (int) model.getValueAt(row, 0); // 获取行的编号

                    if (column == 4) { // 如果点击的是“是否考试”列
                        String currentValue = (String) model.getValueAt(row, column);
                        String newValue = currentValue.equals("是") ? "否" : "是"; // 切换值

                        user.setId(id);
                        user.setHaveIn(newValue.equals("是") ? 1 : 0);

                        if (!(findGrade.getHaveInValue(user.getId()) == user.getHaveIn())) {
                            if (dao.updateUserHaveIn2(user)) {
                                JOptionPane.showMessageDialog(null, "修改成功！", "信息提示框", JOptionPane.WARNING_MESSAGE);
                            }
                        }

                        // 更新表格中的值
                        model.setValueAt(newValue, row, column);
                    }

                    if (column == 3) {
                        String currentValue = (String) model.getValueAt(row, column);
                        // 获取修改后的值
                        String newValue = (String) JOptionPane.showInputDialog(
                                null,
                                "请输入新的考试科目：",
                                "修改考试科目",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                null,
                                currentValue
                        );

                        if (newValue != null && !newValue.isEmpty() && !newValue.equals(currentValue)) {
                            user.setId(id);
                            user.setSubject(newValue);

                            if (dao.updateUserHaveIn2(user)) {
                                JOptionPane.showMessageDialog(null, "修改成功！", "信息提示框", JOptionPane.WARNING_MESSAGE);
                            }

                            // 更新表格中的值
                            model.setValueAt(newValue, row, column);
                        }
                    }
                }
            }
        });
    }





    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton closeJButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton userAddButton;
    private javax.swing.JTable userTable;
    private javax.swing.JButton userUpdateButton;
    private javax.swing.JButton userdeleteButton;
    private Integer tempCount = null;
    // End of variables declaration//GEN-END:variables

}
