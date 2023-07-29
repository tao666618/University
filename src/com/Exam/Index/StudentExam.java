/*
 * StudentExam.java
 *
 * Created on 2008年8月2日, 上午10:04
 */
package com.Exam.Index;

import java.util.List;

import javax.swing.JOptionPane;

import com.Exam.bean.*;
import com.Exam.dao.*;
import com.Exam.student.ExamPage;

/*
 * 学生考试界面
 */
public class StudentExam extends javax.swing.JFrame {
   /*
    * 保存学生信息
    */
    public StudentExam() {
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
    	jPanel = new MySudentExamJPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        FilejMenu = new javax.swing.JMenu();//"考试"
        openjMenuItem = new javax.swing.JMenuItem();//"开始考试"
        closeMenuItem = new javax.swing.JMenuItem();//"退出"
        watchjMenu = new javax.swing.JMenu();//"查看"
        sleanjMenuItem = new javax.swing.JMenuItem();//"查分"
        amendpassjMenuItem = new javax.swing.JMenuItem();//"修改密码"
        aboutjMenu = new javax.swing.JMenu();//"关于"
        aboutExamMenuItem = new javax.swing.JMenuItem();//"本次考试"
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        FilejMenu.setText("考试");
        setTitle("考试系统");
        openjMenuItem.setText("开始考试");
        openjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openjMenuItemActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        FilejMenu.add(openjMenuItem);

        closeMenuItem.setText("退出");
        closeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeMenuItemActionPerformed(evt);
            }
        });
        FilejMenu.add(closeMenuItem);

        jMenuBar1.add(FilejMenu);

        watchjMenu.setText("查看");

        sleanjMenuItem.setText("查分");
        sleanjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sleanjMenuItemActionPerformed(evt);
            }
        });
        watchjMenu.add(sleanjMenuItem);

        amendpassjMenuItem.setText("修改密码");
        amendpassjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amendpassjMenuItemActionPerformed(evt);
            }
        });
        watchjMenu.add(amendpassjMenuItem);

        jMenuBar1.add(watchjMenu);

        aboutjMenu.setText("关于");

        aboutExamMenuItem.setText("本次考试");
        aboutExamMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutExamMenuItemActionPerformed(evt);
            }
        });
        aboutjMenu.add(aboutExamMenuItem);

        jMenuBar1.add(aboutjMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
        pack();
    }

private void openjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
	java.io.File file = new java.io.File("save.txt");
	try{
		java.io.FileInputStream in = new java.io.FileInputStream(file);		
		byte byt[] = new byte[1024];					
		int len = in.read(byt);						
		String strid = new String(byt,0,len);	
		int id = Integer.parseInt(strid);
		MyFindUserDao findUser = new MyFindUserDao();
		User user = new User();
		user.setId(id);		
		User use = findUser.getUserID(user);
		System.out.println("AAA"+use.getId());
		if(use.getHaveIn() == 0){
			ExamPage exampage = new ExamPage();
			exampage.setVisible(true);
			InsertUserDao insertUser = new InsertUserDao();
			use.setHaveIn(0);/*yezi-2013-5-15*/
			boolean b = insertUser.setUserHaveIn(use);	
		}
		else if(use.getHaveIn() == 1){
			JOptionPane.showMessageDialog(this, "你已经参加完考试了！", "信息对话框",JOptionPane.WARNING_MESSAGE);
		}
		in.close();	
	}catch (Exception e) {
		e.printStackTrace();							
	}
}
private void closeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
	int n = JOptionPane.showConfirmDialog(this, "确定要退出考试吗？", "确认对话框", JOptionPane.WARNING_MESSAGE);
	if(n == JOptionPane.YES_OPTION){
		System.exit(0);
	}
}
/*查分操作*/
private void sleanjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
	java.io.File file = new java.io.File("save.txt");
	try{
		java.io.FileInputStream in = new java.io.FileInputStream(file);		
		byte byt[] = new byte[1024];					
		int len = in.read(byt);						
		String strid = new String(byt,0,len);	
		int id = Integer.parseInt(strid);
		FindGrade findGrade = new FindGrade();
		Grade grage = new Grade();
		grage.setId(id);
		Grade gra = findGrade.getGradeID(grage);
		int radioMark = gra.getRadioResult();
		int fullMark = gra.getFullResule();
		int judgeMark = gra.getEsitResult();
		int readMark = gra.getRadioResult();/*yezi 2013-5-14*/
		int bastMark = gra.getBatsisResult();
		int sum = radioMark+fullMark+judgeMark+readMark;/*yezi 2013-5-14*/
		JOptionPane.showMessageDialog(this, "单选题得分："+radioMark+"\n"+"多选题得分："+fullMark+"\n"+"判断题得分："+judgeMark+"\n"+"阅读题得分："+radioMark+"\n"+"总分："+sum,"信息对话框", JOptionPane.WARNING_MESSAGE);
		/*yezi-2013-5-14*/
		in.close();									
	}catch (Exception e) {
		e.printStackTrace();							
	}	
}
private void amendpassjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
	dispose();
	MySetPassWord setPassWord  = new MySetPassWord();
	setPassWord.setVisible(true);
	setPassWord.setTitle("修改密码");
	setPassWord.setBounds(200, 150 , 400 ,200);
}	

private void aboutExamMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
	dispose();
	MyAbout myAbout = new MyAbout();
	myAbout.setVisible(true);
	myAbout.setTitle("关于本次考试");
	myAbout.setBounds(200, 150, 450,280);	
}   
    private javax.swing.JMenu FilejMenu;
    private javax.swing.JMenuItem aboutExamMenuItem;
    private javax.swing.JMenu aboutjMenu;
    private javax.swing.JMenuItem amendpassjMenuItem;
    private javax.swing.JMenuItem closeMenuItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem openjMenuItem;
    private javax.swing.JMenuItem sleanjMenuItem;
    private javax.swing.JMenu watchjMenu;
    private MySudentExamJPanel jPanel;
}
