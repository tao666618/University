package work;

import com.Exam.sql.GetConn;

import java.sql.Connection;

public class cnnData {


    GetConn getConn = new GetConn();
    private Connection conn = getConn.getConnection();
    //创建一个方法，名为getSubject，输入参数为String类型的subject,返回值为String类型的subject，在exam student connection表中查找user_id
    public int getUserID(String subject){
        int userID = 0;
        String sql = "select * from exam student connection where subject = '"+subject+"'";
        try {
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                userID = rs.getInt("userID");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return userID;
    }
//创建一个方法，名为getSubject，输入参数为int类型的user_id,返回值为String类型的subject,在exam student connection表中查找subject
    public String getSubject(int user_id){
        String subject = null;
        String sql = "select * from exam student connection where user_id = '"+user_id+"'";
        try {
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                subject = rs.getString("subject");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return subject;
    }
}