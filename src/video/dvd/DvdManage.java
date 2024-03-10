package video.dvd;

import video.common.Appservice;

import java.util.List;
import java.util.Map;

import static video.dvd.repository.DvdRepository.*;
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
                    addNewDvd();
//                    join();
                    break;
                case 3: // DVD 검색
                    searchDvd();
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
        Map<Integer, Dvd> dvdList = getDvdDatabase();
        System.out.println("\n====================== 우리 가게 DVD 목록 ====================");
        for (Dvd dvd : dvdList.values()) {
            System.out.println(dvd);
        }
    }

    private static void addNewDvd() {
        System.out.println("\n========== 신규 Dvd를 등록합니다. ===========");
        String title = inputInfo("제목: ");
        String nation = inputInfo("국가: ");
        int madeYear = inputNumber("제작연도: ");
        Dvd newDvd = new Dvd(title, nation, madeYear);
        addDvd(newDvd);
        System.out.println("********* 등록 완료! *********");
        showDvdList();
    }

    private void searchDvd() {
        System.out.println("\n========== Dvd 검색을 진행합니다. ===========");
        String title = inputInfo("DVD 제목: ");
        List<Dvd> dvdByTitle = findDvdByTitle(title);
        if(dvdByTitle.isEmpty()) {
            System.out.println("*********** 검색 결과가 없습니다 **********");
            return;
        }
        System.out.println("*********** 검색 결과는 다음과 같습니다 **********");
        for (Dvd dvd : dvdByTitle) {
            System.out.println(dvd);
        }

    }
}
