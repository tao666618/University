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
                grade.setId(rs.getInt("id"));
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
                grade.setId(rs.getInt("id"));
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

    //按id号查找考试科目，传入一个参数user_id，返回一个String类型的科目名，从exam_student_connection表中查找user_id对应的subject
    public String getSubject(int id) {
        String strSql = "select * from exam_student_connection where user_id=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String subject = null;
        try {
            pstmt = conn.prepareStatement(strSql);//
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                subject = rs.getString("subject");
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
        return subject;
    }









    public static void main(String[] args) {

        FindGrade fg = new FindGrade();
        String subject = fg.getSubject(12);
        System.out.println("科目为: " + subject);
    }

}
