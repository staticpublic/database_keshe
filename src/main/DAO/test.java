package main.DAO;

import main.pojo.Admin;
import main.pojo.Student;
import main.pojo.academic;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        /*Admin admin=new Admin();
        admin.setAd_id("001");
        admin.setAd_name("张三");
        admin.setAd_pwd("1");
        DAOFactory.getInstance().getAdminDAO().addAdmin(admin);*/
//        System.out.println("insert:"+admin.toString()+"\n");
        System.out.println("请选择身份：");
        System.out.println("1.研究生\n2.导师\n3.学科负责人");
        System.out.println("请输入你的选择：");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        while (input.next() != null) {
            if (str.equals("1")) {                  //研究生
                System.out.println("请输入学术交流信息：");
                academic a = new academic();
                System.out.println("学术交流id：");
                a.setAc_id(input.next());
                System.out.println("图片：");
                a.setAc_img(input.next());
                System.out.println("报告中英名称");
                a.setAc_meetingName(input.next());
                System.out.println("会议地点：");
                a.setAc_location(input.next());
                System.out.println("会议时间:");
                a.setAc_time(input.next());
                System.out.println("学术交流活动名称:");
                a.setAcName(input.next());
                System.out.println("备注");
                a.setAc_remarks(input.next());
                System.out.println("学生学号：");
                a.setSt_id(input.next());
                DAOFactory.getInstance().getAcademicDao().insertByStudent(a);
            } else if (str.equals("2")) {           //导师
                System.out.println("1.显示学生学术交流情况表\n2.审核签字");
                if (input.next().equals("1")) {
                    System.out.println(DAOFactory.getInstance().getAcademicDao().verify());
                } else if (input.next().equals("2")) {
                    System.out.println("请输学生学号：");
                    String st_id = input.next();
                    System.out.println("签字（通过或不通过）：");
                    String sign = input.next();
                    DAOFactory.getInstance().getAcademicDao().updateByMentor(st_id, sign);
                }
            } else if (str.equals("3")) {           //学科负责人
                System.out.println("1.显示学生学术交流情况表\n2.审核签字");
                if (input.next().equals("1")) {
                    System.out.println(DAOFactory.getInstance().getAcademicDao().verify());
                } else if (input.next().equals("2")) {
                    System.out.println("请输学生学号：");
                    String st_id = input.next();
                    System.out.println("签字（通过或不通过）：");
                    String sign = input.next();
                    DAOFactory.getInstance().getAcademicDao().updateByCharge(st_id, sign);
                }
            }
            System.out.println("请选择身份：");
            System.out.println("1.研究生\n2.导师\n3.学科负责人");
            System.out.println("请输入你的选择：");
        }
    }
}
