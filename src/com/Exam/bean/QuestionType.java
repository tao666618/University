package com.Exam.bean;

/**
 * 该类用于存储试题类型的信息，并提供了相应的访问和修改方法。
 * 通过该类，可以方便地获取或设置每个试题类型的id和名称信息。
 * 在使用时，可以创建QuestionType对象，然后设置相应的id和名称，或者获取已存储的id和名称信息。
 * tao
 */
public class QuestionType {// 试题类型
	private int id;//问题id
	private String qName;//问题类型名称
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQName() {
		return qName;
	}
	public void setQName(String name) {
		qName = name;
	}
	
}
