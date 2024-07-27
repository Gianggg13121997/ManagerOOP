package view;

import Manager.StudentManager;
import object.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMenu {
    StudentManager studentManager = new StudentManager();
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public void showMenu() {
        int choice;
        do {
            System.out.println("========Menu quản lí học sinh :=========");
            System.out.println("1.Thêm học sinh :\n2.Xoá học sinh :\n3.Sửa thông tin hs : \n4.Hiển thị thông tin\n5.Tìm hs theo tên gần đúng :\n6.Tìm hs theo độ tuổi :\n0.Exit:");
            System.out.println("Nhập lựa chọn :");
            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    showMenuAdd();
                    break;
                case 4:
                    showAll();
                    break;
                case 2:
                    showMenuRemove();
                    break;
                case 3:
                    showMenuEdit();
                    break;
                case 5:
                    showMenuSearchByName();
                    break;
                case 6:
                    showMenuSearchByAge();
                    break;


            }
        } while (choice != 0);
    }

    public void showMenuAdd() {
        System.out.println("========Menu thêm học sinh :=========");
        System.out.println("Nhập id");
        int id = inputInt.nextInt();
        System.out.println("Nhập tên :");
        String name = inputString.nextLine();
        System.out.println("Nhập tuổi :");
        int age = inputInt.nextInt();
        System.out.println("Nhập điểm <max 3 loại điểm>");
        ArrayList<Integer> scores = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Nhập điểm thứ :" + (i + 1) + ":");
            int score = inputInt.nextInt();
            scores.add(score);
        }
        Student student = new Student(id, name, age, scores);
        studentManager.add(student);
        System.out.println("Thêm thành công !");

    }

    public void showAll() {
        System.out.println("=========== Danh Sách Các Học Sinh : ==========");

        ArrayList<Student> students = studentManager.findAll();

        if (students.isEmpty()) {
            System.out.println("Danh sách học sinh trống.");
        } else {
            for (Student student : students) {
                System.out.println("ID: " + student.getId() +
                        ", Tên: " + student.getName() +
                        ", Tuổi: " + student.getAge() +
                        ", Điểm số: " + student.getScore());
            }
        }
    }

    public void showMenuRemove() {
        System.out.println("Nhập id học sinh  cần xoá : ");
        int id = inputInt.nextInt();
        studentManager.remove(id);
        System.out.println("xoá thành công !");
    }

    public Student showMenuEdit() {
        System.out.println("=======Menu chỉnh sửa thông tin học sinh========");
        System.out.println("Nhập id học sinh cần sửa : ");
        int id = inputInt.nextInt();
        System.out.println("Nhập tên cần sửa : ");
        String name = inputString.nextLine();
        System.out.println("Nhập tuổi :");
        int age = inputInt.nextInt();
        System.out.println("Nhập điểm <max 3 loại điểm>");
        ArrayList<Integer> scores = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Nhập điểm thứ :" + (i + 1) + ":");
            int score = inputInt.nextInt();
            scores.add(score);
        }
        Student newStudent = new Student(id, name, age, scores);
        studentManager.edit(id, newStudent);

        System.out.println("sửa thành công !");
        return newStudent;
    }

    public ArrayList<Student> showMenuSearchByName() {
        System.out.println("Nhập tên học sinh cần tìm kiếm:");
        String name = inputString.nextLine();

        ArrayList<Student> results = studentManager.searchByName(name);

        if (results.isEmpty()) {
            System.out.println("Không tìm thấy học sinh với tên gần đúng.");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (Student student : results) {
                System.out.println("ID: " + student.getId() +
                        ", Tên: " + student.getName() +
                        ", Tuổi: " + student.getAge() +
                        ", Điểm số: " + student.getScore());
            }

        }
        return results;
    }

    public ArrayList<Student> showMenuSearchByAge() {
        System.out.println("Bạn muốn tìm kiếm học trong trong khoảng tuổi từ :");
        int minage = inputInt.nextInt();
        System.out.println("đến khoảng tuổi từ :");
        int maxage = inputInt.nextInt();
        ArrayList<Student>result = studentManager.searchByAge(minage, maxage);
        if (result.isEmpty()) {
            System.out.println("Không tìm thấy hs trong khoảng tuổi này !");
        }else {
            System.out.println("Kết quả tìm kiếm :");
            for (Student student : result) {
                System.out.println("ID: " + student.getId() +
                        ", Tên: " + student.getName() +
                        ", Tuổi: " + student.getAge() +
                        ", Điểm số: " + student.getScore());
            }
            } return result;
        }
    }
