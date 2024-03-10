package video.user.domain;

public class User {
    public static final int SILVER_PRICE = 5000;
    public static final int GOLD_PRICE = 7000;
    public static final int VIP_PRICE = 10000;
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

        // 회원이 대여를 진행할 때 이 setter가 호출됨.
        // 총 결제금액에 따라 회원 등급을 조정.
        if (this.totalPaying >= VIP_PRICE) {
            this.grade = Grade.VIP;
        } else if (this.totalPaying >= GOLD_PRICE) {
            this.grade = Grade.GOLD;
        } else if (this.totalPaying >= SILVER_PRICE) {
            this.grade = Grade.SILVER;
        }
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
