package com.Exam.dao;

import java.util.*;
import java.sql.*;

import com.Exam.bean.*;
import com.Exam.sql.GetConn;
import org.junit.Test;

public class FindGrade {
    GetConn getConn = new GetConn();
    private Connection conn = getConn.getConnection();

    //查找所有学分用户
    public List findGrade() {
        String strSql = "select * from tb_grade";
        Statement pstmt = null;
        ResultSet rs = null;
        List lstList = new ArrayList();
        try {
            pstmt = conn.createStatement();
            rs = pstmt.executeQuery(strSql);
            while (rs.next()) {
                Grade grade = new Grade();
                grade.setId(rs.getInt("id"));
                grade.setUserName(rs.getString("userName"));
                grade.setRadioResult(rs.getInt("radioResult"));
                grade.setFullResule(rs.getInt("fullResule"));
                grade.setEsitResult(rs.getInt("esitResult"));
                grade.setReadResult(rs.getInt("readResult"));/*yezi-2013_5-14*/
                grade.setBatsisResult(rs.getInt("batsisResult"));
                grade.setDate(rs.getString("date"));
                lstList.add(grade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    rs.close();
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lstList;
    }
    public List findGrade1() {
        String strSql = "select * from tb_grade";
        Statement pstmt = null;
        ResultSet rs = null;
        List lstList = new ArrayList();
        try {
            pstmt = conn.createStatement();
            rs = pstmt.executeQuery(strSql);
            while (rs.next()) {
                Grade grade = new Grade();
                grade.setSubject(rs.getString("subject"));
                grade.setUserName(rs.getString("userName"));
                grade.setRadioResult(rs.getInt("radioResult"));
                grade.setFullResule(rs.getInt("fullResule"));
                grade.setEsitResult(rs.getInt("esitResult"));
                grade.setReadResult(rs.getInt("readResult"));/*yezi-2013_5-14*/
                grade.setBatsisResult(rs.getInt("batsisResult"));
                grade.setDate(rs.getString("date"));
                grade.setId(rs.getInt("id"));
                lstList.add(grade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    rs.close();
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lstList;
    }


    //按id号查询成绩方法

    /**
     * @param grade 对应考分表Java bean Grade对象
     * @return Grade对象
     */
    public Grade getGradeID(Grade grade) {
        String strSql = "select * from tb_grade where id=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(strSql);
            pstmt.setInt(1, grade.getId());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                grade.setSubject(rs.getString("subject"));
                grade.setUserName(rs.getString("userName"));
                grade.setRadioResult(rs.getInt("radioResult"));
                grade.setFullResule(rs.getInt("fullResule"));
                grade.setEsitResult(rs.getInt("esitResult"));
                grade.setReadResult(rs.getInt("readResult"));/*yezi-2013_5-14*/
                grade.setBatsisResult(rs.getInt("batsisResult"));
                grade.setDate(rs.getString("date"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    rs.close();
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return grade;
    }
    //按考生姓名查找考试成绩方法

    /**
     * @param grade 与数据表tb_stat对应的java bean Stat对象
     * @return Stat对象
     */
    public Grade getGradeName(Grade grade) {
        String strSql = "select * from tb_grade where userName=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(strSql);
            pstmt.setString(1, grade.getUserName());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                grade.setSubject(rs.getString("subject"));
                grade.setUserName(rs.getString("userName"));
                grade.setRadioResult(rs.getInt("radioResult"));
                grade.setFullResule(rs.getInt("fullResule"));
                grade.setEsitResult(rs.getInt("esitResult"));
                grade.setReadResult(rs.getInt("readResult"));/*yezi-2013_5-14*/
                grade.setBatsisResult(rs.getInt("batsisResult"));
                grade.setDate(rs.getString("date"));
                grade.setId(rs.getInt("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    rs.close();
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return grade;
    }

    //按id号查找考试科目，传入一个参数user_id，返回一个List<String>类型的科目名列表，从tb_user表中查找user_id对应的subject
    public List<String> getSubjects(int id) {
        String strSql = "SELECT subject FROM tb_user WHERE id=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<String> subjects = new ArrayList<>();

        try {
            pstmt = conn.prepareStatement(strSql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                subjects.add(rs.getString("subject"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    rs.close();
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return subjects;
    }


    //传入一个String类型的科目名和一个String类型的用户名，在tb_grade表中新建一条记录，将科目名和用户名插入到新建的对应列中
//    public void insertGrade(String subject, String userName) {
//        String strSql = "insert into tb_grade(subject,userName) values(?,?)";
//        PreparedStatement pstmt = null;
//        try {
//            pstmt = conn.prepareStatement(strSql);
//            pstmt.setString(9, subject);
//            pstmt.setString(2, userName);
//            pstmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (pstmt != null) pstmt.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }

//根据id号在tb_user表中查找havaIn值
public int getHaveInValue(int userId) {
    String strSql = "SELECT havaIn FROM tb_user WHERE id=?";
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    int haveInValue = -1; // 默认值，表示查找失败

    try {
        pstmt = conn.prepareStatement(strSql);
        pstmt.setInt(1, userId);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            haveInValue = rs.getInt("havaIn");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (pstmt != null) {
                rs.close();
                pstmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    return haveInValue;
}

    //编写一个方法，使用id号与subject科目名在tb_user表中查找N值
    public int getNForIdAndSubject(int userId, String subject) {
        String strSql = "SELECT N FROM tb_user WHERE id=? AND (subject=? OR subject IS NULL)";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int NValue = -1; // 默认值，表示查找失败

        try {
            pstmt = conn.prepareStatement(strSql);
            pstmt.setInt(1, userId);
            pstmt.setString(2, subject);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                NValue = rs.getInt("N");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    rs.close();
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return NValue;
    }


    //编写一个方法，使用id号与havaln号在tb_user表中查找N值
    public int getNForIdAndHavaIn(int userId, int havaIn,String subject) {
        String strSql = "SELECT N FROM tb_user WHERE id=? AND havaIn=? AND subject=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int NValue = -1; // 默认值，表示查找失败

        try {
            pstmt = conn.prepareStatement(strSql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, havaIn);
            pstmt.setString(3, subject);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                NValue = rs.getInt("N");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    rs.close();
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return NValue;
    }

    //根据用户id号与科目名在tb_user表中查找havaIn值
    public int getHavalnForIdAndSubject(int id , String subject){
        String sql = "SELECT havaIn FROM tb_user WHERE id=? AND subject=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int havaInValue = -1; // 默认值，表示查找失败
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.setString(2,subject);
            rs = pstmt.executeQuery();
            if(rs.next()){
                havaInValue = rs.getInt("havaIn");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstmt != null){
                    rs.close();
                    pstmt.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return havaInValue;


    }




    public static void main(String[] args) {
        FindGrade findGrade = new FindGrade();
       List<String> fi=findGrade.getSubjects(19);
        System.out.println("findGrade = " + fi);
    }

}
