package com.Exam.bean;
import java.security.*;

/**
 * 使用MD5对密码进行加密，加密结果为大写形式的十六进制字符串
 */
public class MyMD5 {
	private final String[] hexDigits = {
			"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

	/**
	 *对输入的字符串进行MD5加密并返回MD5加密后的结果。
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
	 * 将一个字节转换成十六进制形式的字符串 - -tao
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
	 * 调用encodeByMD5方法对输入的密码进行加密处理
	 * @param inputString
	 * @return 加密字符串    --tao
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
