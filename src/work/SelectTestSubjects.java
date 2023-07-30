package work;

import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sun Jul 30 21:57:04 CST 2023
 */



/**
 * @author zhangjiantao
 */
public class SelectTestSubjects extends JPanel {
    public SelectTestSubjects() {
        initComponents();
    }
    // 测试
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new SelectTestSubjects());
        frame.pack();
        frame.setVisible(true);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[77:74,fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[0:15,fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]",
                // rows
                "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));

        //---- label1 ----
        label1.setText("选择考试科目");
        add(label1, "cell 5 1 1 2");

        //---- label2 ----
        label2.setText("你需要在下面输入考试科目的代码，");
        add(label2, "cell 4 5 7 2");

        //---- label3 ----
        label3.setText("如果不知道，请询问授课老师");
        add(label3, "cell 4 7");
        add(textField1, "cell 4 12 5 1");

        //---- button1 ----
        button1.setText("确认");//当点击确认按钮时，判断有没有输入科目代码，如果没有，弹出提示框
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        add(button1, "cell 4 17");

        //---- button2 ----
        button2.setText("重置");
        //当点击重置按钮时，清空输入框
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        add(button2, "cell 6 17 3 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    //当点击重置按钮时，清空输入框
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {
        textField1.setText("");
    }
    //点击确认按钮时，判断有没有输入科目代码，如果没有，弹出提示框
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (textField1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "请输入科目代码", "提示", JOptionPane.ERROR_MESSAGE);
        }
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

