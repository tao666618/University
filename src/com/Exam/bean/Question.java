package com.Exam.bean;

/**
 * 用于存储考试试题的信息,通过该类，可以方便地获取或设置每个试题的各项属性，如题目、选项、答案等信息。
 *tao
 */
public class Question {
 private int id ;// 试题的id
 private int typeid ;// 套题类型的id
 private String q_subject;// 试题题目
 private String q_answer;// 问题答案
 private String optionA;//选项A
 private String optionB;//B
 private String optionC;//C
 private String optionD;//D
 private String note;// 备注
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}
public String getOptionA() {
	return optionA;
}
public void setOptionA(String optionA) {
	this.optionA = optionA;
}
public String getOptionB() {
	return optionB;
}
public void setOptionB(String optionB) {
	this.optionB = optionB;
}
public String getOptionC() {
	return optionC;
}
public void setOptionC(String optionC) {
	this.optionC = optionC;
}
public String getOptionD() {
	return optionD;
}
public void setOptionD(String optionD) {
	this.optionD = optionD;
}
public String getQ_answer() {
	return q_answer;
}
public void setQ_answer(String q_answer) {
	this.q_answer = q_answer;
}
public String getQ_subject() {
	return q_subject;
}
public void setQ_subject(String q_subject) {
	this.q_subject = q_subject;
}
public int getTypeid() {
	return typeid;
}
public void setTypeid(int typeid) {
	this.typeid = typeid;
}
 
}
