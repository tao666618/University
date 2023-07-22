package com.Exam.bean;

import java.text.SimpleDateFormat;
import java.util.*;

//�ַ�������

/**
 * �������ڶ��ַ������б���ת��������ʱ���ȡ�Ĵ���
 * tao
 */
public class ChDeal {
	/**
	 *���ַ�����GB2312����ת��ΪGBK���벢���ؽ����
	 * @param strvalue
	 * @return
	 */
	public static String toChinese(String strvalue) {
	try {
		if (strvalue == null) {
			return "";
		} else {
			strvalue = new String(strvalue.getBytes("gb2312"), "GBK")
					.trim();
			return strvalue;
		}
	} catch (Exception e) {
		return "";
	}
}

	/**
	 *
	 * @param strValue
	 * @return ���ַ�����GBK����ת��ΪGB2312���벢���ؽ����
	 */
	public static String toISO(String strValue) {
	try {
		if (strValue == null) {
			return "";
		} else {
			strValue = new String(strValue.getBytes("GBK"), "gb2312")
					.trim();
			return strValue;
		}
	} catch (Exception e) {
		return "";
	}
}

		/**
		 * ��ɴ��ַ�����String�����ת��
		 * 
		 * @param str
		 * @return
		 */
		public static String[] str2IntegerArr(String str){
			String[] is = null ;
			if(str != null && !str.equalsIgnoreCase("")){
				String[] ss = str.split(" ");
				if(ss != null && ss.length > 0){
					is = new String[ss.length];
					for(int i = 0 ; i < ss.length ; i ++){
						is[i] = ss[i];
					}
				}
			}
			return is ;
		}
//		��д������ں�ʱ��ķ�����

	/**
	 *
	 * @return ��ȡ��ǰ���ں�ʱ�䣬����һ����ʽΪ"yyyy-MM-dd HH:mm:ss"������ʱ���ַ���
	 */
	public static String  getDateTime(){						//�÷�������ֵΪString����
	SimpleDateFormat format;                                //simpleDateFormat��ʹ�ÿ���ѡ���κ��û����������-ʱ���ʽ��ģʽ
	Date date = null;
	Calendar myDate = Calendar.getInstance();               //Calendar �ķ��� getInstance���Ի�ô����͵�һ��ͨ�õĶ���
	myDate.setTime(new java.util.Date());                   //ʹ�ø����� Date ���ô� Calendar ��ʱ��
	date = myDate.getTime();                                //����һ����ʾ�� Calendar ʱ��ֵ������Ԫ�����ڵĺ���ƫ�������� Date ����
	format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //����ʱ���ʽΪ���ꡢ�¡��ա�ʱ���֡���
	String strRtn = format.format(date);                    //�������� Date ��ʽ��Ϊ����/ʱ���ַ��������������ֵ���������� String
	return strRtn;
}
}
