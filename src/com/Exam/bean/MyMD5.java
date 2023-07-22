package com.Exam.bean;
import java.security.*;

/**
 * ʹ��MD5��������м��ܣ����ܽ��Ϊ��д��ʽ��ʮ�������ַ���
 */
public class MyMD5 {
	private final String[] hexDigits = {
			"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

	/**
	 *��������ַ�������MD5���ܲ�����MD5���ܺ�Ľ����
	 * @param strMD5
	 * @return
	 */
	public String encodeByMD5(String strMD5){
		if(strMD5 != null){
			try {
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				byte[] results = messageDigest.digest(strMD5.getBytes());
				StringBuffer strb = new StringBuffer();
				for(int i = 0;i<results.length;i++){
					strb.append(byteToHexString(results[i]));
				}
				String strMD = strb.toString();
				return strMD.toUpperCase();
					
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * ��һ���ֽ�ת����ʮ��������ʽ���ַ��� - -tao
	 */
	public String byteToHexString(byte b){
		int n = b;
		if(n <0){
			n = 256 + n;
		}
		int d1 = n /16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
		
	}

	/**
	 * ����encodeByMD5�����������������м��ܴ���
	 * @param inputString
	 * @return �����ַ���    --tao
	 */
	public String createPassWord(String inputString){
		return encodeByMD5(inputString);
	}
	public static void main(String[] args) {
		MyMD5 myMD5 = new MyMD5();
		String password = myMD5.createPassWord("888888");
		System.out.println("PASSWORD1: "+myMD5.createPassWord("888888"));
		System.out.println("PASSWORD: "+password);
	}
	
}
