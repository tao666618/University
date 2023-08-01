/*
 * ExamPage.java
 *
 * Created on 2008年8月2日, 下午12:59
 */

package com.Exam.student;
import java.io.*;
import java.util.Date;
import javax.swing.*;

import com.Exam.Index.StudentExam;
import com.Exam.bean.*;
import com.Exam.dao.*;
import com.sun.org.apache.xml.internal.serialize.XHTMLSerializer;
/**
 *
 * @author  Administrator
 */
public class ExamPage extends javax.swing.JFrame implements Runnable {
    private static String subjectID;

    public static void setSubjectID(String subjectID) {
        ExamPage.subjectID = subjectID;
    }

    public static String getSubjectID() {
        return subjectID;
    }
    private javax.swing.JTabbedPane ExamTabbedPane;
    /*单选题布局控件*/
    private javax.swing.JPanel radiojPanel;//单选题布局
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel fristjLabel;//第
    private javax.swing.JLabel countjLabel;//“”
    private javax.swing.JLabel questionjLabel;//题
    private javax.swing.JScrollPane jScrollPane1;//滚动框
    private javax.swing.JTextArea radiojTextArea;//文本域
    private javax.swing.JLabel answerjLabel;//备选答案
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JLabel answer;//所选答案为：
    private javax.swing.JLabel radioanswer;//显示用户单选答案
    private javax.swing.JButton upjButton;//上一题
    private javax.swing.JButton downjButton;//下一题

    /*判断题布局控件*/
    private javax.swing.JPanel jPanel3;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel messpanduanjLabel;//第
    private javax.swing.JLabel panduanjLabel;//“”
    private javax.swing.JLabel subjectjLabel;//题
    private javax.swing.JScrollPane jScrollPane3;//滚动框
    private javax.swing.JTextArea judgejTextArea;//文本域
    private javax.swing.JLabel beixuanAnswer;//判断题备选答案
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JLabel judgeLabel;//判断题所选答案为：
    private javax.swing.JLabel judgeAnswerLabel;//显示用户判断答案
    private javax.swing.JButton upbutton;
    private javax.swing.JButton downbutton;

    /*多选题布局控件*/
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel messagejLabel;
    private javax.swing.JLabel countjLabel2;
    private javax.swing.JLabel examjLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea morejTextArea;
    private javax.swing.JLabel answer2;//多选题备选答案
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel fullanswerLabel;
    private javax.swing.JLabel fullAnserjLabel;
    private javax.swing.JButton upanswerjButton;
    private javax.swing.JButton downanswerjButton1;

    /*填空题布局控件  yezi2013-5-4*/
    private javax.swing.JPanel jPanel4;//单选题布局
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel fristjLabel4;//第
    private javax.swing.JLabel countjLabel4;//“”
    private javax.swing.JLabel questionjLabel4;//题
    private javax.swing.JScrollPane jScrollPane4;//滚动框
    private javax.swing.JTextArea readjTextArea;//文本域
    private javax.swing.JLabel beixuanAnswerjLabel4;//备选答案
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JLabel readanswerLabel;//所选答案为：
    private javax.swing.JLabel readanswer;//显示用户单选答案
    private javax.swing.JButton readupjButton;//上一题
    private javax.swing.JButton readdownjButton;//下一题
    /*填空题布局控件  yezi2013-5-4*/

    /*考试时间、用户初始化控件*/
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel studentNamejLabel;
    private javax.swing.JLabel jLabel1;//考生具体姓名
    private javax.swing.JButton referjButton;//提交考卷
    private javax.swing.JLabel spareLabel;//剩余具体时间
    private javax.swing.JLabel sparejLabel;//剩余时间标签
    private javax.swing.JLabel timeLabel;//考试时间
    private javax.swing.JLabel timejLabel;//多少分钟

    private java.util.List fullAnswer;			//保存多选题答案集合
    private java.util.List radioList;			//保存单选题答案集合
    private java.util.List judgeList;			//保存判断题答案集合
    private java.util.List readList;			//保存阅读题答案集合  yezi2013-5-4
    private int radioCount ;					//保存单选题个数变量
    private int moreCount ;						//保存多选题个数变量
    private int judgeCount ;					//保存判断题个数变量
    private int readCount ;						//保存阅读题个数变量yezi2013-5-4
    private Thread runner = new Thread(this);
    private  int[] countid = null;				//保存单选题题号
    private int[] countEm;						//保存判断题号
    private int[] exitcount;					//保存多选题号
    private  int[] countRead = null;			//保存阅读题号yezi2013-5-4
    private int radio = 0;
    private StringBuffer strbuff;

