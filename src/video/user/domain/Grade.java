package video.user.domain;

public enum Grade {
    BRONZE("멋진 분"),
    SILVER("감사한 분"),
    GOLD("귀한 분"),
    VIP("매니아");

    private final String gradeName;

    public String getGradeName() {
        return gradeName;
    }

    private Grade(String gradeName) {
        this.gradeName = gradeName;
    }
}
