package lotto;

public class printLotto {
    public static void printTicketCount(int count) {
        System.out.println(count + TICKET_COUNT);
    }

    public static void printSuccessResult() {
        System.out.println("당첨 통계\n---");
    }

    public static void printSuccessMessage(String message, int winCountResult) {
        System.out.println(message + winCountResult + "개");
    }

    public static void printRevenueRate(double EarningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", EarningRate) + "%입니다.");
    }
}
