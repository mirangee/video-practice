package video.user.repository;

import video.user.domain.Grade;
import video.user.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    private static Map<Integer, User> userDatabase = new HashMap<>();


    static {
        User test1 = new User("박미랑", "010-1234-1234", Grade.BRONZE, 0);
        User test2 = new User("박미자", "010-0000-1234", Grade.BRONZE, 0);
        User test3 = new User("이경진", "010-1234-0000", Grade.BRONZE, 0);
        User test4 = new User("권미현", "010-4567-1212", Grade.BRONZE, 0);
        User test5 = new User("지현우", "010-1234-4567", Grade.BRONZE, 0);

        userDatabase.put(test1.getUserNumber(), test1);
        userDatabase.put(test2.getUserNumber(), test2);
        userDatabase.put(test3.getUserNumber(), test3);
        userDatabase.put(test4.getUserNumber(), test4);
        userDatabase.put(test5.getUserNumber(), test5);
    }

    // 회원 목록 보여주기 기능
    public static void showUserList() {
        System.out.println("\n======================== 우리 가게 회원 목록 =========================");
        for (Integer userNumber : userDatabase.keySet()) {
            User user = userDatabase.get(userNumber);
            System.out.println(user.toString());
        }
    }

    // 신규 회원 추가
    public void addNewUser(String name, String contact) {
        User newUser = new User(name, contact, Grade.BRONZE, 0);
        userDatabase.put(newUser.getUserNumber(), newUser);
    }

    public static Map<Integer, User> findUserByName(String name) {
        Map<Integer, User> userList = new HashMap<>();
        for (int userNumber : userDatabase.keySet()) {
            if (userDatabase.get(userNumber).getName().equals(name)) {
                userList.put(userNumber, userDatabase.get(userNumber));
            }
        }
        return userList;
    }

    public static List<User> findUserByContact(String contact) {
        List<User> userList = new ArrayList<>();
        for (int userNumber : userDatabase.keySet()) {
            if (userDatabase.get(userNumber).getContact().equals(contact)) {
                userList.add(userDatabase.get(userNumber));
            }
        }
        return userList;
    }


    public void delUserData(int userNumber) {
        userDatabase.remove(userNumber);
    }
}
