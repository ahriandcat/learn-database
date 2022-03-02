import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    static Service service = new Service();
    static Scanner sc = new Scanner(System.in);

    public static void menu(){
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("1 - Lấy thông tin của tất cả các bài viết gồm: id, title, description, thumbnail, create_at của các bài viết có status = public");
        System.out.println("2 - Lấy ra id, title, content, author_name, tag, create_at của bài viết có id = 1");
        System.out.println("3 - Cập nhật title và content của bài viết theo id");
        System.out.println("4 - Xóa bài viết theo id");
        System.out.println("5 - Thêm bài viết mới");
        System.out.println("0 - Thoát");
        System.out.println("Nhập lựa chọn : ");
    }

    public static void mainMenu(){
        while (true){
            menu();
            int choose = sc.nextInt();
            switch (choose){
                case 1 -> {
                    ArrayList<PostTest1> list1 = service.getAllPostByStatus("public");
                    service.show(list1);
                }
                case 2 -> {
                    ArrayList<PostTest2> list2 = service.getPostById1();
                    service.show(list2);
                }
                case 3 -> {
                    service.updateTitleAndContentById();
                }
                case 5 ->{
                    service.addNewPost();
                }
                case 4 ->{
                    service.deletePostById1();
                }
            }
        }
    }
}
