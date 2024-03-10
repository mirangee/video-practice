package video.dvd.repository;

import video.dvd.Dvd;

import java.util.HashMap;
import java.util.Map;

public class DvdRepository {
    private static Map<Integer, Dvd> dvdDatabase = new HashMap<>();

    static {
        insertTestDvdData();
    }

    private static void insertTestDvdData() {
        Dvd movie1 = new Dvd("인터스텔라", "미국", 2014);
        Dvd movie2 = new Dvd("포레스트 검프", "미국", 1994);
        Dvd movie3 = new Dvd("너의 이름은", "일본", 2017);
        Dvd movie4 = new Dvd("라라랜드", "미국", 2016);
        Dvd movie5 = new Dvd("레옹", "프랑스", 1994);
        Dvd movie6 = new Dvd("어바웃 타임", "영국", 2013);
        Dvd movie7 = new Dvd("타이타닉", "미국", 1998);
        Dvd movie8 = new Dvd("인생은 아름다워", "이탈리아", 1999);
        Dvd movie9 = new Dvd("쇼생크 탈출", "미국", 1995);
        Dvd movie10 = new  Dvd("기생충", "대한민국", 2019);

        dvdDatabase.put(movie1.getDvdNumber(), movie1);
        dvdDatabase.put(movie2.getDvdNumber(), movie2);
        dvdDatabase.put(movie3.getDvdNumber(), movie3);
        dvdDatabase.put(movie4.getDvdNumber(), movie4);
        dvdDatabase.put(movie5.getDvdNumber(), movie5);
        dvdDatabase.put(movie6.getDvdNumber(), movie6);
        dvdDatabase.put(movie7.getDvdNumber(), movie7);
        dvdDatabase.put(movie8.getDvdNumber(), movie8);
        dvdDatabase.put(movie9.getDvdNumber(), movie9);
        dvdDatabase.put(movie10.getDvdNumber(), movie10);
    }

    public static Map<Integer, Dvd> getDvdDatabase() {
        return dvdDatabase;
    }

    public static void addDvd(Dvd newDvd) {
        dvdDatabase.put(newDvd.getDvdNumber(), newDvd);
    }
}
