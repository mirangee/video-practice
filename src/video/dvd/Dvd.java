package video.dvd;

import video.user.domain.User;

public class Dvd {
    private static int movieSequence = 0;
    private int dvdNumber; //dvd 고유번호
    private String title; // 제목
    private String nation; // 국가
    private int madeYear; // 제작연도
    private boolean availability; // 대여가능 여부
    private User rentalUser; //대여회원

    public Dvd(String title, String nation, int madeYear) {
        this.dvdNumber = ++movieSequence;
        this.title = title;
        this.nation = nation;
        this.madeYear = madeYear;
        this.availability = true;
    }

    @Override
    public String toString() {
        String flag = "불가";
        if(availability) flag = "가능";
        return  "식별번호: " + dvdNumber +
                ", 제목: " + title +
                ", 국가: " + nation +
                ", 제작연도: " + madeYear +
                ", 대여가능 여부: " + flag +
                ", 대여자: " + rentalUser;
    }

    public static int getMovieSequence() {
        return movieSequence;
    }

    public static void setMovieSequence(int movieSequence) {
        Dvd.movieSequence = movieSequence;
    }

    public int getDvdNumber() {
        return dvdNumber;
    }

    public void setDvdNumber(int dvdNumber) {
        this.dvdNumber = dvdNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getMadeYear() {
        return madeYear;
    }

    public void setMadeYear(int madeYear) {
        this.madeYear = madeYear;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public User getRentalUser() {
        return rentalUser;
    }

    public void setRentalUser(User rentalUser) {
        this.rentalUser = rentalUser;
    }
}
