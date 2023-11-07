package lotto;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    LottoMachine(){}
    public static void printRandomLotto(List<List<Integer>> randomLottos) {
    }
    private void validateNumber(String input) {
        for (char i : input.toCharArray()) {
            if (!Character.isDigit(i)) {
                throw new IllegalArgumentException("유효한 숫자를 입력해주세요");
            }
        }
    }
    public int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    public void lottoStart() {
        List<List<Integer>> randomLottos = new ArrayList<>();
        randomLottos = RandomLotto.generateRandomLotto(buyLotto(getPrice()));
        printRandomLotto(randomLottos);
    }


    public int buyLotto(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 구입하여야 합니다.");
        }
        int countLotto = price / 1000;
        System.out.println(countLotto + "개를 구매했습니다.");
        //구매한 로또 갯수 리턴
        return countLotto;
    }
}
