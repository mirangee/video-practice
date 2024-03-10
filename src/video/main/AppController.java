package video.main;

import video.common.Appservice;
import video.dvd.service.DvdManage;
import video.user.service.UserManage;

public class AppController {

    private Appservice service;

    public void selectMenu(int num) {
        switch (num) {
            case 1: // 회원 관리
                service = new UserManage();
                break;
            case 2: // DVD 대여 및 반납 관리

                break;
            case 3: // DVD 관리
                service = new DvdManage();
                break;
            case 4: // 프로그램 종료
                System.out.println("***** 프로그램을 종료합니다 *****");
                System.exit(0);
                return;
            default:
                System.out.println("없는 메뉴 번호에요ㅠㅠ");
        }

        service.start();
    }

}
