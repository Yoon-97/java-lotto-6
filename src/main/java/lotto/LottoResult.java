package lotto;

public enum LottoResult {
    FIRST(2000000000, 6, "6개 일치 (2,000,000,000원) - "),
    SECOND(30000000, 5, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(1500000, 5, "5개 일치 (1,500,000원) - "),
    FORTH(50000, 4, "4개 일치 (50,000원) - "),
    FIFTH(5000, 3, "3개 일치 (5,000원) - "),
    LOSE(0, 0, "");

    private static final int LEAST_WIN_COUNT = 3;

    private int reward;
    private int winCount;
    private String message;

    LottoResult(int reward, int winCount, String message) {
        this.reward = reward;
        this.winCount = winCount;
        this.message = message;
    }

    public static LottoResult valueOf(int winCount, boolean isBonus) {
        if (winCount < LEAST_WIN_COUNT) {
            return LOSE;
        }
        if (SECOND.winCount == winCount && isBonus) {
            return SECOND;
        }
        for (LottoResult result : values()) {
            if (result.winCount == winCount && result != SECOND) {
                return result;
            }
        }
        throw new IllegalStateException("[ERROR] 해당하는 등수가 없습니다.");
    }

    public String getMessage() {
        return message;
    }

    public int getReward() {
        return reward;
    }
}
