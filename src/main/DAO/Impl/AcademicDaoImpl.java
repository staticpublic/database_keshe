package main.DAO.Impl;

import main.DAO.AcademicDao;
import main.Util.DruidUtil;
import main.pojo.academic;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AcademicDaoImpl implements AcademicDao {
    @Override
    public void updateByCharge(String st_id,String sign) {
        String Academic_UPDATE_SQL = "update academic set chargeSign=? where st_id=? ";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(Academic_UPDATE_SQL);
            psmt.setString(1, st_id);
            psmt.setString(2, sign);
            psmt.executeUpdate();
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateByMentor(String st_id,String sign) {
        String Academic_UPDATE_SQL = "update academic set mentorSign=? where st_id=? ";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(Academic_UPDATE_SQL);
            psmt.setString(1, st_id);
            psmt.setString(2, sign);
            psmt.executeUpdate();
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<academic> verify() {
        String Academic_SELECTALL_SQL = "select * from academic";
        Connection con = null;
        List<academic> list = new ArrayList<>();
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(Academic_SELECTALL_SQL);
            ResultSet rs=psmt.executeQuery();
            while(rs.next()){
                academic a=new academic();
                a.setAc_id(rs.getString("ac_id"));
                a.setAc_img(rs.getString("ac_img"));
                a.setAc_location(rs.getString("ac_location"));
                a.setAc_remarks(rs.getString("ac_remarks"));
                a.setAc_time(rs.getString("ac_time"));
                a.setAc_meetingName(rs.getString("ac_meetingName"));
                a.setAcName(rs.getString("ac_acName"));
                list.add(a);
            }
            psmt.close();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void insertByStudent(academic a) {
        String Academic_INSERT_SQL = "insert into academic values (?,?,?,?,?,?,?,?,?,?)";
        Connection con = null;
        try{
            DruidUtil druidUtil=null;
            DataSource dataSource=druidUtil.getDataSource();
            con=dataSource.getConnection();//获取连接池;
            PreparedStatement psmt = con.prepareStatement(Academic_INSERT_SQL);
            psmt.setString(1, a.getAc_id());
            psmt.setString(2, a.getAc_img());
            psmt.setString(3, a.getAc_meetingName());
            psmt.setString(4, a.getAc_time());
            psmt.setString(5, a.getAc_location());
            psmt.setString(6, a.getAcName());
            psmt.setString(7,a.getAc_remarks());
            psmt.setString(8,a.getMentorSign());
            psmt.setString(9,a.getChargeSign());
            psmt.setString(10, a.getSt_id());
            psmt.executeUpdate();
            psmt.close();


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
