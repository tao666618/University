package com.Exam.dao;

import java.sql.*;
import java.util.*;

import com.Exam.bean.*;
import com.Exam.sql.GetConn;

public class InsertUserDao {
    GetConn getConn = new GetConn();
    private Connection conn = getConn.getConnection();

    //增加用户
    public boolean setUserInfoToDBbean(User userinfo) {
        boolean blnrec = true;
        String strSql = "insert into tb_user (id, userType, UserName, passWord, havaIn, subject) values (?, ?, ?, ?, ?, ?)";
        System.out.println(strSql);
        PreparedStatement pstmt = null;
        MyMD5 md = new MyMD5();
        try {
            pstmt = conn.prepareStatement(strSql);
            pstmt.setInt(1, userinfo.getId());
            pstmt.setInt(2, userinfo.getUserType());
            pstmt.setString(3, userinfo.getUserName());
            pstmt.setString(4, userinfo.getPassWord());
            pstmt.setInt(5, userinfo.getHaveIn());
            pstmt.setString(6, null);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            blnrec = false;
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return blnrec;
    }

    //

    /**
     * 修改用户，用于判断用户是否已参加考试
     *
     * @param userinfo 与用户表tb_use对应的Java bean
     * @return 成功修改havaIn值返回true，否则返回false
     */
    public boolean setUserHaveIn(User userinfo) {
        boolean blnrec = true;
        String strSql = "update tb_User set havaIn = ? where id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(strSql);
            pstmt.setInt(1, userinfo.getHaveIn());
            pstmt.setInt(2, userinfo.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            blnrec = false;
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return blnrec;
    }

    //修改用户信息
    public boolean updateUserHaveIn(User userinfo) {
        MyMD5 md = new MyMD5();
        boolean blnrec = true;
        String strSql = "update tb_user set userType =?,UserName=?,passWord=?,havaIn=? " +
                "where Id = ?,subject = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(strSql);
            pstmt.setInt(1, userinfo.getUserType());
            pstmt.setString(2, userinfo.getUserName());
            pstmt.setString(3, userinfo.getPassWord());
            pstmt.setInt(4, userinfo.getHaveIn());
            pstmt.setInt(5, userinfo.getId());
            pstmt.setString(6, userinfo.getSubject());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            blnrec = false;
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return blnrec;
    }

    //修改用户信息二
    public boolean updateUserHaveIn2(User userinfo) {
        boolean success = true;
        String sql = "UPDATE tb_user SET userType=?, UserName=?, havaIn=?, subject=? WHERE N=?";
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userinfo.getUserType());
            pstmt.setString(2, userinfo.getUserName());
            pstmt.setInt(3, userinfo.getHaveIn());
            pstmt.setString(4, userinfo.getSubject());
            pstmt.setInt(5, userinfo.getN());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                success = false;
                System.out.println("No rows were updated."); // Debugging
            }

        } catch (SQLException e) {
            e.printStackTrace();
            success = false;
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;
    }

    public boolean InsertNewData(User userinfo) {
        boolean success = true;
        String sql = "INSERT INTO tb_user (id,userType, UserName,passWord, havaIn, subject) VALUES (?, ?, ?,?,?,?)";
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userinfo.getId());
            pstmt.setInt(2, userinfo.getUserType());
            pstmt.setString(3, userinfo.getUserName());
            pstmt.setString(4, userinfo.getPassWord());
            pstmt.setInt(5, userinfo.getHaveIn());
            pstmt.setString(6, userinfo.getSubject());


            int rowsAffected = pstmt.executeUpdate();//执行更新操作，返回所影响的行数
            if (rowsAffected == 0) {
                success = false;
                System.out.println("No rows were inserted."); // Debugging
            }

        } catch (SQLException e) {
            e.printStackTrace();
            success = false;
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;
    }


    //	修改用户密码信息
    public boolean updateUserPassWord(User userinfo) {
        boolean blnrec = true;
        String strSql = "update tb_user set passWord=? " +
                "where Id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(strSql);
            MyMD5 mymd5 = new MyMD5();
            pstmt.setString(1, mymd5.createPassWord(userinfo.getPassWord()));
            pstmt.setString(1, userinfo.getPassWord());
            pstmt.setInt(2, userinfo.getId());
            //pstmt.setString(3, mymd5.createPassWord(userinfo.getSubject()));
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            blnrec = false;
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return blnrec;
    }


    public static void main(String[] args) {
//		User user = new User();
//		MyMD5 md = new MyMD5();
//		user.setId(99);
//		user.setUserName("kkkkk");
//		user.setHaveIn(0);
//		user.setUserType(0);
        InsertUserDao id = new InsertUserDao();
//		boolean bool = id.setUserInfoToDBbean(user);
//		System.out.println(user.getPassWord());	
    }
}
