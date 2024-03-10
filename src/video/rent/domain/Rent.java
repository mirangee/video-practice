package video.rent.domain;

import video.dvd.domain.Dvd;
import video.user.domain.User;

import java.time.LocalDate;

public class Rent {
    private Dvd dvd; //대여 항목
    private User user; // 대여자

    private int fee; // 대여금액
    private LocalDate rentDate; // 대여 일자
    private LocalDate dueDate; // 반납 예정 일자

    private LocalDate returnDate; // 실제 반납 일자

    private boolean late = false; // 연체 여부
    private int lateFee = 0; // 연체료


    public Rent(Dvd dvd, User user) {
        this.dvd = dvd;
        this.user = user;
        this.fee = dvd.getFee();
        this.rentDate = LocalDate.now();
        this.dueDate = rentDate.plusDays(3);
    }

    @Override
    public String toString() {
        return  "DVD 제목: " + dvd.getTitle() +
                ", 대여 회원: " + user.getName() +
                ", 대여료: " + fee + "원" +
                ", 대여일: " + rentDate +
                ", 반납예정일: " + dueDate +
                ", 반납처리일: " + returnDate +
                ", 연체 여부: " + late +
                ", 연체료: " + lateFee + "원";
    }

    public Dvd getDvd() {
        return dvd;
    }

    public void setDvd(Dvd dvd) {
        this.dvd = dvd;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isLate() {
        return late;
    }

    public void setLate(boolean late) {
        this.late = late;
    }

    public int getLateFee() {
        return lateFee;
    }

    public void setLateFee(int lateFee) {
        this.lateFee = lateFee;
    }
}

