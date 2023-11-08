package lotto;

public class PrintLotto {
    public static void printSuccessResult() {
        System.out.println("\n당첨 통계\n---");
    }

    public static void printLottoResult(String message, int winCountResult) {
        System.out.println(message + winCountResult + "개");
    }

    public static void printYield(double EarningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", EarningRate) + "%입니다.");
    }
}
