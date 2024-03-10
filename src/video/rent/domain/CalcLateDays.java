package video.rent.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalcLateDays {

    // 연체료는 하루에 3백원
    private static final int LATE_FEE = 300;

    public static int calcLateDays(Rent rent) {
        LocalDate returnDate = LocalDate.now(); // 반납한 날
        LocalDate dueDate = rent.getDueDate();// 반납 예정 일자

        int between = (int) ChronoUnit.DAYS.between(dueDate,returnDate);
        if(between <= 0) {
            return 0;
        } else {
            return LATE_FEE * between;
        }
    }
}
