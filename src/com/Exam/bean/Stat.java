package com.Exam.bean;

public class Stat {
	private int id;
	private int radio_BL;// ��ѡ��������
	private int more_BL;
	private int judge_BL;
	private int read_BL;// �Ķ��������� yezi2013-5-15
	private int radio_FS;
	private int more_FS;
	private int judge_FS;
	private int read_FS;// �Ķ����� yezi2013-5-15
	private int exam_time;// ����ʱ��
	/* yezi2013-5-15*/
	public int getRead_BL() {
		return read_BL;
	}
	public void setRead_BL(int readBL) {
		read_BL = readBL;
	}
	public int getRead_FS() {
		return read_FS;
	}
	public void setRead_FS(int readFS) {
		read_FS = readFS;
	}
	/* yezi2013-5-15*/
	public int getExam_time() {
		return exam_time;
	}
	public void setExam_time(int exam_time) {
		this.exam_time = exam_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJudge_BL() {
		return judge_BL;
	}
	public void setJudge_BL(int judge_BL) {
		this.judge_BL = judge_BL;
	}
	public int getJudge_FS() {
		return judge_FS;
	}
	public void setJudge_FS(int judge_FS) {
		this.judge_FS = judge_FS;
	}
	public int getMore_BL() {
		return more_BL;
	}
	public void setMore_BL(int more_BL) {
		this.more_BL = more_BL;
	}
	public int getMore_FS() {
		return more_FS;
	}
	public void setMore_FS(int more_FS) {
		this.more_FS = more_FS;
	}
	public int getRadio_BL() {
		return radio_BL;
	}
	public void setRadio_BL(int radio_BL) {
		this.radio_BL = radio_BL;
	}
	public int getRadio_FS() {
		return radio_FS;
	}
	public void setRadio_FS(int radio_FS) {
		this.radio_FS = radio_FS;
	}
}
