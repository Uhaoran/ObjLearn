/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objlearn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import objlearn.entity.UserInfoEntity;

/**
 *
 * @author WU HAORAN
 */
public class UserInfoDao {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    //接続文字列
    final String url = "jdbc:postgresql://localhost:5432/hr";
    final String user = "postgres";
    final String password = "postgres";

    /**
     * ユーザー作成
     *
     * @param entity
     */
    public void createUserInfo(UserInfoEntity entity) {

        try {

            //PostgreSQLへ接続
            conn = DriverManager.getConnection(url, user, password);
            //SELECT文の実行
            stmt = conn.createStatement();
            //sqlに新しデータの挿入
            String sql = "INSERT \n"
                    + "INTO public.user_info_tbl(name -- 名前\n"
                    + ", user_id -- ユーザーID\n"
                    + ", age -- 年齢\n"
                    + ") \n"
                    + "VALUES ('" + entity.getName() + "'-- 名前\n"
                    + ", '" + entity.getUserId() + "' -- ユーザーID\n"
                    + ", " + entity.getAge() + " -- 年齢\n"
                    + ")";
            stmt.executeUpdate(sql);
            //最後にclose
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<UserInfoEntity> selectUserInfo() {

        List<UserInfoEntity> list = new ArrayList<>();

        try {

            //PostgreSQLへ接続
            conn = DriverManager.getConnection(url, user, password);
            //SELECT文の実行
            stmt = conn.createStatement();
            //sqlに新しデータの挿入
            String sql = "select * from user_info_tbl;";
            rset = stmt.executeQuery(sql);

            if (rset != null) {

                while (rset.next()) {

                    UserInfoEntity entity = new UserInfoEntity();
                    entity.setName(rset.getString(1));
                    entity.setUserId(rset.getString(2));
                    entity.setAge(rset.getInt(3));

                    list.add(entity);
                }

            }

            //最後にclose
            rset.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

}
