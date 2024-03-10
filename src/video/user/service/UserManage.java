package video.user.service;

import video.common.Appservice;
import video.ui.AppUi;
import video.user.domain.User;
import video.user.repository.UserRepository;

import java.util.List;

import static video.ui.AppUi.*;
import static video.user.repository.UserRepository.*;

public class UserManage implements Appservice {

    private static final UserRepository userRepository = new UserRepository();

    @Override
    public void start() {
        while (true) {
            showUserManageMenu();
            int num = inputNumber("\n세부 메뉴를 선택하세요: ");
            switch (num) {
                case 1: // 회원 목록 보기
                    showUserList();
                    break;
                case 2: // 신규회원 추가
                    join();
                    break;
                case 3: // 회원 검색
                    search();
                    break;
                case 4: // 회원 삭제
                    delete();
                    break;
                case 5: // 상위 메뉴 이동
                    return;
                default:
                    System.out.println("없는 메뉴 번호에요ㅠㅠ");
            }
        }
    }

    private static void join() {
        System.out.println("\n===================== 신규 회원을 추가합니다 ======================");
        String newName = AppUi.inputInfo("회원명: ");
        String newContact = AppUi.inputInfo("연락처: ");

        if(!userRepository.findUserByContact(newContact).isEmpty()) {
            System.out.println("\n********** 같은 연락처 정보를 가진 회원이 존재합니다 **********");
            for (User user : userRepository.findUserByContact(newContact)) {
                System.out.println(user);
            }
            return;
        }

        userRepository.addNewUser(newName,newContact);
        System.out.println("\n===================== 회원 정보 추가 완료! ======================");
        showUserList();
    }

    private static void search() {
        while (true) {
            System.out.println("\n===================== 회원을 검색합니다 ======================");
            System.out.println("##### 1. 이름으로 검색");
            System.out.println("##### 2. 연락처로 검색");
            System.out.println("##### 3. 상위 메뉴로 돌아가기");
            int num = inputNumber(">>> ");
            switch (num) {
                case 1:
                    String name = inputInfo("찾을 회원명: ");
                    List<User> userByName = userRepository.findUserByName(name);
                    if (userByName.isEmpty()) {
                        System.out.println("*********** 찾을 수 없는 회원 정보입니다 **********");
                        break;
                    }
                    System.out.println("\n*********** 검색된 회원 정보입니다 **********");
                    for (User user : userByName) {
                        System.out.println(user);
                    }
                    break;
                case 2:
                    String contact = inputInfo("찾을 연락처: ");
                    List<User> userByContact = userRepository.findUserByContact(contact);
                    if (userByContact == null) {
                        System.out.println("*********** 찾을 수 없는 회원 정보입니다 **********");
                        break;
                    }
                    System.out.println("\n*********** 검색된 회원 정보입니다 **********");
                    for (User user : userByContact) {
                        System.out.println(user);
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("없는 메뉴 번호에요ㅠㅠ");
            }
        }

    }

    private static void delete() {
        while (true) {
            System.out.println("\n===================== 어떤 회원 정보를 삭제할까요? ======================");
            String name = inputInfo("삭제할 회원명: ");
            List<User> userByName = userRepository.findUserByName(name);
            if (userByName == null) {
                System.out.println("*********** 찾을 수 없는 회원 정보입니다 **********");
                continue;
            }
            System.out.println("\n********** 회원명 '" + name + "'의 검색 결과입니다. **********");
            for (User user : userByName) {
                System.out.println(user);
            }
            while (true) {
                System.out.println("회원 정보 확인 후 삭제할 회원의 '회원번호'를 입력하세요.");
                int num = inputNumber(">>> ");
                boolean flag = false;
                for (User user : userByName) {
                    if(user.getUserNumber() == num) {
                        userRepository.delUserData(num);
                        System.out.println("********** 삭제 완료! *********");
                        showUserList();
                        return;
                    }
                }
                System.out.println("잘못 입력했습니다.");
            }
        }
    }
}