    /** Creates new form ExamPage */
    public ExamPage() {
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
        /*考试初试信息初始化*/
        contentPanel = new javax.swing.JPanel();
        studentNamejLabel = new javax.swing.JLabel();//考试姓名
        jLabel1 = new javax.swing.JLabel();//具体姓名
        timeLabel = new javax.swing.JLabel();//考试时间
        timejLabel = new javax.swing.JLabel();//具体时间
        sparejLabel = new javax.swing.JLabel();//剩余时间
        spareLabel = new javax.swing.JLabel();//具体剩余时间
        /*显示单选，多选，判断，填空列表*/
        ExamTabbedPane = new javax.swing.JTabbedPane();

        /*单选题面板内容如下*/
        buttonGroup1 = new javax.swing.ButtonGroup();//单选题备选答案面板
        radiojPanel = new javax.swing.JPanel();//单选题面板
        fristjLabel = new javax.swing.JLabel();//"第"
        countjLabel = new javax.swing.JLabel();//" "
        questionjLabel = new javax.swing.JLabel();//"题"
        jScrollPane1 = new javax.swing.JScrollPane();//单选题的滚动框，内嵌 radiojTextArea
        radiojTextArea = new javax.swing.JTextArea();
        answerjLabel = new javax.swing.JLabel();//备选答案
        jRadioButton1 = new javax.swing.JRadioButton();//单选A
        jRadioButton2 = new javax.swing.JRadioButton();//单选B
        jRadioButton3 = new javax.swing.JRadioButton();//单选C
        jRadioButton4 = new javax.swing.JRadioButton();//单选D
        answer = new javax.swing.JLabel();//所选答案为：
        radioanswer = new javax.swing.JLabel();//显示用户所选答案
        upjButton = new javax.swing.JButton();//单选上一题
        downjButton = new javax.swing.JButton();//单选下一题

        /*判断题面板内容如下*/
        buttonGroup2 = new javax.swing.ButtonGroup();//判断题备选答案面板
        judgeLabel = new javax.swing.JLabel();
        judgeAnswerLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        messpanduanjLabel = new javax.swing.JLabel();
        panduanjLabel = new javax.swing.JLabel();
        subjectjLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        judgejTextArea = new javax.swing.JTextArea();
        beixuanAnswer = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        upbutton = new javax.swing.JButton();
        downbutton = new javax.swing.JButton();

        /*多选题面板内容如下*/
        jPanel1 = new javax.swing.JPanel();
        messagejLabel = new javax.swing.JLabel();
        countjLabel2 = new javax.swing.JLabel();
        fullanswerLabel = new javax.swing.JLabel();
        fullAnserjLabel = new javax.swing.JLabel();
        examjLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        morejTextArea = new javax.swing.JTextArea();
        jCheckBox1 = new javax.swing.JCheckBox();
        answer2 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        upanswerjButton = new javax.swing.JButton();
        downanswerjButton1 = new javax.swing.JButton();

        /*填空题面板内容如下yezi2013-5-15*/
        buttonGroup4 = new javax.swing.ButtonGroup();//单选题备选答案面板
        jPanel4 = new javax.swing.JPanel();//单选题面板
        fristjLabel4 = new javax.swing.JLabel();//"第"
        countjLabel4 = new javax.swing.JLabel();//" "
        questionjLabel4 = new javax.swing.JLabel();//"题"
        jScrollPane4 = new javax.swing.JScrollPane();//单选题的滚动框，内嵌 radiojTextArea
        readjTextArea = new javax.swing.JTextArea();
        beixuanAnswerjLabel4 = new javax.swing.JLabel();//备选答案
        jRadioButton7 = new javax.swing.JRadioButton();//单选A
        jRadioButton8 = new javax.swing.JRadioButton();//单选B
        jRadioButton9 = new javax.swing.JRadioButton();//单选C
        jRadioButton10 = new javax.swing.JRadioButton();//单选D
        readanswerLabel = new javax.swing.JLabel();//所选答案为：
        readanswer = new javax.swing.JLabel();//显示用户所选答案
        readupjButton = new javax.swing.JButton();//单选上一题
        readdownjButton = new javax.swing.JButton();//单选下一题
        /*填空题面板内容如上yezi2013-5-15*/

        referjButton = new javax.swing.JButton();
        radioList = new java.util.ArrayList();
        fullAnswer = new java.util.ArrayList();
        judgeList = new java.util.ArrayList();
        readList = new java.util.ArrayList();/*yezi2013-5-15*/
        strbuff = new StringBuffer();

        setTitle("考试模块");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        studentNamejLabel.setText("考生姓名：");
        java.io.File file = new java.io.File("save.txt");
        java.io.FileInputStream in;
        try {
            in = new java.io.FileInputStream(file);
            byte byt[] = new byte[1024];
            int len = in.read(byt);
            String strid = new String(byt,0,len);
            int id = Integer.parseInt(strid);
            MyFindUserDao findUser = new MyFindUserDao();
            User user = new User();
            user.setId(id);
            User use = findUser.getUserID(user);
            jLabel1.setText(ChDeal.toChinese(use.getUserName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        timeLabel.setText("考试时间：");
        FindQuestionDao fin = new FindQuestionDao();

        Stat stat = new Stat();//参数类
        stat.setId(1);//给参数类设置id
        FindStat findStat = new FindStat();//参数控制类
        Stat st = findStat.getStat(stat);
        int time = st.getExam_time();
        timejLabel.setText(time+"分钟");
        sparejLabel.setText("剩余时间：");
        if (runner != null)
            runner.start();

        /*单选题面板内容*/
        fristjLabel.setText("第");
        countjLabel.setText("1");
        questionjLabel.setText("题：");
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
        buttonGroup1.add(jRadioButton4);

        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh "+st.getRadio_BL()/10);
        countid = fin.radowId(st.getRadio_BL()/10,/*ChDeal.toISO(*/"单选题"/*)*/);  //得到抽取到的单选题题号
        if(countid.length == 0){
            JOptionPane.showMessageDialog(this, "请管理员添加考题",
                    "信息对话框",JOptionPane.WARNING_MESSAGE);
        }else{
            System.out.println("111111111111111111 "+(countid ==  null));
            Question question = new Question();
            question.setId(countid[radio]);// 设置试题的id值
            Question ques = fin.getQuestion(question,subjectID);// 根据设置的id值查找单选题
            radiojTextArea.setColumns(20);
            radiojTextArea.setRows(5);
            radiojTextArea.setText(ChDeal.toChinese(ques.getQ_subject()));
            jScrollPane1.setViewportView(radiojTextArea);
            jRadioButton1.setText("A:  "+ChDeal.toChinese(ques.getOptionA()));
            answerjLabel.setText("备选答案：");
            jRadioButton2.setText("B:  "+ChDeal.toChinese(ques.getOptionB()));
            jRadioButton3.setText("C:  "+ChDeal.toChinese(ques.getOptionC()));
            jRadioButton4.setText("D:  "+ChDeal.toChinese(ques.getOptionD()));
            answer.setText("所选答案为：");
            radioanswer.setText("");
            jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jRadioButton1ActionPerformed(evt);
                }
            });
            jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jRadioButton2ActionPerformed(evt);
                }
            });
            jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jRadioButton3ActionPerformed(evt);
                }
            });
            jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jRadioButton4ActionPerformed(evt);
                }
            });

            upjButton.setText("上一题");
            upjButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    upjButtonActionPerformed(evt);
                }
            });
            downjButton.setText("下一题");
            downjButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    downjButtonActionPerformed(evt);
                }
            });
            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(radiojPanel);
            radiojPanel.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(answerjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                                    .addComponent(fristjLabel)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(countjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(questionjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                    .addGap(10, 10, 10)
                                                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                            .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                                                                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                            .addComponent(jRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                            .addComponent(jRadioButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                                    .addContainerGap(59, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                    .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(radioanswer)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                                                    .addComponent(upjButton)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(downjButton)
                                                    .addGap(55, 55, 55))))
            );
            jPanel2Layout.setVerticalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(fristjLabel)
                                            .addComponent(countjLabel)
                                            .addComponent(questionjLabel))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(16, 16, 16)
                                    .addComponent(answerjLabel)
                                    .addGap(14, 14, 14)
                                    .addComponent(jRadioButton1)
                                    .addGap(8, 8, 8)
                                    .addComponent(jRadioButton2)
                                    .addGap(10, 10, 10)
                                    .addComponent(jRadioButton3)
                                    .addGap(10, 10, 10)
                                    .addComponent(jRadioButton4)
                                    .addGap(53, 53, 53)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(upjButton)
                                            .addComponent(downjButton)
                                            .addComponent(answer)
                                            .addComponent(radioanswer))
                                    .addContainerGap(45, Short.MAX_VALUE))
            );
            int grade = 0;
            radioCount = st.getRadio_BL()/10;
            ExamTabbedPane.addTab("单选题（共"+radioCount+"题）", radiojPanel);
            /*判断题面板*/
            buttonGroup2.add(jRadioButton5);
            buttonGroup2.add(jRadioButton6);
            messpanduanjLabel.setText("第");
            panduanjLabel.setText("1");
            subjectjLabel.setText("题：");
            countEm = fin.radowId(st.getJudge_BL()/10,ChDeal.toISO("判断题"));
            Question quest = new Question();
            quest.setId(countEm[radio]);
            Question estimation = fin.getQuestion(quest,subjectID);//获取判断题
            judgejTextArea.setColumns(20);
            judgejTextArea.setRows(5);
            judgejTextArea.setText(ChDeal.toChinese(estimation.getQ_subject()));
            jScrollPane3.setViewportView(judgejTextArea);
            beixuanAnswer.setText("备选答案");
            jRadioButton5.setText("正确");
            jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jRadioButton5ActionPerformed(evt);
                }
            });
            jRadioButton6.setText("错误");
            jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jRadioButton6ActionPerformed(evt);
                }
            });
            upbutton.setText("上一题");
            upbutton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    upbuttonActionPerformed(evt);
                }
            });
            downbutton.setText("下一题");
            downbutton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    downbuttonActionPerformed(evt);
                }
            });
            judgeLabel.setText("所选答案为：");

            judgeAnswerLabel.setText("");

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addGap(22, 22, 22)
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(beixuanAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                                    .addComponent(messpanduanjLabel)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                                                    .addComponent(panduanjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(subjectjLabel))))
                                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                                    .addComponent(judgeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(judgeAnswerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addGap(109, 109, 109)
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jRadioButton6)
                                                            .addComponent(jRadioButton5))))
                                    .addContainerGap(66, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addContainerGap(339, Short.MAX_VALUE)
                                    .addComponent(upbutton)
                                    .addGap(26, 26, 26)
                                    .addComponent(downbutton)
                                    .addGap(98, 98, 98))
            );
            jPanel3Layout.setVerticalGroup(
                    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(messpanduanjLabel)
                                            .addComponent(panduanjLabel)
                                            .addComponent(subjectjLabel))
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(beixuanAnswer)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRadioButton5)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRadioButton6)
                                    .addGap(40, 40, 40)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(judgeLabel)
                                            .addComponent(judgeAnswerLabel))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(upbutton)
                                            .addComponent(downbutton))
                                    .addGap(26, 26, 26))
            );
            judgeCount = st.getJudge_BL()/10;
            ExamTabbedPane.addTab("判断题（共"+judgeCount+"题）", jPanel3);
            /*多选题面板内容*/
            messagejLabel.setText("第");
            countjLabel2.setText("1");
            examjLabel.setText("题：");
            exitcount = fin.radowId(st.getMore_BL()/10,"多选题");
            Question questexit = new Question();
            questexit.setId(exitcount[radio]);
            Question estimqu= fin.getQuestion(questexit,subjectID);//获取多选题
            morejTextArea.setColumns(20);
            morejTextArea.setRows(5);
            morejTextArea.setText(ChDeal.toChinese(estimqu.getQ_subject()));
            jScrollPane2.setViewportView(morejTextArea);
            jCheckBox1.setText("A:  "+ChDeal.toChinese(estimqu.getOptionA()));
            jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jCheckBox1ActionPerformed(evt);
                }
            });
            answer2.setText("备选答案：");
            jCheckBox2.setText("B:  "+ChDeal.toChinese(estimqu.getOptionB()));
            jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jCheckBox2ActionPerformed(evt);
                }
            });
            jCheckBox3.setText("C:  "+ChDeal.toChinese(estimqu.getOptionC()));
            jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jCheckBox3ActionPerformed(evt);
                }
            });
            jCheckBox4.setText("D:  "+ChDeal.toChinese(estimqu.getOptionD()));
            jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jCheckBox4ActionPerformed(evt);
                }
            });
            upanswerjButton.setText("上一题");
            upanswerjButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    upanswerjButtonActionPerformed(evt);
                }
            });
            downanswerjButton1.setText("下一题");
            downanswerjButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    downanswerjButton1ActionPerformed(evt);
                }
            });
            fullanswerLabel.setText("所选答案为：");
            fullAnserjLabel.setText("");
            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap(368, Short.MAX_VALUE)
                                    .addComponent(upanswerjButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(downanswerjButton1)
                                    .addGap(77, 77, 77))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                    .addGap(66, 66, 66)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                                                            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                                                            .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                    .addGap(19, 19, 19)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(answer2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                    .addComponent(messagejLabel)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                    .addComponent(countjLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(examjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                    .addComponent(fullanswerLabel)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(fullAnserjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addContainerGap(16, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(messagejLabel)
                                            .addComponent(countjLabel2)
                                            .addComponent(examjLabel))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(answer2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jCheckBox1)
                                    .addGap(10, 10, 10)
                                    .addComponent(jCheckBox2)
                                    .addGap(10, 10, 10)
                                    .addComponent(jCheckBox3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jCheckBox4)
                                    .addGap(28, 28, 28)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(fullanswerLabel)
                                            .addComponent(fullAnserjLabel))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(downanswerjButton1)
                                            .addComponent(upanswerjButton))
                                    .addContainerGap())
            );
            moreCount = st.getMore_BL()/10;
            ExamTabbedPane.addTab("多选题（共"+moreCount+"题）", jPanel1);


            /*填空题面板内容begin yezi 2013-5-14*/

            fristjLabel4.setText("第");
            countjLabel4.setText("1");
            questionjLabel4.setText("题：");
            buttonGroup4.add(jRadioButton7);
            buttonGroup4.add(jRadioButton8);
            buttonGroup4.add(jRadioButton9);
            buttonGroup4.add(jRadioButton10);
            System.out.println("sssssssssssssssssss "+st.getRead_BL()/10);
            countRead = fin.radowId(st.getRead_BL()/10,"阅读题");  //得到抽取到的单选题题号
            Question question4 = new Question();
            question4.setId(countRead[radio]);// 设置试题的id值
            Question ques4 = fin.getQuestion(question4,subjectID);// 根据设置的id值查找试题

            readjTextArea.setColumns(20);
            readjTextArea.setRows(5);
            readjTextArea.setText(ChDeal.toChinese(ques4.getQ_subject()));
            jScrollPane4.setViewportView(readjTextArea);
            beixuanAnswerjLabel4.setText("备选答案：");
            jRadioButton7.setText("A:  "+ChDeal.toChinese(ques4.getOptionA()));
            jRadioButton8.setText("B:  "+ChDeal.toChinese(ques4.getOptionB()));
            jRadioButton9.setText("C:  "+ChDeal.toChinese(ques4.getOptionC()));
            jRadioButton10.setText("D:  "+ChDeal.toChinese(ques4.getOptionD()));
            readanswerLabel.setText("所选答案为：");
            readanswer.setText("");
            jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jRadioButton7ActionPerformed(evt);
                }
            });
            jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jRadioButton8ActionPerformed(evt);
                }
            });
            jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jRadioButton9ActionPerformed(evt);
                }
            });
            jRadioButton10.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jRadioButton10ActionPerformed(evt);
                }
            });
            readupjButton.setText("上一题");
            System.out.println("555");
            readupjButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    readupjButtonActionPerformed(evt);
                }
            });
            System.out.println("666");
            readdownjButton.setText("下一题");
            readdownjButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    readdownjButtonActionPerformed(evt);
                }
            });
            javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                    jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(beixuanAnswerjLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                                    .addComponent(fristjLabel4)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(countjLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(questionjLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                                                    .addGap(10, 10, 10)
                                                                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                            .addComponent(jRadioButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                                                                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addComponent(jRadioButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                            .addComponent(jRadioButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                            .addComponent(jRadioButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                                    .addContainerGap(59, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                    .addComponent(readanswerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(readanswer)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                                                    .addComponent(readupjButton)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(readdownjButton)
                                                    .addGap(55, 55, 55))))
            );
            jPanel4Layout.setVerticalGroup(
                    jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(fristjLabel4)
                                            .addComponent(countjLabel4)
                                            .addComponent(questionjLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(16, 16, 16)
                                    .addComponent(beixuanAnswerjLabel4)
                                    .addGap(14, 14, 14)
                                    .addComponent(jRadioButton7)
                                    .addGap(8, 8, 8)
                                    .addComponent(jRadioButton8)
                                    .addGap(10, 10, 10)
                                    .addComponent(jRadioButton9)
                                    .addGap(10, 10, 10)
                                    .addComponent(jRadioButton10)
                                    .addGap(53, 53, 53)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(readupjButton)
                                            .addComponent(readdownjButton)
                                            .addComponent(readanswerLabel)
                                            .addComponent(readanswer))
                                    .addContainerGap(45, Short.MAX_VALUE))
            );
            readCount = st.getRead_BL()/10;
            ExamTabbedPane.addTab("阅读题（共"+readCount+"题）", jPanel4);

            /*end yezi 2013-5-14*/


            referjButton.setText("提交考卷");
            referjButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    referjButtonActionPerformed(evt);
                }
            });
            javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
            contentPanel.setLayout(contentPanelLayout);
            contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ExamTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(contentPanelLayout.createSequentialGroup()
                                                    .addComponent(studentNamejLabel)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(timeLabel)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(timejLabel)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                                    .addComponent(sparejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(spareLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(referjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap())
            );
            contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(studentNamejLabel)
                                            .addComponent(jLabel1)
                                            .addComponent(timeLabel)
                                            .addComponent(timejLabel)
                                            .addComponent(sparejLabel)
                                            .addComponent(spareLabel)
                                            .addComponent(referjButton))
                                    .addGap(18, 18, 18)
                                    .addComponent(ExamTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                                    .addContainerGap())
            );
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contentPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            pack();
        }
    }

    private void referjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referjButtonActionPerformed
        int n = JOptionPane.showConfirmDialog(this, "确定要提交考卷吗？","确认对话框", JOptionPane.YES_NO_OPTION);

        if(n == JOptionPane.YES_OPTION){
            getGread();
        }
        if(n == JOptionPane.NO_OPTION){

        }
    }
    /*yezi 2013-5-14*/
    private void getGread(){
        int radioGrage = 0;
        int examGrade = 0;
        int moreGrade = 0;
        int readGrade = 0;/*yezi 2013-5-14*/
        Stat stat = new Stat();					//创建对应系统参数表Java bean Stat对象
        stat.setId(1);						//设置对象id号
        FindStat findStat = new FindStat();		//创建检索系统参数表对象
        Stat sta = findStat.getStat(stat);			//查询指定的系统参数
        if(radioList.size()>0){				//如果保存单选题答案集合不为空
            for(int i = 0;i<radioList.size();i++){	//循环遍历集合
                int id = countid[i];			//获取保存随机抽取试题集合中各元素
                FindQuestionDao findQuestionDao = new FindQuestionDao();
                //创建查询考题类对象
                Question question = new Question();	//创建Question类对象
                question.setId(id);
                Question question2 = findQuestionDao.getQuestion(question);	//查询试题方法
                if(question2.getQ_answer().equals(radioList.get(i))){
                    radioGrage = radioGrage+sta.getRadio_FS();
                }
            }
        }
        if(fullAnswer.size()>0){				//遍历保存多选题答案集合
            for(int i = 0;i<fullAnswer.size();i++){
                int id  =	exitcount[i];
                Question ques = new Question();
                ques.setId(id);
                FindQuestionDao findao = new FindQuestionDao();
                Question qetion = findao.getQuestion(ques);
                String answer = qetion.getQ_answer();
                String newAnswer = answer.replace(","," ");
                if((qetion.getQ_answer().trim()).equals(fullAnswer.get(i).toString().trim())){
                    moreGrade = moreGrade+sta.getMore_FS();
                }
            }
        }
        if(judgeList.size()>0){					//遍历保存判断题答案集合
            for(int i = 0 ;i<judgeList.size();i++){
                int id = countEm[i];
                Question qtion = new Question();
                qtion.setId(id);
                FindQuestionDao findQ = new FindQuestionDao();
                Question qes = findQ.getQuestion(qtion);
                if(ChDeal.toChinese(qes.getQ_answer()).equals(judgeList.get(i).toString())){
                    examGrade = examGrade+sta.getJudge_FS();
                }
            }
        }
        /*yezi 2013-5-14 需要修改*/
        if(readList.size()>0){				//如果保存单选题答案集合不为空
            for(int i = 0;i<readList.size();i++){	//循环遍历集合
                int id = countRead[i];			//获取保存随机抽取试题集合中各元素
                FindQuestionDao findQuestionDao = new FindQuestionDao();
                //创建查询考题类对象
                Question question4 = new Question();	//创建Question类对象
                question4.setId(id);
                Question question = findQuestionDao.getQuestion(question4);	//查询试题方法
                if(question.getQ_answer().equals(readList.get(i))){
                    readGrade = readGrade+sta.getRead_FS();
                }
            }
        }
        int sum = radioGrage + moreGrade + examGrade+readGrade;	//获取总分
        Grade grade = new Grade();
        File file = new File("save.txt");
        try{
            FileInputStream in = new FileInputStream(file);		//创建保存登录用户文本文件对象
            byte byt[] = new byte[1024];
            int len = in.read(byt);
            String strbyte = new String(byt,0,len);
            int strid = Integer.parseInt(strbyte);
            User user = new User();
            user.setId(strid);
            MyFindUserDao findUserdao = new MyFindUserDao();
            //创建封装查找用户类MyFindUserDao对象
            User uid = findUserdao.getUserID(user);
            User uses = null;

            MyFindUserDao findUser = new MyFindUserDao();
            uses = findUser.getUserID(user);// 根据文件读取Id查找数据库用户
            if(!"".equals(uses.getId()) ){
                InsertGrade delGrade = new InsertGrade();
                delGrade.delGradeDBbean(uses);

                grade.setId(strid);
                grade.setUserName(uid.getUserName());
                grade.setRadioResult(radioGrage);
                grade.setFullResule(moreGrade);
                grade.setEsitResult(examGrade);
                grade.setReadResult(readGrade);/*yezi 2013-5-19*/
                grade.setBatsisResult(sum);
                grade.setDate(ChDeal.getDateTime());
                InsertGrade inserGrade = new InsertGrade();		//添加考分类对象
                inserGrade.setGradeDBbean(grade);			//添加考分
                in.close();
                grade.setId(Integer.parseInt(strbyte));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "单选题得分："+radioGrage+"\n"+"多选题得分："+moreGrade+"\n"+"判断题得分："
                        +examGrade+"\n"+"阅读题得分："+readGrade+"\n"+"总分为："+sum,"消息对话框",
                JOptionPane.WARNING_MESSAGE);
        this.dispose();
    }

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        String strcountjLabel = panduanjLabel.getText();
        String subR1 = jRadioButton5.getText();
        int intcountjLabel = Integer.parseInt(strcountjLabel);
        if((judgeList.size()>intcountjLabel-1)&&(judgeList.get(intcountjLabel-1)!= null)){
            judgeList.remove(intcountjLabel-1);
        }
        judgeList.add(intcountjLabel-1,subR1);
        radioanswer.setText(subR1);
        judgeAnswerLabel.setText(jRadioButton5.getText());
    }
    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        String strcountjLabel = panduanjLabel.getText();
        String subR1 = jRadioButton6.getText();
        int intcountjLabel = Integer.parseInt(strcountjLabel);
        if((judgeList.size()>intcountjLabel-1)&&(judgeList.get(intcountjLabel-1)!= null)){
            judgeList.remove(intcountjLabel-1);
        }
        judgeList.add(intcountjLabel-1,subR1);
        radioanswer.setText(subR1);
        judgeAnswerLabel.setText(jRadioButton6.getText());
    }
    /*单选题的上一题事件*/
    private void upjButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String count = countjLabel.getText();		//获取当前第几题标签的显示文本
        int countText = Integer.parseInt(count);
        if((jRadioButton1.isSelected() == false)&&(jRadioButton2.isSelected() == false)
                &&(jRadioButton3.isSelected()== false)&&(jRadioButton4.isSelected() == false)){
            JOptionPane.showMessageDialog(this, "请回答完这道题后再执行该操作", "消息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!count.equals("1")){				//如果当前考题不是第一题
            int newCount = countText - 1;
            countjLabel.setText(newCount+"");
            Question question = new Question();
            question.setId(countid[newCount-1]);		//获取保存随机抽取试题中前一项元素
            FindQuestionDao findQuestionDao = new FindQuestionDao();	//创建检索考题类对象
            Question ques = findQuestionDao.getQuestion(question);
            radiojTextArea.setText(ChDeal.toChinese(ques.getQ_subject()));
            buttonGroup1.clearSelection();						//将单选按钮组中对象清空
            String strid = "";
            if(radioList.size()>0){
                for(int i = 0;i<radioList.size();i++){
                    strid = radioList.get(countText-2).toString();	 //获取考生选择的答案
                }
            }
            if(!strid.equals("")&&(jRadioButton1.getText().substring(0, 1).equals(strid))){
                jRadioButton1.setSelected(true);		//如果考生选择“A”选项，将其设置为选中状态
                radioanswer.setText("A");			//答案标签显示为“A”
            }
            if(!strid.equals("")&&(jRadioButton2.getText().substring(0, 1).equals(strid))){
                jRadioButton2.setSelected(true);
                radioanswer.setText("B");
            }
            if(!strid.equals("")&&(jRadioButton3.getText().substring(0, 1).equals(strid))){
                jRadioButton3.setSelected(true);
                radioanswer.setText("C");
            }
            if(!strid.equals("")&&(jRadioButton4.getText().substring(0, 1).equals(strid))){
                jRadioButton4.setSelected(true);
                radioanswer.setText("D");
            }
            jRadioButton1.setText("A:  "+ChDeal.toChinese(ques.getOptionA()));	//设置单选按钮的显示值
            jRadioButton2.setText("B:  "+ChDeal.toChinese(ques.getOptionB()));
            jRadioButton3.setText("C:  "+ChDeal.toChinese(ques.getOptionC()));
            jRadioButton4.setText("D:  "+ChDeal.toChinese(ques.getOptionD()));
        }
        else{
            JOptionPane.showMessageDialog(this, "已经是第一题","消息对话框",JOptionPane.WARNING_MESSAGE);
        }
    }

    /*单选题的下一题事件*/
    private void downjButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String count = countjLabel.getText();			//见代码说明
        int countText = Integer.parseInt(count);		//转换为Integer对象
        System.out.println("COUNTTEXT "+countText);
        //如果考生没有解答当前考题、给出提示信息
        if((jRadioButton1.isSelected() == false)&&(jRadioButton2.isSelected() == false)&&(jRadioButton3.isSelected()
                == false)&&(jRadioButton4.isSelected() == false)){
            JOptionPane.showMessageDialog(this, "请回答完这道题后再执行该操作", "消息对话框",JOptionPane.WARNING_MESSAGE);
            return;							//退出系统
        }
        if(!count.equals(""+radioCount)){			//如果当前考题不是最后一题
            int newCount = countText + 1;				//获取保存随机抽取试题int数组
            Question question = new Question();
            question.setId(countid[countText]);
            countjLabel.setText(""+newCount);
            FindQuestionDao findQDao = new FindQuestionDao();
            Question ques = findQDao.getQuestion(question);
            radiojTextArea.setText(ChDeal.toChinese(ques.getQ_subject()));	//设置窗体中组件的显示信息
            buttonGroup1.clearSelection();						//使单选按钮组中按钮都不被选中
            String strid = "";
            if(radioList.size()>countText){						//radioList为保存按选题答案集合
                for(int i = 0;i<radioList.size();i++){
                    strid = radioList.get(countText).toString();    		//向集合添加值
                }
            }
            if(!strid.equals("")&&(jRadioButton1.getText().substring(0, 1).equals(strid))){
                jRadioButton1.setSelected(true);
                radioanswer.setText("A");				//radioanswer为JLabel对象，用于显示用户选择的答案
            }
            if(!strid.equals("")&&(jRadioButton2.getText().substring(0, 1).equals(strid))){
                jRadioButton2.setSelected(true);
                radioanswer.setText("B");
            }
            if(!strid.equals("")&&(jRadioButton3.getText().substring(0, 1).equals(strid))){
                jRadioButton3.setSelected(true);
                radioanswer.setText("C");
            }
            if(!strid.equals("")&&(jRadioButton4.getText().substring(0, 1).equals(strid))){
                jRadioButton4.setSelected(true);
                radioanswer.setText("D");
            }
            jRadioButton1.setText("A:  "+ChDeal.toChinese(ques.getOptionA()));	//设置窗体的显示信息
            jRadioButton2.setText("B:  "+ChDeal.toChinese(ques.getOptionB()));
            jRadioButton3.setText("C:  "+ChDeal.toChinese(ques.getOptionC()));
            jRadioButton4.setText("D:  "+ChDeal.toChinese(ques.getOptionD()));
        }
        else{							//如果当前显示的考题，是最后一题，给出提示信息
            JOptionPane.showMessageDialog(this, "已经是最后一题！", "信息对话框",JOptionPane.WARNING_MESSAGE);
        }
    }

    /*判断题的上一题事件begin yezi2013-5-15*/
    private void readupjButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String count = countjLabel4.getText();		//获取当前第几题标签的显示文本
        int countText = Integer.parseInt(count);
        if((jRadioButton7.isSelected() == false)&&(jRadioButton8.isSelected() == false)
                &&(jRadioButton9.isSelected()== false)&&(jRadioButton10.isSelected() == false)){
            JOptionPane.showMessageDialog(this, "请回答完这道题后再执行该操作", "消息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!count.equals("1")){				//如果当前考题不是第一题
            int newCount = countText - 1;
            countjLabel4.setText(newCount+"");
            Question question4 = new Question();
            question4.setId(countRead[newCount-1]);		/*countid需要改*///获取保存随机抽取试题中前一项元素
            FindQuestionDao findQuestionDao = new FindQuestionDao();	//创建检索考题类对象
            Question ques4 = findQuestionDao.getQuestion(question4);
            readjTextArea.setText(ChDeal.toChinese(ques4.getQ_subject()));
            buttonGroup4.clearSelection();						//将单选按钮组中对象清空
            String strid = "";
            if(readList.size()>0){/*radioList需要改*/
                for(int i = 0;i<readList.size();i++){
                    strid = readList.get(countText-2).toString();	 //获取考生选择的答案
                }
            }
            if(!strid.equals("")&&(jRadioButton7.getText().substring(0, 1).equals(strid))){
                jRadioButton7.setSelected(true);		//如果考生选择“A”选项，将其设置为选中状态
                readanswer.setText("A");			//答案标签显示为“A”
            }
            if(!strid.equals("")&&(jRadioButton8.getText().substring(0, 1).equals(strid))){
                jRadioButton8.setSelected(true);
                readanswer.setText("B");
            }
            if(!strid.equals("")&&(jRadioButton9.getText().substring(0, 1).equals(strid))){
                jRadioButton9.setSelected(true);
                readanswer.setText("C");
            }
            if(!strid.equals("")&&(jRadioButton10.getText().substring(0, 1).equals(strid))){
                jRadioButton10.setSelected(true);
                readanswer.setText("D");
            }
            jRadioButton7.setText("A:  "+ChDeal.toChinese(ques4.getOptionA()));	//设置单选按钮的显示值
            jRadioButton8.setText("B:  "+ChDeal.toChinese(ques4.getOptionB()));
            jRadioButton9.setText("C:  "+ChDeal.toChinese(ques4.getOptionC()));
            jRadioButton10.setText("D:  "+ChDeal.toChinese(ques4.getOptionD()));
        }
        else{
            JOptionPane.showMessageDialog(this, "已经是第一题","消息对话框",JOptionPane.WARNING_MESSAGE);
        }
    }
    /*判断题的上一题事件end yezi2013-5-15*/    //这写的注释都不清楚
    /*判断题的下一题事件begein yezi2013-5-15*/   //单词都拼错
    private void readdownjButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String count = countjLabel4.getText();			//见代码说明
        int countText = Integer.parseInt(count);		//转换为Integer对象
        System.out.println("COUNTTEXT "+countText);
        //如果考生没有解答当前考题、给出提示信息
        if((jRadioButton7.isSelected() == false)&&(jRadioButton8.isSelected() == false)&&(jRadioButton9.isSelected()
                == false)&&(jRadioButton10.isSelected() == false)){
            JOptionPane.showMessageDialog(this, "请回答完这道题后再执行该操作", "消息对话框",JOptionPane.WARNING_MESSAGE);
            return;							//退出系统
        }
        if(!count.equals(""+readCount)){	/*radioCount需要改*/		//如果当前考题不是最后一题
            int newCount = countText + 1;				//获取保存随机抽取试题int数组
            Question question4 = new Question();
            question4.setId(countRead[countText]);
            countjLabel4.setText(""+newCount);
            FindQuestionDao findQDao = new FindQuestionDao();
            Question ques4 = findQDao.getQuestion(question4);
            readjTextArea.setText(ChDeal.toChinese(ques4.getQ_subject()));	//设置窗体中组件的显示信息
            buttonGroup4.clearSelection();						//使单选按钮组中按钮都不被选中
            String strid = "";
            if(readList.size()>countText){		/*radioList需要改*/	//radioList为保存按选题答案集合
                for(int i = 0;i<readList.size();i++){
                    strid = readList.get(countText).toString();    		//向集合添加值
                }
            }
            if(!strid.equals("")&&(jRadioButton7.getText().substring(0, 1).equals(strid))){
                jRadioButton7.setSelected(true);
                readanswer.setText("A");				//radioanswer为JLabel对象，用于显示用户选择的答案
            }
            if(!strid.equals("")&&(jRadioButton8.getText().substring(0, 1).equals(strid))){
                jRadioButton8.setSelected(true);
                readanswer.setText("B");
            }
            if(!strid.equals("")&&(jRadioButton9.getText().substring(0, 1).equals(strid))){
                jRadioButton9.setSelected(true);
                readanswer.setText("C");
            }
            if(!strid.equals("")&&(jRadioButton10.getText().substring(0, 1).equals(strid))){
                jRadioButton10.setSelected(true);
                readanswer.setText("D");
            }
            jRadioButton7.setText("A:  "+ChDeal.toChinese(ques4.getOptionA()));	//设置窗体的显示信息
            jRadioButton8.setText("B:  "+ChDeal.toChinese(ques4.getOptionB()));
            jRadioButton9.setText("C:  "+ChDeal.toChinese(ques4.getOptionC()));
            jRadioButton10.setText("D:  "+ChDeal.toChinese(ques4.getOptionD()));
        }
        else{							//如果当前显示的考题，是最后一题，给出提示信息
            JOptionPane.showMessageDialog(this, "已经是最后一题！", "信息对话框",JOptionPane.WARNING_MESSAGE);
        }
    }
    /*判断题的下一题事件end -yezi2013-5-15*/


    private void upbuttonActionPerformed(java.awt.event.ActionEvent evt) {
        String count = panduanjLabel.getText();
        int countText = Integer.parseInt(count);
        if((jRadioButton5.isSelected() == false) &&(jRadioButton6.isSelected() == false)){
            judgeList.add(countText - 1,"");
            JOptionPane.showMessageDialog(this, "请回答完这道题后再执行该操作", "消息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!count.equals("1")){
            buttonGroup2.clearSelection();
            int newCount = countText - 1;
            panduanjLabel.setText(newCount+"");
            Question question = new Question();
            question.setId(countEm[newCount-1]);
            FindQuestionDao findQuestionDao = new FindQuestionDao();
            Question ques = findQuestionDao.getQuestion(question);
            judgejTextArea.setText(ChDeal.toChinese(ques.getQ_subject()));
            String strList = "";
            if(judgeList.size()>0){

                for(int i = 0;i<judgeList.size();i++){
                    strList = judgeList.get(newCount-1).toString();
                }
            }
            if(strList.equals("")){
                judgeAnswerLabel.setText("");
            }
            if(!(strList.equals(""))&&jRadioButton5.getText().equals(strList)){
                jRadioButton5.setSelected(true);
                judgeAnswerLabel.setText(jRadioButton5.getText());
            }
            if(!(judgeAnswerLabel.equals(""))&&jRadioButton6.getText().equals(strList)){
                jRadioButton6.setSelected(true);
                judgeAnswerLabel.setText(jRadioButton6.getText());
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "已经是第一题","消息对话框",JOptionPane.WARNING_MESSAGE);
        }
    }

    private void downbuttonActionPerformed(java.awt.event.ActionEvent evt) {
        String strJudgeList = "";
        String count = panduanjLabel.getText();
        int countText = Integer.parseInt(count);
        if((jRadioButton5.isSelected() == false) &&(jRadioButton6.isSelected() == false)){
            judgeList.add(countText -1 ,"");
            JOptionPane.showMessageDialog(this, "请回答完这道题后再执行该操作", "消息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!count.equals(""+judgeCount)){
            buttonGroup2.clearSelection();
            int newCount = countText + 1;
            Question question = new Question();
            question.setId(countEm[countText]);
            panduanjLabel.setText(""+newCount);
            FindQuestionDao findQDao = new FindQuestionDao();
            Question ques = findQDao.getQuestion(question);
            judgejTextArea.setText(ChDeal.toChinese(ques.getQ_subject()));
            if(judgeList.size()>countText){
                for(int i = 0;i<judgeList.size();i++){
                    strJudgeList = judgeList.get(countText).toString();
                }
            }
            if(strJudgeList.equals("")){
                judgeAnswerLabel.setText("");
            }
            if(!(strJudgeList.equals("")) && strJudgeList.equals(jRadioButton5.getText())){
                jRadioButton5.setSelected(true);
                judgeAnswerLabel.setText(jRadioButton5.getText());
            }
            if(!(strJudgeList.equals(""))&&strJudgeList.equals(jRadioButton6.getText())){
                jRadioButton6.setSelected(true);
                judgeAnswerLabel.setText(jRadioButton6.getText());
            }
        }
        else if(count.equals(""+judgeCount)){
            JOptionPane.showMessageDialog(this, "已经是最后一题！", "信息对话框",JOptionPane.WARNING_MESSAGE);
        }

    }
    private void upanswerjButtonActionPerformed(java.awt.event.ActionEvent evt) {
        strbuff.delete(0, strbuff.length());
        fullAnserjLabel.setText("");
        String strListid = "";
        String count = countjLabel2.getText();
        int countText = Integer.parseInt(count);
        if((jCheckBox1.isSelected() == false) &&(jCheckBox2.isSelected() == false)
                &&(jCheckBox3.isSelected() == false)&&(jCheckBox4.isSelected() == false)){
            JOptionPane.showMessageDialog(this, "请回答完这道题后再执行该操作", "消息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!count.equals("1")){
            int newCount = countText - 1;
            countjLabel2.setText(newCount+"");
            Question question = new Question();
            question.setId(countid[newCount-1]);
            FindQuestionDao findQuestionDao = new FindQuestionDao();
            Question ques = findQuestionDao.getQuestion(question);
            if(fullAnswer.size() > countText-1){
                for(int i = 0;i<fullAnswer.size();i++){
                    strListid = fullAnswer.get(countText-2).toString();
                }
            }
            morejTextArea.setText(ChDeal.toChinese(ques.getQ_subject()));
            jCheckBox1.setText("A:  "+ChDeal.toChinese(ques.getOptionA()));
            jCheckBox1.setSelected(false);
            jCheckBox2.setText("B:  "+ChDeal.toChinese(ques.getOptionB()));
            jCheckBox2.setSelected(false);
            jCheckBox3.setSelected(false);
            jCheckBox4.setSelected(false);
            String[] strList = ChDeal.str2IntegerArr(strListid);
            if(strList != null){
                for(int i = 0;i<strList.length;i++){
                    String strListidtostring = strList[i];
                    if(!(strListidtostring.equals(""))
                            &&(jCheckBox1.getText().substring(0, 1)).equals(strListidtostring)){
                        jCheckBox1.setSelected(true);
                    }
                    else if(!(strListidtostring.equals(""))
                            &&(jCheckBox2.getText().substring(0, 1).equals(strListidtostring))){
                        jCheckBox2.setSelected(true);
                    }
                    else if(!(strListidtostring.equals(""))
                            &&(jCheckBox3.getText().substring(0, 1).equals(strListidtostring))){
                        jCheckBox3.setSelected(true);
                    }
                    else if(!(strListidtostring.equals(""))
                            &&(jCheckBox4.getText().substring(0, 1).equals(strListidtostring))){
                        jCheckBox4.setSelected(true);
                    }
                }
            }
            jCheckBox3.setText("C:  "+ChDeal.toChinese(ques.getOptionC()));
            jCheckBox4.setText("D:  "+ChDeal.toChinese(ques.getOptionD()));
            strbuff.append(strListid);
            fullAnserjLabel.setText(strbuff.toString());
        }
        else{
            for(int i = 0;i<fullAnswer.size();i++){
                strListid = fullAnswer.get(0).toString();
            }
            strbuff.append(strListid);
            fullAnserjLabel.setText(strbuff.toString());
            JOptionPane.showMessageDialog(this, "已经是第一题","消息对话框",JOptionPane.WARNING_MESSAGE);
        }
    }
    /*选择单选题A时的事件*/
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String strcountjLabel = countjLabel.getText();//得到目前是第几题
        String subR1 = jRadioButton1.getText().substring(0, 1);//得到A
        int intcountjLabel = Integer.parseInt(strcountjLabel);
        if((radioList.size()>intcountjLabel-1)&&(radioList.get(intcountjLabel-1)!= null)){
            radioList.remove(intcountjLabel-1);
        }
        radioList.add(intcountjLabel-1,subR1);
        radioanswer.setText(subR1);
    }
    /*选择单选题B时的事件*/
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String strcountjLabel = countjLabel.getText();
        String subR1 = jRadioButton2.getText().substring(0, 1);
        int intcountjLabel = Integer.parseInt(strcountjLabel);
        if((radioList.size()>intcountjLabel-1)&&(radioList.get(intcountjLabel-1)!=null)){
            radioList.remove(intcountjLabel-1);
        }
        radioList.add(intcountjLabel-1,subR1);
        radioanswer.setText(jRadioButton2.getText().substring(0, 1));
    }
    /*选择单选题C时的事件*/
    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        String strcountjLabel = countjLabel.getText();
        String subR1 = jRadioButton3.getText().substring(0, 1);
        int intcountjLabel = Integer.parseInt(strcountjLabel);
        if((radioList.size()>intcountjLabel-1)&&(radioList.get(intcountjLabel-1)!=null)){
            radioList.remove(intcountjLabel-1);
        }
        radioList.add(intcountjLabel-1,subR1);
        radioanswer.setText(jRadioButton3.getText().substring(0, 1));
    }
    /*选择单选题D时的事件*/
    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        String strcountjLabel = countjLabel.getText();
        String subR1 = jRadioButton4.getText().substring(0, 1);
        int intcountjLabel = Integer.parseInt(strcountjLabel);
        if((radioList.size()>intcountjLabel-1)&&(radioList.get(intcountjLabel-1)!=null)){
            radioList.remove(intcountjLabel-1);
        }
        radioList.add(intcountjLabel-1,subR1);
        radioanswer.setText(jRadioButton4.getText().substring(0, 1));
    }
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        String strsub1 = jCheckBox1.getText().substring(0, 1);
        String countStr = countjLabel2.getText();
        int intCount = Integer.parseInt(countStr);
        if(jCheckBox1.isSelected() &&(fullAnserjLabel.getText().indexOf(strsub1) == -1)){
            fullAnserjLabel.setText(strbuff.append(" "+(jCheckBox1.getText()).substring(0, 1)).toString());
        }
        else if(jCheckBox1.isSelected() == false){
            int index = (fullAnserjLabel.getText()).indexOf(strsub1);
            strbuff.delete(index,index+2);
            fullAnserjLabel.setText("");
            fullAnserjLabel.setText(strbuff.toString());
            validate();
        }
        if((fullAnswer.size()>intCount-1)&&(fullAnswer.get(intCount-1)!= null)){
            fullAnswer.remove(intCount-1);
        }
        fullAnswer.add(intCount-1,fullAnserjLabel.getText());
    }
    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {
        String strsub2 = jCheckBox2.getText().substring(0, 1);
        String countStr = countjLabel2.getText();
        int intCount = Integer.parseInt(countStr);
        if(jCheckBox2.isSelected()&&(fullAnserjLabel.getText().indexOf(strsub2)==-1)){
            fullAnserjLabel.setText(strbuff.append(" "+strsub2).toString());
        }
        else if(jCheckBox2.isSelected() == false){
            int index = (fullAnserjLabel.getText()).indexOf(strsub2);
            strbuff.delete(index,index+2);
            fullAnserjLabel.setText("");
            fullAnserjLabel.setText(strbuff.toString());
            validate();
        }
        if((fullAnswer.size()>intCount-1)&&(fullAnswer.get(intCount-1)!= null)){
            fullAnswer.remove(intCount-1);
        }
        fullAnswer.add(intCount-1,fullAnserjLabel.getText());
    }
    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {
        String strsub3 = jCheckBox3.getText().substring(0, 1);
        String countStr = countjLabel2.getText();
        int intCount = Integer.parseInt(countStr);
        if(jCheckBox3.isSelected()&&(fullAnserjLabel.getText().indexOf(strsub3))== -1){
            fullAnserjLabel.setText(strbuff.append(" "+strsub3).toString());
        }
        else if(jCheckBox3.isSelected() == false){
            int index = (fullAnserjLabel.getText()).indexOf(strsub3);
            strbuff.delete(index,index+2);
            fullAnserjLabel.setText("");
            fullAnserjLabel.setText(strbuff.toString());
            validate();
        }
        if((fullAnswer.size()>intCount-1)&&(fullAnswer.get(intCount-1)!= null)){
            fullAnswer.remove(intCount-1);
        }
        fullAnswer.add(intCount-1,fullAnserjLabel.getText());
    }
    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {
        String strsub4 = jCheckBox4.getText().substring(0, 1);
        String countStr = countjLabel2.getText();
        int intCount = Integer.parseInt(countStr);
        if(jCheckBox4.isSelected()&&(fullAnserjLabel.getText().indexOf(strsub4))== -1){
            fullAnserjLabel.setText(strbuff.append(" "+strsub4).toString());
        }
        else if(jCheckBox4.isSelected() == false){
            int index = (fullAnserjLabel.getText()).indexOf(strsub4);
            strbuff.delete(index,index+2);
            fullAnserjLabel.setText("");
            fullAnserjLabel.setText(strbuff.toString());
            validate();
        }
        if((fullAnswer.size()>intCount-1)&&(fullAnswer.get(intCount-1)!= null)){
            fullAnswer.remove(intCount-1);
        }
        fullAnswer.add(intCount-1,fullAnserjLabel.getText());
    }

    /*yezi begin-2013-5-15*/
    /*选择填空题A时的事件*/
    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        String strcountjLabel = countjLabel4.getText();//得到目前是第几题
        String subR1 = jRadioButton7.getText().substring(0, 1);//得到A
        int intcountjLabel = Integer.parseInt(strcountjLabel);
        if((readList.size()>intcountjLabel-1)&&(readList.get(intcountjLabel-1)!= null)){
            readList.remove(intcountjLabel-1);
        }
        readList.add(intcountjLabel-1,subR1);
        readanswer.setText(subR1);
    }
    /*选择填空题B时的事件*/
    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        String strcountjLabel = countjLabel4.getText();
        String subR1 = jRadioButton8.getText().substring(0, 1);
        int intcountjLabel = Integer.parseInt(strcountjLabel);
        if((readList.size()>intcountjLabel-1)&&(readList.get(intcountjLabel-1)!=null)){
            readList.remove(intcountjLabel-1);
        }
        readList.add(intcountjLabel-1,subR1);
        readanswer.setText(subR1);
    }
    /*选择填空题C时的事件*/
    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        String strcountjLabel = countjLabel4.getText();
        String subR1 = jRadioButton9.getText().substring(0, 1);
        int intcountjLabel = Integer.parseInt(strcountjLabel);
        if((readList.size()>intcountjLabel-1)&&(readList.get(intcountjLabel-1)!=null)){
            readList.remove(intcountjLabel-1);
        }
        readList.add(intcountjLabel-1,subR1);
        readanswer.setText(subR1);
    }
    /*选择填空题D时的事件*/
    private void jRadioButton10ActionPerformed(java.awt.event.ActionEvent evt) {
        String strcountjLabel = countjLabel4.getText();
        String subR1 = jRadioButton10.getText().substring(0, 1);
        int intcountjLabel = Integer.parseInt(strcountjLabel);
        if((readList.size()>intcountjLabel-1)&&(readList.get(intcountjLabel-1)!=null)){
            readList.remove(intcountjLabel-1);
        }
        readList.add(intcountjLabel-1,subR1);
        readanswer.setText(subR1);
    }
    /*yezi end-2013-5-15     2023-7-5 真是13年的上古代码*/
    private void downanswerjButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        strbuff.delete(0, strbuff.length());
        String strListid = "";
        fullAnserjLabel.setText("");
        String count = countjLabel2.getText();
        int countText = Integer.parseInt(count);
        if((jCheckBox1.isSelected() == false)&&(jCheckBox2.isSelected() == false)
                &&(jCheckBox3.isSelected() == false)&&(jCheckBox4.isSelected() == false)){
            JOptionPane.showMessageDialog(this, "请回答完这道题后再执行该操作", "消息对话框",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!count.equals(""+moreCount)){
            int newCount = countText + 1;
            Question questions = new Question();
            questions.setId(exitcount[countText]);
            countjLabel2.setText(""+newCount);
            FindQuestionDao findQDao = new FindQuestionDao();
            Question ques = findQDao.getQuestion(questions);
            morejTextArea.setText(ChDeal.toChinese(ques.getQ_subject()));
            if(fullAnswer.size() > countText){
                for(int i = 0;i<fullAnswer.size();i++){
                    strListid = fullAnswer.get(countText).toString();
                }
            }
            jCheckBox1.setSelected(false);
            jCheckBox2.setSelected(false);
            jCheckBox3.setSelected(false);
            jCheckBox4.setSelected(false);
            String[] strList = ChDeal.str2IntegerArr(strListid);
            if(strList != null){
                for(int i = 0;i<strList.length;i++){
                    String strListidcount = strList[i];
                    if(!(strListidcount.equals(""))
                            &&(jCheckBox1.getText().substring(0, 1)).equals(strListidcount)){
                        jCheckBox1.setSelected(true);
                    }
                    else if(!(strListidcount.equals(""))
                            &&(jCheckBox2.getText().substring(0, 1).equals(strListidcount))){
                        jCheckBox2.setSelected(true);
                    }
                    else if(!(strListidcount.equals(""))
                            &&(jCheckBox3.getText().substring(0,1).equals(strListidcount))){
                        jCheckBox3.setSelected(true);
                    }
                    else if(!(strListidcount.equals(""))
                            &&(jCheckBox4.getText().substring(0,1).equals(strListidcount))){
                        jCheckBox4.setSelected(true);
                    }
                }
            }
            jCheckBox1.setText("A:  "+ChDeal.toChinese(ques.getOptionA()));
            jCheckBox2.setText("B:  "+ChDeal.toChinese(ques.getOptionB()));
            jCheckBox3.setText("C:  "+ChDeal.toChinese(ques.getOptionC()));
            jCheckBox4.setText("D:  "+ChDeal.toChinese(ques.getOptionD()));
            strbuff.append(strListid);
            fullAnserjLabel.setText(strbuff.toString());
        }
        else{
            for(int i = 0;i<fullAnswer.size();i++){
                strListid = fullAnswer.get(i).toString();
            }
            strbuff.append(strListid);
            System.out.println("STRLISTID "+strListid);
            fullAnserjLabel.setText(strbuff.toString());
            JOptionPane.showMessageDialog(this, "已经是最后一题！", "信息对话框",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void run() {
        int grade = 0;
        FindStat findStat = new FindStat();
        Stat stat = new Stat();
        stat.setId(1);
        Stat st = findStat.getStat(stat);
        int examtime = st.getExam_time();
        long time = (long) (examtime * 60 * 1000L);
        Date date = new Date();
        StringWriter swer = new StringWriter();
        StringBuffer sbf = swer.getBuffer();
        PrintWriter pw = new PrintWriter(swer);
        long cur = 0L;
        long end = System.currentTimeMillis() + time;
        while ((cur = end - System.currentTimeMillis()) > 0) {
            date.setTime(cur);
            pw.format("%1$tM:%1$tS", date);
            pw.flush();
            spareLabel.setText(sbf.toString());
            sbf.setLength(0);
            try {
                Thread.sleep(6L);
            } catch (InterruptedException e) {
            }
        }
        spareLabel.setText("00:00");
        try {
            Thread.sleep(1200L);
        } catch (InterruptedException e) {

        }
        spareLabel.setText("时间到!!!");
        JOptionPane.showMessageDialog(this, "强制交卷!", "消息对话框",
                JOptionPane.WARNING_MESSAGE);
        getGread();
    }


}
