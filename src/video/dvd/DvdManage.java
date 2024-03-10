package video.dvd;

import video.common.Appservice;
import video.dvd.repository.DvdRepository;
import video.user.repository.UserRepository;

import java.util.Map;

import static video.ui.AppUi.*;


public class DvdManage implements Appservice {
    @Override
    public void start() {
        while (true) {
            showDvdManageMenu();
            int num = inputNumber(">>> ");
            switch (num) {
                case 1: // DVD 목록 보기
                    showDvdList();
                    break;
                case 2: // DVD 추가
//                    join();
                    break;
                case 3: // DVD 검색
//                    search();
                    break;
                case 4: // DVD 삭제
//                    delete();
                    break;
                case 5: // 상위 메뉴 이동
                    return;
                default:
                    System.out.println("없는 메뉴 번호에요ㅠㅠ");
            }

        }
    }

    private static void showDvdList() {
        Map<Integer, Dvd> dvdList = DvdRepository.getDvdDatabase();
        System.out.println("====================== 우리 가게 DVD 목록 ====================");
        for (Dvd dvd : dvdList.values()) {
            System.out.println(dvd);
        }
    }
}
