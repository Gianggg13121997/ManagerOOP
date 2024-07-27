package view;

import java.util.Scanner;

public class MainMenu {
   private StudentMenu studentMenu = new StudentMenu();
   private SchoolMenu schoolMenu = new SchoolMenu();
   Scanner input = new Scanner(System.in);
   public void selectMenu(){
       int choice;
       do{
           System.out.println("==========Trang chủ===========");
           System.out.println("1.Quản lí học sinh :\n2.Quản lí trường học\n0.Thoát :");
           System.out.println("Nhập lựa chọn :");
           choice = input.nextInt();
           switch(choice){
               case 1:
                   studentMenu.showMenu();
                   break;
               case 2 :
                   schoolMenu.showMenu();
               case 0 :
                   break;
               default :
                   System.out.println("Không có lựa chọn !");
           }
       }while(choice != 0);
   }


}
