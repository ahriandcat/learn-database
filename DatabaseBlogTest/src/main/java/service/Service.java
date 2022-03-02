package service;

import models.PostTest1;
import models.PostTest2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    static Scanner sc = new Scanner(System.in);
    ConnectDatabase connectDatabase = new ConnectDatabase();
    Connection conn = connectDatabase.connect();

    public ArrayList<PostTest1> getAllPostByStatus(String postStatus){
        String query = "SELECT p.id ,p.title ,p.description ,p.thumnail, p.create_at \n" +
                "FROM post p \n" +
                "WHERE p.status = "+ "'"+postStatus+"'";
        ArrayList<PostTest1> list = new ArrayList<>();

        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);
            while (result.next()){
                int id = result.getInt("id");
                String title = result.getString("title");
                LocalDate date = LocalDate.parse(result.getString("create_at"));
                String description = result.getString("description");
                String thumnail = result.getString("thumnail");


                list.add(new PostTest1(id,title,date,description,thumnail));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public void show(ArrayList<?> list){
        list.stream().forEach(i -> System.out.println(i));
    }

    public ArrayList<PostTest2> getPostById1(){
        String query = "SELECT p.id ,p.title ,p.content,a.name,p.create_at,JSON_ARRAYAGG(JSON_OBJECT('tag_name',t.name)) AS tag_info\n" +
                "FROM post p INNER JOIN post_tag pt \n" +
                "ON p.id = pt.id_post \n" +
                "INNER JOIN tag t ON t.id = pt.id_tag \n" +
                "INNER JOIN author a ON p.id_author = a.id \n" +
                "WHERE p.id = 1";
        ArrayList<PostTest2> list = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);
            while (result.next()){
                int id = result.getInt("id");
                String title = result.getString("title");
                LocalDate date = LocalDate.parse(result.getString("create_at"));
                String content = result.getString("content");
                String name = result.getString("name");
                String tag_info = result.getString("tag_info");


                list.add(new PostTest2(id,title,date,content,name,tag_info));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void addNewPost(){
        System.out.println("Nhập tiêu đề :");
        String title = sc.nextLine();
        System.out.println("Nhập nội dung :");
        String content = sc.nextLine();
        System.out.println("Nhập mô tả :");
        String description = sc.nextLine();
        System.out.println("Nhập trạng thái :");
        String status = sc.nextLine();
        String query = "INSERT INTO `post`(`id`, `title`, `content`, `description`, `thumnail`, `id_category`, `id_author`, `create_at`, `status`) " +
                "VALUES (NULL,'"+title+"','"+content+"','"+description+"',NULL,NULL,NULL,CURRENT_DATE(),'"+status+"')";

        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            System.out.println("Thêm thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePostById1(){
        System.out.println("Nhập id post muốn xóa");
        int id = sc.nextInt();
        String query = "DELETE FROM `post` WHERE id = "+id;
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            System.out.println("Xóa thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTitleAndContentById(){
        System.out.println("Nhập id post :");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tiêu đề mới :");
        String title = sc.nextLine();
        System.out.println("Nhập nội dung mới :");
        String content = sc.nextLine();

        String query = "UPDATE `post` SET `title`='"+title+"',`content`='"+content+"' WHERE id = "+id;

        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            System.out.println("Sửa thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
