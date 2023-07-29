/*
 * UpdateRadioFrame.java
 *
 * Created on 2008年8月11日, 上午11:08
 */
package com.Exam.controller;

import java.io.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.Exam.bean.*;
import com.Exam.dao.*;

/**
 * 修改/删除考题窗口
 */
public class UpdateFrame extends javax.swing.JFrame {

    /** Creates new form UpdateRadioFrame */
    public UpdateFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RadioTable = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        setTitle("修改/删除考题");
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        RadioTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "试题编号", "试题类型编号", "试题题目", "试题答案","答案A","答案B","答案C","答案D","备注"
                }
        ));
        DefaultTableModel model = (DefaultTableModel) RadioTable.getModel();
        RadioTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RadioTableMousePressed(evt);
            }
        });
        RadioTable.setSelectionMode(0);
        FindQuestionDao findQuestion = new FindQuestionDao();
        java.util.List list  = findQuestion.findQuestion();
        if(list.size()>0){
            for(int i = 0;i<list.size();i++){
                Question question = (Question)list.get(i);
                model.addRow(new Object[] {
                        question.getId(),question.getTypeid(),ChDeal.toChinese(question.getQ_subject()),
                        ChDeal.toChinese(question.getQ_answer()),ChDeal.toChinese(question.getOptionA()),
                        ChDeal.toChinese(question.getOptionB()),
                        ChDeal.toChinese(question.getOptionC()),ChDeal.toChinese(question.getOptionD()),
                        ChDeal.toChinese(question.getNote())

                });

            }
        }
        jScrollPane1.setViewportView(RadioTable);
        updateButton.setText("修改");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        closeButton.setText("退出");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("删除");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(updateButton)
                                .addGap(46, 46, 46)
                                .addComponent(deleteButton)
                                .addGap(42, 42, 42)
                                .addComponent(closeButton)
                                .addContainerGap(205, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(updateButton)
                                        .addComponent(closeButton)
                                        .addComponent(deleteButton)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(tempCount == null){
            JOptionPane.showMessageDialog(this, "没有指定要修改的问题！","信息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }
        dispose();
        QuestionUpdate qupdate = new QuestionUpdate();
        qupdate.setVisible(true);
        qupdate.setBounds(150, 100, 405,550);
    }
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(tempCount == null){
            JOptionPane.showMessageDialog(this, "没有指定要删除的问题！","信息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }
        else{
            int n = JOptionPane.showConfirmDialog(this, "确定要删除数据吗？", "确认对话框",JOptionPane.YES_NO_OPTION);
            if(n == JOptionPane.YES_OPTION){
                FindQuestionDao findQuestion = new FindQuestionDao();
                boolean bool = findQuestion.delQuestion(tempCount);
                if(bool == true){
                    JOptionPane.showMessageDialog(this,"试题删除成功！","信息对话框",JOptionPane.WARNING_MESSAGE);
                }
            }
            if(n == JOptionPane.NO_OPTION){
                return;
            }
        }
    }

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        ControllerFrame controll = new ControllerFrame();
        controll.setVisible(true);
        controll.setBounds(100, 100, 650, 500);
    }
    private void RadioTableMousePressed(java.awt.event.MouseEvent evt) {
        int count = RadioTable.getSelectedRow();
        tempCount = (Integer) RadioTable.getValueAt(count,0);
        File file = new File("tableQuestionId.txt");
        try {
            FileOutputStream out = new FileOutputStream(file);
            byte buy[] = (""+tempCount).getBytes();
            out.write(buy);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        dispose();
        ControllerFrame controll = new ControllerFrame();
        controll.setVisible(true);
    }

    private javax.swing.JTable RadioTable;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateButton;
    private Integer tempCount;
}
