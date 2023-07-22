package com.Exam.bean;

/**
 * 该类用于存储用户信息
 * 用户名、用户类型、用户名密码、用户ID、是否参加考试
 * tao
 */
public class User {
  private int id;
  private int UserType;// 用户类型
  private String  UserName;// 用户名
  private String PassWord;// 用户密码
  private int haveIn;// 是否参加考试
public int getHaveIn() {
	return haveIn;
}
public void setHaveIn(int haveIn) {
	this.haveIn = haveIn;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPassWord() {
	return PassWord;
}
public void setPassWord(String passWord) {
	PassWord = passWord;
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public int getUserType() {
	return UserType;
}
public void setUserType(int userType) {
	UserType = userType;
}
  
}
