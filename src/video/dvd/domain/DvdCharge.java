package video.dvd.domain;

import java.time.LocalDateTime;

public class DvdCharge {
    /*
     * 요금 정책
     * 1. 올해 출시된 영화는 기본적으로 5000원
     * 2. 출시 후 1년이 지날 때마다 500원씩 차감
     * 3. 최소 요금은 2000원이며 그 밑으로는 차감되지 않음.
    */

    private static final int BASIC_FEE = 5000;
    private static final int DISCOUNT_RATE = 500;
    private static final int MINIMUM_FEE = 2000;

    public static int feeCharge(Dvd dvd) {
        LocalDateTime localDateTime = LocalDateTime.now();
        int madeYear = dvd.getMadeYear(); // 제작연도
        int nowYear = localDateTime.getYear(); // 현재연도
        int yearGap = nowYear - madeYear; // 현재연도 - 제작연도
        int fee = BASIC_FEE - (DISCOUNT_RATE * yearGap);
        return Math.max(fee, MINIMUM_FEE);
    }
}
