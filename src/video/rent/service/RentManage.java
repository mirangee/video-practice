package video.rent.service;

import video.common.Appservice;
import video.dvd.domain.Dvd;
import video.dvd.repository.DvdRepository;
import video.rent.domain.Rent;
import video.user.domain.User;

import java.util.List;
import java.util.Map;

import static video.ui.AppUi.*;
import static video.user.repository.UserRepository.findUserByName;

public class RentManage implements Appservice {
    @Override
    public void start() {
        while (true) {
            showRentManageMenu();
            int num = inputNumber(">>> ");
            switch (num) {
                case 1: // DVD 대여 처리
                    rentDvd();
                    break;
                case 2: // DVD 반납 처리
                    returnDvd();
                    break;
                case 3: // 상위 메뉴 이동
                    return;
                default:
                    System.out.println("없는 메뉴 번호에요ㅠㅠ");
            }

        }
    }

    private void rentDvd() {
        System.out.println("\n========== DVD 대여 처리 코너입니다 ==========");
        System.out.println("1. 대여 가능 DVD 목록 조회 | 2. 대여 중인 DVD 반납예정일 조회 | 3. 상위 메뉴로 이동 ");
        int num = inputNumber(">>> ");
        switch (num) {
            case 1: // DVD 대여 가능 목록 조회
                searchAvailableDvd();
                break;
            case 2: // 대여 중인 DVD 목록 조회
                searchNotAvailableDvd();
                break;
            case 3: // 상위 메뉴 이동
                return;
            default:
                System.out.println("없는 메뉴 번호에요ㅠㅠ");
        }

    }

    private void searchAvailableDvd() {
        Map<Integer, Dvd> dvdByAvailability = DvdRepository.findDvdByAvailability(true);
        if (dvdByAvailability.isEmpty()) {
            System.out.println("********* 대여 가능한 DVD가 없습니다 **********");
            return;
        }
        for (Dvd dvd : dvdByAvailability.values()) {
            System.out.println(dvd);
        }
        System.out.println("\n대여하려는 DVD의 '식별번호'를 입력하세요.");
        int num = inputNumber(">>> ");
        for (Dvd dvd : dvdByAvailability.values()) {
            if (dvd.getDvdNumber() == num) { // 대여 가능 DVD 목록의 식별번호를 입력하면 대여 회원명 입력으로 이동
                System.out.println("대여 회원명을 입력하세요.");
                String name = inputInfo(">>> ");
                Map<Integer, User> userByName = findUserByName(name);
                if (userByName.isEmpty()) {
                    System.out.println("*********** 찾을 수 없는 회원 정보입니다 **********");
                    return;
                }
                System.out.println("\n*********** 검색된 회원 정보입니다 **********");
                for (User user : userByName.values()) {
                    System.out.println(user);
                }
                System.out.println("\n대여 회원의 '회원번호'를 입력하세요.");
                int userNumber = inputNumber(">>> ");
                for (User user : userByName.values()) {
                    if (user.getUserNumber() == userNumber) {
                        Rent rent = new Rent(dvdByAvailability.get(num), userByName.get(userNumber));
                        dvdByAvailability.get(num).setAvailability(false); // 대여가능 여부 불가로 변경
                        dvdByAvailability.get(num).setRentalUser(rent.getUser()); // 대여자 이름 변경
                        dvdByAvailability.get(num).setDueDate(rent.getDueDate()); // 반납예정일 반영
                        userByName.get(userNumber).setTotalPaying(rent.getFee());
                        System.out.println("\n******** 대여 처리를 완료했습니다 *********");
                        System.out.println(rent);
                        return;
                    }
                }
                System.out.println("잘못된 값을 입력했습니다.");
                return;
            }
        }
        System.out.println("잘못된 값을 입력했습니다.");
    }

    private void searchNotAvailableDvd() {
        Map<Integer, Dvd> dvdByAvailability = DvdRepository.findDvdByAvailability(false);
        if (dvdByAvailability.isEmpty()) {
            System.out.println("********* 대여 중인 DVD가 없습니다 **********");
            return;
        }
        System.out.println("********* 현재 대여 중인 DVD 목록입니다. 반납예정일을 확인하세요. **********");
        for (Dvd dvd : dvdByAvailability.values()) {
            System.out.println(dvd);
        }
    }

    private void returnDvd() {
    }


}
