package video.user.domain;

public class User {
    private static int sequence = 0; // 회원 누적 순차 번호
    private int userNumber; // 회원 고유 번호
    private String name;
    private String contact;
    private Grade grade; // 회원등급
    private int totalPaying = 0; // 총 결제 금액, 이에 따라 회원등급 달라짐

    public User(String name, String contact, Grade grade, int totalPaying) {
        this.userNumber = ++sequence; // 회원 생성될 때 회원고유 번호 하나 올려서 대입
        this.name = name;
        this.contact = contact;
        this.grade = grade;
        this.totalPaying = totalPaying;
    }

    public static int getSequence() {
        return sequence;
    }

    public static void setSequence(int sequence) {
        User.sequence = sequence;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public int getTotalPaying() {
        return totalPaying;
    }

    public void setTotalPaying(int totalPaying) {
        this.totalPaying += totalPaying;
    }

    @Override
    public String toString() {
        return  "회원번호: " + userNumber +
                ", 회원명: " + name +
                ", 연락처: " + contact +
                ", 회원등급: " + grade.getGradeName() +
                ", 누적 결제 금액: " + totalPaying + "원";
    }
}
