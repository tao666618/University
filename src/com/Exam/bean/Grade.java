package com.Exam.bean;

/**
 * 存储学生的考试成绩并提供相关的访问和修改方法   tao
 */
//这个类用于存储学生的考试成绩
public class Grade { // 学分用户
	private int id;// 考生编号
	private String UserName;// 考生姓名
	private int radioResult;// 单选题得分
	private int fullResule;// 多选题得分
	private int esitResult;// 判断题得分
	private int readResult;// 阅读题得分 yezi-2013-5-14  tao
	private int batsisResult;// 总分
	private String date;// 考试时间

	private String subject;// 科目
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}


	public int getBatsisResult() {
		return batsisResult;
	}
	public void setBatsisResult(int batsisResult) {
		this.batsisResult = batsisResult;
	}
	public int getEsitResult() {
		return esitResult;
	}
	public void setEsitResult(int esitResult) {
		this.esitResult = esitResult;
	}
	public int getFullResule() {
		return fullResule;
	}
	public void setFullResule(int fullResule) {
		this.fullResule = fullResule;
	}
	/* yezi-2013-5-14*/
	public int getReadResult() {
		return readResult;
	}
	public void setReadResult(int readResult) {
		this.readResult = readResult;
	}
	/* yezi-2013-5-14*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRadioResult() {
		return radioResult;
	}
	public void setRadioResult(int radioResult) {
		this.radioResult = radioResult;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
}
