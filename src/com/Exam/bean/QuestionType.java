package com.Exam.bean;

/**
 * �������ڴ洢�������͵���Ϣ�����ṩ����Ӧ�ķ��ʺ��޸ķ�����
 * ͨ�����࣬���Է���ػ�ȡ������ÿ���������͵�id��������Ϣ��
 * ��ʹ��ʱ�����Դ���QuestionType����Ȼ��������Ӧ��id�����ƣ����߻�ȡ�Ѵ洢��id��������Ϣ��
 * tao
 */
public class QuestionType {// ��������
	private int id;//����id
	private String qName;//������������
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
