package view;

import object.School;
import Manager.SchoolManager;

import java.util.ArrayList;
import java.util.Scanner;

public class SchoolMenu {
    SchoolManager schoolManager = new SchoolManager();
    Scanner intInput = new Scanner(System.in);
    Scanner stringInput = new Scanner(System.in);
    int choice;

    public void showMenu() {

        do {
            System.out.println("======Menu quản lí trường học :=========");
            System.out.println("1.Thêm school:\n2.Xoá school \n3.Edit school \n.4 Search by name :\n.5 : Hiển thị trường học : \n.0. Exit : ");
            System.out.println(" nhập lựa chọn : ");
            choice = intInput.nextInt();
            switch (choice) {
                case 1:
                    showMenuAdd();
                    break;
                case 5:
                    showAll();
                    break;
                case 2:
                    showMenuDelete();
                    break;
                case 3:
                    showMenuEdit();
                    break;

            }
        } while (choice != 0);
    }

    public void showMenuAdd() {
        System.out.println("----Menu thêm trường học----");
        System.out.println("Nhập id trường học mới :");
        int id = intInput.nextInt();
        intInput.nextLine();
        System.out.println("Nhập tên trường học :");
        String name = stringInput.next();
        System.out.println("Nhập địa chỉ :");
        String address = stringInput.next();
        School school = new School(id, name, address);
        schoolManager.add(school);
        System.out.println("thêm thành công !");
    }

    public void showMenuDelete() {
        System.out.println("Nhập id của trường cần xóa :");
        int id = intInput.nextInt();
        schoolManager.remove(id);
        System.out.println("xóa thành công !");
    }

    public School showMenuEdit() {
        System.out.println("Nhập id của trường cần sửa :");
        int id = intInput.nextInt();
        intInput.nextLine();
        System.out.println("Nhập tên trường mới :");
        String name = stringInput.next();
        System.out.println("Nhập địa chỉ mới :");
        String address = stringInput.next();
        School newSchool = new School(id, name, address);
        System.out.println("sửa thành công");
        return newSchool;
    }

    public void showAll() {
        System.out.println("danh sách trường học :");
        ArrayList<School> school = schoolManager.findAll();
        if (school.isEmpty()) {
            System.out.println("danh sách trường học trống !");
        } else {
            for (School schools : school) {
                System.out.println(schools);

            }

        }
    }
}
