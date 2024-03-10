package video.ui;

import java.util.Scanner;

public class AppUi {
    private static final Scanner sc;
    static {
        sc = new Scanner(System.in);
    }

    public static int inputNumber(String message) {
        System.out.print(message);
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }

    public static String inputInfo(String message) {
        System.out.print(message);
        return sc.nextLine();
    }
    public static void showMain() {
        System.out.println("\n========== DVD 대여 관리 시스템 ==========");
        System.out.println("##### 1. 회원 관리");
        System.out.println("##### 2. DVD 대여 및 반납 관리");
        System.out.println("##### 3. DVD 관리");
        System.out.println("##### 4. 프로그램 종료");
        System.out.println("==========================================");
    }

    public static void showUserManageMenu() {
        System.out.println("\n========== 회원 관리 메뉴입니다 ==========");
        System.out.println("##### 1. 회원 목록 보기");
        System.out.println("##### 2. 신규 회원 추가");
        System.out.println("##### 3. 회원 검색");
        System.out.println("##### 4. 회원 삭제");
        System.out.println("##### 5. 상위 메뉴로 돌아가기");
        System.out.println("==========================================");
    }

    public static void showDvdManageMenu() {
        System.out.println("\n========== DVD 관리 메뉴입니다 ==========");
        System.out.println("##### 1. 보유 DVD 목록 보기");
        System.out.println("##### 2. 신규 DVD 추가");
        System.out.println("##### 3. DVD 검색");
        System.out.println("##### 4. DVD 삭제");
        System.out.println("##### 5. 상위 메뉴로 돌아가기");
        System.out.println("==========================================");
    }

    public static void showRentManageMenu() {
        System.out.println("\n========== DVD 대여 및 반납 관리 메뉴입니다 ==========");
        System.out.println("##### 1. DVD 대여하기");
        System.out.println("##### 2. DVD 반납 처리");
        System.out.println("##### 3. 상위 메뉴로 돌아가기");
        System.out.println("==========================================");
    }
}
